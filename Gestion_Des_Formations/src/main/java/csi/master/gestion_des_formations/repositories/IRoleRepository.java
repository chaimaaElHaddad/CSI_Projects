package csi.master.gestion_des_formations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import csi.master.gestion_des_formations.entities.Role;

public interface IRoleRepository extends JpaRepository<Role, String> {

}
