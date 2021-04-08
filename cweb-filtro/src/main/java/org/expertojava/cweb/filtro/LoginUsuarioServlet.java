package org.expertojava.cweb.filtro;

import java.io.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginUsuarioServlet")
public class LoginUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = -3879890476839074139L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws IOException
	{
		String usuario = req.getParameter("login");
		
		HttpSession session = req.getSession();
		session.setAttribute("usuario", usuario);

		PrintWriter out = resp.getWriter();

		if(usuario!=null && !usuario.trim().equals("")) {
			out.println("<HTML><HEAD><TITLE>Usuario aceptado</TITLE></HEAD>" +
		 		    "<BODY><P>Bienvenido, " + usuario +
			            ". El login se ha efectuado correctamente.</P><HR>" +
				    "<A HREF='" + req.getContextPath() + "/index.html'>Volver a la p&aacute;gina " +
				    "principal</A></BODY></HTML>");
			out.close();
		} else {
			out.println("<HTML><HEAD><TITLE>Login invalido</TITLE></HEAD>" +
		 		    "<BODY><P>ERROR: Login rechazado</P><HR>" +
				    "<A HREF='" + req.getContextPath() + "/index.html'>Volver a la p&aacute;gina " +
				    "principal</A></BODY></HTML>");
			out.close();
		}
	}
}
