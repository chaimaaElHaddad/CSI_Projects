package csi.master.gestion_des_formations.services;

import java.util.List;

import csi.master.gestion_des_formations.entities.CurriculumVitae;

public interface CurriculumVitaeServiceI {
	
	CurriculumVitae create(CurriculumVitae curriculumVitaeToCreate);

	CurriculumVitae update(Long id, CurriculumVitae curriculumVitaeToUpdate);

	void delete(Long id);

	CurriculumVitae getById(Long id);
	
	CurriculumVitae getByFormateurId(Long id);

	List<CurriculumVitae> getAll();

	
}
