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

import csi.master.gestion_des_formations.entities.ElementDeFormation;
import csi.master.gestion_des_formations.services.ElementDeFormationServiceI;

@RestController
@RequestMapping(value = "/elementDeFormation")
public class ElementDeFormationContoller {

	@Autowired
	private ElementDeFormationServiceI elementDeFormationService;

	@PostMapping(value = "/create")
	public ElementDeFormation createElementDeFormation(@RequestBody ElementDeFormation element) {

		return elementDeFormationService.create(element);
	}

	@PutMapping(value = "/update/{id}")
	public ElementDeFormation updateElementDeFormation(@PathVariable Long id, @RequestBody ElementDeFormation element) {
		return elementDeFormationService.update(id, element);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deleteElementDeFormation(@PathVariable Long id) {
		elementDeFormationService.delete(id);

	}

	@GetMapping(value = "/all")
	public List<ElementDeFormation> getAll() {
		return elementDeFormationService.getAll();

	}

	@GetMapping(value = "/formateur/{id}")
	public List<ElementDeFormation> getByFormation(@PathVariable Long id) {

		return elementDeFormationService.getByFormationId(id);

	}

}
