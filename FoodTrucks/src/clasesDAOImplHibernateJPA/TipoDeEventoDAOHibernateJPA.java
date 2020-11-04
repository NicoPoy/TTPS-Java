package clasesDAOImplHibernateJPA;

import clasesDAO.TipoDeEventoDAO;
import modelos.TipoDeEvento;

public class TipoDeEventoDAOHibernateJPA extends GenericDAOHibernateJPA<TipoDeEvento> implements TipoDeEventoDAO{
	 
	public TipoDeEventoDAOHibernateJPA() {
		super(TipoDeEvento.class);
	 }

}
