package ar.edu.uca.bd.template.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import ar.edu.uca.bd.template.domain.Person;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long> {
}
