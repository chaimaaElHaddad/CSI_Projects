package csi.master.gestion_des_formations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class GestionDesFormationsApplication {
	
	private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();;

	public static void main(String[] args) {
		SpringApplication.run(GestionDesFormationsApplication.class, args);
		
	}

}
