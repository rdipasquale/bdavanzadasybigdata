package ar.edu.uca.bd.subtes.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.uca.bd.subtes.entities.Ciudad;

@Transactional
public interface CiudadRepository extends CrudRepository<Ciudad, Integer> {
	
	public List<Ciudad> findByNombre(String nombre);

}
