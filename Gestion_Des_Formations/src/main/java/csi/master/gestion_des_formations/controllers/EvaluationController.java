package csi.master.gestion_des_formations.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csi.master.gestion_des_formations.entities.Evaluation;
import csi.master.gestion_des_formations.services.EvaluationServiceI;

@RestController
@RequestMapping(value = "/evaluation")
public class EvaluationController {

	@Autowired
	private EvaluationServiceI evaluationService;

	@PostMapping(value = "/create")
	public Evaluation createEvaluation(@RequestBody Evaluation evaluation) {

		return evaluationService.create(evaluation);
	}

	@PutMapping(value = "/update/{id}")
	public Evaluation updateEvaluation(@PathVariable Long id, @RequestBody Evaluation evaluation) {
		return evaluationService.update(id, evaluation);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deleteEvaluation(@PathVariable Long id) {
		evaluationService.delete(id);

	}

	@GetMapping(value = "/all")
	public List<Evaluation> getAll() {
		return evaluationService.getAll();
	}

	@GetMapping(value = "/element/{id}")
	public Evaluation getByElement(@PathVariable Long id) {

		return evaluationService.getByElementId(id);

	}

}
