package org.expertojava.cweb.ejercicios;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Ejemplo de servlet que genera texto plano
@WebServlet(name = "ServletLog4J2", urlPatterns = "/ServletLog4J2")
public class ServletLog4J2 extends HttpServlet
{
	private static final long serialVersionUID = 4466756963133948179L;

	static Log logger = LogFactory.getLog(ServletLog4J2.class);

	// Metodo para procesar una peticion GET
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		long t = System.currentTimeMillis();
		logger.info("Inicio de la peticion");

		PrintWriter out = response.getWriter();
		out.println ("Hola, este es un servlet sencillo de prueba para logging (2)");

		logger.info("Fin de la peticion en " + (System.currentTimeMillis()-t) + " ms");
	}
}