package com.jacaranda.caseta;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CasetaManager {

	private Set<Caseta> casetas = new HashSet<>();

	public CasetaManager() {// cargar fichero xml

		try {

			File archivo = new File("folderFeria//casetasferia.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(archivo);

			// normalizar el doc
			doc.getDocumentElement().normalize();

			// cargar doc en casetas
			NodeList listaCasetas = doc.getElementsByTagName("DatosLeidos");// se añade todas las casetas

			for (int i = 0; i < listaCasetas.getLength(); i = i + 1) {
				Node elemento = listaCasetas.item(i); // obtengo cada caseta
				Caseta caseta = new Caseta();
				NodeList listaTags = elemento.getChildNodes();// obtengo la lista de etiquetas de cada caseta
				for (int j = 0; j < listaTags.getLength(); j = j + 1) {
					Node tag = listaTags.item(j);// obtengo la etiqueta
					if (tag.getNodeType() == Node.ELEMENT_NODE) {

						Element element = (Element) tag;
						if (element.getTagName().equalsIgnoreCase("TITULO")) {
							caseta.setTitulo(element.getTextContent());
						} else if (element.getTagName().equalsIgnoreCase("CALLE")) {
							caseta.setCalle(element.getTextContent());
						} else if (element.getTagName().equalsIgnoreCase("NUMERO")) {
							caseta.setNumero(Integer.parseInt(element.getTextContent()));
						} else if (element.getTagName().equalsIgnoreCase("MODULOS")) {
							caseta.setModulo(Integer.parseInt(element.getTextContent()));
						} else if (element.getTagName().equalsIgnoreCase("CLASE")) {
							caseta.setClase(element.getTextContent());
						} else if (element.getTagName().equalsIgnoreCase("ID")) {
							caseta.setId(Integer.parseInt(element.getTextContent()));
						} else if (element.getTagName().equalsIgnoreCase("ID_CALLE")) {
							caseta.setIdCalle(Integer.parseInt(element.getTextContent()));
						} else if (element.getTagName().equalsIgnoreCase("ENTIDAD")) {
							caseta.setEntidad(element.getTextContent());
						}

					}

				}
				casetas.add(caseta);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// Mostrar todas las casetas existentes en una calle.

	public Set<Caseta> mostrarCasetasPorCalle(String calle) {
		Set<Caseta> result = new HashSet<>();

		Iterator<Caseta> iterador = casetas.iterator();
		Caseta iCaseta;

		while (iterador.hasNext()) {
			iCaseta = iterador.next();

			if (iCaseta.getCalle().equalsIgnoreCase(calle)) {
				result.add(iCaseta);
			}
		}
		return result;
	}

	public Set<Caseta> mostrarCasetasDistrito() {
		return mostrarCasetasPorTipo("DISTRITO");
	}

	public Set<Caseta> mostrarCasetasFamiliar() {
		return mostrarCasetasPorTipo("FAMILIAR");
	}

	// Mostrar todas las casetas por tipo.

	private Set<Caseta> mostrarCasetasPorTipo(String tipo) {
		Set<Caseta> result = new HashSet<>();

		Iterator<Caseta> iterador = casetas.iterator();
		Caseta iCaseta;

		while (iterador.hasNext()) {
			iCaseta = iterador.next();

			if (iCaseta.getClase().equalsIgnoreCase(tipo)) {
				result.add(iCaseta);
			}
		}
		return result;
	}

	// Mostrar todas las casetas que no sean ni familiares ni distritos.
	public Set<Caseta> mostrarCasetasOtras() {
		Set<Caseta> result = new HashSet<>();

		Iterator<Caseta> iterador = casetas.iterator();
		Caseta iCaseta;

		while (iterador.hasNext()) {
			iCaseta = iterador.next();

			if (!iCaseta.getClase().equalsIgnoreCase("FAMILIAR") && !iCaseta.getClase().equalsIgnoreCase("DISTRITO")) {
				result.add(iCaseta);
			}
		}
		return result;
	}

	// Mostrar para cada una de las calles del recinto ferial el número de casetas
	// de tipo familiar que existen.

	public Map<String, Integer> mostrarCallesFamiliar() {
		return mostrarCallesTipo("FAMILIAR");
	}

	public Map<String, Integer> mostrarCallesDistrito() {
		return mostrarCallesTipo("DISTRITO");
	}

	private Map<String, Integer> mostrarCallesTipo(String tipo) {
		Map<String, Integer> result = new HashMap<>();

		Iterator<Caseta> iterador = casetas.iterator();
		Caseta iCaseta;

		while (iterador.hasNext()) {
			iCaseta = iterador.next();

			if (result.containsKey(iCaseta.getCalle())) {
				if (iCaseta.getClase().equalsIgnoreCase(tipo)) {
					Integer valor = result.get(iCaseta.getCalle());
					result.put(iCaseta.getCalle(), valor + 1);
				}
			} else {
				if (iCaseta.getClase().equalsIgnoreCase(tipo)) {
					result.put(iCaseta.getCalle(), 1);
				} else {
					result.put(iCaseta.getCalle(), 0);
				}
			}

		}

		return result;
	}

	public boolean eliminarCaseta(String titulo) {
		boolean result = false;

		Iterator<Caseta> iterador = casetas.iterator();
		Caseta iCaseta;

		while (iterador.hasNext() && !result) {
			iCaseta = iterador.next();

			if (iCaseta.getTitulo().equalsIgnoreCase(titulo)) {
				iterador.remove();
				result = true;
			}
		}

		return result;
	}

}
