package org.expertojava.cweb.contexto.to;

public class ValorAtributo {

	private String texto;
	private String sesion;
	
	public ValorAtributo(String texto, String sesion) {
		this.texto = texto;
		this.sesion = sesion;
	}
	
	public String getSesion() {
		return sesion;
	}

	public void setSesion(String sesion) {
		this.sesion = sesion;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String toString() {
		return "{ sesion: " + sesion + "; texto: " + texto + " }";
	}
}