package clasesDAOImplHibernateJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import clasesDAO.FoodTruckDAO;
import modelos.FoodTruck;

public class FoodTruckDAOHibernateJPA extends GenericDAOHibernateJPA<FoodTruck> implements FoodTruckDAO{
	 
	public FoodTruckDAOHibernateJPA() {
		super(FoodTruck.class);
	 }

	@Override
	public List<FoodTruck> encontrarTodosParaUsuarioID(long usuarioID) {
		EntityManagerFactory emf = new EMFactory().getEMF();
		EntityManager em = emf.createEntityManager();
		
		String sql = " SELECT ft "
				 	+ " FROM FoodTruck ft"
				 	+ "		INNER JOIN FoodTrucker uft ON (ft.foodtrucker = uft.id )"
				 	+ " 	INNER JOIN Usuario u ON (u.id = ft.foodtrucker)"
		 			+ " WHERE u.id = :usuarioID ";
		 
		Query consulta = EMFactory.getEMF().createEntityManager().createQuery(sql);
		consulta.setParameter("usuarioID", usuarioID);		 
		List<FoodTruck> resultado = consulta.getResultList();	 
		return resultado;
	}
}
