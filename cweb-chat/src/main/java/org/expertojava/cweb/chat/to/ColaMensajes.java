package org.expertojava.cweb.chat.to;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.*;
import java.io.Serializable;

@ApplicationScoped
@Named("cola")
public class ColaMensajes implements Serializable {

	private static final long serialVersionUID = -2681008235066722777L;

	public final static int DEFAULT_SIZE = 20;

	int max_size;

	LinkedList<Mensaje> lista;

	public ColaMensajes() {
		max_size = DEFAULT_SIZE;
		lista = new LinkedList<>();
	}

	public synchronized void addMessage(Mensaje msg) {
		lista.addLast(msg);
		if(lista.size() > max_size) {
			lista.removeFirst();
		}
	}

	public List<Mensaje> getList() {
		return lista;
	}
}
