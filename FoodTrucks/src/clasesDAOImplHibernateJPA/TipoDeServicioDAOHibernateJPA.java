package clasesDAOImplHibernateJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import clasesDAO.TipoDeServicioDAO;
import modelos.TipoDeServicio;

public class TipoDeServicioDAOHibernateJPA extends GenericDAOHibernateJPA<TipoDeServicio> implements TipoDeServicioDAO{
	 
	public TipoDeServicioDAOHibernateJPA() {
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
	
	

}
