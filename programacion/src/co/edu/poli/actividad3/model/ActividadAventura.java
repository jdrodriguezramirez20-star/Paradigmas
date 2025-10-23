package co.edu.poli.actividad3.model;

import java.io.Serializable;

public class ActividadAventura extends ActividadTuristica implements Serializable {

    private static final long serialVersionUID = 1L;

    private int anioInicio;
    private String usuario;

    // Constructor vacío
    public ActividadAventura() {
        // Necesario para deserialización
    }

    // Constructor con parámetros
    public ActividadAventura(String idActividad, String nombre, String tipo, 
                             Lugar lugar, int duracion, Experiencia experiencia, 
                             Calificacion calificacion, Descripcion descripcion,
                             int anioInicio, String usuario) {
        super(idActividad, nombre, tipo, lugar, duracion, experiencia, calificacion, descripcion);
        this.anioInicio = anioInicio;
        this.usuario = usuario;
    }

    // Getters y setters
    public int getAnioInicio() {
        return anioInicio;
    }

    public void setAnioInicio(int anioInicio) {
        this.anioInicio = anioInicio;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    // Método toString sobrescrito
    @Override
    public String toString() {
        return super.toString() + 
               "\nAño inicio: " + anioInicio +
               "\nUsuario: " + usuario;
    }

	@Override
	public String mostrarInformacion() {
		// TODO Auto-generated method stub
		return null;
	}
}
