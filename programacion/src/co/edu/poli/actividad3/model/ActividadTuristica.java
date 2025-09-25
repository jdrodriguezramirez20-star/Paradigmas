package co.edu.poli.actividad3.model;

/**
 * Clase abstracta que representa una actividad turística genérica.
 * Sirve como superclase para actividades específicas como culturales o de aventura.
 * 
 * Contiene atributos comunes como id, nombre, tipo, lugar, duración,
 * experiencia, calificación y descripción.
 * 
 * @author Julian David Rodriguez Ramirez 
 * @version 1.0
 */
public abstract class ActividadTuristica {

    private String idActividad;
    private String nombre;
    private String tipo;
    private Lugar lugar;
    private int duracion;
    private Experiencia experiencia;
    private Calificacion calificacion;
    private Descripcion descripcion;

    /**
     * Constructor para inicializar los atributos comunes de una actividad turística.
     * 
     * @param idActividad identificador único
     * @param nombre nombre de la actividad
     * @param tipo tipo de actividad
     * @param lugar lugar donde se desarrolla
     * @param duracion duración en minutos
     * @param experiencia experiencia asociada
     * @param calificacion calificación de usuarios
     * @param descripcion descripción de la actividad
     */
    public ActividadTuristica(String idActividad, String nombre, String tipo,
                              Lugar lugar, int duracion,
                              Experiencia experiencia, Calificacion calificacion, Descripcion descripcion) {
        this.idActividad = idActividad;
        this.nombre = nombre;
        this.tipo = tipo;
        this.lugar = lugar;
        this.duracion = duracion;
        this.experiencia = experiencia;
        this.calificacion = calificacion;
        this.descripcion = descripcion;
    }

    // Getters
    public String getIdActividad() { return idActividad; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public Lugar getLugar() { return lugar; }
    public int getDuracion() { return duracion; }
    public Experiencia getExperiencia() { return experiencia; }
    public Calificacion getCalificacion() { return calificacion; }
    public Descripcion getDescripcion() { return descripcion; }

    /**
     * Método abstracto que debe implementar cada subclase para mostrar
     * información detallada de la actividad.
     * 
     * @return cadena con la información de la actividad
     */
    public abstract String mostrarInformacion();

    @Override
    public String toString() {
        return "Actividad: " + nombre + " (" + tipo + ")\n"
             + "Lugar: " + lugar + "\n"
             + "Duración: " + duracion + " min\n"
             + "Experiencia: " + experiencia + "\n"
             + "Calificación: " + calificacion + "\n"
             + "Descripción: " + descripcion;
    }
}
