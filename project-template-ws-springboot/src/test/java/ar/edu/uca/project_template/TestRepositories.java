package ar.edu.uca.project_template;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import ar.edu.uca.project_template.entities.Agente;
import ar.edu.uca.project_template.repositories.AgenteRepository;

@TestPropertySource(locations="classpath:test.properties")
@RunWith(SpringRunner.class)
@DataJpaTest
public class TestRepositories {

	@Autowired 
	private AgenteRepository agenteRepository;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAgenteRepository() {
		
		for (Agente a : agenteRepository.findAll()) 
			System.out.println(a);			
		
	}	
	
}
