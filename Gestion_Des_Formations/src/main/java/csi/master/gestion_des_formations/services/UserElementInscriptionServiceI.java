package csi.master.gestion_des_formations.services;

import java.util.List;

import csi.master.gestion_des_formations.entities.ElementDeFormation;
import csi.master.gestion_des_formations.entities.User;
import csi.master.gestion_des_formations.entities.UserElementInscription;
import csi.master.gestion_des_formations.entities.UserElementInscriptionId;

public interface UserElementInscriptionServiceI {

	UserElementInscription create(UserElementInscription userElementInscriptionToCreate);

	UserElementInscription update(UserElementInscriptionId id, UserElementInscription userElementInscriptionToUpdate);

	void delete(UserElementInscriptionId id);

	UserElementInscription getById(UserElementInscriptionId id);

	List<UserElementInscription> getByBeneficiaire(User beneficiaire);

	List<UserElementInscription> getByElement(ElementDeFormation element);

	List<UserElementInscription> getAll();

}
