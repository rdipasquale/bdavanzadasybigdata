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
public class TestCombinaciones {

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
	private Linea lineaB = new Linea();
	
	private Estacion estacionCatedral = new Estacion( "Estacion Catedral", null, null);
	private Estacion estacion9DeJulio = new Estacion( "9 de Julio", null, null);
	private Estacion estacionTribunales = new Estacion( "Tribunales", null, null);
	private Estacion estacionCongreso= new Estacion( "Congreso de Tucuman", null, null);
	
	
	private Estacion estacionAlem = new Estacion( "Leandro N. Alem", null, null);
	private Estacion estacionFlorida = new Estacion( "Florida", null, null);
	private Estacion estacionPellegrini = new Estacion( "Carlos Pellegrini", null, null);
	private Estacion estacionUruguay = new Estacion( "Uruguay", null, null);
	private Estacion estacionPueyrredon = new Estacion( "Pueyrredon", null, null);
	
	@Before
	public void setUp()
	{
		
		ser.saveCiudad(bsas);		

		lineaA.setId("A");
		lineaA.setCiudad(bsas);
		lineaA.setLongitudTotal(123.4);
		
		lineaB.setId("B");
		lineaB.setCiudad(bsas);
		lineaB.setLongitudTotal(12.45);
		
		lineaRep.save(lineaA);
		lineaRep.save(lineaB);
		
		estacionCatedral.setLinea(lineaA);
		estacion9DeJulio.setLinea(lineaA);
		estacionTribunales.setLinea(lineaA);
		estacionCongreso.setLinea(lineaA);
		
		estacionAlem.setLinea(lineaB);
		estacionFlorida.setLinea(lineaB);
		estacionPellegrini.setLinea(lineaB);
		estacionUruguay.setLinea(lineaB);
		estacionPueyrredon.setLinea(lineaB);

		estacionRep.save(estacionCatedral);
		estacionRep.save(estacion9DeJulio);		
		estacionRep.save(estacionTribunales);		
		estacionRep.save(estacionCongreso);
		
		estacionRep.save(estacionAlem);
		estacionRep.save(estacionFlorida);		
		estacionRep.save(estacionPellegrini);
		estacionRep.save(estacionUruguay);
		estacionRep.save(estacionPueyrredon);
		
		
		//Conexiones de linea A
		
		estacionCatedral.setConectaCon(new HashSet<Estacion>());
		estacionCatedral.getConectaCon().add(estacion9DeJulio);

		estacion9DeJulio.setConectaCon(new HashSet<Estacion>());
		estacion9DeJulio.getConectaCon().add(estacionCatedral);
		estacion9DeJulio.getConectaCon().add(estacionTribunales);
		estacion9DeJulio.getConectaCon().add(estacionPellegrini);

		estacionTribunales.setConectaCon(new HashSet<Estacion>());
		estacionTribunales.getConectaCon().add(estacionCongreso);
		estacionTribunales.getConectaCon().add(estacion9DeJulio);

		estacionCongreso.setConectaCon(new HashSet<Estacion>());
		estacionCongreso.getConectaCon().add(estacionTribunales);
		
		
		//Conexiones de linea B
		
		
		estacionAlem.setConectaCon(new HashSet<Estacion>());
		estacionAlem.getConectaCon().add(estacionFlorida);

		estacionFlorida.setConectaCon(new HashSet<Estacion>());
		estacionFlorida.getConectaCon().add(estacionPellegrini);
		estacionFlorida.getConectaCon().add(estacionAlem);
		
		
		
		estacionPellegrini.setConectaCon(new HashSet<Estacion>());
		estacionPellegrini.getConectaCon().add(estacionFlorida);
		estacionPellegrini.getConectaCon().add(estacion9DeJulio);
		estacionPellegrini.getConectaCon().add(estacionUruguay);
		
		estacionUruguay.setConectaCon(new HashSet<Estacion>());
		estacionUruguay.getConectaCon().add(estacionPellegrini);
		estacionUruguay.getConectaCon().add(estacionPueyrredon);
		
		estacionPueyrredon.setConectaCon(new HashSet<Estacion>());
		estacionPueyrredon.getConectaCon().add(estacionUruguay);
		
		
		//Guardado
		
		estacionRep.save(estacionCatedral);
		estacionRep.save(estacion9DeJulio);		
		estacionRep.save(estacionTribunales);		
		estacionRep.save(estacionCongreso);
		
		estacionRep.save(estacionAlem);
		estacionRep.save(estacionFlorida);		
		estacionRep.save(estacionPellegrini);
		
		lineaA.setCabecera(estacionCatedral);
		lineaA.setFin(estacionCongreso);		
		
		lineaB.setCabecera(estacionAlem);
		lineaB.setFin(estacionPueyrredon);
		
		lineaRep.save(lineaA);
		lineaRep.save(lineaB);
	}
	
	@After
	public void tearDown()
	{

	}
	
	@Test
	public void testRecorridoEntreCabeceraDeLineaAHastaFinDeLineaB()
	{
		Estacion estacionA = lineaA.getCabecera();
		Estacion estacionB = lineaB.getFin();
		
		List<Estacion> reco=ser.findCaminoEntreEstaciones(estacionA, estacionB);
		assertEquals(reco.get(0),estacionA);
		assertEquals(reco.get(1),estacion9DeJulio);
		assertEquals(reco.get(2),estacionPellegrini);
		assertEquals(reco.get(3),estacionUruguay);
		assertEquals(reco.get(4),estacionPueyrredon);
		
	}
	
	@Test
	public void testRecorridoEntreEstacionesNoTerminales()
	{
		Estacion estacionA = estacionFlorida;
		Estacion estacionB = estacionCongreso;
		
		List<Estacion> reco=ser.findCaminoEntreEstaciones(estacionA, estacionB);
		assertEquals(reco.get(0),estacionA);
		assertEquals(reco.get(1),estacionPellegrini);
		assertEquals(reco.get(2),estacion9DeJulio);
		assertEquals(reco.get(3),estacionTribunales);
		assertEquals(reco.get(4),estacionCongreso);
		
	}
	

	
	
}
