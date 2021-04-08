package org.expertojava.cweb.ranking.to;

import java.io.Serializable;

public class PaginaTO implements Serializable {

	private static final long serialVersionUID = 9103019769767558721L;

	private String titulo;
	private int accesos;

	public PaginaTO(String titulo, int accesos) {
		this.titulo = titulo;
		this.accesos = accesos;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAccesos() {
		return accesos;
	}

	public void setAccesos(int accesos) {
		this.accesos = accesos;
	}
	
	
}
