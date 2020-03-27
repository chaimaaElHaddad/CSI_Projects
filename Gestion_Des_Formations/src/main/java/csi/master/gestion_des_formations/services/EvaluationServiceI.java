package csi.master.gestion_des_formations.services;

import java.util.List;

import csi.master.gestion_des_formations.entities.Evaluation;

public interface EvaluationServiceI {

	Evaluation create(Evaluation evaluationToCreate);

	Evaluation update(Evaluation evaluationToUpdate);

	void delete(long id);

	Evaluation getById(long id);

	Evaluation getByElementId(long id);

	List<Evaluation> getAll();

}
