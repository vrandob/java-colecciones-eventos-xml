# Ejercicio: Clasificación de Participantes por Eventos

## Descripción

Este ejercicio consiste en desarrollar una aplicación en Java que simula una competición entre varios participantes a lo largo de varios eventos (jornadas). El objetivo es generar una tabla de clasificación final aplicando varios criterios de desempate.

## Estructura del proyecto

El proyecto se compone de las siguientes clases principales:

- `Evento`: representa un evento individual y almacena los resultados de los participantes.
- `Participante`: almacena las estadísticas acumuladas de cada participante.
- `TablaClasificacion`: gestiona los eventos, actualiza las estadísticas de cada participante y genera la clasificación final.
- `LectorEventosXML`: permite leer los eventos desde un archivo XML.
- `EscritorEventosXML`: permite guardar los eventos en un archivo XML.
- `Main`: clase principal que ejecuta la simulación.

## Clasificación

Cada participante se clasifica según los siguientes **criterios, en orden de prioridad**:

1. Mayor número de puntos.
2. Mayor número de eventos disputados.
3. Mayor diferencia de resultados.
4. Mayor número de resultados a favor.
5. Mayor número de eventos ganados.
6. Orden alfabético del nombre.

## Entrada

Los eventos y resultados pueden leerse desde un archivo XML con estructura como esta:

```xml
<eventos>
  <evento nombre="Jornada 1">
    <resultado participante="Ana">3</resultado>
    <resultado participante="Luis">1</resultado>
  </evento>
  <evento nombre="Jornada 2">
    <resultado participante="Clara">2</resultado>
    <resultado participante="Luis">2</resultado>
  </evento>
</eventos>
```

## Salida

La salida del programa es una tabla con la clasificación final de los participantes, ordenados según los criterios anteriores, por ejemplo:

```
--- Clasificación Final ---
Clara → puntos: 4, eventos: 2, diferencia: 2, a favor: 4, ganados: 1
Ana   → puntos: 3, eventos: 2, diferencia: 1, a favor: 3, ganados: 1
Luis  → puntos: 1, eventos: 2, diferencia: -3, a favor: 2, ganados: 0
```
