package csi.master.gestion_des_formations.entities;

import java.util.List;

import lombok.Data;

@Data
public class Mail {
	
	private String mailFrom = "chaimaahaddad7@gmail.com";
	 
    private String mailTo;
 
    private String mailCc;
 
    private String mailBcc;
 
    private String mailSubject;
 
    private String mailContent;
 
    private String contentType;
 
    private List< Object > attachments;
 
    public Mail() {
        contentType = "text/plain";
    }

}
