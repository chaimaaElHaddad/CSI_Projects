package csi.master.gestion_des_formations.entities;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class ElementDeFormation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private Calendar date;
	private int temps; // temps en minutes
	private Long prix; // en MAD
	private String objectif;
	private String prerequis;
	private String description;

	@ManyToOne(fetch = FetchType.EAGER)
	private Formation formation;

//	@ManyToMany(mappedBy = "elementInscription")
//	Set<User> beneficiaires;

//	@OneToMany(mappedBy = "elementDeFormation")
//    List<ElementInscription> inscriptions = new ArrayList<ElementInscription>();

//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "beneficiaire_element")
//	private List<User> beneficiaires = new ArrayList<User>();

}
