package ar.edu.uca.bd.subtes.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.uca.bd.subtes.entities.Ciudad;
import ar.edu.uca.bd.subtes.repositories.CiudadRepository;
import ar.edu.uca.bd.subtes.repositories.EstacionRepository;
import ar.edu.uca.bd.subtes.repositories.LineaRepository;

@Component
@Transactional
public class SubteService {

	@Autowired
	private LineaRepository lineaRep;
	
	@Autowired
	private EstacionRepository estRep;

	@Autowired
	private CiudadRepository ciudadRep;
	
	public SubteService() {
		// TODO Auto-generated constructor stub
	}
	
	public void saveCiudad(Ciudad c)
	{
		ciudadRep.save(c);
	}

	public Iterable<Ciudad> findAllCiudades()
	{
		return ciudadRep.findAll();
	}
	
}
