package clasesDAO;

import java.util.List;
import modelos.TipoDeServicio;

public interface TipoDeServicioDAO extends GenericDAO<TipoDeServicio> {
	
	public List<TipoDeServicio> traerTodos();
	public TipoDeServicio encontrarPorNombre(String nombre);
	
}
