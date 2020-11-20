package ttps.spring.clasesDAO;

import java.util.List;
import ttps.spring.model.*;

public interface TipoDeServicioDAO extends GenericDAO<TipoDeServicio> {
	
	public List<TipoDeServicio> traerTodos();
	public TipoDeServicio encontrarPorNombre(String nombre);
	/*public List<FoodTruck> devolverFoodTrucks();*/
	
}
