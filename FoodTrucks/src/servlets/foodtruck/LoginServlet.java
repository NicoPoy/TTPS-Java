package servlets.foodtruck;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clasesDAO.*;
import modelos.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//request.getSession(false).invalidate();
		if( !request.getParameter("username").isEmpty() && !request.getParameter("password").isEmpty() ) {
			UsuarioDAO uDAO = DAOFactory.getUsuarioDAO("HibernateJPA");
			Usuario usuario = uDAO.buscarPorUsername(request.getParameter("username") );
			if (usuario != null) {
				if (request.getParameter("password").equals(usuario.getPassword() ) ) {
					request.getSession(true).setAttribute("usuario", usuario);
					System.out.println("===========================");
					System.out.println(" <<<< Sesion iniciada >>>> ");
					System.out.println("===========================");
					
					FoodTruckerDAO ftDAO = DAOFactory.getFoodTruckerDAO("HibernateJPA");
					FoodTrucker ft = ftDAO.buscarPorIDdeUsuario(usuario.getId());		
					
					if (ft != null) {
						System.out.println(" <<<< FoodTrucker >>>> ");
						System.out.println("===========================");
						response.sendRedirect("foodtruckerHome.jsp");
					} else {
						OrganizadorDAO oDAO = DAOFactory.getOrganizadorDAO("HibernateJPA");
						Organizador o = oDAO.buscarPorIDdeUsuario(usuario.getId());	
						if ( o != null) {
							System.out.println(" <<<< Organizador >>>> ");
							System.out.println("===========================");
							response.sendRedirect("organizadorHome.jsp");
						} else {
							response.sendRedirect("error.html");
							System.out.println(" <<<< No se asigno un tipo de usuario >>>> ");
							System.out.println("===========================");
						}		
					}
				} else { System.out.println("==========================="); 
						System.out.println(" <<<< Contraseña incorrecta >>>> ");
						System.out.println("==========================="); 
						response.sendRedirect("errorPage.html"); }
			} else { System.out.println("===========================");
					 System.out.println(" <<<< Usuario incorrecto >>>>");
					 System.out.println("===========================");	
					 response.sendRedirect("errorPage.html"); }
		}
		doGet(request, response);
	}

}
