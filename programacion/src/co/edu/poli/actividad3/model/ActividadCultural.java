package co.edu.poli.actividad3.model;

/**
 * Subclase que representa una actividad cultural.
 * Agrega atributos como año de fundación e idioma de la guía.
 * 
 * @author Julian David Rodriguez Ramirez 
 * @version 1.0
 */
public class ActividadCultural extends ActividadTuristica {

    private int anioFundacion;
    private String idiomaGuia;

    /**
     * Constructor para inicializar una actividad cultural.
     */
    public ActividadCultural(String idActividad, String nombre, String tipo, Lugar lugar, int duracion,
                             Experiencia experiencia, Calificacion calificacion, Descripcion descripcion,
                             int anioFundacion, String idiomaGuia) {
        super(idActividad, nombre, tipo, lugar, duracion, experiencia, calificacion, descripcion);
        this.anioFundacion = anioFundacion;
        this.idiomaGuia = idiomaGuia;
    }

    @Override
    public String mostrarInformacion() {
        return "==== Actividad Cultural ====\n"
             + super.toString() + "\n"
             + "Año fundación: " + anioFundacion + "\n"
             + "Idioma guía: " + idiomaGuia;
    }
}
