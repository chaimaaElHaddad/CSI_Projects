package csi.master.gestion_des_formations.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import csi.master.gestion_des_formations.entities.ElementDeFormation;
import csi.master.gestion_des_formations.entities.User;
import csi.master.gestion_des_formations.entities.UserElementInscription;
import csi.master.gestion_des_formations.entities.UserElementInscriptionId;

public interface IUserElementInscriptionRepository
		extends JpaRepository<UserElementInscription, UserElementInscriptionId> {

	List<UserElementInscription> findByBeneficiaire(User beneficiaire);

	List<UserElementInscription> findByElement(ElementDeFormation element);

}
