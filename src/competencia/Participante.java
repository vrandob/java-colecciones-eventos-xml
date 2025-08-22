package competencia;

/*
 * @author vrand
 */
public class Participante {

  private String nombre;
  private int eventosDisputados;
  private int puntos;
  private int diferenciaResultados;
  private int resultadosAFavor;
  private int eventosGanados;

  public Participante(String nombre) {
    this.nombre = nombre;
    this.eventosDisputados = 0;
    this.puntos = 0;
    this.diferenciaResultados = 0;
    this.resultadosAFavor = 0;
    this.eventosGanados = 0;
  }

  //Getters
  public String getNombre() {
    return nombre;
  }

  public int getEventosDisputados() {
    return eventosDisputados;
  }

  public int getPuntos() {
    return puntos;
  }

  public int getDiferenciaResultados() {
    return diferenciaResultados;
  }

  public int getResultadosAFavor() {
    return resultadosAFavor;
  }

  public int getEventosGanados() {
    return eventosGanados;
  }

  //Métodos de actualización
  public void actualizarEventosDisputados() {
    this.eventosDisputados++;
  }

  public void actualizarPuntos(int puntos) {
    this.puntos += puntos;
  }

  public void actualizarDiferenciaResultados(int diferencia) {
    this.diferenciaResultados += diferencia;
  }

  public void actualizarResultadosAFavor(int resultado) {
    this.resultadosAFavor += resultado;
  }

  public void incrementarEventosGanados() {
    this.eventosGanados++;
  }

}
