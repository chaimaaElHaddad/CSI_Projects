package csi.master.gestion_des_formations.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csi.master.gestion_des_formations.entities.ElementDeFormation;
import csi.master.gestion_des_formations.repositories.IElementRepository;
import csi.master.gestion_des_formations.services.ElementDeFormationServiceI;
import csi.master.gestion_des_formations.services.EvaluationServiceI;
import csi.master.gestion_des_formations.services.FormationServiceI;
import csi.master.gestion_des_formations.services.UserElementInscriptionServiceI;

@Service
public class ElementDeFormationServiceImpl implements ElementDeFormationServiceI {

	@Autowired
	private IElementRepository elementRepository;
	
	@Autowired
	private UserElementInscriptionServiceI inscriptionService;
	
	@Autowired
	private EvaluationServiceI evaluationService;
	
	@Autowired
	private FormationServiceI formationService;


	@Override
	public ElementDeFormation create(ElementDeFormation elementDeFormationToCreate, Long formationId) {
		elementDeFormationToCreate.setFormation(formationService.getById(formationId));
		return elementRepository.save(elementDeFormationToCreate);
	}

	@Override
	public ElementDeFormation update(Long id, ElementDeFormation elementDeFormationToUpdate) {
		if (id != null) {
			Optional<ElementDeFormation> element = elementRepository.findById(id);
			if (element.isPresent()) {
				elementDeFormationToUpdate.setId(id);
				return elementRepository.save(elementDeFormationToUpdate);
			}

		}
		return null;
	}

	@Override
	public void delete(Long id) {
		elementRepository.deleteById(id);
	}

	@Override
	public ElementDeFormation getById(Long id) {
		ElementDeFormation elementDeFormation = null;
		Optional<ElementDeFormation> elementOptional = elementRepository.findById(id);

		if (elementOptional.isPresent()) {
			elementDeFormation = elementOptional.get();
			int nbInscription = inscriptionService.getByElement(elementDeFormation).size();
			elementDeFormation.setNbDePlacesRestantes(elementDeFormation.getFormation().getNombres_places() - nbInscription);
			elementDeFormation.setScore(evaluationService.getScoreByElementId(elementDeFormation.getId()));
		}

		return elementDeFormation;
	}

	@Override
	public List<ElementDeFormation> getAll() {
		List<ElementDeFormation> elementDeFormations = elementRepository.findAll();
		for (ElementDeFormation elementDeFormation : elementDeFormations) {
			int nbInscription = inscriptionService.getByElement(elementDeFormation).size();
			elementDeFormation.setNbDePlacesRestantes(elementDeFormation.getFormation().getNombres_places() - nbInscription);
			elementDeFormation.setScore(evaluationService.getScoreByElementId(elementDeFormation.getId()));
		}
		return elementDeFormations;
	}

	@Override
	public List<ElementDeFormation> getByFormationId(Long formationId) {
		List<ElementDeFormation> elementDeFormations = elementRepository.findByFormationId(formationId);
		for (ElementDeFormation elementDeFormation : elementDeFormations) {
			int nbInscription = inscriptionService.getByElement(elementDeFormation).size();
			elementDeFormation.setNbDePlacesRestantes(elementDeFormation.getFormation().getNombres_places() - nbInscription);
			elementDeFormation.setScore(evaluationService.getScoreByElementId(elementDeFormation.getId()));
		}
		return elementDeFormations;
	}

}
