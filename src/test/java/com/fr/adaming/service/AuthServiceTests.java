package com.fr.adaming.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fr.adaming.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthServiceTests {

	//importer le service
	@Autowired
	private AuthService service;
	
	//declarer des meth public void sans param qui font appel au service.methodQueTuTest
	@Test
	public void a_registerTest() {
		System.out.println("************* first test method****************");
		User user = new User("nom", "prenom", "email", "pwd", null);
		service.register(user);
		assertNotNull(user);
	}
	
	@Test
	public void b_loginTest() {
		System.out.println("**************Second Test Method***************");
		service.login("email@email.fr", "pwd");
	}
	
	@Before
	public void BeforeMethode() {
		System.out.println("*************BeforeMethode******************");
	}
	
	//tester toutes les erreurs possible aussi
}
