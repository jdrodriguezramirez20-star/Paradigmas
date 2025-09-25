package co.edu.poli.actividad4.servicios;

import co.edu.poli.actividad3.model.ActividadTuristica;

/**
 * Interfaz que define las operaciones básicas de un CRUD
 * (Create, Read, Update, Delete) sobre objetos de tipo 
 * {@link ActividadTuristica}.
 * <p>
 * Esta interfaz establece las operaciones mínimas que 
 * cualquier implementación debe cumplir para gestionar 
 * actividades turísticas en memoria u otros medios de almacenamiento.
 * </p>
 * 
 * @author Julian David Rodriguez Ramirez 
 * @version 1.0
 */
public interface OperacionCRUD {

    /**
     * Inserta un nuevo objeto en el almacenamiento.
     * 
     * @param objeto Objeto de tipo {@link ActividadTuristica}.
     * @return {@code true} si la inserción fue exitosa, 
     *         {@code false} en caso contrario.
     */
    boolean create(ActividadTuristica objeto);

    /**
     * Busca un objeto por su identificador único.
     * 
     * @param id Identificador único de la actividad.
     * @return Objeto {@link ActividadTuristica} si fue encontrado,
     *         {@code null} si no existe.
     */
    ActividadTuristica read(String id);

    /**
     * Actualiza un objeto existente dentro del almacenamiento.
     * 
     * @param objeto Objeto con los datos actualizados.
     * @return {@code true} si la actualización fue exitosa, 
     *         {@code false} si no se encontró el objeto.
     */
    boolean update(ActividadTuristica objeto);

    /**
     * Elimina un objeto del almacenamiento a partir de su ID.
     * 
     * @param id Identificador único de la actividad.
     * @return {@code true} si la eliminación fue exitosa, 
     *         {@code false} si no se encontró el objeto.
     */
    boolean delete(String id);

    /**
     * Devuelve todos los objetos almacenados.
     * 
     * @return Arreglo con objetos de tipo {@link ActividadTuristica}.
     */
    ActividadTuristica[] findAll();
}
