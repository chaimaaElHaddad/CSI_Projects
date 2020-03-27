package csi.master.gestion_des_formations.entities;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Evaluation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long elementId;
	private Map<String, Integer> accueilCriteres = new HashMap<String, Integer>(); //<critère,note>
	private Map<String, Integer> formateurCriteres = new HashMap<String, Integer>(); //<critère,note>
	private Map<String, Integer> contenuCriteres = new HashMap<String, Integer>(); //<critère,note>
	
	
}
