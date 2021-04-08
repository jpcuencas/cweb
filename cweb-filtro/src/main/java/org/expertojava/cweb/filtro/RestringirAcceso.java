package org.expertojava.cweb.filtro;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

@WebFilter("/restringido/*")
public class RestringirAcceso implements Filter {

	FilterConfig filterConfig = null;

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// Se intenta acceder a la zona restringida

		// Solo podemos comprobar la sesion en el caso de tener una peticion
		// HTTP
		if (request instanceof HttpServletRequest
				&& response instanceof HttpServletResponse) {

			HttpServletRequest http_request = (HttpServletRequest) request;
			HttpServletResponse http_response = (HttpServletResponse) response;

			// *********** Comprobamos si el usuario se ha registrado
			// ***********
			// En nuestra aplicacion si el usuario se ha registrado habremos
			// establecido
			// el atributo usuario de la sesion al nombre del usuario, si no
			// sera null.

			if (http_request.getSession().getAttribute("usuario") != null) {
				// Continuamos de forma normal con la peticion
				chain.doFilter(request, response);
			} else {
				// Redireccionamos a la pagina de login
				http_response.sendRedirect(http_request.getContextPath() 
						+ "/login.html");
			}

		} else {
			// Si no es una peticion HTTP simplemente procesamos la peticion
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig config) {
		filterConfig = config;
	}

	public void destroy() {
		filterConfig = null;
	}
}