package csi.master.gestion_des_formations.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csi.master.gestion_des_formations.entities.Role;
import csi.master.gestion_des_formations.entities.User;
import csi.master.gestion_des_formations.repositories.IRoleRepository;
import csi.master.gestion_des_formations.repositories.IUserRepository;


@RestController
//@Secured(value= {"ROLE_ADMIN"})
public class UserRestController {
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private IRoleRepository roleRepository;
	
	
	@RequestMapping(value="/addUser")
	public User save(User u) {
		return userRepository.save(u);
	}
	
	
	@RequestMapping(value="/findUsers")
	public List<User> findALL(){
		return userRepository.findAll();
	}
	
	
	@RequestMapping(value="/addRole")
	public Role save(Role r) {
		return roleRepository.save(r);
	}
	
	
	@RequestMapping(value="/findRoles")
	public List<Role> findRoles(){
		return roleRepository.findAll();
	}
	
	@RequestMapping(value="/addRoleToUser")
	public User addRoleToUser(String username, String role) {
		User u = userRepository.getOne(username);
		Role r = roleRepository.getOne(role); 
		u.getRoles().add(r);
		userRepository.save(u);
		return u;
	}
	
	
	@RequestMapping("/username")
	public Principal getUser(Principal user) {
		
		return user;
		
	}


}
