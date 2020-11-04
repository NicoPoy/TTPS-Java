package clasesDAOImplHibernateJPA;

import javax.persistence.*;
import clasesDAO.UsuarioDAO;
import modelos.Usuario;

public class UsuarioDAOHibernateJPA extends GenericDAOHibernateJPA<Usuario> implements UsuarioDAO{

	 public UsuarioDAOHibernateJPA() {
		super(Usuario.class);
	 }
	 
	 @Override
	 public Usuario buscarPorUsername(String username) {
		EntityManagerFactory emf = new EMFactory().getEMF();
		EntityManager em = emf.createEntityManager();
		
		 String sql = " SELECT u "
		 			+ " FROM Usuario as u"
		 			+ " WHERE u.username = :username ";
		 
		 Query consulta = EMFactory.getEMF().createEntityManager().createQuery(sql);
		 consulta.setParameter("username", username);
		 Usuario resultado = (Usuario)consulta.getSingleResult();
		 return resultado;
	 }

	
	 
}
