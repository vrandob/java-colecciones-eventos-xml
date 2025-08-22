package competencia;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.*;
import org.w3c.dom.*;

/*
Lector de eventos desde un archivo XML.
@author vrand
 */
public class LectorEventosXML {

  //private static final String input = "inputEventos.xml";

  public static List<Evento> leerEventos(String rutaArchivo) throws Exception {

    List<Evento> listaEventos = new ArrayList<>();

    File archivo = new File(rutaArchivo);
    if (!archivo.exists()) {
      throw new Exception("Archivo no encontrado " + rutaArchivo);
    }

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.parse(archivo);

    doc.getDocumentElement().normalize();

    NodeList nodosEvento = doc.getElementsByTagName("evento");

    for (int i = 0; i < nodosEvento.getLength(); i++) {
      Element elementoEvento = (Element) nodosEvento.item(i);
      String nombreEvento = elementoEvento.getAttribute("nombre");

      Evento evento = new Evento(nombreEvento);

      NodeList resultados = elementoEvento.getElementsByTagName("resultado");

      for (int j = 0; j < resultados.getLength(); j++) {
        Element elemResultado = (Element) resultados.item(j);
        String participante = elemResultado.getAttribute("participante");
        int valor = Integer.parseInt(elemResultado.getTextContent().trim());
        evento.aniadirResultado(participante, valor);
      }

      listaEventos.add(evento);
    }

    return listaEventos;
  }
}
