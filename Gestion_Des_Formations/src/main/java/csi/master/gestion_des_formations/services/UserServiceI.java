package csi.master.gestion_des_formations.services;

import java.util.List;

import csi.master.gestion_des_formations.entities.User;

public interface UserServiceI {

	void save(User userO);

	User findByUsername(String username);

	User update(User userToUpdate);

	void delete(long id);

	User getById(long id);

	List<User> getAll();
}
