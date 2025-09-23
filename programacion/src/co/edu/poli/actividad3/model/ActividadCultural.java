package co.edu.poli.actividad3.model;

public class ActividadCultural extends ActividadTuristica {
    private int anioFundacion;
    private String idiomaGuia;

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
             + super.mostrarInformacion() + "\n"
             + "Año fundación: " + anioFundacion + "\n"
             + "Idioma guía: " + idiomaGuia;
    }

	public double calcularDuracion() {
		// TODO Auto-generated method stub
		return 0;
	}
}
