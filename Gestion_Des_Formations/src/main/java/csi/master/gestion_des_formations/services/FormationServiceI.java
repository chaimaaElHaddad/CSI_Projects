package csi.master.gestion_des_formations.services;

import java.util.List;

import csi.master.gestion_des_formations.entities.Formation;

public interface FormationServiceI {

	Formation create(Formation formationToCreate);

	Formation update(Long id, Formation formationToUpdate);

	void delete(Long id);

	Formation getById(Long id);

	List<Formation> getByFormateurId(Long id);
	
	List<Formation> getFormationsOfferedDuringTheNext30Days();

	List<Formation> getAll();

}
