package co.edu.poli.actividad3.model;

public class ActividadAventura extends ActividadTuristica {
    private static final long serialVersionUID = 1L;
    
    private String nivelRiesgo;
    
    public ActividadAventura() {
        super();
    }
    
    public ActividadAventura(String idActividadTuristica, String nombre, String tipo, 
                            Lugar lugar, int tiempo, int anioCreacion, String nivelRiesgo) {
        super(idActividadTuristica, nombre, tipo, lugar, tiempo, anioCreacion);
        this.nivelRiesgo = nivelRiesgo;
    }
    
    @Override
    public double calcularDuracion() {
        // La duración puede variar según el nivel de riesgo
        double duracionBase = getTiempo();
        
        if (nivelRiesgo != null) {
            switch (nivelRiesgo.toLowerCase()) {
                case "alto":
                    return duracionBase * 1.5;
                case "medio":
                    return duracionBase * 1.2;
                case "bajo":
                    return duracionBase;
                default:
                    return duracionBase;
            }
        }
        return duracionBase;
    }
    
    // Getters y Setters
    public String getNivelRiesgo() {
        return nivelRiesgo;
    }
    
    public void setNivelRiesgo(String nivelRiesgo) {
        this.nivelRiesgo = nivelRiesgo;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", ActividadAventura{nivelRiesgo='" + nivelRiesgo + "'}";
    }
}