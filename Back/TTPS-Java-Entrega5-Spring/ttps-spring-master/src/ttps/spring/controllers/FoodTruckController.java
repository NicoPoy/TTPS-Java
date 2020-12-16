package ttps.spring.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.clasesDAO.FoodTruckDAO;
import ttps.spring.clasesDAO.FoodTruckerDAO;
import ttps.spring.clasesDAO.TipoDeServicioDAO;
import ttps.spring.model.FoodTruck;
import ttps.spring.model.FoodTrucker;
import ttps.spring.model.Organizador;
import ttps.spring.model.FoodTruck;
import ttps.spring.model.TipoDeServicio;
import ttps.spring.model.FoodTruck;
import ttps.spring.model.Usuario;
import ttps.spring.services.*;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(value = "/foodtrucks", produces = MediaType.APPLICATION_JSON_VALUE)

public class FoodTruckController {

	@Autowired
	private FoodTruckDAO ftDAO;
	@Autowired
	private FoodTruckerDAO ftrDAO;
	@Autowired
	private TipoDeServicioDAO tsDAO;

	@GetMapping
	public ResponseEntity<List<FoodTruck>> getFoodTruck() {
		List<FoodTruck> FoodTrucks = ftDAO.recuperarTodos();
		if (FoodTrucks.isEmpty()) {
			return new ResponseEntity<List<FoodTruck>>(HttpStatus.NO_CONTENT);
		} else {
			ListIterator it = FoodTrucks.listIterator();
			List<FoodTruck> resultadoFoodTrucks = new ArrayList();
			while (it.hasNext()) {
				FoodTruck ft = (FoodTruck) it.next();
				ft.setTipos( tsDAO.encontrarTodosParaFoodtrucker( ft.getId() ) );
				resultadoFoodTrucks.add(ft);
			}		
			System.out.println("< Se encontraron " +resultadoFoodTrucks.size() + " >");
			return new ResponseEntity<List<FoodTruck>>(resultadoFoodTrucks, HttpStatus.OK);
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<FoodTruck>> getFoodTruckParaUsuario( @PathVariable("id") long id, @RequestHeader String token ){	
		FoodTrucker foodtrucker = ftrDAO.recuperar(id);
		if (foodtrucker != null) {
			if (!token.equals(foodtrucker.getId() + "123456")) {
				System.out.println(" <-- Token Invalido --> ");
				return new ResponseEntity<List<FoodTruck>>(HttpStatus.UNAUTHORIZED);
			} else {
				System.out.println("<<-- Buscando FoodTrucks para el usuario " + foodtrucker.getUsername() + " -->>");
				List<FoodTruck> foodTrucks = ftDAO.encontrarTodosParaUsuarioID(foodtrucker.getId());				
				ListIterator it = foodTrucks.listIterator();
				List<FoodTruck> resultadoFoodTrucks = new ArrayList();
				while (it.hasNext()) {
					FoodTruck ft = (FoodTruck) it.next();
					ft.setTipos( tsDAO.encontrarTodosParaFoodtrucker( ft.getId() ) );
					resultadoFoodTrucks.add(ft);
				}		
				System.out.println("< Se encontraron " +resultadoFoodTrucks.size() + " >");
				return new ResponseEntity<List<FoodTruck>>(resultadoFoodTrucks, HttpStatus.OK);
			}
		} else {  System.out.println("!!-- No se encontro el usuario con id " + id + " --!!");
				  return new ResponseEntity<List<FoodTruck>>(HttpStatus.OK); }
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<FoodTruck> crearFoodTruck(@RequestBody FoodTruck foodtruck, @PathVariable("id") long id, @RequestHeader String token) {
		
		System.out.println("Llega el token = " + token);
		
		FoodTrucker foodtrucker = ftrDAO.recuperar(id);
		if (foodtrucker != null) {
			if (!TokenServices.validateToken(token)) {
				System.out.println(" <-- Token Invalido --> ");
				return new ResponseEntity<FoodTruck>(HttpStatus.UNAUTHORIZED);
			} else {
				foodtruck.setFoodtrucker(foodtrucker);
				ListIterator it = foodtruck.getTipos().listIterator();
				List<TipoDeServicio> tipos = new ArrayList();
				while (it.hasNext()) {
					TipoDeServicio ts = (TipoDeServicio) it.next();
					System.out.println(" << Buscando servicio con ID = " + ts.getId());
					TipoDeServicio persistido = tsDAO.recuperar(ts.getId());
					System.out.println("Se encontro el servicio = " + ts.getNombre());
					tipos.add(persistido);
				}
				foodtruck.setTipos(null);
				ftDAO.persistir(foodtruck);
				foodtruck.setTipos(tipos);
				ftDAO.actualizar(foodtruck);
				System.out.println(" <<-- FoodTruck creado -->> ");
				return new ResponseEntity<FoodTruck>(foodtruck, HttpStatus.CREATED);
			}
		} else {
			return new ResponseEntity<FoodTruck>(foodtruck, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<FoodTruck> updateFoodTruck(@PathVariable("id") long id, @RequestBody FoodTruck foodtruck, @RequestHeader String token) {
		FoodTruck foodt = ftDAO.recuperar(id);
		if (foodt != null) {
			if (!token.equals(foodt.getFoodtrucker().getId() + "123456")) {
				System.out.println(" <-- Token Invalido --> ");
				return new ResponseEntity<FoodTruck>(HttpStatus.UNAUTHORIZED);
			} else {
				FoodTruck ft = ftDAO.recuperar(id);
				if (ft == null) {
					return new ResponseEntity<FoodTruck>(HttpStatus.NOT_FOUND);
				} else {
					if (foodtruck.getNombre() != null) {
						ft.setNombre(foodtruck.getNombre());
					}
					if (foodtruck.getDescripcion() != null) {
						ft.setDescripcion(foodtruck.getDescripcion());
					}
					if (foodtruck.getUrl() != null) {
						ft.setUrl(foodtruck.getUrl());
					}
					if (foodtruck.getWhatsapp() != null) {
						ft.setWhatsapp(foodtruck.getWhatsapp());
					}
					if (foodtruck.getInstagram() != null) {
						ft.setInstagram(foodtruck.getInstagram());
					}
					if (foodtruck.getTwitter() != null) {
						ft.setTwitter(foodtruck.getTwitter());
					}
					if (foodtruck.getTipos() != null) {
						ListIterator it = foodtruck.getTipos().listIterator();
						List<TipoDeServicio> tipos = new ArrayList();
						while (it.hasNext()) {
							TipoDeServicio ts = (TipoDeServicio) it.next();
							System.out.println(" << Buscando servicio con ID = " + ts.getId());
							TipoDeServicio persistido = tsDAO.recuperar(ts.getId());
							System.out.println("Se encontro el servicio = " + persistido.getNombre());
							tipos.add(persistido);
						}
						ft.setTipos(tipos);
					}
					ftDAO.actualizar(ft);
					return new ResponseEntity<FoodTruck>(foodtruck, HttpStatus.OK);
				}
			}
		} else {
			return new ResponseEntity<FoodTruck>(foodtruck, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<FoodTruck> deleteFoodTruck(@PathVariable("id") long id, @RequestHeader String token) {
		FoodTruck foodt = ftDAO.recuperar(id);
		if (foodt != null) {
			if (!token.equals(foodt.getFoodtrucker().getId() + "123456")) {
				System.out.println(" <-- Token Invalido --> ");
				return new ResponseEntity<FoodTruck>(HttpStatus.UNAUTHORIZED);
			} else {
				boolean existe = ftDAO.existe(id);
				if (!existe) {
					return new ResponseEntity<FoodTruck>(HttpStatus.NOT_FOUND);
				} else {
					foodt.setTipos(null);
					ftDAO.actualizar(foodt);
					ftDAO.borrar(id);
					System.out.println(" <<< Foodtruck " + foodt.getNombre() + " eliminado >>> ");
					return new ResponseEntity<FoodTruck>(HttpStatus.NO_CONTENT);
				}
			}
		} else {
			return new ResponseEntity<FoodTruck>(HttpStatus.NOT_FOUND);
		}
	}

	/*
	 * @DeleteMapping public ResponseEntity<FoodTruck> deleteAllFoodTrucks(){ List
	 * <FoodTruck> foodtrucks = ftDAO.recuperarTodos(); ListIterator it =
	 * foodtrucks.listIterator(); while(it.hasNext()) { FoodTruck ft = (FoodTruck)
	 * it.next(); ftDAO.borrar(ft.getId()); } if ( ftDAO.recuperarTodos().size() > 0
	 * ) { return new ResponseEntity<FoodTruck>(HttpStatus.NOT_FOUND); } else {
	 * return new ResponseEntity<FoodTruck>(HttpStatus.NO_CONTENT); } }
	 */

}
