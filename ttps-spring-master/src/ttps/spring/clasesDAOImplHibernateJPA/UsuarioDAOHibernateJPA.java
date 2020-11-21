package ttps.spring.clasesDAOImplHibernateJPA;

import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import ttps.spring.model.*;
import ttps.spring.clasesDAO.UsuarioDAO;

@Repository
public class UsuarioDAOHibernateJPA extends GenericDAOHibernateJPA<Usuario> implements UsuarioDAO{

	 public UsuarioDAOHibernateJPA() {
		super(Usuario.class);
	 }
	 
	 @Override
	 public Usuario buscarPorUsername(String username) {
		 String sql = " SELECT u "
		 			+ " FROM Usuario as u"
		 			+ " WHERE u.username = :username ";		 
		 Query consulta = getEntityManager().createQuery(sql);
		 consulta.setParameter("username", username);
		 Usuario resultado = (Usuario)consulta.getSingleResult();
		 return resultado;
	 }

	@Override
	public List<Usuario> recuperarTodos() {
		 String sql = " SELECT u "
		 			+ " FROM Usuario as u ";		 
		 Query consulta = getEntityManager().createQuery(sql);
		 return consulta.getResultList();
	}
	 
	 
	 
	 
}
