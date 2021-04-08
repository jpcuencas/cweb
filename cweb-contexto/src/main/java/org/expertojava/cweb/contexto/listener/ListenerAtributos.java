package org.expertojava.cweb.contexto.listener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@WebListener
public class ListenerAtributos implements ServletContextAttributeListener {

	public void attributeAdded(ServletContextAttributeEvent scab) {
		ServletContext sc = scab.getServletContext();

		sc.log("Atributo [" + scab.getName() + "] agregado");
	}

	public void attributeRemoved(ServletContextAttributeEvent scab) {
		ServletContext sc = scab.getServletContext();

		sc.log("Atributo [" + scab.getName() + "] eliminado");
	}

	public void attributeReplaced(ServletContextAttributeEvent scab) {
		ServletContext sc = scab.getServletContext();

		sc.log("Atributo [" + scab.getName() + "] reemplazado");
	}

}
