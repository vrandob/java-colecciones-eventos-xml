package competencia;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @author vrand
 */
public class TablaClasificacion {

  private List<Evento> eventos;           // Lista de eventos que se disputan
  private Map<String, Participante> participantes; // para actualizar y buscar participantes eficientemente

  public TablaClasificacion(List<Evento> eventos) {
    this.eventos = eventos;
    this.participantes = new HashMap<>();
  }

  // Buscar o crear participante automátcamente
  private Participante obtenerParticipante(String nombre) {
    return participantes.computeIfAbsent(nombre, Participante::new);
  }

  //Actualizar los datos de un participante después de un evento
  private void actualizarParticipante(String nombre, int resultado, int resultadoOponente, boolean gano) {
    Participante p = obtenerParticipante(nombre);
    p.actualizarEventosDisputados();
    p.actualizarResultadosAFavor(resultado);
    p.actualizarDiferenciaResultados(resultado - resultadoOponente);
    if (gano) {
      p.incrementarEventosGanados();
    }

    if (resultado > resultadoOponente) {
      p.actualizarPuntos(3); //victoria
    } else if (resultado == resultadoOponente) {
      p.actualizarPuntos(1); //empate
    } else {
      p.actualizarPuntos(0); //derrota
    }
  }

  // Procesar todos los eventos para generar estadísticas
  public void generarClasificacion() {
    for (Evento evento : eventos) {
      Map<String, Integer> resultados = evento.getResultados();
      List<Map.Entry<String, Integer>> participantesEvento = new ArrayList<>(resultados.entrySet());

      //Comparar todos los participantes
      for (int i = 0; i < participantesEvento.size(); i++) {
        for (int j = i + 1; j < participantesEvento.size(); j++) {
          String nombre1 = participantesEvento.get(i).getKey();
          int res1 = participantesEvento.get(i).getValue();
          String nombre2 = participantesEvento.get(j).getKey();
          int res2 = participantesEvento.get(j).getValue();
          
          actualizarParticipante(nombre1, res1, res2, res1 > res2);
          actualizarParticipante(nombre2, res2, res1, res2 > res1);
        }
      }
    } //for evento
  } //method
  
  //Mostrar clasificación ordenada según los 6 criterios
  public void mostrarClasificacion() {
    List<Participante> lista = new ArrayList<>(participantes.values());
    
    lista.sort(Comparator.comparingInt(Participante::getPuntos).reversed()
    .thenComparingInt(Participante::getEventosDisputados)
    .thenComparingInt(Participante::getDiferenciaResultados).reversed()
    .thenComparingInt(Participante::getResultadosAFavor).reversed()
    .thenComparingInt(Participante::getEventosGanados)
    .thenComparing(Participante::getNombre));
    
    System.out.println("Clasificación final:  ");
    for(Participante p : lista) {
      System.out.printf("%s --> puntos: %d, diferencia: %d, a favor: %d, ganados: %d\n", p.getNombre(), p.getPuntos(), p.getDiferenciaResultados(),
        p.getDiferenciaResultados(), p.getResultadosAFavor(), p.getEventosGanados());
    }
  }
}
