package csi.master.gestion_des_formations.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csi.master.gestion_des_formations.entities.CurriculumVitae;
import csi.master.gestion_des_formations.repositories.ICurriculumVitaeRepository;

@RestController
@RequestMapping(value = "/cv")
public class CurriculumVitaeController {

	@Autowired
	private ICurriculumVitaeRepository cvRepo;

	@PostMapping(value = "/create")
	public CurriculumVitae createFormateur(@RequestBody CurriculumVitae cvitae) {

		return cvRepo.save(cvitae);
	}

	@PutMapping(value = "/update/{id}")
	public CurriculumVitae updateCV(@PathVariable Long id, @RequestBody CurriculumVitae cvitae) {
		if (id != null) {
			Optional<CurriculumVitae> cv = cvRepo.findById(id);
			if (cv != null) {
				cvitae.setId_CV(id);
				return cvRepo.save(cvitae);
			}

		}
		return null;
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deleteCV(@PathVariable Long id) {
		if (id != null) {
			Optional<CurriculumVitae> cvitae = cvRepo.findById(id);
			if (cvitae != null) {
				cvRepo.deleteById(id);
			}
		}

	}

	@GetMapping(value = "/all")
	public List<CurriculumVitae> getAll() {
		return cvRepo.findAll();

	}

	

}
