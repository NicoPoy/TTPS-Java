package servlets.foodtruck;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clasesDAO.DAOFactory;
import clasesDAO.UsuarioDAO;
import modelos.Usuario;

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
