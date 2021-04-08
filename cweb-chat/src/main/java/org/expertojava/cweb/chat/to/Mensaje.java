package org.expertojava.cweb.chat.to;

import java.io.Serializable;

public class Mensaje implements Serializable {
	
	private static final long serialVersionUID = 5261283062848807646L;

	private String emisor;
	private String texto;

	public Mensaje(String emisor, String texto) {
		this.emisor = emisor;
		this.texto = texto;
	}

	public String getEmisor() {
		return emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
}
