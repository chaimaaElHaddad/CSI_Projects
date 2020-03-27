package csi.master.gestion_des_formations.services;

import csi.master.gestion_des_formations.entities.User;

public interface UserService {

	void save(User userO);

	User findByUsername(String username);
}
