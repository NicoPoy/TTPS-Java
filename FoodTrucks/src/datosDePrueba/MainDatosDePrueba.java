package datosDePrueba;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import clasesDAO.DAOFactory;
import clasesDAO.UsuarioDAO;
import clasesDAOImplHibernateJPA.*;
import modelos.*;

public class MainDatosDePrueba {

	public static void main(String[] args) {
		EntityManagerFactory emf = new EMFactory().getEMF();
		EntityManager em = emf.createEntityManager();
		
	/*	TipoDeServicio t1= new TipoDeServicio("Cerveza");
		TipoDeServicio t2= new TipoDeServicio("Pancho");
		TipoDeServicio t3 = new TipoDeServicio("Hamburguesa");
		TipoDeServicio t4 = new TipoDeServicio("Papas Fritas");
		
		em.getTransaction().begin();
		em.persist(t1);
		em.persist(t2);
		em.persist(t3);
		em.persist(t4);
		em.getTransaction().commit();
		
		Zona z1 = new Zona("La Plata");
		Zona z2 = new Zona("Berisso");
		Zona z3 = new Zona("Ensenada");
		
		em.getTransaction().begin();
		em.persist(z1);
		em.persist(z2);
		em.persist(z3);
		em.getTransaction().commit();

		// ------------- Primer Usuario -------------
		
		Usuario u1 = new Usuario("Nicolas", "Poy Peters", "nicopoy", "123");
		FoodTrucker uft1 = new FoodTrucker(z1, u1);
		
		List<FoodTruck> foodtrucks1 = new ArrayList<>();
		List<TipoDeServicio> tipos1 = new ArrayList<>();
		
		tipos1.add(t4);
		tipos1.add(t1);
		tipos1.add(t3);
		
		FoodTruck ft1 = new FoodTruck("Papas Fest", "Papas con Cheddar", "www.papasfest.com", "+5492219876543", "papafest_ok", "papasfest_lp",uft1, tipos1);	
		FoodTruck ft2 = new FoodTruck("Beer Fest", "Mucha cerveza", "www.beerfest.com", "+5492219876543", "beerfest_ok", "beerfest_lp",uft1, tipos1);
		
		foodtrucks1.add(ft1);
		foodtrucks1.add(ft2);
		
		uft1.setFoodtrucks(foodtrucks1);
		
		em.getTransaction().begin();
		em.persist(u1);
		em.persist(uft1);
		em.persist(ft1);
		em.persist(ft2);
		em.getTransaction().commit();
		
		// ------------- Segundo USuario -------------
		
		Usuario u2 = new Usuario("Tomas", "Cuenca", "tomicuenca", "123");
		FoodTrucker uft2 = new FoodTrucker(z2, u2);
		
		List<FoodTruck> foodtrucks2 = new ArrayList<>();
		List<TipoDeServicio> tipos2 = new ArrayList<>();
		
		tipos2.add(t2);
		tipos2.add(t1);
		tipos2.add(t3);
		
		FoodTruck ft3 = new FoodTruck("Buerger Fest", "Las mejores hamburguesas", "www.burgerfest.com", "+5492219876543", "burgerfest_ok", "burgerfest_lp",uft2, tipos2);	
		FoodTruck ft4 = new FoodTruck("Pancho Fest", "Mucho pancho", "www.panchofest.com", "+5492219876543", "panchofest_ok", "panchofest_lp",uft2, tipos2);
		
		foodtrucks2.add(ft4);
		foodtrucks2.add(ft3);
		
		uft2.setFoodtrucks(foodtrucks2);
		
		em.getTransaction().begin();
		em.persist(u2);
		em.persist(uft2);
		em.persist(ft3);
		em.persist(ft4);
		em.getTransaction().commit();	*/
		
		UsuarioDAO uDAO = DAOFactory.getUsuarioDAO("HibernateJPA");
		Usuario u = uDAO.getUsuarioPorUsername("nicopoy");
		System.out.println(u.getNombre());
		
	}

}
