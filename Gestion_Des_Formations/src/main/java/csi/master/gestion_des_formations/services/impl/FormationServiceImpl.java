package csi.master.gestion_des_formations.services.impl;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csi.master.gestion_des_formations.entities.Formation;
import csi.master.gestion_des_formations.repositories.IFormationRepository;
import csi.master.gestion_des_formations.services.FormationServiceI;

@Service
public class FormationServiceImpl implements FormationServiceI {

	@Autowired
	private IFormationRepository formationRepository;

	@Override
	public Formation create(Formation formationToCreate) {
		return formationRepository.save(formationToCreate);
	}

	@Override
	public Formation update(Long id, Formation formationToUpdate) {
		if (id != null) {
			Optional<Formation> formation = formationRepository.findById(id);
			if (formation.isPresent()) {
				formationToUpdate.setId(id);
				;
				return formationRepository.save(formationToUpdate);
			}

		}
		return null;
	}

	@Override
	public void delete(Long id) {
		formationRepository.deleteById(id);
	}

	@Override
	public Formation getById(Long id) {
		Optional<Formation> formationOptional = formationRepository.findById(id);

		if (formationOptional.isPresent()) {
			return formationOptional.get();
		}

		return null;
	}

	@Override
	public List<Formation> getByFormateurId(Long id) {
		return formationRepository.findByFormateurId(id);
	}

	@Override
	public List<Formation> getAll() {
		return formationRepository.findAll();
	}

	@Override
	public List<Formation> getFormationsPour30JoursSuivants() {
		Calendar todayDate = Calendar.getInstance();
		Calendar after30Days = Calendar.getInstance();
		after30Days.add(Calendar.DATE, 30);
		return formationRepository.findByDateBetween(todayDate, after30Days);
		
	}

}
