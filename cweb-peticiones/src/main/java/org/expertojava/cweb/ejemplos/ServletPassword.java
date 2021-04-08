package org.expertojava.cweb.ejemplos;
import java.io.*;
import java.util.*;
import sun.misc.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

// Servlet ejemplo de cabeceras de autentificacion

@WebServlet("/ServletPassword")
public class ServletPassword extends HttpServlet
{
	private static final long serialVersionUID = 2008635599061168285L;

	// Conjunto de logins y passwords permitidos
	
	Properties datos = new Properties();
	
	// Metodo de inicializacion
	
	public void init()
	{
		datos.setProperty("usuario1", "password1");
		datos.setProperty("usuario2", "password2");
	}
	
	// Metodo para GET
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{		
		response.setContentType("text/html");

		// Comprobamos si hay cabecera de autorizacion
		
		String autorizacion = request.getHeader("Authorization");
		
		if (autorizacion == null)
		{
			// Enviamos el codigo 401 y la cabecera para autentificacion
			
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.setHeader("WWW-Authenticate", "BASIC realm=\"privileged-few\"");
		}
		else
		{
			// Obtenemos los datos del usuario y comparamos con los almacenados
			
			String datosUsuario = autorizacion.substring(6).trim();
			BASE64Decoder dec = new BASE64Decoder();
			String usuarioPassword = new String(dec.decodeBuffer(datosUsuario));
			int indice = usuarioPassword.indexOf(":");
			String usuario = usuarioPassword.substring(0, indice);
			String password = usuarioPassword.substring(indice + 1);
			String passwordReal = datos.getProperty(usuario);
			
			if (passwordReal != null && passwordReal.equals(password))
			{
				// Mostramos mensaje de bienvenida
				
				PrintWriter out = response.getWriter();
				out.println ("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");
				out.println ("<HTML><BODY>");
				out.println ("Usuario identificado correctamente");
				out.println ("</BODY></HTML>");				
			} else {
				
				// Volvemos a pedir autentificacion

				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				response.setHeader("WWW-Authenticate", "BASIC realm=\"privileged-few\"");
			}
		}
	}	

	// Metodo para POST
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
	
}
