package clasesDAOImplHibernateJPA;

import clasesDAO.EventoDAO;
import modelos.Evento;

public class EventoDAOHibernateJPA extends GenericDAOHibernateJPA<Evento> implements EventoDAO{
	 
	public EventoDAOHibernateJPA() {
		super(Evento.class);
	 }

}
