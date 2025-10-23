package co.edu.poli.actividad3.vista;

import co.edu.poli.actividad3.model.*;
import co.edu.poli.actividad4.servicios.ImplementacionOperacionCRUD;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        ImplementacionOperacionCRUD crud = new ImplementacionOperacionCRUD();
        Scanner sc = new Scanner(System.in);
        int opcion;

        // ✅ Cargar datos al iniciar con manejo de excepciones
        try {
            crud.deserializar();
            System.out.println("✅ Datos cargados correctamente al iniciar.");
        } catch (Exception e) {
            System.out.println("⚠️ No se pudieron cargar los datos iniciales: " + e.getMessage());
        }

        do {
            System.out.println("\n===== MENÚ CRUD =====");
            System.out.println("1. Crear objeto");
            System.out.println("2. Listar todos");
            System.out.println("3. Listar por ID");
            System.out.println("4. Guardar en archivo");
            System.out.println("5. Cargar desde archivo");
            System.out.println("6. Modificar objeto");
            System.out.println("7. Eliminar objeto");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                // ================= 1. CREAR =================
                case 1:
                    System.out.print("Digite ID: ");
                    String id = sc.nextLine();

                    System.out.print("Digite nombre del usuario: ");
                    String usuario = sc.nextLine();

                    System.out.print("Digite nombre del lugar (actividad): ");
                    String nombreLugar = sc.nextLine();

                    System.out.print("Digite país: ");
                    String pais = sc.nextLine();

                    System.out.print("Digite ciudad: ");
                    String ciudad = sc.nextLine();

                    Lugar lugar = new Lugar(nombreLugar, pais, ciudad);

                    System.out.print("Digite duración (en minutos): ");
                    int duracion = sc.nextInt();
                    sc.nextLine();

                    int experienciaValor;
                    do {
                        System.out.print("Digite experiencia (1 a 10): ");
                        experienciaValor = sc.nextInt();
                        sc.nextLine();
                    } while (experienciaValor < 1 || experienciaValor > 10);

                    Experiencia experiencia = new Experiencia(usuario, experienciaValor, "");

                    int calificacionValor;
                    do {
                        System.out.print("Digite calificación (1 a 10): ");
                        calificacionValor = sc.nextInt();
                        sc.nextLine();
                    } while (calificacionValor < 1 || calificacionValor > 10);

                    Calificacion calificacion = new Calificacion(calificacionValor);

                    System.out.print("Digite año de inicio: ");
                    int anioInicio = sc.nextInt();
                    sc.nextLine();

                    // Crear la actividad de aventura con los datos nuevos
                    ActividadAventura act = new ActividadAventura(
                            id,
                            nombreLugar,
                            "Aventura",
                            lugar,
                            duracion,
                            experiencia,
                            calificacion,
                            null,        // Descripción puede ser null o crearse luego
                            anioInicio,
                            usuario
                    );

                    crud.create(act);
                    System.out.println("✅ Objeto creado correctamente.");
                    break;

                // ================= 2. LISTAR TODOS =================
                case 2:
                    System.out.println("\n=== Listado de Actividades ===");
                    for (ActividadTuristica a : crud.findAll()) {
                        if (a != null) {
                            System.out.println("-------------------------------");
                            System.out.println(a);
                        }
                    }
                    break;

                // ================= 3. LISTAR POR ID =================
                case 3:
                    System.out.print("Digite ID a buscar: ");
                    String idBuscar = sc.nextLine();
                    ActividadTuristica encontrada = crud.read(idBuscar);
                    if (encontrada != null) {
                        System.out.println("\n=== Actividad encontrada ===");
                        System.out.println(encontrada);
                    } else {
                        System.out.println("⚠️ No se encontró ninguna actividad con ese ID.");
                    }
                    break;

                // ================= 4. GUARDAR ARCHIVO =================
                case 4:
                    crud.serializar();
                    System.out.println("✅ Datos guardados correctamente.");
                    break;

                // ================= 5. CARGAR ARCHIVO =================
                case 5:
                    try {
                        crud.deserializar();
                        System.out.println("✅ Datos cargados correctamente desde archivo.");
                    } catch (Exception e) {
                        System.out.println("⚠️ Error al cargar datos: " + e.getMessage());
                    }
                    break;

                // ================= 6. MODIFICAR =================
                case 6:
                    System.out.print("Digite ID a modificar: ");
                    String idMod = sc.nextLine();
                    ActividadTuristica mod = crud.read(idMod);
                    if (mod != null) {
                        System.out.print("Nuevo nombre del lugar: ");
                        String nuevoNombre = sc.nextLine();
                        mod.getLugar().setNombre(nuevoNombre);
                        crud.update(mod);
                        System.out.println("✅ Actividad modificada correctamente.");
                    } else {
                        System.out.println("⚠️ No se encontró la actividad.");
                    }
                    break;

                // ================= 7. ELIMINAR =================
                case 7:
                    System.out.print("Digite ID a eliminar: ");
                    String idEliminar = sc.nextLine();
                    if (crud.delete(idEliminar)) {
                        System.out.println("✅ Actividad eliminada correctamente.");
                    } else {
                        System.out.println("⚠️ No se encontró la actividad.");
                    }
                    break;

                // ================= 8. SALIR =================
                case 8:
                    System.out.println("👋 Saliendo...");
                    break;

                default:
                    System.out.println("⚠️ Opción no válida.");
            }

        } while (opcion != 8);

        sc.close();
    }
}
