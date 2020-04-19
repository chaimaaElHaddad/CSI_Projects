package csi.master.gestion_des_formations.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csi.master.gestion_des_formations.entities.UserElementInscription;
import csi.master.gestion_des_formations.entities.UserElementInscriptionId;
import csi.master.gestion_des_formations.services.ElementDeFormationServiceI;
import csi.master.gestion_des_formations.services.UserElementInscriptionServiceI;
import csi.master.gestion_des_formations.services.UserServiceI;

@RestController
@RequestMapping(value = "/userElementInscription")
@CrossOrigin("http://localhost:4200")
public class UserElementInscriptionController {

	@Autowired
	private UserElementInscriptionServiceI userElementInscriptionService;

	@Autowired
	private ElementDeFormationServiceI elementService;

	@Autowired
	private UserServiceI userService;

	@PostMapping(value = "/create")
	public List<UserElementInscription> createUserElementInscription(
			@RequestBody UserElementInscription userInscription) {
		userElementInscriptionService.create(userInscription);
		return userElementInscriptionService.getByElement(userInscription.getElement());
	}

//	@PutMapping(value = "/update/{id}")
//	public List<ElementDeFormation> updateElementDeFormation(@PathVariable Long id,
//			@RequestBody ElementDeFormation element) {
//		elementDeFormationService.update(id, element);
//		return elementDeFormationService.getByFormationId(element.getFormation().getId());
//	}

	@DeleteMapping(value = "/delete/{id}")
	public void deleteUserElementInscription(@PathVariable UserElementInscriptionId id) {
		userElementInscriptionService.delete(id);
	}

	@GetMapping(value = "/beneficiaire/{id}")
	public List<UserElementInscription> getByBeneficiaire(@PathVariable Long id) {

		return userElementInscriptionService.getByBeneficiaire(userService.getById(id));

	}

	@GetMapping(value = "/element/{element}")
	public List<UserElementInscription> getByElement(@PathVariable Long element) {

		return userElementInscriptionService.getByElement(elementService.getById(element));

	}

}
