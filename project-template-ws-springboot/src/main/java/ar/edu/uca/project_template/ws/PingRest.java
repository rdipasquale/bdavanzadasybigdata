package ar.edu.uca.project_template.ws;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping")
@CrossOrigin
public class PingRest {
	
	
	@RequestMapping(value = "/ping", method = RequestMethod.GET, produces = "application/json")
	public String ping(){
		return "pong";
	}
	
}
