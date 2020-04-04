package csi.master.gestion_des_formations.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import csi.master.gestion_des_formations.entities.User;

public interface IUserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
	
	List<User> findByRole(String role);
		
}
