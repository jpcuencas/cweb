package org.expertojava.cweb.ranking.servlet;

import org.expertojava.cweb.ranking.dao.PaginasDAO;
import org.expertojava.cweb.ranking.to.PaginaTO;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/RankingPaginasServlet")
public class RankingPaginasServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		PaginasDAO dao = new PaginasDAO();
		
		Collection<PaginaTO> lista = dao.listaPaginas();

		PrintWriter out = response.getWriter();

		out.println("<html><head><title>Ranking de paginas</title></head>");
		out.println("<body>");

		out.println("<table>");
		out.println("<tr>");
		out.println("<th><b>Titulo</b></th>");
		out.println("<th><b>Accesos</b></th>");
		out.println("</tr>");

		for(PaginaTO pagina: lista) {
			out.println("<tr>");
			out.println("<td>" + pagina.getTitulo() + "</td>");
			out.println("<td>" + pagina.getAccesos() + "</td>");
			out.println("</tr>");
		}

		out.println("</table>");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		doGet(req, res);
	}

	/**
	  * Destruye el servlet. Cierra conexin a base de datos
	  */

	public void destroy() {

	}

	/**
	  * Inicializa el servlet. Abre conexin a BD y lee par�etros.
	  * @param servletConfig Configuracin del servlet y de la aplicacin.
	  */

	public void init(ServletConfig servletConfig) throws ServletException {

	}

}
