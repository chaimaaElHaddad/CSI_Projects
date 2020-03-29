package csi.master.gestion_des_formations.schedule;

import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import csi.master.gestion_des_formations.entities.Mail;
import csi.master.gestion_des_formations.entities.UserElementInscription;
import csi.master.gestion_des_formations.services.MailServiceI;
import csi.master.gestion_des_formations.services.UserElementInscriptionServiceI;

@Component
public class SupprimerInscriptionSchedule {

	@Autowired
	private UserElementInscriptionServiceI userElementInscriptionService;

	@Autowired
	private MailServiceI mailService;

	@Scheduled(cron = "0 44 19 * * *")
	public void deleteInscriptionAfter7days() {

		List<UserElementInscription> inscriptions = userElementInscriptionService.getAll();
		Calendar now = Calendar.getInstance();

		for (UserElementInscription userElementInscription : inscriptions) {
			Calendar dateInscription = userElementInscription.getDateInscription();
			if (ChronoUnit.DAYS.between(dateInscription.toInstant(), now.toInstant()) >= 2) {
				
				Mail mail = new Mail();
				mail.setMailFrom("chaimaahaddad7@gmail.com");
				mail.setMailTo(userElementInscription.getEmail());
				mail.setMailSubject("Gestion des formations - Email pour réactiver l'inscription");
				mail.setMailContent("Bonjour "+userElementInscription.getBeneficiaire().getUsername()+",\n\nTu dois réactiver ton inscription dans l'élément '"+userElementInscription.getElement().getDescription()+"' de la formation '"+userElementInscription.getElement().getFormation().getDescription()+"'.\n\nCordialement\nCSI_Group.");
				mailService.sendEmail(mail);
				
				userElementInscriptionService.delete(userElementInscription.getId());
				System.err.println("deleted");
			}
		}

		System.err.println("it's ok");

	}

}
