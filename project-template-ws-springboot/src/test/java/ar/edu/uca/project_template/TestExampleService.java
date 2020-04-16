package ar.edu.uca.project_template;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

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
import ar.edu.uca.project_template.services.ExampleService;

@TestPropertySource(locations="classpath:test.properties")
@RunWith(SpringRunner.class)
@DataJpaTest
public class TestExampleService {

	@Autowired 
	private ExampleService ser;

	@Autowired 
	private AgenteRepository agenteRepository;
	
	@Before
	public void setUp() throws Exception {
		Agente a=new Agente();
		a.setAgeId(1);
		a.setFechaDesde(new Date());
		a.setNemo("AGE1");
		a.setNombre("Agente Nro 1");
		a.setTagId(14);
		agenteRepository.save(a);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExampleService() {
		Agente a = ser.exampleLogicAgentes(1);
		assertNotNull(a);
		assertTrue(a.getAgeId()==1);
		// Idem 
		assertEquals(a.getAgeId(),1);
		
	}	
	
}
