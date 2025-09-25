package co.edu.poli.actividad4.servicios;

import co.edu.poli.actividad3.model.ActividadTuristica;

/**
 * Implementación de la interfaz {@link OperacionCRUD}
 * utilizando un arreglo dinámico para almacenar objetos
 * de tipo {@link ActividadTuristica}.
 * <p>
 * El arreglo crece automáticamente cuando se llena, 
 * garantizando una capacidad de almacenamiento infinita. 
 * Las operaciones CRUD se basan en el identificador único (ID) 
 * de cada actividad turística.
 * </p>
 * 
 * @author Julian David Rodriguez Ramirez 
 * @version 1.0
 */
public class ImplementacionOperacionCRUD implements OperacionCRUD {

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

    /**
     * Inserta un nuevo objeto en el primer espacio disponible (null).
     * Si el arreglo está lleno, se duplica su tamaño automáticamente.
     *
     * @param objeto Objeto de tipo {@link ActividadTuristica}.
     * @return {@code true} si la inserción fue exitosa, 
     *         {@code false} en caso contrario.
     */
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

    /**
     * Busca un objeto dentro del arreglo por su identificador único.
     *
     * @param id Identificador de la actividad.
     * @return Objeto {@link ActividadTuristica} si se encuentra,
     *         {@code null} si no existe.
     */
    @Override
    public ActividadTuristica read(String id) {
        for (ActividadTuristica obj : datos) {
            if (obj != null && obj.getIdActividad().equals(id)) {
                return obj;
            }
        }
        return null;
    }

    /**
     * Actualiza un objeto existente en el arreglo, 
     * identificándolo por su ID.
     *
     * @param objeto Objeto con los datos actualizados.
     * @return {@code true} si la actualización fue exitosa, 
     *         {@code false} si no se encontró el objeto.
     */
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

    /**
     * Elimina un objeto del arreglo identificándolo por su ID.
     *
     * @param id Identificador único de la actividad.
     * @return {@code true} si la eliminación fue exitosa,
     *         {@code false} si no se encontró el objeto.
     */
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

    /**
     * Devuelve el arreglo completo de actividades almacenadas.
     *
     * @return Arreglo de objetos {@link ActividadTuristica}.
     */
    @Override
    public ActividadTuristica[] findAll() {
        return datos;
    }

    /**
     * Asegura que el arreglo tenga suficiente capacidad 
     * para almacenar nuevos objetos. Si está lleno,
     * se duplica su tamaño.
     */
    private void ensureCapacity() {
        if (count >= datos.length) {
            ActividadTuristica[] nuevo = new ActividadTuristica[datos.length * 2];
            for (int i = 0; i < datos.length; i++) {
                nuevo[i] = datos[i];
            }
            datos = nuevo;
        }
    }
}
