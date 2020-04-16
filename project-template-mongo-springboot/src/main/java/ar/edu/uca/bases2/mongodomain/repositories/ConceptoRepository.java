package ar.edu.uca.bases2.mongodomain.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ar.edu.uca.bases2.mongodomain.entities.Concepto;


public interface ConceptoRepository  extends MongoRepository<Concepto, String>{

	public List<Concepto> findByDescripcion(String desc);
	
}
