package org.expertojava.cweb.ejercicios;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.commons.logging.*;

// Ejemplo de servlet que genera texto plano
@WebServlet(name = "ServletLog4J1", urlPatterns = "/ServletLog4J1")
public class ServletLog4J1 extends HttpServlet
{
	
	private static final long serialVersionUID = -3638010169817868083L;

	static Log logger = LogFactory.getLog(ServletLog4J1.class);
	
	// Metodo para procesar una peticion GET
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		logger.info("Atendiendo peticion Servlet Log4J");
		PrintWriter out = response.getWriter();
		out.println ("Hola, este es un servlet sencillo de prueba para logging");
	}
}