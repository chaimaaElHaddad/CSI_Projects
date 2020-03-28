package csi.master.gestion_des_formations.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class ElementDeFormation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Date date;
	private int temps; // temps en minutes
	private long prix; // en MAD
	private String objectif;
	private String prerequis;
	private String description;
	
	private Long formationId;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "beneficiaire_element")
	private List<User> beneficiaires;

}
