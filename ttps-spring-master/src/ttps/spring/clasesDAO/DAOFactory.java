package ttps.spring.clasesDAO;

import org.springframework.transaction.annotation.Transactional;

import ttps.spring.clasesDAOImpl.*;

@Transactional
public class DAOFactory {

	public static UsuarioDAO getUsuarioDAO(){
			return new UsuarioDAOImpl();
		}
		
	public static ContratacionDAO getContratacionDAO(){
			return new ContratacionDAOImpl();
		}
	
	public static EventoDAO getEventoDAO(){
			return new EventoDAOImpl();
		}
	
	public static FoodTruckDAO getFoodTruckDAO(){
			return new FoodTruckDAOImpl();
		}
	
	public static FoodTruckerDAO getFoodTruckerDAO(){
			return new FoodTruckerDAOImpl();
		}
	
	public static OrganizadorDAO getOrganizadorDAO(){
			return new OrganizadorDAOImpl();
		}
	
	public static TipoDeEventoDAO getTipoDeEventoDAO(){
			return new TipoDeEventoDAOImpl();
		}
	
	public static TipoDeServicioDAO getTipoDeServicioDAO(){
			return new TipoDeServicioDAOImpl();
		}
	
	public static ZonaDAO getZonaDAO(){
			return new ZonaDAOImpl();
		}
	
}
