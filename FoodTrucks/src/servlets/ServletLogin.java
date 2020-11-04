package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.naming.NamingException;
import javax.persistence.*;
import validador.Validador;

import clasesDAO.*;
import clasesDAOImplHibernateJPA.EMFactory;
import modelos.*;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
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
		if ( (request.getParameter("usuario").isEmpty()) || (request.getParameter("clave").isEmpty()) ) {
			response.sendRedirect("login.html");
		} else {
			request.getSession(false).invalidate();
			if ( request.getSession(false) == null){
				Validador v = new Validador();
				UsuarioDAO uDAO = DAOFactory.getUsuarioDAO("HibernateJPA");
				Usuario u = uDAO.getUsuarioPorUsername(request.getParameter("usuario") );
				if (u != null) {								
					if (v.validarLogin(u.getUsername(), u.getPassword(), request.getParameter("usuario"), request.getParameter("clave")  ) ){
						request.getSession(true).setAttribute("usuario", u);
						
						System.out.println("======================================");
						System.out.println("Se inicio sesion correctamente");
						System.out.println("======================================");								
						
						//response.sendRedirect("visualizarMensajes.jsp"); 							
						}
					} else { System.out.println("<<< No se encontraron resultados en la Base >>>"); 
							 response.sendRedirect("visualizarMensajes.jsp"); }
				} else {
					System.out.println("======================================");
					System.out.println("Sesion : Ya existe una sesion");
					System.out.println("======================================");
					response.sendRedirect("error.html"); }
			}		
			doGet(request, response); 
	}
		

}
