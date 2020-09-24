package ttps.clasificados;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
		// ValidadorUsuarios v;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    /* public void init() {
    	this.v = new ValidadorUsuarios(); 
    } */
    
	
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Menu");
		if (dispatcher != null) { 
			dispatcher.forward(request, response);
		}
		
	}

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/* response.setContentType("text/html");
		String tipoUsuario = v.validar(request.getParameter("username"), request.getParameter("password"));
		
		if ( tipoUsuario != null ) {
			if ( tipoUsuario.equals("admin") ) {
				response.sendRedirect("/clasificados40/admin.html");
			}else {
				if ( tipoUsuario.equals("user") ){ 
					response.sendRedirect("/clasificados40/user.html");	
				}
			}
		} else { response.sendRedirect("/clasificados40/error.html"); } */
		
		doGet(request, response);
	}

}
