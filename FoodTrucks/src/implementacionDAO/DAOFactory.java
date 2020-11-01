package implementacionDAO;
import clasesDAO.FoodTruckerDAO;

public class DAOFactory {

	 public static FoodTruckerDAO getPersonaDAO() {
		 return new FoodTruckerDAOHibernateJPA();
	}
	
}
