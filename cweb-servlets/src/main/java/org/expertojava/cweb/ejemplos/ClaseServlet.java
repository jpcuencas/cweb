package org.expertojava.cweb.ejemplos;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Ejemplo de servlet que genera texto plano

public class ClaseServlet extends HttpServlet
{
	private static final long serialVersionUID = -4415217187424288468L;

	// Metodo para procesar una peticion GET
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		out.println ("Hola, este es un servlet sencillo de prueba");
	}
}