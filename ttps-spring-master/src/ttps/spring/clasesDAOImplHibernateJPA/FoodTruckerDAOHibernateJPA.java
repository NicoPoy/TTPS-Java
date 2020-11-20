package ttps.spring.clasesDAOImplHibernateJPA;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.spring.model.*;
import ttps.spring.clasesDAO.FoodTruckerDAO;

@Repository
public class FoodTruckerDAOHibernateJPA extends GenericDAOHibernateJPA<FoodTrucker> implements FoodTruckerDAO{
	
	 public FoodTruckerDAOHibernateJPA() {
		super(FoodTrucker.class);
	 }
	 
	 @Override
	 public FoodTrucker buscarPorIDdeUsuario(long usuarioID) {
		EntityManagerFactory emf = new EMFactory().getEMF();
		EntityManager em = emf.createEntityManager();
		FoodTrucker resultado = null;
		
		 String sql = " SELECT f "
		 			+ " FROM FoodTrucker as f"
		 			+ " INNER JOIN Usuario u on (u.id = f.usuario)"
		 			+ " WHERE u.id = :usuarioID";
		 
		 Query consulta = EMFactory.getEMF().createEntityManager().createQuery(sql);
		 consulta.setParameter("usuarioID", usuarioID);
		 List <FoodTrucker> result = consulta.getResultList();
		 
		 if( !result.isEmpty() ) {
			 resultado = (FoodTrucker)result.get(0); }
		 
		 return resultado;
	 }
	 
}


