package org.expertojava.cweb.ejercicios;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="CompruebaServlet", urlPatterns = "/CompruebaServlet")
public class CompruebaServlet extends HttpServlet {

    static Log logger = LogFactory.getLog(CompruebaServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        logger.info("Remote address: " + request.getRemoteAddr());
        logger.info("User-Agent: " + request.getHeader("User-Agent"));
        logger.info("Request method: " + request.getMethod());

        String error = "";

        if(isEmpty(request.getParameter("nick"))) {
            error += "<p>El nick esta vacio</p>";
        }
        if(isEmpty(request.getParameter("password"))) {
            error += "<p>El password esta vacio</p>";
        }
        if(isEmpty(request.getParameter("email"))) {
            error += "<p>El email esta vacio</p>";
        }

        if(isEmpty(error)) {
            PrintWriter out = response.getWriter();
            out.println("<html><head><title>Comprueba</title></head><body><h1>Formulario correcto</h1></body></html>");
            out.flush();
            out.close();
        } else {
            response.sendRedirect("ErrorCompruebaServlet?mensaje=" + error);
        }
    }

    private boolean isEmpty(String s) {
        return s==null || s.isEmpty();
    }

}