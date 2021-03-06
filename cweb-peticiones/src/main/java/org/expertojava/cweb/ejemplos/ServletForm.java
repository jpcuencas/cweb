package org.expertojava.cweb.ejemplos;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

// Servlet ejemplo de manejo de formularios

@WebServlet("/ServletForm")
public class ServletForm extends HttpServlet
{
	
	private static final long serialVersionUID = -5539972276319383069L;

	// Metodo para GET
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();

		// Mostramos los datos del formulario

		out.println ("<HTML>");			
		out.println ("<BODY>");			
		out.println ("<H1>Datos del formulario</H1>");			
		out.println ("<BR>");

		String valor1 = request.getParameter("texto1");
		String valor2 = request.getParameter("lista");
		String[] valor3 = request.getParameterValues("texto2");
		
		out.println ("Valor 1:" + valor1);
		out.println ("<BR>");
		out.println ("Valor 2:" + valor2);
		out.println ("<BR>");
		out.println ("Valor 3:");
		out.println ("<BR>");
		if (valor3 != null)
			for (int i = 0; i < valor3.length; i++)
			{
				out.println (valor3[i]);
				out.println ("<BR>");
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
