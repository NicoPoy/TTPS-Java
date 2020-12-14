package ttps.spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ttps.spring.clasesDAO.UsuarioDAO;

public class mainDePrueba {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		
		//registra una o m�s componentes que ser�n procesadas
		ctx.register(ttps.spring.config.PersistenceConfig.class);
		//Busca clases anotadas en el paquete base pasado por par�metro
		ctx.scan("ttps");
		ctx.refresh();
		
		UsuarioDAO usrDAO = ctx.getBean("usuarioDAOImplHibernateJPA", UsuarioDAO.class);
		
		System.out.println( (usrDAO.buscarPorUsername("nicopoy")).getUsername() );
	}

}
