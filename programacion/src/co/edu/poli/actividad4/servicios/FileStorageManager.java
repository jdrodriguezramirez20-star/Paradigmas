package co.edu.poli.actividad4.servicios;

import co.edu.poli.actividad3.model.ActividadTuristica;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileStorageManager {
    private String path;
    
    public FileStorageManager(String path) {
        this.path = path;
    }
    
    public boolean saveAll(List<ActividadTuristica> lista) {
        if (lista == null) {
            return false;
        }
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(lista);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @SuppressWarnings("unchecked")
    public List<ActividadTuristica> loadAll() {
        File file = new File(path);
        
        if (!file.exists()) {
            return new ArrayList<>();
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                return (List<ActividadTuristica>) obj;
            }
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    // Getters y Setters
    public String getPath() {
        return path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }
}