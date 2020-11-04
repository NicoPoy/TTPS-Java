package clasesDAOImplHibernateJPA;

import javax.persistence.*;
import clasesDAO.UsuarioDAO;
import modelos.Usuario;

public class UsuarioDAOHibernateJPA extends GenericDAOHibernateJPA<Usuario> implements UsuarioDAO{

	 public UsuarioDAOHibernateJPA() {
		super(Usuario.class);
	 }
	 
	 @Override
	 public Usuario getUsuarioPorUsername(String username) {
		 String sql = " SELECT * "
		 			+ " FROM usuarios"
		 			+ " WHERE usuarios.username = :username ";
		 Query consulta = EMFactory.getEMF().createEntityManager().createQuery(sql);
		 consulta.setParameter("username", username);
		 Usuario resultado = (Usuario)consulta.getSingleResult();
		 return resultado;
	 }

	
}
