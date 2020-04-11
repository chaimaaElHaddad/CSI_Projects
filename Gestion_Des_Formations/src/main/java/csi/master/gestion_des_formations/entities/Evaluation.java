package csi.master.gestion_des_formations.entities;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Evaluation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long elementId;
	
	@ElementCollection(fetch = FetchType.LAZY)
	private Map<String, Integer> accueilCriteresNotes = new HashMap<String, Integer>(); //<critère,note>  note/10
	
	@ElementCollection(fetch = FetchType.LAZY)
	private Map<String, Integer> formateurCriteresNotes = new HashMap<String, Integer>(); //<critère,note>
	
	@ElementCollection(fetch = FetchType.LAZY)
	private Map<String, Integer> contenuCriteresNotes = new HashMap<String, Integer>(); //<critère,note>
 
	
	public Evaluation() {
		accueilCriteresNotes.put("propreté", 0);
		accueilCriteresNotes.put("matériel", 0);
		accueilCriteresNotes.put("propreté matériel ", 0);
		
		formateurCriteresNotes.put("", 0);
		formateurCriteresNotes.put("", 0);
		formateurCriteresNotes.put("", 0);
		
		contenuCriteresNotes.put("", 0);
		contenuCriteresNotes.put("", 0);
		contenuCriteresNotes.put("", 0);
		contenuCriteresNotes.put("", 0);
	}
		
}
