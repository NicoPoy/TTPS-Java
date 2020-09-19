package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

/**
 * Servlet implementation class ServletTexto
 */
public class ServletTexto extends HttpServlet {
	private int visitas = 0;
	private String mensaje1 = "¡Felicitaciones @! ", mensaje2 = "eres el visitante número # de nuestro sitio y has sido seleccionado para el gran premio TTPS - Cursada APROBADA" ;
	
	
	private static final long serialVersionUID = 1L;      
    /**
     * @see HttpServlet#HttpServlet()
     */
	public ServletTexto() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		visitas++;
		
		out.println("<html><body>");
		out.println( mensaje1.replace("@",request.getParameter("texto") ) + mensaje2.replace("#", this.getVisitasString() ));
		out.println("<body><html>");
		out.close();	
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private String getVisitasString() {
		return  Integer.toString(visitas);
	} 

}
