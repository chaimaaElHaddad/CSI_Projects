package csi.master.gestion_des_formations.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class UserElementInscriptionId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6354507935508089044L;

	private Long userId;

	private Long elementId;

}
