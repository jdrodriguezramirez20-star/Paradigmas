package co.edu.poli.actividad3.model;

/**
 * Clase que representa una calificación de una actividad turística.
 * Incluye título, puntuación, autor y comentario.
 * 
 * @author Julian David Rodriguez Ramirez 
 * @version 1.0
 */
public class Calificacion {

    private String titulo;
    private double puntuacion;
    private String autor;
    private String comentario;

    /**
     * Constructor para inicializar la calificación.
     * 
     * @param titulo título de la reseña
     * @param puntuacion valor numérico de la calificación
     * @param autor nombre del autor de la reseña
     * @param comentario comentario del autor
     */
    public Calificacion(String titulo, double puntuacion, String autor, String comentario) {
        this.titulo = titulo;
        this.puntuacion = puntuacion;
        this.autor = autor;
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Puntuación: " + puntuacion +
               ", Autor: " + autor + ", Comentario: " + comentario;
    }
}
