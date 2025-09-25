package co.edu.poli.actividad3.model;

/**
 * Clase que representa la experiencia de una actividad turística.
 * Incluye nombre, duración y nivel de dificultad.
 * 
 * @author Julian David Rodriguez Ramirez 
 * @version 1.0
 */
public class Experiencia {

    private String nombre;
    private int duracion;
    private String dificultad;

    /**
     * Constructor para inicializar la experiencia.
     * 
     * @param nombre nombre de la experiencia
     * @param duracion duración en minutos
     * @param dificultad nivel de dificultad
     */
    public Experiencia(String nombre, int duracion, String dificultad) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.dificultad = dificultad;
    }

    @Override
    public String toString() {
        return nombre + " - " + duracion + " min (" + dificultad + ")";
    }
}
