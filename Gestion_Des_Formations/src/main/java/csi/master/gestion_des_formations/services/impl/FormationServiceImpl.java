package csi.master.gestion_des_formations.services.impl;

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
	public Formation update(Formation formationToUpdate) {
		return formationRepository.save(formationToUpdate);
	}

	@Override
	public void delete(long id) {
		formationRepository.deleteById(id);
	}

	@Override
	public Formation getById(long id) {
		Optional<Formation> formationOptional = formationRepository.findById(id);

		if (formationOptional.isPresent()) {
			return formationOptional.get();
		}

		return null;
	}

	@Override
	public Formation getByFormateurId(long id) {
		return formationRepository.findByFormateurId(id);
	}

	@Override
	public List<Formation> getAll() {
		return formationRepository.findAll();
	}

}
