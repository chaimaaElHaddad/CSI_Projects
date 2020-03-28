package csi.master.gestion_des_formations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import csi.master.gestion_des_formations.entities.Evaluation;

public interface IEvaluationRepository extends JpaRepository<Evaluation, Long> {

	Evaluation findByElementId(Long id);

}
