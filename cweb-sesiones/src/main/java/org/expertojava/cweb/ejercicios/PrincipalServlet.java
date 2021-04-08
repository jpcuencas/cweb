package org.expertojava.cweb.ejercicios;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/PrincipalServlet")
public class PrincipalServlet extends HttpServlet
{
    private static final long serialVersionUID = 1250835839215094177L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Cookie[] cookies = request.getCookies();
        String nombre = null, color = null;

        for (int i = 0; i < cookies.length; i++)
        {
            Cookie c = cookies[i];
            if (c.getName().equals("nombre"))
                nombre = c.getValue();
            if (c.getName().equals("color"))
                color = c.getValue();
        }

        PrintWriter out = response.getWriter();
        out.println("<html>");
        if (color != null)
            out.println("<body bgcolor=\"" + color + "\">");
        else
            out.println("<body>");
        if (nombre != null)
            out.println ("Hola, " + nombre);
        else
            out.println("Hola, no has introducido tu nombre");
    }
}