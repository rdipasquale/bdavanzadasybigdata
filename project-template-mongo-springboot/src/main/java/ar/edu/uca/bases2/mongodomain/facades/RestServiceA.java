package ar.edu.uca.bases2.mongodomain.facades;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.uca.bases2.mongodomain.entities.Concepto;
import ar.edu.uca.bases2.mongodomain.repositories.ConceptoRepository;

@RestController
@RequestMapping("/restservice")
public class RestServiceA {

	  @Autowired
	  private ConceptoRepository rep;
	  
	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  public List<Concepto> getAllConceptos() {
	    return rep.findAll();
	  }

	  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	  public Concepto getPetById(@PathVariable("id") String id) {
		  Optional<Concepto> salida=rep.findById(id);
		  if (salida==null) return null;
		  if (salida.isPresent()) return salida.get();
	    return null;
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  public void modifyParById(@PathVariable("id") Integer id, @Valid @RequestBody Concepto con) {
	    rep.save(con);
	  }
	  
	  @RequestMapping(value = "/", method = RequestMethod.POST)
	  public Concepto createPet(@Valid @RequestBody Concepto conc) {
	    rep.save(conc);
	    return conc;
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deletePet(@PathVariable String id) {
		  Optional<Concepto> salida=rep.findById(id);
		  if (salida==null) return ;
		  if (!salida.isPresent()) return ;
	    rep.delete(salida.get());
	  }
	  
}
