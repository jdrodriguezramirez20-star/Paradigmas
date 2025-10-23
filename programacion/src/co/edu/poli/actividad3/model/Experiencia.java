package co.edu.poli.actividad3.model;

import java.io.Serializable;

/**
 * Clase que representa la experiencia de una actividad turística.
 * Incluye nombre, duración (usada como puntuación 1–10) y dificultad.
 * 
 * @author Julian David Rodriguez Ramirez 
 * @version 1.2
 */
public class Experiencia implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;
    private int duracion;
    private String dificultad;

    public Experiencia(String nombre, int duracion, String dificultad) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.dificultad = dificultad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getDificultad() {
        return dificultad;
    }

    @Override
    public String toString() {
        return nombre + " - " + duracion + " min (" + dificultad + ")";
    }
}
