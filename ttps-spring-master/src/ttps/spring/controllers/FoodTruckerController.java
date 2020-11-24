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

import ttps.spring.clasesDAO.FoodTruckerDAO;
import ttps.spring.clasesDAO.ZonaDAO;
import ttps.spring.model.FoodTrucker;
import ttps.spring.model.Usuario;
import ttps.spring.model.Zona;

@RestController
@RequestMapping(value="/foodtruckers", produces = MediaType.APPLICATION_JSON_VALUE)

public class FoodTruckerController {

	@Autowired
	private FoodTruckerDAO fDAO;
	
	@Autowired
	private ZonaDAO zDAO;	
	
	@GetMapping
	public ResponseEntity<List<FoodTrucker>> getFoodTruckers( ){		
		List< FoodTrucker > foodTruckers = fDAO.recuperarTodos();		
		if(foodTruckers.isEmpty()){
			return new ResponseEntity<List<FoodTrucker>>(HttpStatus.NO_CONTENT);
		}	
	    return new ResponseEntity< List<FoodTrucker> > (foodTruckers, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity <FoodTrucker> crearFoodTrucker (@RequestBody FoodTrucker user ) {
		Usuario exist = (fDAO.buscarPorUsername(user.getUsername()));
		Zona zona = ( zDAO.recuperar( user.getZona().getId() ) );
		user.setZona(zona); 
		
	    if ( exist != null ) {
	    	return new ResponseEntity <FoodTrucker> (user, HttpStatus.CONFLICT);
	    } else {
	    	System.out.println("<< Guardando usuario " + user.getUsername() + " >>>");
	    	fDAO.persistir(user);
	    	System.out.println("<--- Usuario guardado --->");
	    	return new ResponseEntity <FoodTrucker> (user, HttpStatus.CREATED);
	    }		       
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<FoodTrucker> getFoodTrucker(@PathVariable("id") long id) {
		System.out.println("Obteniendo usuario con id " + id);
		FoodTrucker user = fDAO.recuperar(id);
		if (user == null) {
			System.out.println("Usuario con id " + id + " no encontrado");
			return new ResponseEntity<FoodTrucker>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<FoodTrucker>(user, HttpStatus.OK);
	 }
	
	@PutMapping("/{id}")
	public ResponseEntity<FoodTrucker> updateFoodTrucker( @PathVariable("id") long id, @RequestBody FoodTrucker user ){
		FoodTrucker u = fDAO.recuperar(id);
		if (u == null) {
			System.out.println("Usuario con id " + id + " no encontrado");
			return new ResponseEntity<FoodTrucker>(HttpStatus.NOT_FOUND);
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
			if ( user.getZona() != null ) {
				Zona zona = ( zDAO.recuperar( user.getZona().getId() ) );
				user.setZona(zona); 
			}		
			fDAO.actualizar(u);
			return new ResponseEntity<FoodTrucker>(u, HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<FoodTrucker> deleteFoodTrucker( @PathVariable("id") long id ){
		boolean existe = fDAO.existe(id);
		if ( !existe) {
			System.out.println("Usuario con id " + id + " no encontrado");
			return new ResponseEntity<FoodTrucker>(HttpStatus.NOT_FOUND);
		} else { fDAO.borrar(id);
				return new ResponseEntity<FoodTrucker>(HttpStatus.NO_CONTENT); }
	}
	
	@DeleteMapping
	public ResponseEntity<FoodTrucker> deleteAllFoodTruckers(){
		System.out.println("<--- Eliminando FoodTruckers --->");
		
		List< FoodTrucker > foodTruckers = fDAO.recuperarTodos();	
		ListIterator it = foodTruckers.listIterator();
		
		while(it.hasNext()) {
			FoodTrucker ft = (FoodTrucker) it.next();
			ft.setZona(null);
			fDAO.borrar(ft.getId());
		}

		if ( fDAO.recuperarTodos().size() > 0 ) {
			return new ResponseEntity<FoodTrucker>(HttpStatus.NOT_FOUND);
		} else { return new ResponseEntity<FoodTrucker>(HttpStatus.NO_CONTENT); }
		
	}
	
}
