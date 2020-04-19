package csi.master.gestion_des_formations.entities;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
public class ElementDeFormation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nom;
	private Calendar date;
	private int temps; // temps en minutes
	private Long prix; // en MAD
	private String objectif;
	private String prerequis;
	private String description;
	private int score;
	private int nbDePlacesRestantes;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private Formation formation;

}
