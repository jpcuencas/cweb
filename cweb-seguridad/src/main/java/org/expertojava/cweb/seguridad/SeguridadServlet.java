package org.expertojava.cweb.seguridad;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SeguridadServlet
 */
@WebServlet("/SeguridadServlet")
@ServletSecurity(@HttpConstraint(rolesAllowed = { "admin", "registrado" }))
public class SeguridadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see javax.servlet.http.HttpServlet#HttpServlet()
     */
    public SeguridadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<p>Principal: " + request.getUserPrincipal() + "</p>");			
		out.println("<p>Tipo de autentificacion: " + request.getAuthType() + "</p>");
		out.println("<p>Transmisión segura: " + request.isSecure() + "</p>");

		if(request.isUserInRole("admin")) {
			out.println("<p><strong>Accediendo como administrador</strong></p>");
		}

		out.flush();
		out.close();
	}

	/**
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
