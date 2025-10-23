package co.edu.poli.actividad3.model;

import java.io.Serializable;

/**
 * Clase que representa la calificación de una actividad.
 * Guarda la puntuación de 1 a 10.
 * 
 * @author Julian David Rodriguez Ramirez 
 * @version 1.2
 */
public class Calificacion implements Serializable {

    private static final long serialVersionUID = 1L;

    private double puntuacion;

    public Calificacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return String.valueOf(puntuacion);
    }
}
