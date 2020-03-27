package csi.master.gestion_des_formations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import csi.master.gestion_des_formations.entities.Element;

public interface IElementRepository extends JpaRepository<Element, Long> {

}
