package co.edu.poli.actividad3.model;

public class InvalidDataException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    
    public InvalidDataException(String mensaje) {
        super(mensaje);
    }
}