package org.expertojava.cweb.ejercicios;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by expertojava on 15/10/15.
 */
public class ParamIniServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Parametros de inicio</title></head><body><table><tr><th>Parametro</th><th>Valor</th></tr>");

        Enumeration<String> nombres = this.getInitParameterNames();
        while (nombres.hasMoreElements()) {
            String nombre = nombres.nextElement();
            String valor = this.getInitParameter(nombre);

            out.println("<tr><td>" + nombre + "</td><td>" + valor + "</td></tr>");
        }

        out.println("</table></body></html>");
        out.flush();
        out.close();
    }
}
