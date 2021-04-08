package org.expertojava.cweb.wrapper.parse;

import java.io.*;
import java.util.*;
import com.kizna.html.*;
import com.kizna.html.tags.*;

public class AnalisisHTML {

	String titulo;

	public AnalisisHTML() {
	}

	public void parse(char[] contenido) {

		// Analiza contenido de la URL

		BufferedReader in = new BufferedReader(new CharArrayReader(contenido));
		HTMLReader hr = new HTMLReader(in, contenido.length);

		HTMLParser parser = new HTMLParser(hr);

		parser.registerScanners();

		// Examina cada token leido de la pagina

		for (Enumeration e = parser.elements(); e.hasMoreElements();) {
			HTMLNode node = (HTMLNode) e.nextElement();

			// Extraccion del titulo de la pagina

			if (node instanceof HTMLTitleTag) {
				HTMLTitleTag titleNode = (HTMLTitleTag) node;
				titulo = titleNode.getTitle();
			}
		}
	}

	public String getTitulo() {
		return titulo;
	}
}
