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
	
		<% if (session.getAttribute("usuario") == null ) {
			
			out.println("<form action='agregarUsuario' method='post'> ");
			out.println(" <p> Nombre: <input type='text' name='nombre'> </p> ");
			out.println(" <p> Apellido: <input type='text' name='apellido'> </p> ");
			out.println(" <p> Username: <input type='text' name='username'> </p> ");
			out.println(" <p> Password: <input type='text' name='password'> </p>");	
			out.println(" <p> <input type='checkbox' name='foodtrucker' value='foodtrucker'> FoodTrucker </p>");
			out.println(" <p> <input type='checkbox' name='organizador' value='organizador'> Organizador </p>");
			out.println(" <input type='submit' value='Crear'> ");
			out.println(" </form> ");	
			
		} %>

</body>
</html>