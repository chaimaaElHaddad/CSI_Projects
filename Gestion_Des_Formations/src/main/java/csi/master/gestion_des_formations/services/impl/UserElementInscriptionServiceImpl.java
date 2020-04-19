package csi.master.gestion_des_formations.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csi.master.gestion_des_formations.entities.ElementDeFormation;
import csi.master.gestion_des_formations.entities.Mail;
import csi.master.gestion_des_formations.entities.User;
import csi.master.gestion_des_formations.entities.UserElementInscription;
import csi.master.gestion_des_formations.entities.UserElementInscriptionId;
import csi.master.gestion_des_formations.repositories.IUserElementInscriptionRepository;
import csi.master.gestion_des_formations.services.MailServiceI;
import csi.master.gestion_des_formations.services.UserElementInscriptionServiceI;

@Service
public class UserElementInscriptionServiceImpl implements UserElementInscriptionServiceI {

	@Autowired
	private IUserElementInscriptionRepository userElementInscriptionRepository;
	
	@Autowired
	private MailServiceI mailService;

	@Override
	public UserElementInscription create(UserElementInscription userElementInscriptionToCreate) {
		
		//Envoyer un e-mail à le bénéficiaire pour lui noter qu'il doit réactiver son inscription chaque semaine, sinon sa demande sera supprimée.
		Mail mail = new Mail();
		mail.setMailFrom("chaimaahaddad7@gmail.com");
		mail.setMailTo(userElementInscriptionToCreate.getEmail());
		mail.setMailSubject("Gestion des formations - Email pour réactiver l'inscription");
		mail.setMailContent("Bonjour " + userElementInscriptionToCreate.getBeneficiaire().getUsername()
				+ ",\n\nTu dois réactiver ton inscription chaque semaine, sinon ta demande sera supprimée dans l'élément '"
				+ userElementInscriptionToCreate.getElement().getNom() + "'.\n\nCordialement\nCSI_Group.");
		System.err.println(mail);
		mailService.sendEmail(mail);
		return userElementInscriptionRepository.save(userElementInscriptionToCreate);

	}

	@Override
	public UserElementInscription update(UserElementInscriptionId id,
			UserElementInscription userElementInscriptionToUpdate) {
		if (id != null) {
			Optional<UserElementInscription> userElementInscription = userElementInscriptionRepository.findById(id);
			if (userElementInscription.isPresent()) {
				userElementInscriptionToUpdate.setId(id);
				;
				return userElementInscriptionRepository.save(userElementInscriptionToUpdate);
			}

		}
		return null;
	}

	@Override
	public void delete(UserElementInscriptionId id) {
		userElementInscriptionRepository.deleteById(id);

	}

	@Override
	public UserElementInscription getById(UserElementInscriptionId id) {
		Optional<UserElementInscription> userElementInscriptionOptional = userElementInscriptionRepository.findById(id);

		if (userElementInscriptionOptional.isPresent()) {
			return userElementInscriptionOptional.get();
		}

		return null;
	}

	@Override
	public List<UserElementInscription> getByBeneficiaire(User beneficiaire) {
		return userElementInscriptionRepository.findByBeneficiaire(beneficiaire);
	}

	@Override
	public List<UserElementInscription> getByElement(ElementDeFormation element) {
		return userElementInscriptionRepository.findByElement(element);
	}

	@Override
	public List<UserElementInscription> getAll() {
		return userElementInscriptionRepository.findAll();
	}

}
