package csi.master.gestion_des_formations.services;

import java.util.List;

import csi.master.gestion_des_formations.entities.Evaluation;

public interface EvaluationServiceI {

	Evaluation create(Evaluation evaluationToCreate);

	Evaluation update(Long id, Evaluation evaluationToUpdate);

	void delete(Long id);

	Evaluation getById(Long id);

	List<Evaluation> getByElementId(Long id);

	List<Evaluation> getAll();
	
	int getEvaluationNote(Evaluation evaluation);
	
	int getScoreByElementId(Long elementId);

}
