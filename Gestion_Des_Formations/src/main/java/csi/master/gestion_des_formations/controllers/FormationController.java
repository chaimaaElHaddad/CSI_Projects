package csi.master.gestion_des_formations.controllers;

import java.util.List;

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
import csi.master.gestion_des_formations.services.FormationServiceI;

@RestController
@RequestMapping(value = "/formation")
public class FormationController {

	@Autowired
	private FormationServiceI formationService;

	@PostMapping(value = "/create")
	public Formation createFormation(@RequestBody Formation formation) {

		return formationService.create(formation);
	}

	@PutMapping(value = "/update/{id}")
	public Formation updateFormation(@PathVariable Long id, @RequestBody Formation formation) {
		return formationService.update(id, formation);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deleteFormation(@PathVariable Long id) {
		formationService.delete(id);

	}

	@GetMapping(value = "/all")
	public List<Formation> getAll() {
		return formationService.getAll();

	}

	@GetMapping(value = "/duringNext30Days")
	public List<Formation> getFormationDuringTheNext30Days() {

		return formationService.getFormationsOfferedDuringTheNext30Days();

	}

	@GetMapping(value = "/formateur/{id}")
	public List<Formation> getByFormateur(@PathVariable Long id) {

		return formationService.getByFormateurId(id);

	}

}
