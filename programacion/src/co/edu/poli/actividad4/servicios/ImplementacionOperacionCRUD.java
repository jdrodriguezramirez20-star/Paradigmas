package co.edu.poli.actividad4.servicios;

import co.edu.poli.actividad3.model.ActividadTuristica;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.Serializable;

/**
 * Implementación de la interfaz {@link OperacionCRUD}
 * utilizando un arreglo dinámico para almacenar objetos
 * de tipo {@link ActividadTuristica}.
 * <p>
 * Incluye también métodos de serialización y deserialización
 * para guardar y recuperar los datos desde un archivo binario.
 * </p>
 * 
 * @author Julian David Rodriguez Ramirez 
 * @version 1.1
 */
public class ImplementacionOperacionCRUD implements OperacionCRUD, Serializable {

    private static final long serialVersionUID = 1L;

    /** Arreglo dinámico de actividades turísticas. */
    private ActividadTuristica[] datos;

    /** Número actual de elementos almacenados en el arreglo. */
    private int count;

    /**
     * Constructor que inicializa el arreglo con una capacidad inicial de 10.
     */
    public ImplementacionOperacionCRUD() {
        datos = new ActividadTuristica[10];
        count = 0;
    }

    /** Inserta un nuevo objeto en el primer espacio disponible (null). */
    @Override
    public boolean create(ActividadTuristica objeto) {
        ensureCapacity();
        for (int i = 0; i < datos.length; i++) {
            if (datos[i] == null) {
                datos[i] = objeto;
                count++;
                return true;
            }
        }
        return false;
    }

    /** Busca un objeto dentro del arreglo por su identificador único. */
    @Override
    public ActividadTuristica read(String id) {
        for (ActividadTuristica obj : datos) {
            if (obj != null && obj.getIdActividad().equals(id)) {
                return obj;
            }
        }
        return null;
    }

    /** Actualiza un objeto existente en el arreglo. */
    @Override
    public boolean update(ActividadTuristica objeto) {
        for (int i = 0; i < datos.length; i++) {
            if (datos[i] != null && datos[i].getIdActividad().equals(objeto.getIdActividad())) {
                datos[i] = objeto;
                return true;
            }
        }
        return false;
    }

    /** Elimina un objeto del arreglo por su ID. */
    @Override
    public boolean delete(String id) {
        for (int i = 0; i < datos.length; i++) {
            if (datos[i] != null && datos[i].getIdActividad().equals(id)) {
                datos[i] = null;
                count--;
                return true;
            }
        }
        return false;
    }

    /** Devuelve el arreglo completo de actividades almacenadas. */
    @Override
    public ActividadTuristica[] findAll() {
        return datos;
    }

    /** Devuelve el número de elementos actualmente en el arreglo. */
    public int getCount() {
        return count;
    }

    /** Asegura que el arreglo tenga suficiente capacidad. */
    private void ensureCapacity() {
        if (count >= datos.length) {
            ActividadTuristica[] nuevo = new ActividadTuristica[datos.length * 2];
            for (int i = 0; i < datos.length; i++) {
                nuevo[i] = datos[i];
            }
            datos = nuevo;
        }
    }

    /**
     * Serializa el arreglo de actividades turísticas a un archivo binario.
     *
     * @param nombreArchivo Nombre del archivo donde se guardarán los datos.
     */
    public void serializar(String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(datos);
            System.out.println("Datos serializados correctamente en " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al serializar: " + e.getMessage());
        }
    }

    /**
     * Deserializa el arreglo de actividades turísticas desde un archivo binario.
     *
     * @param nombreArchivo Nombre del archivo donde están los datos.
     * @return Arreglo de objetos {@link ActividadTuristica} cargados desde el archivo.
     */
    public ActividadTuristica[] deserializar(String nombreArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            datos = (ActividadTuristica[]) ois.readObject();
            System.out.println("Datos deserializados correctamente desde " + nombreArchivo);
            return datos;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al deserializar: " + e.getMessage());
            return new ActividadTuristica[0];
        }
    }

    // ==== Sobrecargas para usar archivo fijo (datos.bin) ====
    public void serializar() {
        serializar("datos.bin");
    }

    public ActividadTuristica[] deserializar() {
        return deserializar("datos.bin");
    }
}
