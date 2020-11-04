package clasesDAO;
import modelos.FoodTrucker;

public interface FoodTruckerDAO extends GenericDAO <FoodTrucker> {	
	
	public FoodTrucker buscarPorIDdeUsuario(long idUsuario);

}
