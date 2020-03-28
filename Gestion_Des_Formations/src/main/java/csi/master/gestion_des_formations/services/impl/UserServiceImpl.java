package csi.master.gestion_des_formations.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csi.master.gestion_des_formations.entities.User;
import csi.master.gestion_des_formations.repositories.IRoleRepository;
import csi.master.gestion_des_formations.repositories.IUserRepository;
import csi.master.gestion_des_formations.services.UserServiceI;

@Service
public class UserServiceImpl implements UserServiceI {
	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private IRoleRepository roleRepository;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User save(User user) {
		// user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(new HashSet<>(roleRepository.findAll()));
		return userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User update(Long id, User userToUpdate) {
		if (id != null) {
			Optional<User> user = userRepository.findById(id);
			if (user.isPresent()) {
				userToUpdate.setId(id);
				return userRepository.save(userToUpdate);
			}

		}
		return null;
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User getById(Long id) {
		Optional<User> userOptional = userRepository.findById(id);

		if (userOptional.isPresent()) {
			return userOptional.get();
		}

		return null;
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}
}