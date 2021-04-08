package org.expertojava.cweb.ejemplos;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

// Servlet ejemplo de gestion de sesiones 

@WebServlet("/ServletSesiones")
public class ServletSesiones extends HttpServlet
{	
	private static final long serialVersionUID = 1804042987996878346L;

	// Metodo para GET
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession sesion = request.getSession();

		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");
		
		PrintWriter out = response.getWriter();

		if (sesion.getAttribute("contadorVisitas")==null)
		{
			// Mostramos un mensaje de primera visita

			out.println ("<HTML>");			
			out.println ("<BODY>");			
			out.println ("Hola, esta es tu primera visita al sitio web en esta sesion");			
			out.println ("<BR>");
			out.println ("</BODY>");			
			out.println ("</HTML>");			
			
			sesion.setAttribute("contadorVisitas", new Integer(1));
			
		} else {

			// Mostramos el numero de visitas y actualizamos el contador
			int contador = (Integer)(sesion.getAttribute("contadorVisitas"));
			contador++;

			out.println ("<HTML>");			
			out.println ("<BODY>");			
			out.println ("Hola, esta es tu visita numero " + contador + " a la pagina en esta sesion");			
			out.println ("<BR>");
			out.println ("</BODY>");			
			out.println ("</HTML>");			
			
			sesion.setAttribute("contadorVisitas", new Integer(contador));			
		}		
	}	
}
