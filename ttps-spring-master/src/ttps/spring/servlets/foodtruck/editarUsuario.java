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
 * Servlet implementation class editarUsuario
 */
@WebServlet("/editarUsuario")
public class editarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editarUsuario() {
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
		
		UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();			
		Usuario u = uDAO.buscarPorUsername( ( (Usuario) request.getSession(false).getAttribute("usuario")).getUsername() );
		
		u.setNombre( request.getParameter("nombre") );
		u.setApellido( request.getParameter("apellido") );
		u.setUsername(request.getParameter("username") );
		u.setPassword(request.getParameter("password") );
		
		uDAO.actualizar(u);
		request.getSession(true).setAttribute("usuario", u);
		response.sendRedirect("foodtruckerHome.jsp");
		
		
		doGet(request, response);
	}

}
