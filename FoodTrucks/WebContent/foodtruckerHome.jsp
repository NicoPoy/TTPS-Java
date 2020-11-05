<%@ page import=" modelos.FoodTrucker, modelos.Usuario, clasesDAO.*, modelos.*, java.util.* " %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>

	<% if (session.getAttribute("usuario") != null ) {
		
		out.print ("<h1> Bienvenido " + ( (Usuario) session.getAttribute("usuario") ).getUsername() + "</h1>");
		out.print ("<table style='width:100%'> <tr>");
		
		out.print ("<td> <a href='agregarFoodTruck.jsp'> Agregar FoodTruck </td>");
		out.print ("<td> <form action='LogOutServlet' method='post'> <input type='submit' value='Cerrar Sesion' > </from> </td>");
		
		out.print ("</tr> </table>");
		
		FoodTruckDAO ftDAO = DAOFactory.getFoodTruckDAO("HibernateJPA");
		List<FoodTruck> listResult = ftDAO.encontrarTodosParaUsuarioID( ((Usuario) session.getAttribute("usuario")).getId() );
		
		Iterator<FoodTruck> it = listResult.iterator();
		
		out.print (" <h3> ====================================================== </h3>");
		out.print (" <h3>                      Mis FoodTrucks                    </h3>");
		out.print (" <h3> ====================================================== </h3>");
		
		while( it.hasNext() ) {
		   	FoodTruck foodtruck = it.next();
			out.println( "<h4>" + foodtruck.getNombre() + "</h4>");
		   	out.println("<br> <br>");
			out.println("-----------------------------------------");
		}
		
	}  %>	

</body>
</html>