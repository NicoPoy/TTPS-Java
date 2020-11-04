package clasesDAOImplHibernateJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import clasesDAO.FoodTruckerDAO;
import modelos.FoodTrucker;

public class FoodTruckerDAOHibernateJPA extends GenericDAOHibernateJPA<FoodTrucker> implements FoodTruckerDAO{
	
	 public FoodTruckerDAOHibernateJPA() {
		super(FoodTrucker.class);
	 }
	 
	 @Override
	 public FoodTrucker buscarPorIDdeUsuario(long usuarioID) {
		EntityManagerFactory emf = new EMFactory().getEMF();
		EntityManager em = emf.createEntityManager();
		
		 String sql = " SELECT f "
		 			+ " FROM FoodTrucker as f"
		 			+ " INNER JOIN Usuario u on (u.id = f.usuario)"
		 			+ " WHERE u.id = :usuarioID";
		 
		 Query consulta = EMFactory.getEMF().createEntityManager().createQuery(sql);
		 consulta.setParameter("usuarioID", usuarioID);
		 FoodTrucker resultado = (FoodTrucker)consulta.getSingleResult();
		 return resultado;
	 }
	 
}


