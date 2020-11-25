package ttps.spring.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.clasesDAO.FoodTruckDAO;
import ttps.spring.clasesDAO.FoodTruckerDAO;
import ttps.spring.clasesDAO.TipoDeServicioDAO;
import ttps.spring.model.FoodTruck;
import ttps.spring.model.FoodTrucker;
import ttps.spring.model.TipoDeServicio;
import ttps.spring.model.FoodTruck;
import ttps.spring.model.Usuario;

@RestController
@RequestMapping(value="/foodtrucks", produces = MediaType.APPLICATION_JSON_VALUE)

public class FoodTruckController {

	@Autowired
	private FoodTruckDAO ftDAO;
	@Autowired
	private FoodTruckerDAO ftrDAO;
	@Autowired
	private TipoDeServicioDAO tsDAO;
	
	@GetMapping
	public ResponseEntity<List<FoodTruck>> getFoodTruckers( ){		
		List< FoodTruck > FoodTrucks = ftDAO.recuperarTodos();		
		if(FoodTrucks.isEmpty()){
			return new ResponseEntity<List<FoodTruck>>(HttpStatus.NO_CONTENT);
		}	
	    return new ResponseEntity< List<FoodTruck> > (FoodTrucks, HttpStatus.OK);
	}

	@PostMapping("/{id}")
	public ResponseEntity <FoodTruck> crearFoodTruck (@RequestBody FoodTruck foodtruck, @PathVariable("id") long id) {
		FoodTrucker foodtrucker = ftrDAO.recuperar(id);
	    foodtruck.setFoodtrucker(foodtrucker);    
	    ListIterator it = foodtruck.getTipos().listIterator();
	    List<TipoDeServicio> tipos = new ArrayList();
		while(it.hasNext()) {	
			TipoDeServicio ts = (TipoDeServicio) it.next(); 
			System.out.println( " << Buscando servicio con ID = " + ts.getId() );
			TipoDeServicio persistido = tsDAO.recuperar( ts.getId() );
			System.out.println( "Se encontro el servicio = " + ts.getNombre() );
			tipos.add(persistido);
		}	
		foodtruck.setTipos(null);
		if ( foodtrucker == null ) {
	    	return new ResponseEntity <FoodTruck> (foodtruck, HttpStatus.CONFLICT);
	    } else {
		    	ftDAO.persistir(foodtruck);    	
		    	foodtruck.setTipos(tipos);
		    	ftDAO.actualizar(foodtruck);
		    	System.out.println( " <<-- FoodTruck creado -->> " );
		    	return new ResponseEntity <FoodTruck> (foodtruck, HttpStatus.CREATED);
	    }		       
    }
	
}
