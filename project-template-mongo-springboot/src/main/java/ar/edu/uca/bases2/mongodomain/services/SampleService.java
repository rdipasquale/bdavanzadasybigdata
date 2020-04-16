package ar.edu.uca.bases2.mongodomain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.uca.bases2.mongodomain.entities.Concepto;
import ar.edu.uca.bases2.mongodomain.repositories.ConceptoRepository;


@Component
public class SampleService
{

  @Autowired
  private ConceptoRepository conceptoRepository;

  public SampleService()
  {

  }

  public List<Concepto> findAllConceptos()
  {
    return conceptoRepository.findAll();
  }

  
  public List<Concepto> findConceptosByDescripcion(String desc)
  {
	    return conceptoRepository.findByDescripcion(desc);
  }
  
  public void saveConcepto(Concepto c)
  {
	    conceptoRepository.save(c);
  }
}