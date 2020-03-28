package csi.master.gestion_des_formations.entities;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Formation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private Calendar date;
	// private Date duree;
	private String accueil; // accueil=nom,adress
	private int nembres_places;
	private float prix;
	private String objectifs;
	private String prerequis;
	private String description;

	@ManyToOne
	private User formateur;

}
