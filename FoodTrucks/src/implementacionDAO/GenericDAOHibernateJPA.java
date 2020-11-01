package implementacionDAO;
import java.io.Serializable;

import clasesDAO.GenericDAO;

public class GenericDAOHibernateJPA<T> implements GenericDAO<T> {

	@Override
	public T actualizar(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrar(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T borrar(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T persistir(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T recuperar(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

}
