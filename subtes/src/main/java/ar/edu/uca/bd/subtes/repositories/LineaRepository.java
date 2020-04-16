package ar.edu.uca.bd.subtes.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.uca.bd.subtes.entities.Linea;

@Transactional
public interface LineaRepository extends CrudRepository<Linea, String> {

}
