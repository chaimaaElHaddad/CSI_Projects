package csi.master.gestion_des_formations.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csi.master.gestion_des_formations.entities.Role;
import csi.master.gestion_des_formations.repositories.IRoleRepository;

@RestController
@RequestMapping(value = "/role")
public class RoleController {

	@Autowired
	private IRoleRepository roleRepository;

	@GetMapping("/all")
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

}
