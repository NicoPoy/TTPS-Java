package ttps.spring.servlets.foodtruck;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ttps.spring.clasesDAO.*;
import ttps.spring.model.*;

/**
 * Servlet implementation class editarFoodTruck
 */
@WebServlet("/editarFoodTruck")
public class editarFoodTruck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editarFoodTruck() {
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
		long id = Long.parseLong( request.getParameter("id") );
		
		TipoDeServicioDAO tsDAO = DAOFactory.getTipoDeServicioDAO();			
		List<TipoDeServicio> listResult = tsDAO.traerTodos();
		Iterator<TipoDeServicio> it = listResult.iterator();
		List<TipoDeServicio> tiposNew = new ArrayList<>();
		
		while( it.hasNext() ) {
			TipoDeServicio tipo = it.next();
			if ( request.getParameter( tipo.getNombre() ) != null ) {	
				TipoDeServicio tipoServicio = tsDAO.encontrarPorNombre( tipo.getNombre() );
				if( tipoServicio != null) {
					System.out.println(" <<<< Cargado el tipo de servicio: " + tipoServicio.getNombre() + "(ID = " + tipoServicio.getId() + ") >>>>");
					tiposNew.add(tipoServicio);
				}	
			}		
		}
		
		FoodTruckDAO ftDAO = DAOFactory.getFoodTruckDAO();
		FoodTruck ftNew = ftDAO.recuperar(id);
		
		ftNew.setNombre( request.getParameter("nombre") );
		ftNew.setDescripcion( request.getParameter("descripcion") );
		ftNew.setUrl(request.getParameter("url") );
		ftNew.setWhatsapp(request.getParameter("whatsapp") );
		ftNew.setInstagram(request.getParameter("instagram") );
		ftNew.setTwitter(request.getParameter("twitter") );			
		ftNew.setTipos(tiposNew);
		
		ftDAO.actualizar(ftNew);
		response.sendRedirect("foodtruckerHome.jsp");
		
		doGet(request, response);
	}

}
