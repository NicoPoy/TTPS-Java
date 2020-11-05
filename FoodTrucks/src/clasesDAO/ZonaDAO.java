package clasesDAO;

import java.util.List;

import modelos.*;

public interface ZonaDAO extends GenericDAO<Zona> {

	public Zona buscarPorNombre(String nombre);
	/*public List<FoodTrucker> devolverFoodTruckers();*/
	
}