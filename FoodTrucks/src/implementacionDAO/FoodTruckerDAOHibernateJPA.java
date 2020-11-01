package implementacionDAO;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import clasesDAO.FoodTruckerDAO;
import modelos.FoodTrucker;

public class FoodTruckerDAOHibernateJPA extends GenericDAOHibernateJPA<FoodTrucker> implements FoodTruckerDAO{
	
	@Override
	public FoodTrucker recuperarFoodTrucker(String foodtruckero) {
		// TODO Auto-generated method stub
		return null;
	}

}


