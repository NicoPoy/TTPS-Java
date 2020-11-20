package ttps.spring.clasesDAOImplHibernateJPA;

import ttps.spring.model.*;
import org.springframework.stereotype.Repository;
import ttps.spring.clasesDAO.ContratacionDAO;

@Repository
public class ContratacionDAOHibernateJPA extends GenericDAOHibernateJPA<Contratacion> implements ContratacionDAO{
	 
	public ContratacionDAOHibernateJPA() {
		super(Contratacion.class);
	 }

}
