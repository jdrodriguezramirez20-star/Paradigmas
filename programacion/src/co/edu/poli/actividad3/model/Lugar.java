package co.edu.poli.actividad3.model;

/**
 * Representa un lugar asociado a una actividad turística.
 * Contiene información como el nombre del lugar, país y clima.
 * 
 * La clase es {@code final}, por lo que no puede ser heredada.
 * 
 * @author Julian David Rodriguez Ramirez 
 * @version 1.0
 */
public final class Lugar {

    /**
     * Nombre del lugar. Es un atributo inmutable.
     */
    private final String nombre;

    /**
     * País en el que se encuentra el lugar.
     */
    private String pais;

    /**
     * Clima característico del lugar.
     */
    private String clima;

    /**
     * Constructor de la clase Lugar.
     * 
     * @param nombre nombre del lugar
     * @param pais país donde se encuentra el lugar
     * @param clima clima del lugar
     */
    public Lugar(String nombre, String pais, String clima) {
        this.nombre = nombre; 
        this.pais = pais;
        this.clima = clima;
    }

    /**
     * Obtiene el nombre del lugar.
     * 
     * @return nombre del lugar
     */
    public final String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el país del lugar.
     * 
     * @return país del lugar
     */
    public String getPais() {
        return pais;
    }

    /**
     * Modifica el país del lugar.
     * 
     * @param pais nuevo país del lugar
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Obtiene el clima del lugar.
     * 
     * @return clima del lugar
     */
    public String getClima() {
        return clima;
    }

    /**
     * Modifica el clima del lugar.
     * 
     * @param clima nuevo clima del lugar
     */
    public void setClima(String clima) {
        this.clima = clima;
    }

    /**
     * Devuelve una representación en cadena del lugar.
     * 
     * @return cadena con el formato: "nombre - país (clima)"
     */
    @Override
    public String toString() {
        return nombre + " - " + pais + " (" + clima + ")";
    }
}
