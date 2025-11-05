package co.edu.poli.actividad3.model;

public class TourMuseo extends ActividadTuristica {
    private static final long serialVersionUID = 1L;
    
    private int duracionGuia;
    private String idioma;
    
    public TourMuseo() {
        super();
    }
    
    public TourMuseo(String idActividadTuristica, String nombre, String tipo, 
                     Lugar lugar, int tiempo, int anioCreacion, int duracionGuia, String idioma) {
        super(idActividadTuristica, nombre, tipo, lugar, tiempo, anioCreacion);
        this.duracionGuia = duracionGuia;
        this.idioma = idioma;
    }
    
    @Override
    public double calcularDuracion() {
        // Duración es la suma del tiempo base más la duración del guía
        return getTiempo() + duracionGuia;
    }
    
    // Getters y Setters
    public int getDuracionGuia() {
        return duracionGuia;
    }
    
    public void setDuracionGuia(int duracionGuia) {
        this.duracionGuia = duracionGuia;
    }
    
    public String getIdioma() {
        return idioma;
    }
    
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", TourMuseo{duracionGuia=" + duracionGuia + ", idioma='" + idioma + "'}";
    }
}