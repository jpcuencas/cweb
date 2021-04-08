package org.expertojava.cweb.chat;

import org.expertojava.cweb.chat.to.ColaMensajes;
import org.expertojava.cweb.chat.to.Mensaje;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/ListaMensajesServlet")
public class ListaMensajesServlet extends HttpServlet {

	private static final long serialVersionUID = 427199619647569137L;

    @Inject
    ColaMensajes cm;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		HttpSession sesion = req.getSession();
		ServletContext sc = this.getServletContext();

		// Añadir cabecera para actualizar cada 5 segundos
		res.setHeader("Refresh", "5");
        res.setContentType("text/html");

        RequestDispatcher rd = sc.getRequestDispatcher("/chat/listaMensajes.xhtml");
        rd.forward(req, res);
        /*
        PrintWriter out = res.getWriter();

        // Incluir /chat/cabecera.htmlf
        RequestDispatcher rd = sc.getRequestDispatcher("/chat/cabecera.htmlf");
        rd.include(req, res);

        // Mostrar mensajes del chat
        String nick = (String)sesion.getAttribute("org.expertojava.cweb.chat.nick");

        //ColaMensajes cm = (ColaMensajes)sc.getAttribute("org.expertojava.cweb.chat.mensajes");
        for(Mensaje m: cm.getList()) {
            if(m.getEmisor().equals(nick)) {
                out.println("<strong>&lt;" + m.getEmisor() + "&gt;</strong> " + m.getTexto() + "<br/>");
            } else {
                out.println("&lt;" + m.getEmisor() + "&gt; " + m.getTexto() + "<br/>");
            }
        }

        // Incluir /chat/pie.htmlf
        rd = sc.getRequestDispatcher("/chat/pie.htmlf");
        rd.include(req, res);

        out.flush();
        out.close();
        */
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		doGet(req,res);
	}
}
