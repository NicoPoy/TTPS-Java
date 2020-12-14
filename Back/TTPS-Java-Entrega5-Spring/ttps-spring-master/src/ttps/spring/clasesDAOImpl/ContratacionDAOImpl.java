package ttps.spring.clasesDAOImpl;

import ttps.spring.model.*;
import org.springframework.stereotype.Repository;
import ttps.spring.clasesDAO.ContratacionDAO;

@Repository
public class ContratacionDAOImpl extends GenericDAOImpl<Contratacion> implements ContratacionDAO{
	 
	public ContratacionDAOImpl() {
		super(Contratacion.class);
	 }

}
