package ar.edu.uca.project_template.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.uca.project_template.entities.Agente;
import ar.edu.uca.project_template.entities.Maquina;
import ar.edu.uca.project_template.repositories.AgenteRepository;
import ar.edu.uca.project_template.ws.ExampleException;


@Component
//@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.SUPPORTS,noRollbackFor = ExampleException.class)
public class ExampleService {

	  private static final Logger LOG = LoggerFactory.getLogger(ExampleService.class);

	  @Autowired
	  private AgenteRepository agentesRepository;
	  
	  public ExampleService() {
		// TODO Auto-generated constructor stub
	  }
	  
	  public Agente exampleLogicAgentes(int ageId)
	  {
		  // TODO: Reemplazar con logging aspect
		  LOG.info("exampleLogicAgentes => " + ageId);
		  Optional<Agente> age= agentesRepository.findById(ageId);
		  LOG.info("exampleLogicAgentes <= " + age.get());
		  return age.get();
	  }
	  
	  public List<Agente> findAllAgente()
	  {    
		  // simple bridge
		  return (List<Agente>)agentesRepository.findAll();
	  }
	  
	  
		public void hacerA()
		{
				Agente a=new Agente();
				/*...*/
		}
 
	  

}
