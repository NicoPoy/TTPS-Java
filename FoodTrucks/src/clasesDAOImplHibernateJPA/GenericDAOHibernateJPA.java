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
	public T borrar(Serializable id) {		
		EntityManagerFactory emf = new EMFactory().getEMF();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		T entity = em.find(clasePersistente,id);
		em.remove(entity);
		em.getTransaction().commit();
		return entity; 
	}

	@Override
	public boolean existe(Serializable id) {
		return !this.recuperar(id).equals(null);
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
		EntityManagerFactory emf = new EMFactory().getEMF();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		T entity = em.find(clasePersistente, id);
		em.getTransaction().commit();
		return entity;
	}

}
