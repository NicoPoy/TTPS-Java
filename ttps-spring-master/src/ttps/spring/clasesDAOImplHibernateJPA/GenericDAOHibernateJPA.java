package ttps.spring.clasesDAOImplHibernateJPA;
import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.clasesDAO.GenericDAO;

@Transactional
public class GenericDAOHibernateJPA<T> implements GenericDAO<T>{
	
	protected Class<T> clasePersistente;	
	private EntityManager entityManager;
	
	@PersistenceContext
	 
	public void setEntityManager(EntityManager em){
		this.entityManager = em;
	 }
	 
	public EntityManager getEntityManager() {
		return entityManager;
	 }

	
	public GenericDAOHibernateJPA(Class<T> clase) {
		clasePersistente = clase;
	}

	@Override
	public T actualizar(T entity) {
		this.getEntityManager().merge(entity);
		return entity;
	}

	@Override
	public T borrar(Serializable id) {		
		T entity = this.getEntityManager().find(clasePersistente,id);
		this.getEntityManager().remove(entity);
		return entity; 
	}

	@Override
	public boolean existe(Serializable id) {
		return !this.recuperar(id).equals(null);
	}

	@Override
	public T persistir(T entity) {		
		this.getEntityManager().persist(entity);
		return entity;
	} 


	@Override
	public T recuperar(Serializable id) {
		T entity = this.getEntityManager().find(clasePersistente, id);
		this.getEntityManager().getTransaction().commit();
		return entity;
	}

}
