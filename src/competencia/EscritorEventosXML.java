package competencia;

import java.io.File;
import java.util.List;
import java.util.Map;
import javax.management.StringValueExp;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

/*
 * @author vrand
 */
public class EscritorEventosXML {

  public static void escribirEventos(String rutaSalida, List<Evento> eventos) throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    
    //Crear documento XML
    Document doc = builder.newDocument();
    Element raiz = doc.createElement("eventos");
    doc.appendChild(raiz);
    
    for (Evento evento : eventos) {
      Element nodoEvento = doc.createElement("evento");
      nodoEvento.setAttribute("nombre", evento.getNombre());
      
      for(Map.Entry<String, Integer> entry : evento.getResultados().entrySet()) {
        Element resultado = doc.createElement("resultado");
        resultado.setAttribute("participante", entry.getKey());
        resultado.setTextContent(String.valueOf(entry.getValue()));
        nodoEvento.appendChild(resultado);
      }
      
      raiz.appendChild(nodoEvento);
    }
    
    //Escribir archivo a XML
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    DOMSource source = new DOMSource(doc);
    StreamResult result = new StreamResult(new File(rutaSalida));
    transformer.transform(source, result);
    
    //Para usarlo en el main:
    /*
    List<Evento> eventos = new ArrayList<>();

    Evento jornada1 = new Evento("Jornada 1");
    jornada1.añadirResultado("Ana", 3);
    jornada1.añadirResultado("Luis", 1);
    eventos.add(jornada1);

    EscritorEventosXML.escribirEventos("eventosGuardados.xml", eventos);

    */
  } //method 
} //class