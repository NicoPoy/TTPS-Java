package ttps.spring.clasesDAO;
import java.util.List;

import ttps.spring.model.*;

public interface FoodTruckerDAO extends GenericDAO <FoodTrucker> {	

	public List<FoodTrucker> recuperarTodos();
	public FoodTrucker buscarPorUsername(String username);


	
}
