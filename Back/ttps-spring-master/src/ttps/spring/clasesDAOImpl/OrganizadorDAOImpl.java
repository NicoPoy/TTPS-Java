package ttps.spring.clasesDAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.spring.model.*;
import ttps.spring.clasesDAO.OrganizadorDAO;

@Repository
public class OrganizadorDAOImpl extends GenericDAOImpl<Organizador> implements OrganizadorDAO{
	 
	public OrganizadorDAOImpl() {
		super(Organizador.class);
	 }

	@Override
	public Organizador buscarPorIDdeUsuario(long idUsuario) {
		EntityManagerFactory emf = new EMFactory().getEMF();
		EntityManager em = emf.createEntityManager();
		
		 String sql = " SELECT o "
		 			+ " FROM Organizador as o"
		 			+ " INNER JOIN Usuario u on (u.id = o.usuario)"
		 			+ " WHERE u.id = :usuarioID";
		 
		 Query consulta = EMFactory.getEMF().createEntityManager().createQuery(sql);
		 consulta.setParameter("usuarioID", idUsuario);
		 Organizador resultado = (Organizador)consulta.getSingleResult();
		 return resultado;
	}

	@Override
	public List<Organizador> recuperarTodos() {
		String sql = " SELECT o "
 				   + " FROM Organizador as o ";		 
		Query consulta = getEntityManager().createQuery(sql);
		return consulta.getResultList();
	}
	
	@Override
	public Organizador buscarPorUsername(String username) {
		Organizador resultado = null;
		String sql = " SELECT o "
		 			+ " FROM Organizador as o"
		 			+ " WHERE o.username = :username";
		 Query consulta =  this.getEntityManager().createQuery(sql);
		 consulta.setParameter("username", username);
		 List <Organizador> result = consulta.getResultList(); 
		 if( !result.isEmpty() ) {
			 resultado = (Organizador) result.get(0); }
		 return resultado;
	}

}
