package clasesDAOImplHibernateJPA;

import clasesDAO.DAOFactory;
import clasesDAO.FoodTruckerDAO;

public class DAOFactoryHibernateJPA implements DAOFactory{

	 public static FoodTruckerDAO getPersonaDAO() {
		 return new FoodTruckerDAOHibernateJPA();
	}
	
	
}
