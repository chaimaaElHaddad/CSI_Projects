package csi.master.gestion_des_formations.entities;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class UserElementInscription {

	@EmbeddedId
	private UserElementInscriptionId id;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("userId")
	private User beneficiaire;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("elementId")
	private ElementDeFormation element;

	@Email
	private String email;
	private String phone;
	private String localisation;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Evaluation evaluation;

	private Calendar dateInscription = Calendar.getInstance();

}