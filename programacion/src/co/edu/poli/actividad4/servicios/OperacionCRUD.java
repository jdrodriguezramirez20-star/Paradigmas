package co.edu.poli.actividad4.servicios;

import co.edu.poli.actividad3.model.ActividadTuristica;
import java.util.List;

public interface OperacionCRUD {
    boolean create(ActividadTuristica obj);
    ActividadTuristica read(String id);
    boolean update(ActividadTuristica obj);
    boolean delete(String id);
    List<ActividadTuristica> findAll();
}