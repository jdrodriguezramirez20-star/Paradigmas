package co.edu.poli.actividad4.servicios;

import co.edu.poli.actividad3.model.ActividadTuristica;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImplementacionOperacionCRUD implements OperacionCRUD {
    private ActividadTuristica[] datos;
    private int count;
    private static final int CAPACIDAD_INICIAL = 10;
    private FileStorageManager storageManager;
    
    public ImplementacionOperacionCRUD() {
        this.datos = new ActividadTuristica[CAPACIDAD_INICIAL];
        this.count = 0;
        this.storageManager = new FileStorageManager("actividades.dat");
    }
    
    @Override
    public boolean create(ActividadTuristica obj) {
        if (obj == null) {
            return false;
        }
        
        // Verificar si ya existe
        if (read(obj.getIdActividadTuristica()) != null) {
            return false;
        }
        
        // Expandir array si es necesario
        if (count >= datos.length) {
            expandirArray();
        }
        
        datos[count] = obj;
        count++;
        return true;
    }
    
    @Override
    public ActividadTuristica read(String id) {
        if (id == null) {
            return null;
        }
        
        for (int i = 0; i < count; i++) {
            if (datos[i] != null && datos[i].getIdActividadTuristica().equals(id)) {
                return datos[i];
            }
        }
        return null;
    }
    
    @Override
    public boolean update(ActividadTuristica obj) {
        if (obj == null) {
            return false;
        }
        
        for (int i = 0; i < count; i++) {
            if (datos[i] != null && datos[i].getIdActividadTuristica().equals(obj.getIdActividadTuristica())) {
                datos[i] = obj;
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean delete(String id) {
        if (id == null) {
            return false;
        }
        
        for (int i = 0; i < count; i++) {
            if (datos[i] != null && datos[i].getIdActividadTuristica().equals(id)) {
                // Mover todos los elementos hacia la izquierda
                for (int j = i; j < count - 1; j++) {
                    datos[j] = datos[j + 1];
                }
                datos[count - 1] = null;
                count--;
                return true;
            }
        }
        return false;
    }
    
    @Override
    public List<ActividadTuristica> findAll() {
        List<ActividadTuristica> lista = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (datos[i] != null) {
                lista.add(datos[i]);
            }
        }
        return lista;
    }
    
    public boolean saveToFile() {
        try {
            List<ActividadTuristica> lista = findAll();
            return storageManager.saveAll(lista);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean loadFromFile() {
        try {
            List<ActividadTuristica> lista = storageManager.loadAll();
            if (lista != null && !lista.isEmpty()) {
                // Limpiar datos actuales
                datos = new ActividadTuristica[Math.max(CAPACIDAD_INICIAL, lista.size() * 2)];
                count = 0;
                
                // Cargar datos
                for (ActividadTuristica actividad : lista) {
                    datos[count] = actividad;
                    count++;
                }
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    private void expandirArray() {
        int nuevaCapacidad = datos.length * 2;
        datos = Arrays.copyOf(datos, nuevaCapacidad);
    }
    
    // Getters
    public int getCount() {
        return count;
    }
}