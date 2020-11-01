package clasesDAO;
import modelos.FoodTrucker;

public interface FoodTruckerDAO extends GenericDAO <FoodTrucker> {	
	public FoodTrucker recuperarFoodTrucker(String foodtruckero);
	
}
