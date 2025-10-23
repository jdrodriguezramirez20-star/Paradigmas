package co.edu.poli.actividad3.model;

import java.io.Serializable;

/**
 * Clase que representa la descripción de una actividad turística.
 * Contiene tipo, objetivo y recomendaciones.
 * 
 * @author Julian David Rodriguez Ramirez 
 * @version 1.1
 */
public class Descripcion implements Serializable {

    private static final long serialVersionUID = 1L;

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
