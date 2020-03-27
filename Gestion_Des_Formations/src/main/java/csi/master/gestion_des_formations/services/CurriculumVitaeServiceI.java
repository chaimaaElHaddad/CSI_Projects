package csi.master.gestion_des_formations.services;

import java.util.List;

import csi.master.gestion_des_formations.entities.CurriculumVitae;

public interface CurriculumVitaeServiceI {
	
	CurriculumVitae create(CurriculumVitae curriculumVitaeToCreate);

	CurriculumVitae update(CurriculumVitae curriculumVitaeToUpdate);

	void delete(long id);

	CurriculumVitae getById(long id);
	
	CurriculumVitae getByFormateurId(long id);

	List<CurriculumVitae> getAll();

	
}
