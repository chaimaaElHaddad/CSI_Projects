package csi.master.gestion_des_formations.services;

import java.util.List;

import csi.master.gestion_des_formations.entities.Role;

public interface RoleServiceI {

	Role create(Role formationToCreate);

	Role update(Role formationToUpdate);

	void delete(String id);

	Role getById(String role);

	List<Role> getAll();
}
