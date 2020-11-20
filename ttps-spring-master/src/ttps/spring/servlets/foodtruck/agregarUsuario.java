package ttps.spring.servlets.foodtruck;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ttps.spring.clasesDAO.*;
import ttps.spring.model.*;

/**
 * Servlet implementation class agregarUsuario
 */
@WebServlet("/agregarUsuario")
public class agregarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public agregarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if( (request.getParameter("foodtrucker") != null) && (request.getParameter("organizador") != null ) ) {
			
			response.sendRedirect("agregarUsuario.jsp"); }
		
		else if( (request.getParameter("foodtrucker") == null ) && (request.getParameter("organizador") == null ) ) {
			
			response.sendRedirect("agregarUsuario.jsp");
			
		}
		
		else if ( ( request.getParameter("nombre") != null) && ( request.getParameter("apellido") != null) && ( request.getParameter("username") != null) && ( request.getParameter("password") != null) ) {
			
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			Usuario u = new Usuario(nombre, apellido, username, password);
			UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
		
			uDAO.persistir(u);
			
			if ( request.getParameter("foodtrucker") != null ) {
				u = uDAO.buscarPorUsername(username);
				FoodTrucker ft = new FoodTrucker();
				FoodTruckerDAO ftDAO = DAOFactory.getFoodTruckerDAO();
				ftDAO.persistir(ft);
				ft.setUsuario(u);
				ftDAO.actualizar(ft);
				
			} else {
				u = uDAO.buscarPorUsername(username);
				OrganizadorDAO oDAO = DAOFactory.getOrganizadorDAO();
				Organizador o = new Organizador();
				oDAO.persistir(o);
				o.setUsuario(u);
				oDAO.actualizar(o);
			}
			
		}
		
		response.sendRedirect("login.jsp");	
		doGet(request, response);
	}

}
