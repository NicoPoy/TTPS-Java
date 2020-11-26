package ttps.spring.clasesDAOImpl;

import ttps.spring.model.*;

import org.springframework.stereotype.Repository;

import ttps.spring.clasesDAO.EventoDAO;

@Repository
public class EventoDAOImpl extends GenericDAOImpl<Evento> implements EventoDAO{
	 
	public EventoDAOImpl() {
		super(Evento.class);
	 }

}
