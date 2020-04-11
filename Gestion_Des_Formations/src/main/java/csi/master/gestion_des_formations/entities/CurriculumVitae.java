package csi.master.gestion_des_formations.entities;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

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
	
	private Long formateurId;
	
	private String nomComplet;
	private String metier;
	private String phone;
	@Email
	private String email;
	
	private Calendar dateDebutFormation;
	private Calendar dateFinFormation;
	private String etablissement;
	private String villeFormation;
	
	private Calendar dateDebutExperience;
	private Calendar dateFinExperience;
	private String villeExperience;
}
