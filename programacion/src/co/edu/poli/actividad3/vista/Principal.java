package co.edu.poli.actividad3.vista;

import co.edu.poli.actividad3.model.*;
import co.edu.poli.actividad4.servicios.*;

/**
 * Clase Principal que prueba el funcionamiento de las operaciones CRUD
 * sobre actividades turísticas, utilizando la implementación de
 * {@link OperacionCRUD}.
 * 
 * Se crean objetos de ejemplo y se realizan las operaciones:
 * Create, Read, Update, Delete y FindAll.
 * 
 * @author Julian David Rodriguez Ramirez 
 * @version 1.0
 */
public class Principal {

    /**
     * Método principal que ejecuta las pruebas del CRUD.
     * 
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {

        // Crear servicio CRUD
        OperacionCRUD crud = new ImplementacionOperacionCRUD();

        // Crear objetos de apoyo para ActividadTuristica
        Lugar lugar1 = new Lugar("Museo del Oro", "Colombia", "Templado");
        Experiencia exp1 = new Experiencia("Recorrido guiado", 120, "Baja");
        Calificacion cal1 = new Calificacion("Excelente", 4.8, "Ana", "Muy recomendado");
        Descripcion desc1 = new Descripcion("Cultural", "Conocer historia precolombina", "Llevar cámara");

        Lugar lugar2 = new Lugar("Parque Aventura", "Colombia", "Cálido");
        Experiencia exp2 = new Experiencia("Escalada", 90, "Alta");
        Calificacion cal2 = new Calificacion("Adrenalina pura", 4.5, "Pedro", "Emocionante experiencia");
        Descripcion desc2 = new Descripcion("Aventura", "Vivir emociones extremas", "Usar ropa deportiva");

        // ==== CREATE ====
        ActividadTuristica act1 = new TourMuseo("A1", "Tour Museo del Oro", "Cultural", 
                lugar1, 120, exp1, cal1, desc1, 1939, "Español", 60);

        ActividadTuristica act2 = new ActividadAventura("A2", "Escalada en roca", "Aventura", 
                lugar2, 90, exp2, cal2, desc2, 2005, "Alto");

        crud.create(act1);
        crud.create(act2);

        System.out.println("==== CREATE ====");
        for (ActividadTuristica a : crud.findAll()) {
            if (a != null) {
                System.out.println(a.mostrarInformacion());
            }
        }

        // ==== READ ====
        System.out.println("\n==== READ ====");
        ActividadTuristica encontrada = crud.read("A1");
        if (encontrada != null) {
            System.out.println("Encontrada: " + encontrada.mostrarInformacion());
        }

        // ==== UPDATE ====
        System.out.println("\n==== UPDATE ====");
        ActividadTuristica act2Actualizada = new ActividadAventura("A2", "Escalada extrema", "Aventura", 
                lugar2, 100, exp2, cal2, desc2, 2005, "Muy Alto");
        if (crud.update(act2Actualizada)) {
            System.out.println("Actividad actualizada correctamente.");
        }

        // Mostrar después del UPDATE
        for (ActividadTuristica a : crud.findAll()) {
            if (a != null) {
                System.out.println(a.mostrarInformacion());
            }
        }

        // ==== DELETE ====
        System.out.println("\n==== DELETE ====");
        if (crud.delete("A1")) {
            System.out.println("Actividad A1 eliminada correctamente.");
        }

        // Mostrar después del DELETE
        for (ActividadTuristica a : crud.findAll()) {
            if (a != null) {
                System.out.println(a.mostrarInformacion());
            }
        }
    }
}
