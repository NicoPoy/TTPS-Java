package clasesDAO;

import java.util.List;

import modelos.*;

public interface OrganizadorDAO extends GenericDAO<Organizador> {
	
	public Organizador buscarPorIDdeUsuario(long idUsuario);
	/*public Usuario devolverUsuario();
	public List<Evento> devolverEventos();*/
	
	
}
