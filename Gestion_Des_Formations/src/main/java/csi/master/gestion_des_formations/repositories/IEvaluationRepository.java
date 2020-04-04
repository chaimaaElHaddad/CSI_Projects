package csi.master.gestion_des_formations.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import csi.master.gestion_des_formations.entities.Evaluation;

public interface IEvaluationRepository extends JpaRepository<Evaluation, Long> {

	List<Evaluation> findByElementId(Long id);

}
