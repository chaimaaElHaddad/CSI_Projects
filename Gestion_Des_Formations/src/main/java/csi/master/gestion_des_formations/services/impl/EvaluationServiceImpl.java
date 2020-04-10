package csi.master.gestion_des_formations.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csi.master.gestion_des_formations.entities.Evaluation;
import csi.master.gestion_des_formations.repositories.IEvaluationRepository;
import csi.master.gestion_des_formations.services.EvaluationServiceI;

@Service
public class EvaluationServiceImpl implements EvaluationServiceI {

	@Autowired
	private IEvaluationRepository evaluationRepository;

	@Override
	public Evaluation create(Evaluation evaluationToCreate) {
		return evaluationRepository.save(evaluationToCreate);
	}

	@Override
	public Evaluation update(Long id, Evaluation evaluationToUpdate) {
		if (id != null) {
			Optional<Evaluation> evaluation = evaluationRepository.findById(id);
			if (evaluation.isPresent()) {
				evaluationToUpdate.setId(id);
				;
				return evaluationRepository.save(evaluationToUpdate);
			}

		}
		return null;
	}

	@Override
	public void delete(Long id) {
		evaluationRepository.deleteById(id);
	}

	@Override
	public Evaluation getById(Long id) {
		Optional<Evaluation> evaluationOptional = evaluationRepository.findById(id);

		if (evaluationOptional.isPresent()) {
			return evaluationOptional.get();
		}

		return null;
	}

	@Override
	public List<Evaluation> getByElementId(Long id) {
		return evaluationRepository.findByElementId(id);
	}

	@Override
	public List<Evaluation> getAll() {
		return evaluationRepository.findAll();
	}

}
