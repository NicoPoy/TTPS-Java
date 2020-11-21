package ttps.spring.servlets.foodtruck;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.*;

import ttps.spring.clasesDAO.UsuarioDAO;
import ttps.spring.model.Usuario;

@RestController
@RequestMapping(value="/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)

public class UsuarioController {
	@Autowired
	private UsuarioDAO uDAO;	

	@GetMapping
	public ResponseEntity<List<Usuario>> getUsuarios( ){		
		List< Usuario > users = uDAO.recuperarTodos();
		if(users.isEmpty()){
			return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);
		}	
	    return new ResponseEntity< List<Usuario> > (users, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity <Usuario> crearUsuario (@RequestBody Usuario user) {
		Usuario exist = (uDAO.buscarPorUsername(user.getUsername()));
	    if ( exist != null ) {
	    	return new ResponseEntity <Usuario> (user, HttpStatus.CONFLICT);
	    } else {
	    	System.out.println("<< Guardando usuario " + user.getUsername() + " >>>");
	    	uDAO.persistir(user);
	    	System.out.println("<--- Usuario guardado --->");
	    	return new ResponseEntity <Usuario> (user, HttpStatus.CREATED);
	    }		       
    }

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable("id") long id) {
		System.out.println("Obteniendo usuario con id " + id);
		Usuario user = uDAO.recuperar(id);
		if (user == null) {
			System.out.println("Usuario con id " + id + " no encontrado");
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	 }

	
	
	
}