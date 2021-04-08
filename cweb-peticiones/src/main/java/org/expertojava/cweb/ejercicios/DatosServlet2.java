package org.expertojava.cweb.ejercicios;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="DatosServlet2", urlPatterns = "/DatosServlet2")
public class DatosServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(isEmpty(request.getParameter("nombre")) || isEmpty(request.getParameter("apellidos")) ||
                isEmpty(request.getParameter("email")) || isEmpty(request.getParameter("sexo"))) {

            response.sendRedirect("form_datos2.html");
        } else {
            response.sendRedirect("bienvenida.html");
        }
    }

    private boolean isEmpty(String s) {
        return s==null || s.isEmpty();
    }
}