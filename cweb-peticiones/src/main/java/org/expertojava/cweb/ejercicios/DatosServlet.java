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
@WebServlet(name = "DatosServlet", urlPatterns = "/DatosServlet")
public class DatosServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Parametros</title></head><body>");
        out.println("<table><tr><th>Nombre</th><th>Valor</th></tr>");

        Enumeration<String> params = request.getParameterNames();
        while(params.hasMoreElements()) {
            String param = params.nextElement();
            String valor = request.getParameter(param);

            out.println("<tr><td>" + param + "</td><td>" + valor + "</td></tr>");
        }

        out.println("</table></body></html>");
        out.flush();
        out.close();
    }
}
