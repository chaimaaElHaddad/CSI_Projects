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
	
	
	
//	  @CollectionTable(name = "raw_events_custom", joinColumns = @JoinColumn(name =     "raw_event_id"))
//	  @MapKeyColumn(name = "field_key", length = 50)
//	  @Column(name = "field_val", length = 100)
//	  @BatchSize(size = 20)
//	  private Map<String, String> customValues = new HashMap<String, String>();
//	
}
