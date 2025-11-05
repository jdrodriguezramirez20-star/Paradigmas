package co.edu.poli.actividad3.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
            // Cargar el archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("actividad10.fxml"));
            Parent root = loader.load();
            
            // Crear la escena
            Scene scene = new Scene(root);
            
            // Configurar el Stage
            primaryStage.setTitle("Sistema de Gestión de Actividades Turísticas - CRUD");
            primaryStage.setScene(scene);
            primaryStage.setResizable(true);
            primaryStage.show();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error al iniciar la aplicación: " + e.getMessage());
        }
    }
    
    @Override
    public void stop() {
        System.out.println("Aplicación cerrada correctamente");
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}