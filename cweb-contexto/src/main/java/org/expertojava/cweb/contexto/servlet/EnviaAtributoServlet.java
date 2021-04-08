package org.expertojava.cweb.contexto.servlet;

import org.expertojava.cweb.contexto.to.ValorAtributo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;

@WebServlet("/EnviaAtributoServlet")
public class EnviaAtributoServlet extends HttpServlet {

	private static final long serialVersionUID = 5391808124309654794L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		ServletContext sc = getServletContext();

		String nombre = req.getParameter("nombre");
		String valor = req.getParameter("valor");

		String id = req.getSession().getId();

		if(valor==null || valor.equals("")) {
			sc.setAttribute(nombre, null);			
		} else {
			ValorAtributo atr = new ValorAtributo(valor, id);
			sc.setAttribute(nombre, atr);
		}

		RequestDispatcher rd = sc.getRequestDispatcher("/ListaAtributosServlet");
		rd.forward(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		doGet(req,res);
	}
}
