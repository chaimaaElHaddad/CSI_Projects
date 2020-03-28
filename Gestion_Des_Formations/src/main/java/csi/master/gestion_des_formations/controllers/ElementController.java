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

import csi.master.gestion_des_formations.entities.ElementDeFormation;
import csi.master.gestion_des_formations.repositories.IElementRepository;

@RestController
@RequestMapping(value = "/element")
public class ElementController {

	@Autowired
	private IElementRepository elementRepo;

	@PostMapping(value = "/create")
	public ElementDeFormation createElement(@RequestBody ElementDeFormation element) {

		return elementRepo.save(element);
	}

	@PutMapping(value = "/update/{id}")
	public ElementDeFormation updateElement(@PathVariable Long id, @RequestBody ElementDeFormation element) {
		if (id != null) {
			Optional<ElementDeFormation> e = elementRepo.findById(id);
			if (e != null) {
				element.setId(id);
				return elementRepo.save(element);
			}

		}
		return null;
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deleteElement(@PathVariable Long id) {
		if (id != null) {
			Optional<ElementDeFormation> element = elementRepo.findById(id);
			if (element != null) {
				elementRepo.deleteById(id);
			}
		}

	}

	@GetMapping(value = "/all")
	public List<ElementDeFormation> getAll() {
		return elementRepo.findAll();

	}

}
