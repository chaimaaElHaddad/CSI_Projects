package csi.master.gestion_des_formations.services;

import java.util.List;

import csi.master.gestion_des_formations.entities.Formation;

public interface FormationServiceI {

	Formation create(Formation formationToCreate);

	Formation update(Formation formationToUpdate);

	void delete(long id);

	Formation getById(long id);

	Formation getByFormateurId(long id);

	List<Formation> getAll();

}
