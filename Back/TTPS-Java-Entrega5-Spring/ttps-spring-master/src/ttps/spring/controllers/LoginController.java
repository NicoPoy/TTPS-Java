package ttps.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.clasesDAO.*;
import ttps.spring.model.Usuario;
import ttps.spring.services.Credentials;
import ttps.spring.services.TokenServices;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(value="/auth/login", produces = MediaType.APPLICATION_JSON_VALUE)

public class LoginController {

	@Autowired
	private UsuarioDAO uDAO;
	
	private final int EXPIRATION_IN_SEC = 100;
	
/*	@PostMapping
	public ResponseEntity<String> login(@RequestHeader String username, @RequestHeader String password){
		Usuario u = uDAO.login(username, password);
		if( u != null ) {
			HttpHeaders header =  new HttpHeaders();
			header.set("token", u.getId()+"123456");
			if ( u.esFoodTrucker() ) {
				header.set("tipo", "FoodTrucker");
				return new ResponseEntity<String> (header, HttpStatus.OK);
			} else if ( u.esOrganizador() ) {
				header.set("tipo", "Organizador");
				return new ResponseEntity<String> (header, HttpStatus.OK);
			} else { return new ResponseEntity<String> (header, HttpStatus.NO_CONTENT); }
		}
		return  new ResponseEntity<String> ("Usuario o contraseña incorrectos", HttpStatus.NO_CONTENT);
	} */
	
	@PostMapping
	public ResponseEntity<?> loginNuevo (@RequestBody Usuario user){
		Usuario u = uDAO.login( user.getUsername(), user.getPassword() );
		
		if( u != null ) {
			
			String token = TokenServices.generateToken(user.getUsername(), EXPIRATION_IN_SEC);
			String status = "ok";
			String tipo;
			String userID = Long.toString(u.getId()) ;
			
			if (u.esFoodTrucker()) {
				tipo = "foodtrucker";
			} else { tipo = "organizador"; }
			
		    return ResponseEntity.ok(new Credentials(token, EXPIRATION_IN_SEC, status, tipo, userID));
		
		} else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o password incorrecto"); }
	}	
	
}
