package csi.master.gestion_des_formations.services;

import java.util.List;

import csi.master.gestion_des_formations.entities.ElementDeFormation;

public interface ElementDeFormationServiceI {

	ElementDeFormation create(ElementDeFormation elementDeFormationToCreate);

	ElementDeFormation update(ElementDeFormation elementDeFormationToUpdate);

	void delete(long id);

	ElementDeFormation getById(long id);

	List<ElementDeFormation> getAll();

}
