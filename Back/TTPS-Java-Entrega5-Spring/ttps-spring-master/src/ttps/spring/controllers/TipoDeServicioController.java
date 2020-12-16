package ttps.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.clasesDAO.TipoDeServicioDAO;
import ttps.spring.model.TipoDeServicio;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(value="/tiposdeservicios", produces = MediaType.APPLICATION_JSON_VALUE)

public class TipoDeServicioController {
	
	@Autowired
	private TipoDeServicioDAO tsDAO;
	
	@GetMapping
	public ResponseEntity<List<TipoDeServicio>> getTiposDeServicio( ){	
		System.out.println("-- LLEGO A LA API --");
		List< TipoDeServicio > servicios = tsDAO.traerTodos();
		System.out.println("Se encontraron " + servicios.size() + " servicios.");
		if(servicios.isEmpty()){
			return new ResponseEntity<List<TipoDeServicio>>(HttpStatus.NO_CONTENT);
		}	
	    return new ResponseEntity< List<TipoDeServicio> > (servicios, HttpStatus.OK);
	}
	
	
	
	
	

}
