package ar.edu.uca.bd.subtes.repositories;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import ar.edu.uca.bd.subtes.entities.Ciudad;

public interface CiudadRepository extends Neo4jRepository<Ciudad, Long> {
	
	public List<Ciudad> findByNombre(String nombre);

}
