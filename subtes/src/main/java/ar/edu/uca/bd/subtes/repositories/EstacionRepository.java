package ar.edu.uca.bd.subtes.repositories;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.uca.bd.subtes.entities.Estacion;
import ar.edu.uca.bd.subtes.entities.Linea;

@Transactional
public interface EstacionRepository extends CrudRepository<Estacion, Integer> {
	
	public Set<Estacion> findByLinea(Linea linea);

}
