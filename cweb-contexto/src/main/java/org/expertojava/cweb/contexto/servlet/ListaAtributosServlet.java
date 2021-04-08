package org.expertojava.cweb.contexto.servlet;

import org.expertojava.cweb.contexto.to.Atributo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListaAtributosServlet")
public class ListaAtributosServlet extends HttpServlet {

	private static final long serialVersionUID = 6344358363291420572L;

	@SuppressWarnings("rawtypes")
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		ServletContext sc = getServletContext();

		Enumeration nombresAtributos = sc.getAttributeNames();

		ArrayList<Atributo> listaAtributos = new ArrayList<Atributo>();
		
		while(nombresAtributos.hasMoreElements()) {
			String nombreAtrib = (String)nombresAtributos.nextElement();
			listaAtributos.add(new Atributo(nombreAtrib, sc.getAttribute(nombreAtrib)));
		}

		RequestDispatcher rd = sc.getRequestDispatcher("/jsp/listaAtributos.jsp");
		req.setAttribute("listaAtrib", listaAtributos);
		rd.forward(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		doGet(req,res);
	}
}
