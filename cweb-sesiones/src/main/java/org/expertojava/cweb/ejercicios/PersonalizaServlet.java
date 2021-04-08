package org.expertojava.cweb.ejercicios;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/PersonalizaServlet")
public class PersonalizaServlet extends HttpServlet
{
    private static final long serialVersionUID = -3223093068081588642L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String nombre = request.getParameter("nombre");
        String color = request.getParameter("color");

        Cookie c1 = new Cookie("nombre", nombre);
        Cookie c2 = new Cookie("color", color);

        response.addCookie(c1);
        response.addCookie(c2);

        response.sendRedirect("form_pers.html");
    }
}