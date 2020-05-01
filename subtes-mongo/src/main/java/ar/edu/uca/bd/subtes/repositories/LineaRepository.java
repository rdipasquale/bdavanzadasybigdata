package ar.edu.uca.bd.subtes.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import ar.edu.uca.bd.subtes.entities.Linea;


public interface LineaRepository extends MongoRepository<Linea, String> {

}
