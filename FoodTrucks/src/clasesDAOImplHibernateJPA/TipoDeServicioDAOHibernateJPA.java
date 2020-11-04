package clasesDAOImplHibernateJPA;

import clasesDAO.TipoDeServicioDAO;
import modelos.TipoDeServicio;

public class TipoDeServicioDAOHibernateJPA extends GenericDAOHibernateJPA<TipoDeServicio> implements TipoDeServicioDAO{
	 
	public TipoDeServicioDAOHibernateJPA() {
		super(TipoDeServicio.class);
	 }

}
