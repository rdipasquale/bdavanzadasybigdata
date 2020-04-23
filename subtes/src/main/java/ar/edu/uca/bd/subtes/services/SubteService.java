package ar.edu.uca.bd.subtes.services;

import java.util.ArrayList;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.uca.bd.subtes.entities.Ciudad;
import ar.edu.uca.bd.subtes.entities.Estacion;
import ar.edu.uca.bd.subtes.entities.Linea;
import ar.edu.uca.bd.subtes.repositories.CiudadRepository;
import ar.edu.uca.bd.subtes.repositories.EstacionRepository;
import ar.edu.uca.bd.subtes.repositories.LineaRepository;

@Component
@Transactional
public class SubteService {

	@Autowired
	private LineaRepository lineaRep;
	
	@Autowired
	private EstacionRepository estRep;

	@Autowired
	private CiudadRepository ciudadRep;
	
	public SubteService() {
		// TODO Auto-generated constructor stub
	}
	
	public void saveCiudad(Ciudad c)
	{
		ciudadRep.save(c);
	}

	public Iterable<Ciudad> findAllCiudades()
	{
		return ciudadRep.findAll();
	}
	
//	public Iterable<Estacion> findAllEstacionesByLinea(Linea linea)
//	{
//		Estacion estacionActual = linea.getCabecera();
//		ArrayList<Estacion> recorrido = new ArrayList<Estacion>();
//		
//		Set<Estacion> estacionesPosibles = estRep.findByLinea(linea);
//		
//		estacionesPosibles.remove(cabecera);	
//		
//		while (estacionActual.getConectaCon t)
//		
//		while(!estacionesPosibles.isEmpty())
//		{
//			recorrido.add(estacionActual);
//			estacionActual.getConectaCon().forEach((Estacion estacionVecina)->{
//				if(estacionVecina.getLinea)
//			});
//			
//		}
//		
//		1)
//			Estacion 1 -> Estacion 2 -> est...
//		
//		
//		
//		
//	}
	
}
