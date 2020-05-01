package ar.edu.uca.bd.subtes.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import ar.edu.uca.bd.subtes.Application;
import ar.edu.uca.bd.subtes.entities.Ciudad;
import ar.edu.uca.bd.subtes.repositories.CiudadRepository;
import ar.edu.uca.bd.subtes.services.SubteService;

@TestPropertySource(locations="classpath:test.properties")
@RunWith(SpringRunner.class)
@Import(Application.class)
public class TestCiudad {

	@Autowired
	private SubteService ser;

	@Autowired
	private CiudadRepository ciudadRep;
	
	private Ciudad bsas=new Ciudad("CABA",null,null);
	
	@Before
	public void setUp()
	{
		
		ser.saveCiudad(bsas);		
	}
	
	@After
	public void tearDown()
	{
		ciudadRep.delete(bsas);
	}
	
	@Test
	public void testFindAllCiudades()
	{
		Iterable<Ciudad> ciudades=ser.findAllCiudades();		
		assertTrue(ciudades.iterator().hasNext());
		
	}
	
	@Test
	public void testFindCiudadesByNombre()
	{
		List<Ciudad> ciudades=ciudadRep.findByNombre("CABA");		
		assertTrue(ciudades.size()>=1);
		
	}	
	
}
