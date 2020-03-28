package csi.master.gestion_des_formations.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;
	private String password;
	private int avtived;

	@Email
	private String email;
	private String phone;
	private String adress;

	@Transient
	private String passwordConfirm;

	@ManyToMany
	@JoinTable(name = "element_inscription", joinColumns = @JoinColumn(name = "users_id"), inverseJoinColumns = @JoinColumn(name = "element_de_formation_id"))
	Set<ElementDeFormation> elementInscription;

//	@OneToMany(mappedBy = "user")
//	List<ElementInscription> inscriptions = new ArrayList<ElementInscription>();

	@ManyToOne(fetch = FetchType.EAGER)
	private Role role;

}
