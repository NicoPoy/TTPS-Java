package clasesDAO;

import modelos.Organizador;

public interface OrganizadorDAO extends GenericDAO<Organizador> {
	
	public Organizador buscarPorIDdeUsuario(long idUsuario);
}
