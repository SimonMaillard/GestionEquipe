package com.fr.adaming.service;

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

import com.fr.adaming.entity.Equipe;
import com.fr.adaming.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EquipeServiceTest {
	
//importer le service
	@Autowired
	private EquipeService service;
	
//instancier une equipe en static pour tous les tests
	private static Equipe equipe;
	
	@After
	public void AfterMethode() {
		System.out.println("*******AfterMethod Delete***********");
		if (equipe != null && equipe.getId() != null) {
			service.delete(equipe.getId());
		}
	}
	
//tester les cas create
	@Test
	public void a_createTestOk() {
		System.out.println("*********Create Equipe OK**************");
		equipe = new Equipe("nom1", "niveau1");
		equipe = service.create(equipe);
		System.out.println("DEBUG : "+equipe);
		assertNotNull(equipe);
	}

	@Test
	public void b_createEquipeNomNull() {
		System.out.println("**********Create Equipe Nom Null************");
		equipe = new Equipe(null, "niveau1");
		equipe = service.create(equipe);
		System.out.println("DEBUG result : "+equipe);
		assertNull(equipe);
	}
	
	@Test
	public void c_createEquipeNiveauNull() {
		System.out.println("**********Create Equipe Niveau Null************");
		equipe = new Equipe("nom1", null);
		equipe = service.create(equipe);
		System.out.println("DEBUG result : "+equipe);
		assertNull(equipe);
	}
	
	@Test
	public void d_createEquipeNull() {
		System.out.println("**********Create Equipe Null************");
		equipe = null;
		equipe = service.create(equipe);
		System.out.println("DEBUG result : "+equipe);
		assertNull(equipe);
	}
	
	@Test
	public void e_createEquipeNomExist() {
		System.out.println("**********Create Equipe Nom Exist************");
		Equipe equipeNom = new Equipe("nom1", "niveau1");
		service.create(equipeNom);
		equipe = new Equipe("nom1", "niveau2");
		Equipe result = service.create(equipe);
		System.out.println("DEBUG result : "+result);
		assertNull(result);
	}
	
//tester Find By Id
	@Test
	public void f_findByIdTest() {
		System.out.println("***************Find By Id OK*******************");
		equipe = service.create(new Equipe("nomfind", "niveaufind"));
		equipe = service.findById(equipe.getId());
		System.out.println("DEBUG : "+equipe);
		assertNotNull(equipe);
	}
	
	@Test
	public void g_findByIdNullTest() {
		System.out.println("***************Find By Id Null*******************");
		equipe = service.findById(null);
		System.out.println("DEBUG : "+equipe);
		assertNull(equipe);
	}
	
	@Test
	public void h_findByIdUnknownTest() {
		System.out.println("***************Find By Id Unknown*******************");
		equipe = service.findById(150);
		System.out.println("DEBUG : "+equipe);
		assertNull(equipe);
	}
	
//tester Update
	@Test
	public void i_updateTest() {
		System.out.println("***************Update OK************)");
		equipe = service.create(new Equipe("nomUpdate", "niveauUpdate"));
		System.out.println("DEBUG : "+equipe);
		equipe = service.update(new Equipe("nomUpdate2", "niveauUpdate2"));
		System.out.println("DEBUG : "+equipe);
		assertNotNull(equipe);
	}
	
	@Test
	public void j_updateNullTest() {
		System.out.println("***************Update Null************)");
		equipe = service.update(null);
		System.out.println("DEBUG : "+equipe);
		assertNull(equipe);
	}
	
	@Test
	public void k_updateNomNullTest() {
		System.out.println("***************Update Nom Null************)");
		equipe = service.create(new Equipe("nomUpdate", "niveauUpdate"));
		System.out.println("DEBUG : "+equipe);
		equipe = service.update(new Equipe(null, "niveauUpdate"));
		System.out.println("DEBUG : "+equipe);
		assertNull(equipe);
	}
	
	@Test
	public void l_updateNomExistTest() {
		System.out.println("***************Update Nom Exist************)");
		equipe = service.create(new Equipe("nomUpdate", "niveauUpdate"));
		System.out.println("DEBUG : "+equipe);
		equipe = service.update(new Equipe("nomUpdate", "niveauUpdate2"));
		System.out.println("DEBUG : "+equipe);
		assertNull(equipe);
	}
	
	@Test @Ignore("non fonctionnel")
	public void m_updateNiveauNullTest() {
		System.out.println("***************Update Niveau Null************)");
		equipe = service.create(new Equipe("nomUpdate", "niveauUpdate"));
		System.out.println("DEBUG : "+equipe);
		equipe = service.update(new Equipe("nomUpdate2", null));
		System.out.println("DEBUG : "+equipe);
		assertNull(equipe);
	}
}
