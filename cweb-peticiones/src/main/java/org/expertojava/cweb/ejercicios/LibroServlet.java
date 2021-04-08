package org.expertojava.cweb.ejercicios;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "LibroServlet", urlPatterns = "/LibroServlet")
public class LibroServlet extends HttpServlet {

    List<String> libros = new ArrayList<String>();

    @Override
    public void init() throws ServletException {
        super.init();

        InputStream is = getClass().getResourceAsStream("/libros.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String libro;
        try {
            while( (libro=br.readLine())!=null ) {
                libros.add(libro);
            }
        } catch (IOException e) { }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cadena = request.getParameter("cadena");

        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Lista de libros</title></head><body>");

        for(String libro: libros) {
            if(libro.contains(cadena)) {
                out.println("<p>" + libro + "</p>");
            }
        }

        out.println("</body></html>");
        out.flush();
        out.close();

    }
}