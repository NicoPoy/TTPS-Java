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
		 List <Usuario> resultList = consulta.getResultList();
		 if( resultList.size() != 0 ) {
			return (Usuario) resultList.get(0); }
		 else { System.out.println("<<< No existe usuario con username = " + username + " >>>");
			 	return null; }
	 }

	@Override
	public List<Usuario> recuperarTodos() {
		 String sql = " SELECT u "
		 			+ " FROM Usuario as u ";		 
		 Query consulta = getEntityManager().createQuery(sql);
		 return consulta.getResultList();
	}

	@Override
	public boolean login (String username, String password) {		
		String sql = " SELECT u "
	 			   + " FROM Usuario as u"
	 			   + " WHERE u.username = :username AND u.password = :password ";		 
		Query consulta = getEntityManager().createQuery(sql);
		consulta.setParameter("username", username);
		consulta.setParameter("password", password);
		return ( consulta.getResultList().size() == 1 );
	}
	 
	 
	 
	 
}
