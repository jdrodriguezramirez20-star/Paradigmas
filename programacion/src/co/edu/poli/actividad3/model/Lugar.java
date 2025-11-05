package co.edu.poli.actividad3.model;

import java.io.Serializable;

public class Lugar implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String idLugar;
    private String nombre;
    private String direccion;
    private double coordenada;
    private String pais;
    private String clima;
    
    public Lugar() {
    }
    
    public Lugar(String idLugar, String nombre, String direccion, double coordenada, String pais, String clima) {
        this.idLugar = idLugar;
        this.nombre = nombre;
        this.direccion = direccion;
        this.coordenada = coordenada;
        this.pais = pais;
        this.clima = clima;
    }
    
    // Getters y Setters
    public String getIdLugar() {
        return idLugar;
    }
    
    public void setIdLugar(String idLugar) {
        this.idLugar = idLugar;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public double getCoordenada() {
        return coordenada;
    }
    
    public void setCoordenada(double coordenada) {
        this.coordenada = coordenada;
    }
    
    public String getPais() {
        return pais;
    }
    
    public void setPais(String pais) {
        this.pais = pais;
    }
    
    public String getClima() {
        return clima;
    }
    
    public void setClima(String clima) {
        this.clima = clima;
    }
    
    @Override
    public String toString() {
        return "Lugar{" +
                "idLugar='" + idLugar + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", coordenada=" + coordenada +
                ", pais='" + pais + '\'' +
                ", clima='" + clima + '\'' +
                '}';
    }
}