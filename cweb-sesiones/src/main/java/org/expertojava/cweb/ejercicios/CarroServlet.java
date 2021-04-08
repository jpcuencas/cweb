package org.expertojava.cweb.ejercicios;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CarroServlet")
public class CarroServlet extends HttpServlet
{
    private static final long serialVersionUID = 8096674173922793965L;

    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        if(req.getParameter("invalidar")!=null) {
            HttpSession sesion = req.getSession();
            sesion.invalidate();

            PrintWriter out = resp.getWriter();
            out.println("<html><body><h2>Sesion invalidada</h2>");
            out.println("<a href='form_carro.html'>Seguir comprando</a></body></html>");
            out.flush();
            out.close();
            return;
        }

        String articulo = req.getParameter("articulo");
        int precio = Integer.parseInt(req.getParameter("precio"));

        HttpSession sesion = req.getSession();

        List<ObjetoCarro> lista = (List<ObjetoCarro>)sesion.getAttribute("lista");;
        if(lista==null) {
            lista = new ArrayList<ObjetoCarro>();
            sesion.setAttribute("lista", lista);
        }

        lista.add(new ObjetoCarro(articulo, precio));

        PrintWriter out = resp.getWriter();
        out.println("<html><body><table>");
        out.println("<tr><th>Articulo</th><th>Precio</th></tr>");
        int total = 0;

        for(ObjetoCarro oc: lista) {
            out.println("<tr><td>" + oc.getArticulo() + "</td><td>" + oc.getPrecio() + "</td></tr>");
            total += oc.getPrecio();
        }

        out.println("</table><p><strong>Total: " + total + "</strong></p>");
        out.println("<a href='CarroServlet?invalidar=1'>Cerrar sesion</a><br/>");
        out.println("<a href='form_carro.html'>Seguir comprando</a></body></html>");
        out.flush();
        out.close();
    }
}

class ObjetoCarro {
    String articulo;
    int precio;

    public ObjetoCarro(String articulo, int precio) {
        this.articulo = articulo;
        this.precio = precio;
    }

    public String getArticulo() {
        return articulo;
    }

    public int getPrecio() {
        return precio;
    }
}