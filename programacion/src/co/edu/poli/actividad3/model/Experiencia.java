package co.edu.poli.actividad3.model;

import java.io.Serializable;

public class Experiencia implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String idExperiencia;
    private String tipo;
    private int duracion;
    private String requisito;
    private String dificultad;
    
    public Experiencia() {
    }
    
    public Experiencia(String idExperiencia, String tipo, int duracion, String requisito, String dificultad) {
        this.idExperiencia = idExperiencia;
        this.tipo = tipo;
        this.duracion = duracion;
        this.requisito = requisito;
        this.dificultad = dificultad;
    }
    
    // Getters y Setters
    public String getIdExperiencia() {
        return idExperiencia;
    }
    
    public void setIdExperiencia(String idExperiencia) {
        this.idExperiencia = idExperiencia;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public int getDuracion() {
        return duracion;
    }
    
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    public String getRequisito() {
        return requisito;
    }
    
    public void setRequisito(String requisito) {
        this.requisito = requisito;
    }
    
    public String getDificultad() {
        return dificultad;
    }
    
    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }
    
    @Override
    public String toString() {
        return "Experiencia{" +
                "idExperiencia='" + idExperiencia + '\'' +
                ", tipo='" + tipo + '\'' +
                ", duracion=" + duracion +
                ", requisito='" + requisito + '\'' +
                ", dificultad='" + dificultad + '\'' +
                '}';
    }
}