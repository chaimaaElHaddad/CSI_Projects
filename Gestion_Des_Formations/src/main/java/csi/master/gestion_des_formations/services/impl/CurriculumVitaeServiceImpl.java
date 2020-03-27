package csi.master.gestion_des_formations.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csi.master.gestion_des_formations.entities.CurriculumVitae;
import csi.master.gestion_des_formations.repositories.ICurriculumVitaeRepository;
import csi.master.gestion_des_formations.services.CurriculumVitaeServiceI;

@Service
public class CurriculumVitaeServiceImpl implements CurriculumVitaeServiceI {

	@Autowired
	private ICurriculumVitaeRepository curriculumVitaeRepository;

	@Override
	public CurriculumVitae create(CurriculumVitae curriculumVitaeToCreate) {

		return curriculumVitaeRepository.save(curriculumVitaeToCreate);
	}

	@Override
	public CurriculumVitae update(CurriculumVitae curriculumVitaeToUpdate) {

		return curriculumVitaeRepository.save(curriculumVitaeToUpdate);
	}

	@Override
	public void delete(long id) {
		curriculumVitaeRepository.deleteById(id);
	}

	@Override
	public CurriculumVitae getById(long id) {
		Optional<CurriculumVitae> cvOptional = curriculumVitaeRepository.findById(id);
		if (cvOptional.isPresent())
			return cvOptional.get();

		return null;
	}

	@Override
	public CurriculumVitae getByFormateurId(long id) {

		return curriculumVitaeRepository.findByFormateurId(id);
	}

	@Override
	public List<CurriculumVitae> getAll() {
		return curriculumVitaeRepository.findAll();
	}

}
