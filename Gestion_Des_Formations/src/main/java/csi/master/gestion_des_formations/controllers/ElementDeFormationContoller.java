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

import csi.master.gestion_des_formations.entities.ElementDeFormation;
import csi.master.gestion_des_formations.services.ElementDeFormationServiceI;

@RestController
@RequestMapping(value = "/elementDeFormation")
@CrossOrigin("http://localhost:4200")
public class ElementDeFormationContoller {

	@Autowired
	private ElementDeFormationServiceI elementDeFormationService;
	
	

	@PostMapping(value = "/create/{formationId}")
	public List<ElementDeFormation> createElementDeFormation(@RequestBody ElementDeFormation element,@PathVariable Long formationId) {
		elementDeFormationService.create(element, formationId);
		return elementDeFormationService.getByFormationId(formationId);
	}

	@PutMapping(value = "/update/{id}")
	public List<ElementDeFormation> updateElementDeFormation(@PathVariable Long id,
			@RequestBody ElementDeFormation element) {
		elementDeFormationService.update(id, element);
		return elementDeFormationService.getByFormationId(element.getFormation().getId());
	}

	@DeleteMapping(value = "/delete/{id}")
	public List<ElementDeFormation> deleteElementDeFormation(@PathVariable Long id) {
		Long formationId = elementDeFormationService.getById(id).getFormation().getId();
		elementDeFormationService.delete(id);
		return elementDeFormationService.getByFormationId(formationId);
	}

	@GetMapping(value = "/all")
	public List<ElementDeFormation> getAll() {
		List<ElementDeFormation> elementDeFormations = elementDeFormationService.getAll();

		return elementDeFormations;

	}

	@GetMapping(value = "/formation/{id}")
	public List<ElementDeFormation> getByFormation(@PathVariable Long id) {

		List<ElementDeFormation> elementDeFormations = elementDeFormationService.getByFormationId(id);
		return elementDeFormations;

	}

}
