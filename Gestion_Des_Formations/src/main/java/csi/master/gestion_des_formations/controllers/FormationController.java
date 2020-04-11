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

import csi.master.gestion_des_formations.entities.Formation;
import csi.master.gestion_des_formations.services.FormationServiceI;

@RestController
@RequestMapping(value = "/formation")
@CrossOrigin("http://localhost:4200")
public class FormationController {

	@Autowired
	private FormationServiceI formationService;

	@PostMapping(value = "/create")
	public List<Formation> createFormation(@RequestBody Formation formation) {

		formationService.create(formation);
		return formationService.getByFormateurId(formation.getFormateur().getId());
	}

	@PutMapping(value = "/update/{id}")
	public List<Formation> updateFormation(@PathVariable Long id, @RequestBody Formation formation) {
		formationService.update(id, formation);
		return formationService.getByFormateurId(formation.getFormateur().getId());
	}

	@DeleteMapping(value = "/delete/{id}")
	public List<Formation> deleteFormation(@PathVariable Long id) {
		Long formateurId = formationService.getById(id).getFormateur().getId();
		formationService.delete(id);
		return formationService.getByFormateurId(formateurId);
	}

	@GetMapping(value = "/all")
	public List<Formation> getAll() {
		return formationService.getAll();

	}

	@GetMapping(value = "/Next30Days")
	public List<Formation> getFormationPour30JoursSuivants() {

		return formationService.getFormationsPour30JoursSuivants();

	}

	@GetMapping(value = "/formateur/{id}")
	public List<Formation> getByFormateur(@PathVariable Long id) {

		return formationService.getByFormateurId(id);

	}
	
	@GetMapping(value = "/{id}")
	public Formation getById(@PathVariable Long id) {

		return formationService.getById(id);

	}

}
