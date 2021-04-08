package org.expertojava.cweb.ejemplos;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

// Servlet ejemplo de manejo de cabeceras de peticion HTTP

@WebServlet("/ServletCabecerasPeticion")
public class ServletCabecerasPeticion extends HttpServlet
{
	private static final long serialVersionUID = 4102656829518300180L;

	// Metodo para GET
	
	@SuppressWarnings("rawtypes")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println ("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");

		// Mostramos las cabeceras enviadas en la peticion

		out.println ("<HTML>");			
		out.println ("<BODY>");			
		out.println ("<H1>Cabeceras</H1>");			
		out.println ("<BR>");

		Enumeration cabeceras = request.getHeaderNames();

		while (cabeceras.hasMoreElements())
		{		
			String nombre = (String)(cabeceras.nextElement());
			out.println ("Nombre: " + nombre + ", Valor: " + request.getHeader(nombre));
			out.println ("<BR><BR>");
		}

		out.println ("</BODY>");			
		out.println ("</HTML>");						
	}	

	// Metodo para POST
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
	
}
