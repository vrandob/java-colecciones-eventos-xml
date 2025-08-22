package competencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author vrand
 */
public class Main {

  public static void main(String[] args) {

    // Crear eventos con resultados
    Evento jornada1 = new Evento("Jornada 1");
    jornada1.aniadirResultado("Ana", 3);
    jornada1.aniadirResultado("Luis", 1);
    jornada1.aniadirResultado("Clara", 2);

    Evento jornada2 = new Evento("Jornada 2");
    jornada2.aniadirResultado("Ana", 0);
    jornada2.aniadirResultado("Luis", 2);
    jornada2.aniadirResultado("Clara", 2);

    // Crear la tabla de clasificación con los eventos
    List<Evento> listaEventos = new ArrayList<>();
    listaEventos.add(jornada1);
    listaEventos.add(jornada2);

    TablaClasificacion tabla = new TablaClasificacion(listaEventos);

    // Procesar la clasificación
    tabla.generarClasificacion();

    // Mostrar resultados finales
    tabla.mostrarClasificacion();

    //Lectura del archivo xml
    List<Evento> eventosReader = new ArrayList<>();
    
    try {
      eventosReader = LectorEventosXML.leerEventos("xml/inputEventos.xml");
      System.out.println("Se ha cargado el archivo xml.");
    } catch (Exception ex) {
      System.out.println("No se ha podido acceder al archivo " + ex.getMessage());
    }

    for (Evento e : eventosReader) {
      System.out.println("Evento: " + e.getNombre());
      for (Map.Entry<String, Integer> resultado : e.getResultados().entrySet()) {
        System.out.println("Participante: " + resultado.getKey()+ " --> " + resultado.getValue());
      }
    }
    
    //Escritura en XML
    List<Evento> eventos = new ArrayList<>();

    Evento jornada5 = new Evento("Jornada 5");
    jornada5.aniadirResultado("Jorge", 1);
    jornada5.aniadirResultado("Marta", 1);
    eventos.add(jornada5);

    try {
      EscritorEventosXML.escribirEventos("xml/eventosGuardados.xml", eventos);
      System.out.println("Archivo guardado correctamente.");
    } catch (Exception ex) {
      System.out.println("Error al escribir el archivo: " + ex.getMessage());
    }

  }
}
