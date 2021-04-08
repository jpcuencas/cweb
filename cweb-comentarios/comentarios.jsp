<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, es.ua.jtech.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Comentarios</h1>
<h2>Añadir comentario</h2>
<form action="AddComentario" method="post">
	Tu nombre: <input type="text" name="autor"/> <br/>
	Tu comentario: <br/>
	<textarea rows="5" cols="40" name="texto"></textarea> <br/>
	<input type="submit" value="Enviar"/>	
</form>
<h2>Comentarios de otros usuarios</h2>
<%
	List<Comentario> coments;
	coments = (List<Comentario>) application.getAttribute("comentarios");
	if (coments!=null) { 
 		for (Comentario c : coments) {
%>
			<p>
				mensaje de <strong><%=c.getAutor()%></strong> el <%= c.getFechaCadena() %> <br/>
				<em><%=c.getTexto() %></em>
			</p>
<%
 		}
	}
%>
</body>
</html>