package csi.master.gestion_des_formations.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import csi.master.gestion_des_formations.entities.Formation;

public interface IFormationRepository extends JpaRepository<Formation, Long> {

	public List<Formation> getByDate(Date date);

	public Formation findByFormateurId(long id);

}
