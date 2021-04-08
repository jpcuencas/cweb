package org.expertojava.cweb.wrapper.filtro;

import org.expertojava.cweb.wrapper.parse.AnalisisHTML;
import org.expertojava.cweb.wrapper.wrapper.GenericResponseWrapper;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter("/*")
public final class RegistrarAccesosFilter implements Filter {

	private FilterConfig filterConfig = null;

	/**
	  *	Efectua el filtrado de una peticion.
	  * @param request Peticion realizada al servidor
	  * @param response Respuesta para enviar al cliente
	  * @param chain Cadena de filtros para procesar la peticion
	  */

	public void doFilter(
		ServletRequest request,
		ServletResponse response,
		FilterChain chain)
		throws IOException, ServletException {

		HttpServletRequest http_request = null;
		HttpServletResponse http_response = null;

		if (request instanceof HttpServletRequest) {
			http_request = (HttpServletRequest) request;
		}

		if (response instanceof HttpServletResponse) {
			http_response = (HttpServletResponse) response;
		}

		// Tratamos solo peticiones HTTP

		if (http_request != null && http_response != null) {

			// Creamos un wrapper

			GenericResponseWrapper responseWrapper =
				new GenericResponseWrapper(http_response);

			// Solicitamos la URL al servidor

			chain.doFilter(http_request, responseWrapper);

			// Procesamos los datos generados

			byte[] datos = responseWrapper.getData();

			String responseString = new String(datos);

			AnalisisHTML parser = new AnalisisHTML();

			parser.parse(responseString.toCharArray());

			ServletContext sc = filterConfig.getServletContext();

			sc.log("Ha accedido a la pagina " + parser.getTitulo());

			// Devolvemos el contenido al cliente

			http_response.setHeader("Cache-control", "no-cache");
			http_response.setHeader("Cache-control", "no-store");
			http_response.setHeader("Pragma", "no-cache");
			http_response.setHeader("Expires", "0");

			OutputStream out = http_response.getOutputStream();
			out.write(datos);
			out.close();

		} else {
			chain.doFilter(request, response);
		}

	}

	/**
	  * Destruye el filtro. Cierra conexion a base de datos
	  */
	public void destroy() {
		this.filterConfig = null;
	}

	/** 
	  * Inicializa el filtro. Abre conexion a BD y lee parametros.
	  * @param filterConfig Configuracion del filtro y de la aplicacion.
	  */
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

}
