package ttps;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginMultilenguaje
 */
@WebServlet("/LoginMultilenguaje")
public class LoginMultilenguaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginMultilenguaje() {
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
		
		//String nombreArchivo = request.getParameter("lenguaje");
		PrintWriter out = response.getWriter();
		String nombreArchivo = (String) this.getServletContext().getAttribute("lenguaje");
		Properties p = new Properties();
		p.load(new FileReader(request.getServletContext().getRealPath("/") + nombreArchivo) );
		

		System.out.println("saludo="+p.getProperty("hola"));
		
		response.setContentType("text/html");
	
		out.println("<html><body>");
		out.println("<form action='ServletLogin' method='post'>" );
		out.println("<p>" + p.getProperty("usuario") + ": <input type='text' name='texto'></p>");
		out.println("<p> <input type='submit' value=' " + p.getProperty("enviar") + "'> </p>");
		out.println("</form>");
		out.println("<body><html>");
		out.close();	
		
		doGet(request, response);
	}

}
