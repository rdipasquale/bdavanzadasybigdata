package ar.edu.uca.bd.subtes.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ar.edu.uca.bd.subtes.entities.Ciudad;

public interface CiudadRepository extends MongoRepository<Ciudad, String> {
	
	public List<Ciudad> findByNombre(String nombre);

}
