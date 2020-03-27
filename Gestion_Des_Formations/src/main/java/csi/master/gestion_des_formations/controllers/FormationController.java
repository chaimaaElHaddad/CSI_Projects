package csi.master.gestion_des_formations.controllers;

import java.sql.Date;
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

import csi.master.gestion_des_formations.entities.Formation;
import csi.master.gestion_des_formations.repositories.IFormationRepository;

@RestController
@RequestMapping(value = "/formation")
public class FormationController {

	@Autowired
	private IFormationRepository formationRepo;

	@PostMapping(value = "/create")
	public Formation createPerson(@RequestBody Formation person) {

		return formationRepo.save(person);
	}

	@PutMapping(value = "/update/{id}")
	public Formation updatePerson(@PathVariable Long id, @RequestBody Formation formation) {
		if (id != null) {
			Optional<Formation> f = formationRepo.findById(id);
			if (f != null) {
				formation.setId(id);
				return formationRepo.save(formation);
			}

		}
		return null;
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deleteFormation(@PathVariable Long id) {
		if (id != null) {
			Optional<Formation> person = formationRepo.findById(id);
			if (person != null) {
				formationRepo.deleteById(id);
			}
		}

	}

	@GetMapping(value = "/all")
	public List<Formation> getAll() {
		return formationRepo.findAll();

	}

	@GetMapping(value = "/all/by/{date}")
	public List<Formation> getByDate(@PathVariable Date date) {

		return formationRepo.getByDate(date);
	}

}
