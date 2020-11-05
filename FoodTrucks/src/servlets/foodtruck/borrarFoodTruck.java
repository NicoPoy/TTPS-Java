package servlets.foodtruck;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clasesDAO.*;
import modelos.*;

/**
 * Servlet implementation class borrarFoodTruck
 */
@WebServlet("/borrarFoodTruck")
public class borrarFoodTruck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public borrarFoodTruck() {
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
			
			FoodTrucker ft = (FoodTrucker) request.getSession(false).getAttribute("foodtrucker");	
			List<FoodTruck> foodtrucks = ft.getFoodtrucks();
			Iterator<FoodTruck> it = foodtrucks.iterator();
			
			while( it.hasNext() ) {
				FoodTruck foodtruck = it.next();
				if ( request.getParameter( foodtruck.getNombre() ) != null ) {
					FoodTruckDAO ftDAO = DAOFactory.getFoodTruckDAO("HibernateJPA");	
					FoodTruck ftPersistido = ftDAO.encontrarPorNombre(foodtruck.getNombre());
					ftPersistido.setTipos(null);
					ftDAO.actualizar(ftPersistido);
					ftDAO.borrar(ftPersistido.getId());					
					System.out.println(" <<<< FoodTruck Borrado >>>>");
				}	
			}
		}
		
		response.sendRedirect("foodtruckerHome.jsp");	
		doGet(request, response);
	}

}
