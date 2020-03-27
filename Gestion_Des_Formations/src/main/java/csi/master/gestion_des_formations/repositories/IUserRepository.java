package csi.master.gestion_des_formations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import csi.master.gestion_des_formations.entities.User;

public interface IUserRepository extends JpaRepository<User, String> {

	User findByUsername(String username);
}
