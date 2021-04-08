package org.expertojava.cweb.chat.listener; /**
 * Created by expertojava on 22/10/15.
 */

import org.expertojava.cweb.chat.to.ColaMensajes;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class ContextoListener implements ServletContextListener {

    // Public constructor is required by servlet spec
    public ContextoListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
        /*
        ServletContext sc = sce.getServletContext();
        ColaMensajes cm = new ColaMensajes();
        sc.setAttribute("org.expertojava.cweb.chat.mensajes", cm);
        */
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }


}
