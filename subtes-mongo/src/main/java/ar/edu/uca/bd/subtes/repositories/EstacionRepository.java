package ar.edu.uca.bd.subtes.repositories;

import java.util.Set;

import org.springframework.data.mongodb.repository.MongoRepository;

import ar.edu.uca.bd.subtes.entities.Estacion;
import ar.edu.uca.bd.subtes.entities.Linea;


public interface EstacionRepository extends MongoRepository<Estacion, String> {
	
	public Set<Estacion> findByLinea(Linea linea);

}
