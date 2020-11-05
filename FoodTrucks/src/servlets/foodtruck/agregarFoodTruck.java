package servlets.foodtruck;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import clasesDAO.*;
import modelos.*;

/**
 * Servlet implementation class agregarFoodTruck
 */
@WebServlet("/agregarFoodTruck")
public class agregarFoodTruck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public agregarFoodTruck() {
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
		
		if ( request.getSession(false) != null ) { 
			System.out.println("<<<< Cargando FoodTruck para " + ( (FoodTrucker) request.getSession(false).getAttribute("foodtrucker") ).getUsuario().getUsername() +" >>>>");
			
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
			String url = request.getParameter("url");
			String whatsapp = request.getParameter("whatsapp");
			String instagram = request.getParameter("instagram");
			String twitter = request.getParameter("twitter");
			
			FoodTrucker ft = (FoodTrucker) request.getSession(false).getAttribute("foodtrucker");	
			
			TipoDeServicioDAO tsDAO = DAOFactory.getTipoDeServicioDAO("HibernateJPA");			
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
			
			FoodTruck ftNew = new FoodTruck(nombre, descripcion, url, whatsapp, instagram, twitter, ft);		
			FoodTruckDAO ftDAO = DAOFactory.getFoodTruckDAO("HibernateJPA");
			
			
			//=========================================
			//=========================================
						//GUARDAR FOOD TRUCK
			//=========================================
			//=========================================
			
			ftDAO.persistir(ftNew);
			
			//=========================================
			//=========================================
						//ASIGNAR LOS TIPOS
			//=========================================
			//=========================================
			
			ftNew = ftDAO.encontrarPorNombre(nombre);
			ftNew.setTipos(tiposNew);
			ftDAO.actualizar(ftNew);
			
			response.sendRedirect("foodtruckerHome.jsp");
		
		}	
		
		doGet(request, response);
	}

}
