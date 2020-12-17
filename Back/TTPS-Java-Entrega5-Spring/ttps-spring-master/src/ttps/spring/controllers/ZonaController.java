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

import ttps.spring.clasesDAO.*;
import ttps.spring.model.TipoDeServicio;
import ttps.spring.model.Zona;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(value="/zonas", produces = MediaType.APPLICATION_JSON_VALUE)

public class ZonaController {
	
	@Autowired
	private ZonaDAO zDAO;
	
	@GetMapping
	public ResponseEntity<List<Zona>> getTiposDeServicio( ){	
		List< Zona > zonas = zDAO.traerTodas();
		if(zonas.isEmpty()){
			return new ResponseEntity<List<Zona>>(HttpStatus.NO_CONTENT);
		}	
	    return new ResponseEntity< List<Zona> > (zonas, HttpStatus.OK);
	}

}
