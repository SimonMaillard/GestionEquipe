package com.fr.adaming.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
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
public class UserServiceTest {
	
//importer le service
	@Autowired
	private UserService service;
	
//instancier un user static pour tous les tests
	private static User user;
	
//tester les cas create
	@Test
	public void a_createUsertest() {
		System.out.println("**************1st Test User OK***************");
		user = new User("nom", "prenom", "testemail@email.fr", "pwd", null);
		User result = service.create(user);
		assertNotNull(result);
	}
	
//	@Test @Ignore
//	public void b_createUser2test() {
//		System.out.println("**************1st-2 Test User OK***************");
//		user = new User("nom", "prenom", "testemail@email.fr", "pwd", null);
//		User result = service.create(user);
//		System.out.println("DEBUG id user : "+result.getId());
//		
//		User user2 = new User(user.getId(), "nom2", "prenom2", "user2email@email.fr", "pwd2", null);
//		service.create(user2);
//		assertNull(user2);
//	}
	
//	@Test @Ignore
//	public void c_createUser3test() {
//		System.out.println("**************1st-3 Test User OK***************");
//		user = new User(150,"nom", "prenom", "testemail@email.fr", "pwd", null);
//		service.create(user);
//		assertNull(user);
//	}
	
	@Test
	public void d_createUserNulltest() {
		System.out.println("**************2nd Test User null***************");
		user = null;
		User result = service.create(user);
		assertNull(result);
	}
	
	@Test
	public void e_createUserMailInvalidtest() {
		System.out.println("**************3rd Test User Email Invalid***************");
		user = new User("nom", "prenom", "testemail", "pwd", null);
		User result = service.create(user);
		assertNull(result);
	}
	
	@Test
	public void f_createUserEmailNulltest() {
		System.out.println("**************4th Test User Email Null***************");
		user = new User("nom", "prenom", null, "pwd", null);
		User result = service.create(user);
		assertNull(result);
	}
	
	@Test
	public void g_createUserPwdNulltest() {
		System.out.println("**************5th Test User PWD null***************");
		user = new User("nom", "prenom", "testemail@email.fr", null, null);
		User result = service.create(user);
		assertNull(result);
	}
	
//tester findById
	@Test
	public void h_findByIdTest() {
		System.out.println("*********Find By Id test*************");
		user = new User("nombla", "prenombla", "testemail@email.fr", "pwdbla", null);
		service.create(user);
		User result = service.findById(user.getId());
		System.out.println("DEBUG : "+result);
		assertNotNull(result);
	}
	
	@Test
	public void i_findByIdNullTest() {
		System.out.println("*********Find By Id null test*************");
		user = service.findById(150);
		assertNull(user);
	}
	
//tester update
	@Test
	public void j_udateTest() {
		System.out.println("**************Update OK***************");
		user = new User("nomA", "prenomA", "emailA@email.fr", "pwdA", null);
		User result = service.create(user);
		result = new User(result.getId(), "nomAA", "prenomAA", result.getEmail(), result.getPwd(), null);
		result = service.update(result);
		assertNotNull(result);
	}
	
	@Test
	public void k_udateIdNullTest() {
		System.out.println("**************Update Id Null***************");
		user = new User("nomA", "prenomA", "emailA@email.fr", "pwdA", null);
		User result = service.create(user);
		result = new User(null, "nomAA", "prenomAA", result.getEmail(), result.getPwd(), null);
		result = service.update(result);
		assertNull(result);
	}
	
	@Test
	public void l_udateNullTest() {
		System.out.println("**************Update Null***************");
		User result = service.update(user);
		assertNull(result);
	}
	
//tester delete
	@Test
	public void m_deleteTest() {
		System.out.println("**************Delete OK***************");
		user = new User("nomA", "prenomA", "emailA@email.fr", "pwdA", null);
		user = service.create(user);
		String result = service.delete(user.getId());
		String message = "SUCCESS";
		assertEquals(message, result);
		user=null;
	}
	
	@Test
	public void n_deleteIdNullTest() {
		System.out.println("**************Delete Id Null***************");
		String result = service.delete(null);
		String message = "SUCCESS";
		assertEquals(message, result);
		user=null;
	}
	
	@Test
	public void o_deleteUnknownTest() {
		System.out.println("**************Delete Unknown***************");
		String result = service.delete(150);
		String message = "SUCCESS";
		assertEquals(message, result);
		user=null;
	}
	
//assurer la destruction auto de notre user static
	@After
	public void AfterMethode() {
		System.out.println("*******DeleteUser Auto******");
		if (user != null && user.getId() != null) {
			service.delete(user.getId());
		}
	}

}
