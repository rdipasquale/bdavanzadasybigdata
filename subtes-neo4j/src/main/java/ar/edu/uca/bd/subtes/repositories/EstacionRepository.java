package ar.edu.uca.bd.subtes.repositories;

import java.util.Set;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import ar.edu.uca.bd.subtes.entities.Estacion;
import ar.edu.uca.bd.subtes.entities.Linea;


public interface EstacionRepository extends Neo4jRepository<Estacion, Long> {
	
	public Set<Estacion> findByLinea(Linea linea);

}
