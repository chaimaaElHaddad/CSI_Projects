package csi.master.gestion_des_formations.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import csi.master.gestion_des_formations.entities.ElementDeFormation;

public interface IElementRepository extends JpaRepository<ElementDeFormation, Long> {

	List<ElementDeFormation> findByFormationId(Long formationId);

}
