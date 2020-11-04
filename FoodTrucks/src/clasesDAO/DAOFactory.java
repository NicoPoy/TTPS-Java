package clasesDAO;

import clasesDAOImplHibernateJPA.UsuarioDAOHibernateJPA;

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
}
