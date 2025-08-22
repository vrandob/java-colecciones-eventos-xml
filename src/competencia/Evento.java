package competencia;

import java.util.HashMap;
import java.util.Map;

/*
 * @author vrand
 */
public class Evento {

  private String nombre;
  private Map<String, Integer> resultados;
  
  public Evento(String nombre) {
    this.nombre = nombre;
    this.resultados = new HashMap<>();
  }
  
  public String getNombre() {
    return nombre;
  }
  
  public Map<String, Integer> getResultados() {
    return resultados;
  }
  
  public void aniadirResultado(String participante, int resultado) {
    resultados.put(participante, resultado);
  }
}
