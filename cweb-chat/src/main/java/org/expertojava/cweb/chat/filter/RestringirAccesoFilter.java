package org.expertojava.cweb.chat.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by expertojava on 27/10/15.
 */
@WebFilter(filterName = "RestringirAccesoFilter", urlPatterns = "/chat/*")
public class RestringirAccesoFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

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

            if (http_request.getSession().getAttribute("org.expertojava.cweb.chat.nick") != null) {
                // Continuamos de forma normal con la peticion
                chain.doFilter(request, response);
            } else {
                // Redireccionamos a la pagina de login
                http_response.sendRedirect(http_request.getContextPath()
                        + "/index.html");
            }

        } else {
            // Si no es una peticion HTTP simplemente procesamos la peticion
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
