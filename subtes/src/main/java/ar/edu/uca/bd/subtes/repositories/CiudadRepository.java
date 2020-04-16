package ar.edu.uca.bd.subtes.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.uca.bd.subtes.entities.Ciudad;

@Transactional
public interface CiudadRepository extends CrudRepository<Ciudad, Integer> {

}
