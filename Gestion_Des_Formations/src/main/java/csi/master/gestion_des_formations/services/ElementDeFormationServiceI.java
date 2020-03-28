package csi.master.gestion_des_formations.services;

import java.util.List;

import csi.master.gestion_des_formations.entities.ElementDeFormation;


public interface ElementDeFormationServiceI {

	ElementDeFormation create(ElementDeFormation elementDeFormationToCreate);

	ElementDeFormation update(Long id, ElementDeFormation elementDeFormationToUpdate);

	void delete(Long id);

	ElementDeFormation getById(Long id);
	
	List<ElementDeFormation> getByFormationId(Long formationId);

	List<ElementDeFormation> getAll();
	

}
