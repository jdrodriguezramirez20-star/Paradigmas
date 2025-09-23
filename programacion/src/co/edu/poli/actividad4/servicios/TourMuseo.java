package co.edu.poli.actividad4.servicios;

import co.edu.poli.actividad3.model.*;  

public class TourMuseo extends ActividadCultural {

    private int duracionGuia;

    // Constructor
    public TourMuseo(String idActividadTuristica, String nombre, String tipo,
                     Lugar lugar, int tiempo, Experiencia experiencia,
                     Calificacion calificacion, Descripcion descripcion,
                     int anioCreacion, String idiomaGuia, int duracionGuia) {
        
       
        super(idActividadTuristica, nombre, tipo, lugar, tiempo, experiencia, calificacion, descripcion, anioCreacion, idiomaGuia);
        
        this.duracionGuia = duracionGuia;
    }

    
    public int getDuracionGuia() {
        return duracionGuia;
    }

    public void setDuracionGuia(int duracionGuia) {
        this.duracionGuia = duracionGuia;
    }

   
    @Override
    public double calcularDuracion() {
        return duracionGuia;
    }
}
