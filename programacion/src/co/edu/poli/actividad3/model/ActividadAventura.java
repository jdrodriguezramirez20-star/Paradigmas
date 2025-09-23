package co.edu.poli.actividad3.model;

public class ActividadAventura extends ActividadTuristica {
    private int anioInicio;
    private String nivelRiesgo;

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
             + super.mostrarInformacion() + "\n"
             + "Año inicio: " + anioInicio + "\n"
             + "Nivel de riesgo: " + nivelRiesgo;
    }
}
