package ttps.spring.controllers;

import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.clasesDAO.OrganizadorDAO;
import ttps.spring.model.FoodTrucker;
import ttps.spring.model.Organizador;
import ttps.spring.model.Usuario;
import ttps.spring.model.Zona;

@RestController
@RequestMapping(value="/organizadores", produces = MediaType.APPLICATION_JSON_VALUE)

public class OrganizadorController {
	
	@Autowired
	private OrganizadorDAO oDAO;
	
	@GetMapping
	public ResponseEntity<List<Organizador>> getOrganizadorres( ){		
		List< Organizador > organizadores = oDAO.recuperarTodos();		
		if(organizadores.isEmpty()){
			return new ResponseEntity<List<Organizador>>(HttpStatus.NO_CONTENT);
		}	
	    return new ResponseEntity< List<Organizador> > (organizadores, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity <Organizador> crearOrganizador (@RequestBody Organizador user ) {
		Usuario exist = (oDAO.buscarPorUsername(user.getUsername()));
		
	    if ( exist != null ) {
	    	return new ResponseEntity <Organizador> (user, HttpStatus.CONFLICT);
	    } else {
	    	System.out.println("<< Guardando usuario " + user.getUsername() + " >>>");
	    	oDAO.persistir(user);
	    	System.out.println("<--- Usuario guardado --->");
	    	return new ResponseEntity <Organizador> (user, HttpStatus.CREATED);
	    }		       
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Organizador> getOrganizador (@PathVariable("id") long id) {
		System.out.println("Obteniendo usuario con id " + id);
		Organizador user = oDAO.recuperar(id);
		if (user == null) {
			System.out.println("Usuario con id " + id + " no encontrado");
			return new ResponseEntity<Organizador>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Organizador>(user, HttpStatus.OK);
	 }
	
	@PutMapping("/{id}")
	public ResponseEntity<Organizador> updateOrganizador( @PathVariable("id") long id, @RequestBody Organizador user ){
		Organizador u = oDAO.recuperar(id);
		if (u == null) {
			System.out.println("Usuario con id " + id + " no encontrado");
			return new ResponseEntity<Organizador>(HttpStatus.NOT_FOUND);
		} else {
			if ( user.getApellido() != null ) {
				u.setApellido(user.getApellido());
			}
			if ( user.getNombre() != null ) {
				u.setNombre(user.getNombre());
			}
			if ( user.getUsername() != null ) {
				u.setUsername(user.getUsername());
			}
			if ( user.getPassword() != null ) {
				u.setPassword(user.getPassword());
			}		
			oDAO.actualizar(u);
			return new ResponseEntity<Organizador>(user, HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Organizador> deleteOrganizador( @PathVariable("id") long id ){
		boolean existe = oDAO.existe(id);
		if ( !existe) {
			System.out.println("Usuario con id " + id + " no encontrado");
			return new ResponseEntity<Organizador>(HttpStatus.NOT_FOUND);
		} else { oDAO.borrar(id);
				return new ResponseEntity<Organizador>(HttpStatus.NO_CONTENT); }
	}
	
	@DeleteMapping()
	public ResponseEntity<Organizador> deleteAllOrganizadores(){
		System.out.println("<--- Eliminando FoodTruckers --->");
		List <Organizador> organizadores = oDAO.recuperarTodos();	
		ListIterator it = organizadores.listIterator();
		while(it.hasNext()) {
			Organizador or = (Organizador) it.next();
			oDAO.borrar(or.getId());
		}
		if ( oDAO.recuperarTodos().size() > 0 ) {
			return new ResponseEntity<Organizador>(HttpStatus.NOT_FOUND);
		} else { return new ResponseEntity<Organizador>(HttpStatus.NO_CONTENT); }
	}
	
	
}
