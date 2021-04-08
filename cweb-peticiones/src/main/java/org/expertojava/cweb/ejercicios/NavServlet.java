package org.expertojava.cweb.ejercicios;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="NavServlet", urlPatterns = "/NavServlet")
public class NavServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nav = request.getHeader("User-Agent");
        // Cambiar "Firefox" por el texto que sea

        String img = null;
        if (nav.indexOf("Firefox") != -1) {
            img = "firefox_logo.png";
        } else if (nav.indexOf("Chrome") != -1) {
            img = "chrome_logo.png";
        } else if (nav.indexOf("Safari") != -1) {
            img = "safari_logo.jpg";
        } else if (nav.indexOf("Mozilla") != -1) {
            img = "mozilla_logo.png";
        } else if (nav.indexOf("Explorer") != -1) {
            img = "explorer_logo.jpg";
        }

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Navegador</title></head><body><img src=\"logos/" + img + "\"/></body></html>");
        out.flush();
        out.close();
    }
}