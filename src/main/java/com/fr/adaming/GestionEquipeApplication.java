package com.fr.adaming;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.fr.adaming.entity.Equipe;
import com.fr.adaming.entity.User;
import com.fr.adaming.service.IAuthService;
import com.fr.adaming.service.IEquipeService;
import com.fr.adaming.service.IUserService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class GestionEquipeApplication {

	public static void main(String[] args) {
		ApplicationContext ctxt = SpringApplication.run(GestionEquipeApplication.class, args);
		
//		//créer une equipe
//		Equipe equipe1 = new Equipe(1, "nom1", "niveau1");
//		ctxt.getBean(IEquipeService.class).create(equipe1);
//		//créer des users
//		User user = new User(1, "nom1", "prenom1", "email1", "pwd1", equipe1);
//		User user2 = new User(2, "nom2", "prenom2", "email2", "pwd2", equipe1);
//		
//		//ctxt.getBean(IUserService.class).create(user);
//		IUserService service = (IUserService) ctxt.getBean("userService");
//		service.create(user);
//		service.create(user2);
//		
//		Logger log = Logger.getLogger(GestionEquipeApplication.class);
//		
//		log.trace("message log (TRACE)");
//		log.debug("message log (DEBUG)");
//		log.info("message log (INFO)");
//		log.warn("message log (WARN)");
//		log.error("message log (ERROR)");
//		log.fatal("message log (FATAL)");
		
	}
}
