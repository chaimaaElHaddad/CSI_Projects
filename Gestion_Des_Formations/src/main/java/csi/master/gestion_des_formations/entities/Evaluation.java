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
	private long id;
	private long elementId;
	
	@ElementCollection(fetch = FetchType.LAZY)
	private Map<String, Integer> accueilCriteres = new HashMap<String, Integer>(); //<critère,note>
	
	@ElementCollection(fetch = FetchType.LAZY)
	private Map<String, Integer> formateurCriteres = new HashMap<String, Integer>(); //<critère,note>
	
	@ElementCollection(fetch = FetchType.LAZY)
	private Map<String, Integer> contenuCriteres = new HashMap<String, Integer>(); //<critère,note>
	
	private int score;
	
	public int getScore() {
		int accueilScore = 0;
		for (int note : this.getAccueilCriteres().values()) {
			accueilScore += note;
		}
		
		int formateurScore = 0;
		for (int note : this.getFormateurCriteres().values()) {
			formateurScore += note;
		}
		
		int contenuScore = 0;
		for (int note : this.getContenuCriteres().values()) {
			contenuScore += note;
		}
		this.score =  accueilScore + formateurScore + contenuScore;
		
		return score;
	}
		
}
