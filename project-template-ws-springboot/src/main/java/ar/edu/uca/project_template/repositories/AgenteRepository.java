package ar.edu.uca.project_template.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ar.edu.uca.project_template.entities.Agente;

@Transactional
public interface AgenteRepository extends CrudRepository<Agente, Integer> {
		
		@Cacheable("basicCache")
		@Query("select a FROM Agente a WHERE  a.fechaDesde<=SYSDATE and (a.fechaHasta is null or a.fechaHasta>trunc(SYSDATE)) order by a.ageId")
		public List<Agente> findAgentesVigentes() ;

}
