package ar.edu.uca.bd.subtes.services;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.uca.bd.subtes.entities.Ciudad;
import ar.edu.uca.bd.subtes.entities.Estacion;
import ar.edu.uca.bd.subtes.entities.Linea;
import ar.edu.uca.bd.subtes.repositories.CiudadRepository;
import ar.edu.uca.bd.subtes.repositories.EstacionRepository;
import ar.edu.uca.bd.subtes.repositories.LineaRepository;

@Component
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
		Integer nivelActual = 0;
		ArrayList<Estacion> recorrido = new ArrayList<Estacion>();
		HashMap<Estacion, Integer> estacionNivel = new HashMap<Estacion,Integer>();
		Deque<Estacion> nodosPorVisitar = new ArrayDeque<Estacion>();
		
		
		//Implementacion con un BFS de orden O(m+n) m: nodos n:ejes
		//Carga todo el grafo, con lazy loading puede ser ineficiente.

		//Breath First Search guardando los niveles
		nodosPorVisitar.add(origen);
		estacionNivel.put(origen,0);
		while (!nodosPorVisitar.isEmpty())
		{
			estacionActual = nodosPorVisitar.pop();
			nivelActual = estacionNivel.get(estacionActual);
			
			for (Estacion estacionVecina: estacionActual.getConectaCon()) {
				
				if (!estacionNivel.containsKey(estacionVecina)) {
					estacionNivel.put(estacionVecina, nivelActual + 1);
					nodosPorVisitar.add(estacionVecina);
				}
			}
			
		}
		
		//Recupero el camino hacia atras
		estacionActual = destino;
	
		while(estacionActual != origen) {
			recorrido.add(estacionActual);
			estacionActual = Collections.min(estacionActual.getConectaCon(), Comparator.comparing(e->estacionNivel.get(e)));
		}
		recorrido.add(origen);

		Collections.reverse(recorrido);
		return recorrido;
	}
	
}
