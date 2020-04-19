package csi.master.gestion_des_formations.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
public class Formation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nom;
	private Calendar date;
	private String accueil; // accueil=nom,address
	private int nombres_places;
	private float prix;
	private String objectifs;
	private String prerequis;
	private String description;

	@ManyToOne
	private User formateur;
	
	@OneToMany(mappedBy = "formation" ,cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<ElementDeFormation> elementDeFormations = new ArrayList<ElementDeFormation>();

}
