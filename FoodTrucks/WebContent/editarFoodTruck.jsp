<%@ page import="clasesDAO.*, modelos.*, java.util.* " %>
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
	  		
	  		TipoDeServicioDAO tsDAO = DAOFactory.getTipoDeServicioDAO("HibernateJPA");
			List<TipoDeServicio> listResult = tsDAO.traerTodos();
			Iterator<TipoDeServicio> it = listResult.iterator();
						
			FoodTruckDAO fDAO = DAOFactory.getFoodTruckDAO("HibernateJPA");
			FoodTruck f = fDAO.recuperar(id);
			
			out.println("<form action='editarFoodTruck' method='post'> ");
			out.println(" <p> Nombre del FoodTruck: <input type='text' name='nombre' value="+ f.getNombre() +"> </p> ");
			out.println(" <p> Descripcion: <input type='text' name='descripcion' value="+ f.getDescripcion() +"> </p> ");
			out.println(" <p> Instagram: <input type='text' name='instagram' value="+ f.getInstagram() +"> </p> ");
			out.println(" <p> Twitter: <input type='text' name='twitter' value="+ f.getTwitter() +"> </p>");
			out.println(" <p> Whatsapp: <input type='text' name='whatsapp' value="+ f.getWhatsapp() +"> </p>");
			out.println(" <p> Pagina Web: <input type='text' name='url' value="+ f.getUrl() +"> </p> ");
			
			Boolean tiene;
			
			while( it.hasNext() ) {
				tiene=false;	
				TipoDeServicio tipo = it.next();
				while("la lista no se acabo"){
						"lista.siguiente"
						if("elemento actual = tipo"){
							tiene=true;
						}
				}
				if (tiene){
					out.println("<p><input type='checkbox' name="+ tipo.getNombre() +" value="+ tipo.getNombre() +" checked='true'>"+ tipo.getNombre() +"</p>");
				}
				else{
					out.println("<p><input type='checkbox'  name="+ tipo.getNombre() +" value="+ tipo.getNombre() +" checked='false'>"+ tipo.getNombre() +"</p>");
				}
			}
			
			out.print(" <input type='submit' value='Cargar'> ");
			out.print(" </form> ");			

		%>

</body>
</html>