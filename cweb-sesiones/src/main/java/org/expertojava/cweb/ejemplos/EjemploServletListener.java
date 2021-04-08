package org.expertojava.cweb.ejemplos;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/EjemploServletListener")
public class EjemploServletListener extends HttpServlet {
	private static final long serialVersionUID = 628099376929567700L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");

		HttpSession sesion = request.getSession();
		PrintWriter out = response.getWriter();

		if (sesion.isNew()) {
			// Mostramos mensaje de inicio

			out.println("<HTML><BODY>" + "Mensaje de inicio"
							+ "</BODY></HTML>");
			sesion.setAttribute("contador", new ObjetoSesion(1));

		} else {

			// Mostramos el valor actual del objeto "contador"

			int contador = ((ObjetoSesion) (sesion.getAttribute("contador")))
					.getValor();
			String mensaje = ((ObjetoSesion) (sesion.getAttribute("contador")))
					.getEnlazado();

			out.println("<HTML><BODY>");
			out.println("Valor: " + contador + "<br>Enlazado: " + mensaje);
			out.println("</BODY></HTML>");

			sesion.setAttribute("contador", new ObjetoSesion(contador + 1));
		}
	}
}

class ObjetoSesion implements HttpSessionBindingListener {
	int valor;
	String enlazado = "NO";

	public ObjetoSesion(int valor) {
		this.valor = valor;
	}

	public void valueBound(HttpSessionBindingEvent e) {
		enlazado = "Objeto enlazado a la sesion " + valor + " veces";
	}

	public void valueUnbound(HttpSessionBindingEvent e) {
	}

	public String getEnlazado() {
		return enlazado;
	}

	public int getValor() {
		return valor;
	}
}
