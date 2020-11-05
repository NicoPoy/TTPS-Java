<%@ page import="clasesDAO.*, modelos.*, java.util.* " %>

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
		out.print ("<table style='width:90%'> <tr>");
		
		out.print ("<td> <a href='editarUsuario.jsp'> Editar Usuario </td>");
		out.print ("<td> <a href='agregarFoodTruck.jsp'> Agregar FoodTruck </td>");
		out.print ("<td> <a href='editarFoodTruck.jsp'> Editar FoodTruck </td>");
		out.print ("<td> <a href='borrarFoodTruck.jsp'> Borrar FoodTruck </td>");
		
		out.print ("<td> <form action='LogOutServlet' method='post'> <input type='submit' value='Cerrar Sesion' > </from> </td>");
		
		out.print ("</tr> </table>");
		
		FoodTruckDAO ftDAO = DAOFactory.getFoodTruckDAO("HibernateJPA");
		List<FoodTruck> listResult = ftDAO.encontrarTodosParaUsuarioID( ((Usuario) session.getAttribute("usuario")).getId() );
		Iterator<FoodTruck> it = listResult.iterator();
		
		out.print (" <h3> ======================================================================== </h3>");
		out.print (" <h3>                   		   Mis FoodTrucks     			               </h3>");
		out.print (" <h3> ======================================================================== </h3>");
		
		out.print ("<table style='width:100%'>");
		
		while( it.hasNext() ) {
		   	FoodTruck foodtruck = it.next();
			out.print( "<tr> <td>" + foodtruck.getNombre() + "</td>");
			Iterator<TipoDeServicio> serviciosIt = foodtruck.getTipos().iterator();
			
			out.print("<td> Servicios:");
		
			while ( serviciosIt.hasNext()) {
				TipoDeServicio tipo = serviciosIt.next();
				out.print(" " + tipo.getNombre() );
			}
			
			out.print( "</td>");		
			out.print("<td> <a href='editarFoodTruck.jsp'> Editar </td> </tr>");
		}
		
		out.print ("</table>");
				
	} else { out.print ("No estas logeado"); }
		
	%>	
	

</body>
</html>