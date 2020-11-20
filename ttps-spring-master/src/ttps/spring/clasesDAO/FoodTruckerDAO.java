package ttps.spring.clasesDAO;
import java.util.List;

import ttps.spring.model.*;

public interface FoodTruckerDAO extends GenericDAO <FoodTrucker> {	
	
	public FoodTrucker buscarPorIDdeUsuario(long idUsuario);
	/*public Usuario devolverUsuario();
	public Zona devolverZona();
	public List<FoodTruck> devolverFoodTrucks();*/
	
}
