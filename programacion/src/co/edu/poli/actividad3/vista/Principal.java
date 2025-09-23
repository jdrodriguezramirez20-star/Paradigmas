package co.edu.poli.actividad3.vista;

import co.edu.poli.actividad3.model.*;
import co.edu.poli.actividad4.servicios.TourMuseo;
import java.util.ArrayList;

public class Principal {

   
    public static void mostrarActividad(ActividadTuristica actividad) {
        System.out.println(">>> Información de la actividad recibida:");
        System.out.println(actividad.mostrarInformacion());
        System.out.println("--------------------------------");
    }

    
    public static ActividadTuristica crearActividadDemo() {
        Lugar lugar = new Lugar("Parque Nacional", "Colombia", "Templado");
        Experiencia exp = new Experiencia("Caminata ecológica", 60, "Media");
        Calificacion cal = new Calificacion("Muy buena", 4.5, "Laura Gómez", "Excelente guía");
        Descripcion desc = new Descripcion("Senderismo", "Conectar con la naturaleza", "Llevar ropa cómoda");

       
        return new ActividadAventura("A004", "Senderismo", "Aventura", lugar, 120, exp, cal, desc, 2020, "Medio");
    }

    public static void main(String[] args) {

       
        System.out.println("=== PUNTO 1: Arreglo polimórfico ===");

        Lugar lugar1 = new Lugar("L001", "Cartagena", "Cálido");
        Experiencia exp1 = new Experiencia("Guía turística", 120, "Baja");
        Calificacion cal1 = new Calificacion("Excelente", 4.8, "Juan Pérez", "Muy buena experiencia");
        Descripcion desc1 = new Descripcion("Recorrido cultural", "Conocer historia", "Llevar agua");

        ActividadCultural actCultural = new ActividadCultural("A001", "Tour Histórico", "Cultural",
                lugar1, 180, exp1, cal1, desc1, 1995, "Español");

        ActividadAventura actAventura = new ActividadAventura("A002", "Rafting", "Aventura",
                lugar1, 240, exp1, cal1, desc1, 2005, "Alto");

        TourMuseo tourMuseo = new TourMuseo("A003", "Visita Museo", "Cultural",
                lugar1, 90, exp1, cal1, desc1, 2010, "Español", 60);

      
        ActividadTuristica[] arregloActividades = new ActividadTuristica[5];
        arregloActividades[0] = actCultural;
        arregloActividades[1] = actAventura;
        arregloActividades[2] = tourMuseo;

        
        for (int i = 0; i < arregloActividades.length; i++) {
            System.out.println("Posición " + i + ":");
            if (arregloActividades[i] != null) {
                System.out.println(arregloActividades[i].mostrarInformacion());
            } else {
                System.out.println("null");
            }
            System.out.println("--------------------------------");
        }

       
        System.out.println("\n=== PUNTO 2: Métodos con polimorfismo ===");

        
        ActividadTuristica actPoli = crearActividadDemo();

        
        mostrarActividad(actPoli);

       
        System.out.println("\n=== PUNTO 3: Uso de final ===");

        // -------- Cambios realizados --------
        // 1. En la clase Lugar → atributo final (nombre)
        // 2. En la clase Lugar → método final (getNombre)
        // 3. En la clase Lugar → clase final (no se puede heredar)
        // -------------------------------------

        Lugar lugarFinal = new Lugar("Museo del Oro", "Colombia", "Templado");
        System.out.println("Nombre (atributo final): " + lugarFinal.getNombre());
        System.out.println("País: " + lugarFinal.getPais());
        System.out.println("Clima: " + lugarFinal.getClima());
    }
}
