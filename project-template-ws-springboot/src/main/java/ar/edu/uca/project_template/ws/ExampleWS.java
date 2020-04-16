package ar.edu.uca.project_template.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.uca.project_template.entities.Agente;
import ar.edu.uca.project_template.services.ExampleService;

@CrossOrigin
@RestController("/ExampleService")
@RequestMapping("/ExampleService")
public class ExampleWS
{

  @Autowired
  private ExampleService ser;

  @RequestMapping("/findAllAgentes")
  public List<Agente> findAllAgentes()
  {
    return ser.findAllAgente();
  }

  @RequestMapping("/getAgenteById")
  public Agente getAgenteById(@RequestParam(name = "id") int ageId)
  {
    return ser.exampleLogicAgentes(ageId);
  }


}