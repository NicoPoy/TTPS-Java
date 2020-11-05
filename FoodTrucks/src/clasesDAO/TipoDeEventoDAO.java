package clasesDAO;

import java.util.List;

import modelos.*;

public interface TipoDeEventoDAO extends GenericDAO<TipoDeEvento> {

	public TipoDeEvento buscarPorNombre(String nombre);
	/*public List<Organizador> devolverOrganizadores();*/
	
	
}
