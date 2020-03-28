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
	public CurriculumVitae update(Long id, CurriculumVitae curriculumVitaeToUpdate) {
		
		if (id != null) {
			Optional<CurriculumVitae> cv = curriculumVitaeRepository.findById(id);
			if (cv.isPresent()) {
				curriculumVitaeToUpdate.setId_CV(id);
				return curriculumVitaeRepository.save(curriculumVitaeToUpdate);
			}

		}
		return null;
	}

	@Override
	public void delete(Long id) {
		curriculumVitaeRepository.deleteById(id);
	}

	@Override
	public CurriculumVitae getById(Long id) {
		Optional<CurriculumVitae> cvOptional = curriculumVitaeRepository.findById(id);
		if (cvOptional.isPresent())
			return cvOptional.get();

		return null;
	}

	@Override
	public CurriculumVitae getByFormateurId(Long id) {

		return curriculumVitaeRepository.findByFormateurId(id);
	}

	@Override
	public List<CurriculumVitae> getAll() {
		return curriculumVitaeRepository.findAll();
	}

}
