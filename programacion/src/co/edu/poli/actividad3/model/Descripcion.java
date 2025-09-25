package co.edu.poli.actividad3.model;

/**
 * Clase que representa la descripción de una actividad turística.
 * Contiene tipo, objetivo y recomendaciones.
 * 
 * @author Julian David Rodriguez Ramirez 
 * @version 1.0
 */
public class Descripcion {

    private String tipo;
    private String objetivo;
    private String recomendaciones;

    /**
     * Constructor para inicializar la descripción.
     * 
     * @param tipo tipo de actividad
     * @param objetivo objetivo principal
     * @param recomendaciones consejos para el participante
     */
    public Descripcion(String tipo, String objetivo, String recomendaciones) {
        this.tipo = tipo;
        this.objetivo = objetivo;
        this.recomendaciones = recomendaciones;
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + ", Objetivo: " + objetivo +
               ", Recomendaciones: " + recomendaciones;
    }
}
