<%@ page import="ttps.spring.clasesDAO.*, ttps.spring.model.*, java.util.* " %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar FoodTruck - FoodTrucker</title>
</head>
<body>

		<h1>Editar FoodTruck</h1>
	  	
	  	<%
	  		Long id = Long.parseLong(request.getParameter("id"));	  		
	  		
	  		TipoDeServicioDAO tsDAO = DAOFactory.getTipoDeServicioDAO();
			List<TipoDeServicio> listResult = tsDAO.traerTodos();
			Iterator<TipoDeServicio> it = listResult.iterator();
						
			FoodTruckDAO fDAO = DAOFactory.getFoodTruckDAO();
			FoodTruck f = fDAO.recuperar(id);
			
			out.println("<form action='editarFoodTruck?id="+id+"' method='post'> ");
			out.println(" <p> Nombre del FoodTruck: <input type='text' name='nombre' value="+ f.getNombre() +"> </p> ");
			out.println(" <p> Descripcion: <input type='text' name='descripcion' value="+ f.getDescripcion() +"> </p> ");
			out.println(" <p> Instagram: <input type='text' name='instagram' value="+ f.getInstagram() +"> </p> ");
			out.println(" <p> Twitter: <input type='text' name='twitter' value="+ f.getTwitter() +"> </p>");
			out.println(" <p> Whatsapp: <input type='text' name='whatsapp' value="+ f.getWhatsapp() +"> </p>");
			out.println(" <p> Pagina Web: <input type='text' name='url' value="+ f.getUrl() +"> </p> ");
			
			while( it.hasNext() ) {
				TipoDeServicio tipo = it.next();
				out.println("<p><input type='checkbox' name="+ tipo.getNombre() +" value="+ tipo.getNombre() +">"+ tipo.getNombre() +"</p>");
			}
			
			out.print(" <input type='submit' value='Cargar'> ");
			out.print(" </form> ");			

		%>

</body>
</html>