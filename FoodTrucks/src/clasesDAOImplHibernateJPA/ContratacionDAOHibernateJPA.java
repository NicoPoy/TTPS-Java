package clasesDAOImplHibernateJPA;

import clasesDAO.ContratacionDAO;
import modelos.Contratacion;

public class ContratacionDAOHibernateJPA extends GenericDAOHibernateJPA<Contratacion> implements ContratacionDAO{
	 
	public ContratacionDAOHibernateJPA() {
		super(Contratacion.class);
	 }

}
