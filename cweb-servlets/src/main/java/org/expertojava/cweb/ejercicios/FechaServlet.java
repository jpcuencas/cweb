package org.expertojava.cweb.ejercicios;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FechaServlet extends HttpServlet
{
	private static final long serialVersionUID = -9004080270649416898L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String fecha = "" + new java.util.Date();
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		out.println("<html><head><title>" + fecha + "</title></head>");
		out.println("<body><h3>" + fecha +"</h3></body></html>");
		out.flush();
		out.close();
	}
}