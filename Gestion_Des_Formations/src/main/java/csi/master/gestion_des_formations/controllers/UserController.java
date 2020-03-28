package csi.master.gestion_des_formations.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csi.master.gestion_des_formations.entities.User;
import csi.master.gestion_des_formations.repositories.IRoleRepository;
import csi.master.gestion_des_formations.services.UserServiceI;

@RestController
//@Secured(value= {"ROLE_ADMIN"})
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserServiceI userService;

	@Autowired
	private IRoleRepository roleRepository;

	@PostMapping(value = "/create")
	public User save(User u) {
		return userService.save(u);
	}

	@GetMapping(value = "/formateurs")
	public List<User> getFormateurs() {
		List<User> users = userService.getAll();

		List<User> formateurs = new ArrayList<User>();

		for (User user : users) {
			if (user.getRole().equals(roleRepository.getOne("FORMATEUR"))) {
				formateurs.add(user);
			}

		}

		return formateurs;
	}

	@GetMapping(value = "/beneficiaires")
	public List<User> getBeneficiaires() {
		List<User> users = userService.getAll();

		List<User> beneficiaires = new ArrayList<User>();

		for (User user : users) {
			if (user.getRole().equals(roleRepository.getOne("BENEFICIAIRE"))) {
				beneficiaires.add(user);
			}

		}

		return beneficiaires;
	}

	@GetMapping("/formateur/{id}")
	public User getFormateurById(@PathVariable Long id) {
		User user = userService.getById(id);
		if (user != null) {
			if (user.getRole().equals(roleRepository.getOne("FORMATEUR"))) {
				return user;
			}
		}
		return null;
	}

	@GetMapping("/beneficiaire/{id}")
	public User getBeneficiaireById(@PathVariable Long id) {
		User user = userService.getById(id);
		if (user != null) {
			if (user.getRole().equals(roleRepository.getOne("BENEFICIAIRE"))) {
				return user;
			}
		}
		return null;
	}

	@GetMapping("/username")
	public Principal getUser(Principal user) {

		return user;

	}

}
