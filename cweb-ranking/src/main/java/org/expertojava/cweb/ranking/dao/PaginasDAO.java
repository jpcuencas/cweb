package org.expertojava.cweb.ranking.dao;

import java.sql.*;
import java.util.*;

import org.expertojava.cweb.ranking.to.PaginaTO;


public class PaginasDAO {

    static Map<String, PaginaTO> paginas = new HashMap<>();

	public PaginasDAO() {
	}

	public synchronized boolean estaRegistrada(String url)  {
		return paginas.containsKey(url);
	}

	public synchronized void registraPagina(String url, String titulo) {
        paginas.put(url, new PaginaTO(titulo,1));
	}

	public synchronized void incrementaAccesos(String url) {
		PaginaTO pagina = paginas.get(url);
        pagina.setAccesos(pagina.getAccesos()+1);
	}

	public synchronized Collection<PaginaTO> listaPaginas() {
		return paginas.values();
	}

}
