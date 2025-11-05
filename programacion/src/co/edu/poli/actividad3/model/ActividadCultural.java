package co.edu.poli.actividad3.model;

public class ActividadCultural extends ActividadTuristica {
    private static final long serialVersionUID = 1L;
    
    private String idiomaGuia;
    
    public ActividadCultural() {
        super();
    }
    
    public ActividadCultural(String idActividadTuristica, String nombre, String tipo, 
                            Lugar lugar, int tiempo, int anioCreacion, String idiomaGuia) {
        super(idActividadTuristica, nombre, tipo, lugar, tiempo, anioCreacion);
        this.idiomaGuia = idiomaGuia;
    }
    
    @Override
    public double calcularDuracion() {
        // Duración base del tiempo
        return getTiempo();
    }
    
    // Getters y Setters
    public String getIdiomaGuia() {
        return idiomaGuia;
    }
    
    public void setIdiomaGuia(String idiomaGuia) {
        this.idiomaGuia = idiomaGuia;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", ActividadCultural{idiomaGuia='" + idiomaGuia + "'}";
    }
}