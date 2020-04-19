package csi.master.gestion_des_formations.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csi.master.gestion_des_formations.entities.CurriculumVitae;
import csi.master.gestion_des_formations.services.CurriculumVitaeServiceI;

@RestController
@RequestMapping(value = "/cv")
@CrossOrigin("http://localhost:4200")
public class CurriculumVitaeController {

	@Autowired
	private CurriculumVitaeServiceI curriculumVitaeService;

	@PostMapping(value = "/create")
	public CurriculumVitae createCV(@RequestBody CurriculumVitae cvitae) {

		return curriculumVitaeService.create(cvitae);
	}

	@PutMapping(value = "/update/{id}")
	public CurriculumVitae updateCV(@PathVariable Long id, @RequestBody CurriculumVitae cvitae) {
		return curriculumVitaeService.update(id, cvitae);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deleteCV(@PathVariable Long id) {
		curriculumVitaeService.delete(id);

	}

	@GetMapping(value = "/all")
	public List<CurriculumVitae> getAll() {
		return curriculumVitaeService.getAll();

	}

	@GetMapping(value = "/formateur/{id}")
	public CurriculumVitae getByFormateur(@PathVariable Long id) {
		CurriculumVitae curriculumVitae = curriculumVitaeService.getByFormateurId(id);
		System.err.println(id);
		return curriculumVitae;

	}

}
