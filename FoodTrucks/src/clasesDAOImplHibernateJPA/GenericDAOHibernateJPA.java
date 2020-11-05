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

/*	@Override
	public void borrar(T entity) {
		EntityManagerFactory emf = new EMFactory().getEMF();
		EntityManager em = emf.createEntityManager();
		em.remove(entity);
		em.getTransaction().commit();
	} */

	@Override
	public T borrar(Serializable id) {	
		EntityManagerFactory emf = new EMFactory().getEMF();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		T entity = em.find(clasePersistente,id);
		if ( entity != null ) {
			em.remove(entity);
			em.getTransaction().commit();
		}else { em.getTransaction().rollback();
				System.out.println("<<< Fallo el Borrar: No se encontro ninguna entidad >>>"); }
		return entity;
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

}
