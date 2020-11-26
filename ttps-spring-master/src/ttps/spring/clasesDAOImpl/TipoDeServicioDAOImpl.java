package ttps.spring.clasesDAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.spring.model.*;
import ttps.spring.clasesDAO.TipoDeServicioDAO;

@Repository
public class TipoDeServicioDAOImpl extends GenericDAOImpl<TipoDeServicio> implements TipoDeServicioDAO{
	 
	public TipoDeServicioDAOImpl() {
		super(TipoDeServicio.class);
	 }

	@Override
	public List<TipoDeServicio> traerTodos() {
		EntityManagerFactory emf = new EMFactory().getEMF();
		EntityManager em = emf.createEntityManager();
		
		String sql = " SELECT ts "
				   + " FROM TipoDeServicio ts";
		 
		Query consulta = EMFactory.getEMF().createEntityManager().createQuery(sql);	 
		List<TipoDeServicio> resultado = consulta.getResultList();	 
		return resultado;
	}

	@Override
	public TipoDeServicio encontrarPorNombre(String nombre) {
		EntityManagerFactory emf = new EMFactory().getEMF();
		EntityManager em = emf.createEntityManager();
		
		String sql = " SELECT ts "
					+ " FROM TipoDeServicio ts"
		 			+ " WHERE ts.nombre = :nombre ";
		 
		 Query consulta = EMFactory.getEMF().createEntityManager().createQuery(sql);
		 consulta.setParameter("nombre", nombre);
		 TipoDeServicio resultado = (TipoDeServicio)consulta.getSingleResult();
		 return resultado;
	}

	@Override
	public List<TipoDeServicio> encontrarTodosParaFoodtrucker(long idFoodTruck) {
	String sql = " SELECT ft.tipos "
				+ " FROM FoodTruck ft"
	 			+ " WHERE ft.id = :idFoodTruck ";
	 
	 Query consulta = getEntityManager().createQuery(sql);
	 consulta.setParameter("idFoodTruck", idFoodTruck);
	 return consulta.getResultList();
	}
	
	

}
