package org.expertojava.cweb.ejemplos;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Ejemplo de servlet que utiliza parametros de inicializacion

public class ClaseServletInit extends HttpServlet
{
	
	private static final long serialVersionUID = 9076340286631079513L;

	String mensaje = "";		// Mensaje que se va a mostrar en la pagina
	int contador = 1;			// Numero de veces que se va a repetir el mensaje

	// Metodo de inicializacion
	
	public void init(ServletConfig conf) throws ServletException
	{
		super.init(conf);		// MUY IMPORTANTE
		
		mensaje = conf.getInitParameter("mensaje");
		if (mensaje == null)
			mensaje = "No se ha encontrado mensaje a mostrar";
		
		try
		{
			contador = Integer.parseInt(conf.getInitParameter("contador"));
		} catch (NumberFormatException e) {
			contador = 1;
		}
	}

	// Metodo para procesar una peticion GET
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println ("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");
		out.println ("<HTML>");
		out.println ("<BODY>");
		
		for (int i = 0; i < contador; i++)		
		{
			out.println ("<strong>" + mensaje + "</strong>");
			out.println ("<BR>");
		}
		
		out.println ("</BODY>");
		out.println ("</HTML>");
	}
}