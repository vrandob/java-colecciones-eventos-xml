package competencia;

import java.util.ArrayList;
import java.util.List;

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
  }
}
