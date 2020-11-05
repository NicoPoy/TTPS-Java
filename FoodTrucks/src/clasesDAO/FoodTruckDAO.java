package clasesDAO;

import java.util.List;
import modelos.FoodTruck;

public interface FoodTruckDAO extends GenericDAO<FoodTruck> {

	public List<FoodTruck> encontrarTodosParaUsuarioID(long usuarioID);
	public FoodTruck encontrarPorID(long id);
}
