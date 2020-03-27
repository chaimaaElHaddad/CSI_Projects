package csi.master.gestion_des_formations.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;

import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String username;
	private String password;
	private boolean avtived;

	@Email
	private String email;
	private int phone;
	private String adress;

	@Transient
	private String passwordConfirm;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USERS_ROLES")
	private Collection<Role> roles;

}
