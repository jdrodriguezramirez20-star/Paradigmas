package co.edu.poli.actividad3.model;

public class ActividadTuristica {
    private String idActividad;
    private String nombre;
    private String tipo;
    private Lugar lugar;
    private int duracion;
    private Experiencia experiencia;
    private Calificacion calificacion;
    private Descripcion descripcion;

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

  
    public String getIdActividad() { return idActividad; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public Lugar getLugar() { return lugar; }
    public int getDuracion() { return duracion; }
    public Experiencia getExperiencia() { return experiencia; }
    public Calificacion getCalificacion() { return calificacion; }
    public Descripcion getDescripcion() { return descripcion; }

   
    public String mostrarInformacion() {
        return "Actividad: " + getNombre() + " (" + getTipo() + ")\n"
             + "Lugar: " + getLugar() + "\n"
             + "Duración: " + getDuracion() + " min\n"
             + "Experiencia: " + getExperiencia() + "\n"
             + "Calificación: " + getCalificacion() + "\n"
             + "Descripción: " + getDescripcion();
    }

    
    public String mostrarInformacion(boolean detalle) {
        if (detalle) {
            return mostrarInformacion() + "\n(Detalle activado)";
        } else {
            return "Actividad: " + getNombre() + " (" + getTipo() + ")";
        }
    }

    
    public String mostrarInformacion(String etiqueta) {
        return "=== " + etiqueta + " ===\n" + mostrarInformacion();
    }
}
