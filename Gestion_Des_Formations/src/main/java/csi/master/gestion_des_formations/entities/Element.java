package csi.master.gestion_des_formations.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Element {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

}
