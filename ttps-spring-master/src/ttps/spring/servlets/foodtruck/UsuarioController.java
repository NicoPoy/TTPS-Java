package ttps.spring.servlets.foodtruck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.*;

import ttps.spring.clasesDAO.UsuarioDAO;
import ttps.spring.model.Usuario;

@RestController
@RequestMapping(path="/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)

public class UsuarioController {
	@Autowired
	private UsuarioDAO uDAO;	

	@GetMapping
	public Usuario getUsuarios(){
		return uDAO.buscarPorUsername("nicopoy");
	}




}