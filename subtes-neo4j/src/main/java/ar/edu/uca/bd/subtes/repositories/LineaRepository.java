package ar.edu.uca.bd.subtes.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import ar.edu.uca.bd.subtes.entities.Linea;


public interface LineaRepository extends Neo4jRepository<Linea, String> {

}
