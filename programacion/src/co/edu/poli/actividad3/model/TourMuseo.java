package co.edu.poli.actividad3.model;

/**
 * Subclase que representa un tour de museo,
 * especialización de una actividad cultural.
 * 
 * Agrega el atributo de duración de la guía.
 * 
 * @author Julian David Rodriguez Ramirez 
 * @version 1.0
 */
public class TourMuseo extends ActividadCultural {

    private int duracionGuia;

    /**
     * Constructor para inicializar un tour de museo.
     */
    public TourMuseo(String idActividadTuristica, String nombre, String tipo,
                     Lugar lugar, int tiempo, Experiencia experiencia,
                     Calificacion calificacion, Descripcion descripcion,
                     int anioCreacion, String idiomaGuia, int duracionGuia) {

        super(idActividadTuristica, nombre, tipo, lugar, tiempo,
              experiencia, calificacion, descripcion, anioCreacion, idiomaGuia);

        this.duracionGuia = duracionGuia;
    }

    public int getDuracionGuia() { return duracionGuia; }
    public void setDuracionGuia(int duracionGuia) { this.duracionGuia = duracionGuia; }

    @Override
    public String mostrarInformacion() {
        return "==== Tour Museo ====\n"
             + super.mostrarInformacion() + "\n"
             + "Duración de la guía: " + duracionGuia + " min";
    }
}
