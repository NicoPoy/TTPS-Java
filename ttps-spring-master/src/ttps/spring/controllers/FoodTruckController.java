package ttps.spring.controllers;

import java.util.List;

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
import ttps.spring.model.FoodTruck;
import ttps.spring.model.FoodTrucker;
import ttps.spring.model.FoodTruck;
import ttps.spring.model.Usuario;

@RestController
@RequestMapping(value="/foodtrucks", produces = MediaType.APPLICATION_JSON_VALUE)

public class FoodTruckController {

	@Autowired
	private FoodTruckDAO ftDAO;
	@Autowired
	private FoodTruckerDAO ftrDAO;
	
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
	    
	    
	    
	    System.out.println(foodtruck.getTipos().size());
	    
	    
	    
	    
		if ( foodtrucker == null ) {
	    	return new ResponseEntity <FoodTruck> (foodtruck, HttpStatus.CONFLICT);
	    } else {
	    	ftDAO.persistir(foodtruck);
	    	return new ResponseEntity <FoodTruck> (foodtruck, HttpStatus.CREATED);
	    }		       
    }
	
}
