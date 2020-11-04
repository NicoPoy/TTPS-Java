package clasesDAOImplHibernateJPA;

import clasesDAO.FoodTruckerDAO;
import modelos.FoodTrucker;

public class FoodTruckerDAOHibernateJPA extends GenericDAOHibernateJPA<FoodTrucker> implements FoodTruckerDAO{
	
	 public FoodTruckerDAOHibernateJPA() {
		super(FoodTrucker.class);
	 }

}


