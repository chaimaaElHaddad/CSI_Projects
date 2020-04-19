package csi.master.gestion_des_formations.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CurriculumVitae {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_CV;
	
	private Long formateurId;
	private String metier;
	
	@Column(name="formations")
	@ElementCollection()
	private List<String> formations; //formation = dateDebut,dateFin,description,etablessement,ville
	
	@Column(name="experiences")
	@ElementCollection()
	private List<String> experiences; //experience = dateDebut,dateFin,description,entreprise,ville

}
