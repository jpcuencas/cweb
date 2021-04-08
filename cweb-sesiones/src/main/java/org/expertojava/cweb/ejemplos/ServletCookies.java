package org.expertojava.cweb.ejemplos;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

// Servlet ejemplo de gestion de cookies 

@WebServlet("/ServletCookie")
public class ServletCookies extends HttpServlet
{	
	private static final long serialVersionUID = -6335676457940742053L;

	// Metodo para GET
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");
		
		Cookie[] cookies = request.getCookies();
		Cookie contador = buscaCookie("contador", cookies);

		HttpSession sesion = request.getSession();

		if (contador == null)
		{
			// Creamos la cookie con el contador
			
			Cookie cookie = new Cookie ("contador", "1");
			cookie.setMaxAge(180);
			response.addCookie(cookie);

			// Mostramos el mensaje de primera visita

			PrintWriter out = response.getWriter();
			out.println ("<HTML>");			
			out.println ("<BODY>");			
			out.println ("Hola, esta es tu primera visita a la pagina que almacena esta cookie");			
			out.println ("<BR>");
			out.println ("</BODY>");			
			out.println ("</HTML>");			
		} else {
		
			// Obtenemos el valor actual del contador
			
			int cont = Integer.parseInt(contador.getValue());
			cont++;
			
			// Modificamos el valor de la cookie incrementando el contador
			
			Cookie cookie = new Cookie ("contador", "" + cont);
			cookie.setMaxAge(180);
			response.addCookie(cookie);

			// Mostramos el numero de visitas

			PrintWriter out = response.getWriter();
			out.println ("<HTML>");			
			out.println ("<BODY>");			
			out.println ("Hola, esta es tu visita numero " + cont + " almacenada por esta cookie");			
			out.println ("<BR>");
			out.println ("</BODY>");			
			out.println ("</HTML>");						
		}		
	}	
	
	// Busca la cookie 'nombre' en el array de cookies indicado. Devuelve null si no esta
	
	private Cookie buscaCookie(String nombre, Cookie[] cookies)
	{
		if (cookies == null)
			return null;
		
		for (int i = 0; i < cookies.length; i++)
			if (cookies[i].getName().equals(nombre))
				return cookies[i];
		
		return null;
	}
}
