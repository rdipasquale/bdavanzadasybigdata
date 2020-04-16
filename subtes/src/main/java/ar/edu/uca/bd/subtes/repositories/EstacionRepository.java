package ar.edu.uca.bd.subtes.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.uca.bd.subtes.entities.Estacion;

@Transactional
public interface EstacionRepository extends CrudRepository<Estacion, Integer> {

}
