package co.edu.poli.actividad3.model;

import java.io.Serializable;

public class Calificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String idCalificacion;
    private String nombre;
    private String autor;
    private String comentario;
    private double puntuacion;
    private int fecha;
    
    public Calificacion() {
    }
    
    public Calificacion(String idCalificacion, String nombre, String autor, String comentario, double puntuacion, int fecha) {
        this.idCalificacion = idCalificacion;
        this.nombre = nombre;
        this.autor = autor;
        this.comentario = comentario;
        this.puntuacion = puntuacion;
        this.fecha = fecha;
    }
    
    // Getters y Setters
    public String getIdCalificacion() {
        return idCalificacion;
    }
    
    public void setIdCalificacion(String idCalificacion) {
        this.idCalificacion = idCalificacion;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public String getComentario() {
        return comentario;
    }
    
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    public double getPuntuacion() {
        return puntuacion;
    }
    
    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    public int getFecha() {
        return fecha;
    }
    
    public void setFecha(int fecha) {
        this.fecha = fecha;
    }
    
    @Override
    public String toString() {
        return "Calificacion{" +
                "idCalificacion='" + idCalificacion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", autor='" + autor + '\'' +
                ", comentario='" + comentario + '\'' +
                ", puntuacion=" + puntuacion +
                ", fecha=" + fecha +
                '}';
    }
}