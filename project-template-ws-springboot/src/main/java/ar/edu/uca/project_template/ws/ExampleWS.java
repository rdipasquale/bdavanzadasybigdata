package ar.edu.uca.project_template.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.uca.project_template.entities.Agente;
import ar.edu.uca.project_template.services.ExampleService;
import ar.edu.uca.project_template.services.ExampleBService;

@CrossOrigin
@RestController
@RequestMapping("/ExampleService")
public class ExampleWS
{

  @Autowired
  private ExampleService ser;
  
  @Autowired
  private ExampleBService tra;
  
  @RequestMapping(path="/findAllAgentes",method = RequestMethod.GET)  
  public List<Agente> findAllAgentes()
  {
    return ser.findAllAgente();
  }

  @RequestMapping(path="/getAgenteById",method = RequestMethod.GET)
  public Agente getAgenteById(@RequestParam(name = "id") int ageId)
  {
    return ser.exampleLogicAgentes(ageId);
  }

  @RequestMapping(path="/hacerAyB",method = RequestMethod.POST)
  public void hacerAyB() 
  {
    ser.hacerA();
    tra.hacerB();
  }
  

}