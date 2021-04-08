package org.expertojava.cweb.chat;

import org.expertojava.cweb.chat.to.ColaMensajes;
import org.expertojava.cweb.chat.to.Mensaje;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/EnviaMensajeServlet")
public class EnviaMensajeServlet extends HttpServlet {

	private static final long serialVersionUID = -481257371131179080L;

	@Inject
	ColaMensajes cm;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		// Si no hay usuario, redireccionar a /chat/error.html
		HttpSession sesion = req.getSession();
		ServletContext sc = this.getServletContext();

		String nick = (String)sesion.getAttribute("org.expertojava.cweb.chat.nick");
		if(nick==null) {
			RequestDispatcher rd = sc.getRequestDispatcher("/chat/error.html");
			rd.forward(req, res);

			return;
		}

		// Agregar mensaje enviado a la cola de mensajes
		String texto = req.getParameter("texto");

		//ColaMensajes cm = (ColaMensajes)sc.getAttribute("org.expertojava.cweb.chat.mensajes");
		cm.addMessage(new Mensaje(nick, texto));

		// Redireccionar a /chat/enviaMensaje.html
		res.setContentType("text/html");

		RequestDispatcher rd = sc.getRequestDispatcher("/chat/enviaMensaje.html");
		rd.include(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		doGet(req,res);
	}
}
