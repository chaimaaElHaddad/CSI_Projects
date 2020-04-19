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

	@Override
	public int getEvaluationNote(Evaluation evaluation) {
//		int accueilNote = 0;
//		for (int note : evaluation.getAccueilCriteresNotes().values()) {
//			accueilNote += note;
//		}
//
//		int formateurNote = 0;
//		for (int note : evaluation.getFormateurCriteresNotes().values()) {
//			formateurNote += note;
//		}
//
//		int contenuNote = 0;
//		for (int note : evaluation.getContenuCriteresNotes().values()) {
//			contenuNote += note;
//		}

		// evaluationNote = somme des notes / 100
		return (evaluation.getAccueilNote() + evaluation.getFormateurNote() + evaluation.getContenuNote());
	}

	@Override
	public int getScoreByElementId(Long elementId) {
		List<Evaluation> evaluationList = getByElementIdAndDone(elementId,1);

		int score = 0;

		if(evaluationList.size() != 0) {
			for (Evaluation evaluation : evaluationList) {
				score += getEvaluationNote(evaluation);
			}
			
			System.err.println(score);
			System.err.println(evaluationList);

			score /= evaluationList.size();
		}
		

		return score; // (/100)
	}

	@Override
	public List<Evaluation> getByElementIdAndDone(Long id, int done) {
		// TODO Auto-generated method stub
		return evaluationRepository.findByElementIdAndDone(id,done);
	}

}
