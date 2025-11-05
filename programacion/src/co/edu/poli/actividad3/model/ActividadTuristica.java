package co.edu.poli.actividad3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class ActividadTuristica implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String idActividadTuristica;
    private String nombre;
    private String tipo;
    private Lugar lugar;
    private int tiempo;
    private Experiencia experiencia;
    private Calificacion calificacion;
    private Descripcion descripcion;
    private int anioCreacion;
    
    // Listas para manejar múltiples calificaciones y experiencias
    private List<Calificacion> calificaciones;
    private List<Experiencia> experiencias;
    
    public ActividadTuristica() {
        this.calificaciones = new ArrayList<>();
        this.experiencias = new ArrayList<>();
    }
    
    public ActividadTuristica(String idActividadTuristica, String nombre, String tipo, Lugar lugar, 
                             int tiempo, int anioCreacion) {
        this.idActividadTuristica = idActividadTuristica;
        this.nombre = nombre;
        this.tipo = tipo;
        this.lugar = lugar;
        this.tiempo = tiempo;
        this.anioCreacion = anioCreacion;
        this.calificaciones = new ArrayList<>();
        this.experiencias = new ArrayList<>();
    }
    
    // Métodos abstractos
    public abstract double calcularDuracion();
    
    // Sobrecarga del método calcularDuracion
    public double calcularDuracion(int factor) {
        return calcularDuracion() * factor;
    }
    
    // Método para mostrar información
    public String mostrarInformacion() {
        return "ActividadTuristica{" +
                "id='" + idActividadTuristica + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", tiempo=" + tiempo +
                ", anioCreacion=" + anioCreacion +
                ", lugar=" + (lugar != null ? lugar.getNombre() : "N/A") +
                '}';
    }
    
    // Método para agregar calificación
    public void addCalificacion(Calificacion c) {
        if (c != null) {
            this.calificaciones.add(c);
            this.calificacion = c; // Mantener referencia a la última
        }
    }
    
    // Método para remover calificación por id
    public boolean removeCalificacion(String id) {
        return calificaciones.removeIf(c -> c.getIdCalificacion().equals(id));
    }
    
    // Método para agregar experiencia
    public void addExperiencia(Experiencia e) {
        if (e != null) {
            this.experiencias.add(e);
            this.experiencia = e; // Mantener referencia a la última
        }
    }
    
    @Override
    public String toString() {
        return "ActividadTuristica{" +
                "id='" + idActividadTuristica + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", tiempo=" + tiempo +
                ", anioCreacion=" + anioCreacion +
                '}';
    }
    
    // Getters y Setters
    public String getIdActividadTuristica() {
        return idActividadTuristica;
    }
    
    public void setIdActividadTuristica(String idActividadTuristica) {
        this.idActividadTuristica = idActividadTuristica;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public Lugar getLugar() {
        return lugar;
    }
    
    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }
    
    public int getTiempo() {
        return tiempo;
    }
    
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
    public Experiencia getExperiencia() {
        return experiencia;
    }
    
    public void setExperiencia(Experiencia experiencia) {
        this.experiencia = experiencia;
    }
    
    public Calificacion getCalificacion() {
        return calificacion;
    }
    
    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }
    
    public Descripcion getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(Descripcion descripcion) {
        this.descripcion = descripcion;
    }
    
    public int getAnioCreacion() {
        return anioCreacion;
    }
    
    public void setAnioCreacion(int anioCreacion) {
        this.anioCreacion = anioCreacion;
    }
    
    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }
    
    public void setCalificaciones(List<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }
    
    public List<Experiencia> getExperiencias() {
        return experiencias;
    }
    
    public void setExperiencias(List<Experiencia> experiencias) {
        this.experiencias = experiencias;
    }
}