package ar.edu.uca.bd.subtes.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
	
	public List<Estacion> findAllEstacionesByLinea(Linea linea)
	{
		Estacion estacionActual = linea.getCabecera();
		ArrayList<Estacion> recorrido = new ArrayList<Estacion>();
		
		recorrido.add(estacionActual);
		while (!estacionActual.equals(linea.getFin()))
		{
			Estacion siguiente=estacionActual.getConectaCon().stream().filter(e->e.getLinea().equals(linea) && !recorrido.contains(e)).collect(Collectors.toList()).get(0);
			recorrido.add(siguiente);
			estacionActual=siguiente;
		}

		return recorrido;
	}
	
	public List<Estacion> findCaminoEntreEstaciones(Estacion origen, Estacion destino)
	{
		Estacion estacionActual = origen;
		ArrayList<Estacion> recorrido = new ArrayList<Estacion>();
		
		
		recorrido.add(estacionActual);
		
		while (!estacionActual.equals(destino))
		{
			
		}

		return recorrido;
	}
	
}
