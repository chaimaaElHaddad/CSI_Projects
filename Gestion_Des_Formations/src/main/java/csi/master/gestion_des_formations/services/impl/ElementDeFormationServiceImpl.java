package csi.master.gestion_des_formations.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csi.master.gestion_des_formations.entities.ElementDeFormation;
import csi.master.gestion_des_formations.repositories.IElementRepository;
import csi.master.gestion_des_formations.services.ElementDeFormationServiceI;

@Service
public class ElementDeFormationServiceImpl implements ElementDeFormationServiceI {

	@Autowired
	private IElementRepository elementRepository;

	@Override
	public ElementDeFormation create(ElementDeFormation elementDeFormationToCreate) {
		return elementRepository.save(elementDeFormationToCreate);
	}

	@Override
	public ElementDeFormation update(Long id, ElementDeFormation elementDeFormationToUpdate) {
		if (id != null) {
			Optional<ElementDeFormation> element = elementRepository.findById(id);
			if (element.isPresent()) {
				elementDeFormationToUpdate.setId(id);
				;
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
		Optional<ElementDeFormation> elementOptional = elementRepository.findById(id);

		if (elementOptional.isPresent()) {
			return elementOptional.get();
		}

		return null;
	}

	@Override
	public List<ElementDeFormation> getAll() {
		return elementRepository.findAll();
	}

	@Override
	public List<ElementDeFormation> getByFormationId(Long formationId) {
		return elementRepository.findByFormationId(formationId);
	}

}
