package csi.master.gestion_des_formations.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3846474220046952524L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String prenom;
	private String nom;
	private String username;
	private String password;
	// private int actived;

	@Email
	private String email;
	private String phone;
	private String address;

	private String role;

}
