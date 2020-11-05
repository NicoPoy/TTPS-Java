package clasesDAO;

import java.util.List;

import modelos.*;

public interface EventoDAO extends GenericDAO<Evento> {

	public Organizador devolverOrganizador();
	public TipoDeEvento devolverTipo();
	public List<Contratacion> devolverSolicitudes();	
	
}
