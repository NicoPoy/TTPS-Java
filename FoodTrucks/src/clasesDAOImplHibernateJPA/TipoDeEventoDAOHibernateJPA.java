package clasesDAOImplHibernateJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import clasesDAO.TipoDeEventoDAO;
import modelos.TipoDeEvento;
import modelos.Usuario;

public class TipoDeEventoDAOHibernateJPA extends GenericDAOHibernateJPA<TipoDeEvento> implements TipoDeEventoDAO{
	 
	public TipoDeEventoDAOHibernateJPA() {
		super(TipoDeEvento.class);
	 }
	
	@Override
	public TipoDeEvento buscarPorNombre(String nombre){
		EntityManagerFactory emf = new EMFactory().getEMF();
		EntityManager em = emf.createEntityManager();
		
		 String sql = " SELECT tde "
		 			+ " FROM TipoDeEvento as tde"
		 			+ " WHERE tde.nombre = :nombre ";
		 
		 Query consulta = EMFactory.getEMF().createEntityManager().createQuery(sql);
		 consulta.setParameter("nombre", nombre);
		 TipoDeEvento resultado = (TipoDeEvento)consulta.getSingleResult();
		 return resultado;
	}
	
}
