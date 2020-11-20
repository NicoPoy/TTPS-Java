<%@ page import="ttps.spring.clasesDAO.*, ttps.spring.model.*, java.util.* " %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agregar FoodTruck - FoodTrucker</title>
</head>
<body>
	
	<% if (session.getAttribute("usuario") != null ) {

		FoodTrucker uft = (FoodTrucker) session.getAttribute("foodtrucker");
		FoodTruckerDAO uftDAO = DAOFactory.getFoodTruckerDAO();
		FoodTrucker ftPersistido = (FoodTrucker) uftDAO.recuperar(uft.getId());

		FoodTruckDAO ftDAO = DAOFactory.getFoodTruckDAO();
		List<FoodTruck> foodtrucks = ftDAO.encontrarTodosParaUsuarioID(uft.getUsuario().getId());
		Iterator<FoodTruck> it = foodtrucks.iterator();
		
		out.println("<h1> Marque los FoodTrucks que quiere eliminar </h1>");
		out.println("<form action='borrarFoodTruck' method='post'>");
		
		while( it.hasNext() ) {
			FoodTruck foodtruck = it.next();
			out.println("<p><input type='checkbox' name="+ foodtruck.getNombre() +" value="+ foodtruck.getNombre() +">"+ foodtruck.getNombre() +"</p>");
		}
		
		out.print(" <input type='submit' value='Eliminar'> ");
		out.print(" </form> ");	
		
		
		
	}
	
	
	%>

</body>
</html>