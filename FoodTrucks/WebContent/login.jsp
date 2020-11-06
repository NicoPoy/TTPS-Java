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
		
		out.print( "<form action='LoginServlet' method='post'>" );
		out.print( "<p> Usuario: <input type='text' name='username' ></p> " );
		out.print( "<p> Password: <input type='password' name='password' ></p> " );
		out.print( "<p> <input type='submit' value='Ingresar'> </p> " );
		out.print( "</form> " );
		
		out.print("<a href='agregarUsuario.jsp'> Registrarse </a>");	
	} %>	

</body>

</html>