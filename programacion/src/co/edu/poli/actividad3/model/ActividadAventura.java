package co.edu.poli.actividad3.model;

/**
 * Subclase que representa una actividad de aventura.
 * Agrega atributos como año de inicio y nivel de riesgo.
 * 
 * @author Julian David Rodriguez Ramirez 
 * @version 1.0
 */
public class ActividadAventura extends ActividadTuristica {

    private int anioInicio;
    private String nivelRiesgo;

    /**
     * Constructor para inicializar una actividad de aventura.
     */
    public ActividadAventura(String idActividad, String nombre, String tipo, Lugar lugar, int duracion,
                             Experiencia experiencia, Calificacion calificacion, Descripcion descripcion,
                             int anioInicio, String nivelRiesgo) {
        super(idActividad, nombre, tipo, lugar, duracion, experiencia, calificacion, descripcion);
        this.anioInicio = anioInicio;
        this.nivelRiesgo = nivelRiesgo;
    }

    @Override
    public String mostrarInformacion() {
        return "==== Actividad Aventura ====\n"
             + super.toString() + "\n"
             + "Año inicio: " + anioInicio + "\n"
             + "Nivel de riesgo: " + nivelRiesgo;
    }
}
