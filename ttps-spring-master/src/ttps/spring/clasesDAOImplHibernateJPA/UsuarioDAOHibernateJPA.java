package ttps.spring.clasesDAOImplHibernateJPA;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import ttps.spring.model.*;
import ttps.spring.clasesDAO.UsuarioDAO;

@Repository
public class UsuarioDAOHibernateJPA extends GenericDAOHibernateJPA<Usuario> implements UsuarioDAO{

	 public UsuarioDAOHibernateJPA() {
		super(Usuario.class);
	 }
	 
	private EntityManager entityManager;
	
	@PersistenceContext
		 
	public void setEntityManager(EntityManager em){
		this.entityManager = em;
	 }
		 
	public EntityManager getEntityManager() {
		return entityManager;
	 }
	 
	 @Override
	 public Usuario buscarPorUsername(String username) {
		 String sql = " SELECT u "
		 			+ " FROM Usuario as u"
		 			+ " WHERE u.username = :username ";
		 Query consulta =this.getEntityManager().createQuery(sql);
		 consulta.setParameter("username", username);
		 Usuario resultado = (Usuario)consulta.getSingleResult();
		 return resultado;
	 }
	 
	 
}
