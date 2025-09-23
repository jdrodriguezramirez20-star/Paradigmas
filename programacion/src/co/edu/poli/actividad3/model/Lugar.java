package co.edu.poli.actividad3.model;


public final class Lugar {

    
    private final String nombre;

    private String pais;
    private String clima;

    // Constructor
    public Lugar(String nombre, String pais, String clima) {
        this.nombre = nombre; 
        this.pais = pais;
        this.clima = clima;
    }

   
    public final String getNombre() {
        return nombre;
    }

    
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    @Override
    public String toString() {
        return nombre + " - " + pais + " (" + clima + ")";
    }
}
