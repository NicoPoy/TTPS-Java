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
		 Query consulta = EMFactory.getEMF().createEntityManager().
				 createQuery("consulta loca");
		 consulta.setParameter(1, username);
		 Usuario resultado = (Usuario)consulta.getSingleResult();
		 return resultado;
	 }

	
}
