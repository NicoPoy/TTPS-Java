package ttps.spring.clasesDAO;

import ttps.spring.model.*;

public interface UsuarioDAO extends GenericDAO<Usuario> {

	 public Usuario buscarPorUsername(String username);
	
}
