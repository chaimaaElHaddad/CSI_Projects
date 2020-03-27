package csi.master.gestion_des_formations.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CurriculumVitae {

	/*
	 * ici on va utiliser la technique de générateur des rapport dont on va essayer
	 * de générer un CV forma pdf oubien word.. ^_^
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_CV;

//	@OneToOne
//	@MapsId
//	private User formateur;

}
