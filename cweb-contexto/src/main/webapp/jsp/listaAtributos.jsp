<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" %>
<%@ page import="org.expertojava.cweb.contexto.to.Atributo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de atributos</title>
</head>
<body>
<h1>Listado de atributos</h1>
<% List<Atributo> listaAtrib = (List<Atributo>)request.getAttribute("listaAtrib"); %>
<ul>
<% for(Atributo atrib: listaAtrib) { %>
<li>
<strong><%= atrib.getNombre() %></strong>
<%= atrib.getValor() %>
</li>
<% } %>
</ul>
<hr/>
<a href="<%= request.getContextPath() %>/index.html">Volver al índice</a>
</body>
</html>