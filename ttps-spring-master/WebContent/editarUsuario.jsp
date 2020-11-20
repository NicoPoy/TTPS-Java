<%@ page import="ttps.spring.clasesDAO.*, ttps.spring.model.*, java.util.* " %>
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
			Usuario u = (Usuario) session.getAttribute("usuario");	  		
			out.println("<form action='editarUsuario' method='post'> ");
			out.println(" <p> Nombre: <input type='text' name='nombre' value="+ u.getNombre() +"> </p> ");
			out.println(" <p> Apellido: <input type='text' name='apellido' value="+ u.getApellido() +"> </p> ");
			out.println(" <p> Username: <input type='text' name='username' value="+ u.getUsername() +"> </p> ");
			out.println(" <p> Password: <input type='text' name='password' value="+ u.getPassword() +"> </p>");	
			out.print(" <input type='submit' value='Guardar'> ");
			out.print(" </form> ");			
		} %>

</body>

</html>