package clasesDAOImplHibernateJPA;
import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import clasesDAO.GenericDAO;

public class GenericDAOHibernateJPA<T> implements GenericDAO<T>{
	
	protected Class<T> clasePersistente;

	
	public GenericDAOHibernateJPA(Class<T> clase) {
		clasePersistente = clase;
	}

	@Override
	public T actualizar(T entity) {
		EntityManagerFactory emf = new EMFactory().getEMF();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
		return entity;
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
		EntityManagerFactory emf = new EMFactory().getEMF();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		return entity;
	} 


	@Override
	public T recuperar(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T merge(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
