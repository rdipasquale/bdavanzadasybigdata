package ar.edu.uca.bases2.mongodomain;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import ar.edu.uca.bases2.mongodomain.entities.Concepto;
import ar.edu.uca.bases2.mongodomain.services.SampleService;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:test.properties")
public class MongodomainApplicationTests {

	@Autowired
	private SampleService ser;
	
	@Before
	public void before()
	{
		Concepto c=new Concepto("ConceptoD","ConceptoG");
		ser.saveConcepto(c);
	}
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void findAllConceptos() {
		List<Concepto> conceptos= ser.findAllConceptos();
		assertTrue(conceptos.size()==1);
	}	
}
