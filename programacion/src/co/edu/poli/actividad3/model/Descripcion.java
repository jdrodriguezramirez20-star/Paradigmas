package co.edu.poli.actividad3.model;

import java.io.Serializable;

public class Descripcion implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String idDescripcion;
    private String resumen;
    private String objetivo;
    private String beneficio;
    private String recomendacion;
    
    public Descripcion() {
    }
    
    public Descripcion(String idDescripcion, String resumen, String objetivo, String beneficio, String recomendacion) {
        this.idDescripcion = idDescripcion;
        this.resumen = resumen;
        this.objetivo = objetivo;
        this.beneficio = beneficio;
        this.recomendacion = recomendacion;
    }
    
    // Getters y Setters
    public String getIdDescripcion() {
        return idDescripcion;
    }
    
    public void setIdDescripcion(String idDescripcion) {
        this.idDescripcion = idDescripcion;
    }
    
    public String getResumen() {
        return resumen;
    }
    
    public void setResumen(String resumen) {
        this.resumen = resumen;
    }
    
    public String getObjetivo() {
        return objetivo;
    }
    
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
    
    public String getBeneficio() {
        return beneficio;
    }
    
    public void setBeneficio(String beneficio) {
        this.beneficio = beneficio;
    }
    
    public String getRecomendacion() {
        return recomendacion;
    }
    
    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }
    
    @Override
    public String toString() {
        return "Descripcion{" +
                "idDescripcion='" + idDescripcion + '\'' +
                ", resumen='" + resumen + '\'' +
                ", objetivo='" + objetivo + '\'' +
                ", beneficio='" + beneficio + '\'' +
                ", recomendacion='" + recomendacion + '\'' +
                '}';
    }
}