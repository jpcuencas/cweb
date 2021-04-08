package org.expertojava.cweb.ejemplos;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Ejemplo de servlet que genera HTML

public class ClaseServletHTML extends HttpServlet
{
	
	private static final long serialVersionUID = -3859180041587925707L;

	// Metodo para procesar una peticion GET
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println ("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");
		out.println ("<HTML>");
		out.println ("<BODY>");
		out.println ("<h1>Titulo de una pagina de prueba</h1>");
		out.println ("<br>Hola, este es un servlet que genera HTML");
		out.println ("</BODY>");
		out.println ("</HTML>");
	}
}