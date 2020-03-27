package csi.master.gestion_des_formations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import csi.master.gestion_des_formations.entities.CurriculumVitae;

public interface ICurriculumVitaeRepository extends JpaRepository<CurriculumVitae, Long> {

	CurriculumVitae findByFormateurId(long id);

}
