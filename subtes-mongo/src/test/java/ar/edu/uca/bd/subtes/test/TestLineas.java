package ar.edu.uca.bd.subtes.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
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
import ar.edu.uca.bd.subtes.entities.Estacion;
import ar.edu.uca.bd.subtes.entities.Linea;
import ar.edu.uca.bd.subtes.repositories.CiudadRepository;
import ar.edu.uca.bd.subtes.repositories.EstacionRepository;
import ar.edu.uca.bd.subtes.repositories.LineaRepository;
import ar.edu.uca.bd.subtes.services.SubteService;

@TestPropertySource(locations="classpath:test.properties")
@RunWith(SpringRunner.class)
@Import(Application.class)
public class TestLineas {

	@Autowired
	private SubteService ser;

	@Autowired
	private CiudadRepository ciudadRep;
	
	@Autowired
	private EstacionRepository estacionRep;
	
	@Autowired
	private LineaRepository lineaRep;
	
	private Ciudad bsas=new Ciudad("CABA",null,null);
	private Linea lineaA = new Linea();
	private Estacion estacionCatedral = new Estacion("Estacion Catedral", null, null);
	private Estacion estacion9DeJulio = new Estacion("9 de Julio", null, null);
	private Estacion estacionTribunales = new Estacion("Tribunales", null, null);
	private Estacion estacionCongreso= new Estacion("Congreso de Tucuman", null, null);
	
	
	@Before
	public void setUp()
	{
		
		ser.saveCiudad(bsas);		

		lineaA.setId("A");
		lineaA.setCiudad(bsas);
		lineaA.setLongitudTotal(123.4);

		lineaRep.save(lineaA);
		
		estacionCatedral.setLinea(lineaA);
		estacion9DeJulio.setLinea(lineaA);
		estacionTribunales.setLinea(lineaA);
		estacionCongreso.setLinea(lineaA);

		estacionRep.save(estacionCatedral);
		estacionRep.save(estacion9DeJulio);		
		estacionRep.save(estacionTribunales);		
		estacionRep.save(estacionCongreso);		
		
		estacionCatedral.setConectaCon(new HashSet<Estacion>());
		estacionCatedral.getConectaCon().add(estacion9DeJulio);

		estacion9DeJulio.setConectaCon(new HashSet<Estacion>());
		estacion9DeJulio.getConectaCon().add(estacionCatedral);
		estacion9DeJulio.getConectaCon().add(estacionTribunales);

		estacionTribunales.setConectaCon(new HashSet<Estacion>());
		estacionTribunales.getConectaCon().add(estacionCongreso);
		estacionTribunales.getConectaCon().add(estacion9DeJulio);

		estacionCongreso.setConectaCon(new HashSet<Estacion>());
		estacionCongreso.getConectaCon().add(estacionTribunales);
		
		estacionRep.save(estacionCatedral);
		estacionRep.save(estacion9DeJulio);		
		estacionRep.save(estacionTribunales);		
		estacionRep.save(estacionCongreso);		
		
		lineaA.setCabecera(estacionCatedral);
		lineaA.setFin(estacionCongreso);		
		
		lineaRep.save(lineaA);
	}
	
	@After
	public void tearDown()
	{

	}
	
	@Test
	public void testRecorridoEnLaLinea()
	{
		List<Estacion> reco=ser.findAllEstacionesByLinea(lineaA);
		assertEquals(reco.get(0),lineaA.getCabecera());
		assertEquals(reco.get(1),estacion9DeJulio);
		assertEquals(reco.get(2),estacionTribunales);
		assertEquals(reco.get(3),estacionCongreso);
	}
	

	
}
