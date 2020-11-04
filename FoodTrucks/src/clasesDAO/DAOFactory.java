package clasesDAO;

import clasesDAOImplHibernateJPA.*;

public interface DAOFactory {

	public static UsuarioDAO getUsuarioDAO(String type){
		UsuarioDAO retornar;
		switch(type){
		case "HibernateJPA":
			retornar = new UsuarioDAOHibernateJPA();
		break;
		default:
			retornar = new UsuarioDAOHibernateJPA();
		break;
		}
		return retornar;
	}
	
	public static UsuarioDAO getUsuarioDAO(){
			return new UsuarioDAOHibernateJPA();
		}
	
	public static ContratacionDAO getContratacionDAO(String type){
		ContratacionDAO retornar;
		switch(type){
		case "HibernateJPA":
			retornar = new ContratacionDAOHibernateJPA();
		break;
		default:
			retornar = new ContratacionDAOHibernateJPA();
		break;
		}
		return retornar;
	}
	
	public static ContratacionDAO getContratacionDAO(){
			return new ContratacionDAOHibernateJPA();
		}
	
	public static EventoDAO getEventoDAO(String type){
		EventoDAO retornar;
		switch(type){
		case "HibernateJPA":
			retornar = new EventoDAOHibernateJPA();
		break;
		default:
			retornar = new EventoDAOHibernateJPA();
		break;
		}
		return retornar;
	}
	
	public static EventoDAO getEventoDAO(){
			return new EventoDAOHibernateJPA();
		}
	
	public static FoodTruckDAO getFoodTruckDAO(String type){
		FoodTruckDAO retornar;
		switch(type){
		case "HibernateJPA":
			retornar = new FoodTruckDAOHibernateJPA();
		break;
		default:
			retornar = new FoodTruckDAOHibernateJPA();
		break;
		}
		return retornar;
	}
	
	public static FoodTruckDAO getFoodTruckDAO(){
			return new FoodTruckDAOHibernateJPA();
		}
	
	public static FoodTruckerDAO getFoodTruckerDAO(String type){
		FoodTruckerDAO retornar;
		switch(type){
		case "HibernateJPA":
			retornar = new FoodTruckerDAOHibernateJPA();
		break;
		default:
			retornar = new FoodTruckerDAOHibernateJPA();
		break;
		}
		return retornar;
	}
	
	public static FoodTruckerDAO getFoodTruckerDAO(){
			return new FoodTruckerDAOHibernateJPA();
		}
	
	public static OrganizadorDAO getOrganizadorDAO(String type){
		OrganizadorDAO retornar;
		switch(type){
		case "HibernateJPA":
			retornar = new OrganizadorDAOHibernateJPA();
		break;
		default:
			retornar = new OrganizadorDAOHibernateJPA();
		break;
		}
		return retornar;
	}
	
	public static OrganizadorDAO getOrganizadorDAO(){
			return new OrganizadorDAOHibernateJPA();
		}
	
	public static TipoDeEventoDAO getTipoDeEventoDAO(String type){
		TipoDeEventoDAO retornar;
		switch(type){
		case "HibernateJPA":
			retornar = new TipoDeEventoDAOHibernateJPA();
		break;
		default:
			retornar = new TipoDeEventoDAOHibernateJPA();
		break;
		}
		return retornar;
	}
	
	public static TipoDeEventoDAO getTipoDeEventoDAO(){
			return new TipoDeEventoDAOHibernateJPA();
		}
	
	public static TipoDeServicioDAO getTipoDeServicioDAO(String type){
		TipoDeServicioDAO retornar;
		switch(type){
		case "HibernateJPA":
			retornar = new TipoDeServicioDAOHibernateJPA();
		break;
		default:
			retornar = new TipoDeServicioDAOHibernateJPA();
		break;
		}
		return retornar;
	}
	
	public static TipoDeServicioDAO getTipoDeServicioDAO(){
			return new TipoDeServicioDAOHibernateJPA();
		}
	
	public static ZonaDAO getZonaDAO(String type){
		ZonaDAO retornar;
		switch(type){
		case "HibernateJPA":
			retornar = new ZonaDAOHibernateJPA();
		break;
		default:
			retornar = new ZonaDAOHibernateJPA();
		break;
		}
		return retornar;
	}
	
	public static ZonaDAO getZonaDAO(){
			return new ZonaDAOHibernateJPA();
		}
	
}
