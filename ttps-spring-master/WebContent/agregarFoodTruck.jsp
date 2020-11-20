<%@ page import="ttps.spring.clasesDAO.*, ttps.spring.model.*, java.util.* " %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Borrar FoodTruck - FoodTrucker</title>
</head>
<body>
	
	<h1> Agregar FoodTruck a su perfil </h1>
	  	
	  	<%  TipoDeServicioDAO tsDAO = DAOFactory.getTipoDeServicioDAO();
			List<TipoDeServicio> listResult = tsDAO.traerTodos();
			Iterator<TipoDeServicio> it = listResult.iterator();
						
			out.println("<form action='agregarFoodTruck' method='post'> ");
			out.println(" <p> Nombre del FoodTruck: <input type='text' name='nombre'> </p> ");
			out.println(" <p> Descripcion: <input type='text' name='descripcion'> </p> ");
			out.println(" <p> Instagram: <input type='text' name='instagram'> </p> ");
			out.println(" <p> Twitter: <input type='text' name='twitter'> </p>");
			out.println(" <p> Whatsapp: <input type='text' name='whatsapp'> </p>");
			out.println(" <p> Pagina Web: <input type='text' name='url'> </p> ");
			
			while( it.hasNext() ) {
				TipoDeServicio tipo = it.next();
				out.println("<p><input type='checkbox' name="+ tipo.getNombre() +" value="+ tipo.getNombre() +">"+ tipo.getNombre() +"</p>");
			}
			
			out.print(" <input type='submit' value='Cargar'> ");
			out.print(" </form> ");			
		%>

</body>

</html>