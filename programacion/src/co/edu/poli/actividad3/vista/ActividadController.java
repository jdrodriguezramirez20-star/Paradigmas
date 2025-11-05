package co.edu.poli.actividad3.vista;

import co.edu.poli.actividad3.model.*;
import co.edu.poli.actividad4.servicios.ImplementacionOperacionCRUD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ActividadController {
    
    @FXML private TableView<ActividadTuristica> tablaActividades;
    @FXML private TableColumn<ActividadTuristica, String> colId;
    @FXML private TableColumn<ActividadTuristica, String> colNombre;
    @FXML private TableColumn<ActividadTuristica, String> colTipo;
    @FXML private TableColumn<ActividadTuristica, Integer> colTiempo;
    @FXML private TableColumn<ActividadTuristica, Integer> colAnio;
    
    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private ComboBox<String> cbTipo;
    @FXML private TextField txtTiempo;
    @FXML private TextField txtAnio;
    @FXML private TextField txtLugarNombre;
    @FXML private TextField txtAtributoEspecifico;
    @FXML private Label lblAtributoEspecifico;
    
    @FXML private Button btnCrear;
    @FXML private Button btnActualizar;
    @FXML private Button btnEliminar;
    @FXML private Button btnCargar;
    
    private ImplementacionOperacionCRUD servicio;
    private ObservableList<ActividadTuristica> listaActividades;
    
    @FXML
    public void initialize() {
        servicio = new ImplementacionOperacionCRUD();
        listaActividades = FXCollections.observableArrayList();
        
        configurarTabla();
        configurarComboBox();
        
        // Listener para el ComboBox de tipo
        cbTipo.setOnAction(e -> actualizarCampoEspecifico());
        
        // Listener para selección en tabla
        tablaActividades.getSelectionModel().selectedItemProperty().addListener(
            (obs, oldVal, newVal) -> {
                if (newVal != null) {
                    cargarActividadEnFormulario(newVal);
                }
            }
        );
        
        // Cargar datos al iniciar
        onLoadClicked();
    }
    
    private void configurarTabla() {
        colId.setCellValueFactory(new PropertyValueFactory<>("idActividadTuristica"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colTiempo.setCellValueFactory(new PropertyValueFactory<>("tiempo"));
        colAnio.setCellValueFactory(new PropertyValueFactory<>("anioCreacion"));
        
        tablaActividades.setItems(listaActividades);
    }
    
    private void configurarComboBox() {
        cbTipo.setItems(FXCollections.observableArrayList(
            "Cultural",
            "Aventura",
            "TourMuseo"
        ));
    }
    
    private void actualizarCampoEspecifico() {
        String tipo = cbTipo.getValue();
        if (tipo == null) return;
        
        switch (tipo) {
            case "Cultural":
                lblAtributoEspecifico.setText("Idioma Guía:");
                txtAtributoEspecifico.setPromptText("Ej: Español");
                break;
            case "Aventura":
                lblAtributoEspecifico.setText("Nivel Riesgo:");
                txtAtributoEspecifico.setPromptText("Ej: Alto, Medio, Bajo");
                break;
            case "TourMuseo":
                lblAtributoEspecifico.setText("Duración Guía (min):");
                txtAtributoEspecifico.setPromptText("Ej: 60");
                break;
        }
    }
    
    @FXML
    public void onCreateClicked() {
        try {
            ActividadTuristica actividad = construirActividad();
            
            if (actividad != null) {
                if (servicio.create(actividad)) {
                    listaActividades.add(actividad);
                    servicio.saveToFile();
                    limpiarFormulario();
                    mostrarMensaje("Éxito", "Actividad creada correctamente", Alert.AlertType.INFORMATION);
                } else {
                    mostrarMensaje("Error", "No se pudo crear la actividad. Verifique que el ID no exista.", Alert.AlertType.ERROR);
                }
            }
        } catch (InvalidDataException e) {
            mostrarMensaje("Error", e.getMessage(), Alert.AlertType.ERROR);
        } catch (Exception e) {
            mostrarMensaje("Error", "Error al crear actividad: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    @FXML
    public void onUpdateClicked() {
        ActividadTuristica seleccionada = tablaActividades.getSelectionModel().getSelectedItem();
        
        if (seleccionada == null) {
            mostrarMensaje("Advertencia", "Seleccione una actividad de la tabla", Alert.AlertType.WARNING);
            return;
        }
        
        try {
            ActividadTuristica actividad = construirActividad();
            
            if (actividad != null) {
                if (servicio.update(actividad)) {
                    // Actualizar en la lista observable
                    int index = listaActividades.indexOf(seleccionada);
                    listaActividades.set(index, actividad);
                    servicio.saveToFile();
                    limpiarFormulario();
                    mostrarMensaje("Éxito", "Actividad actualizada correctamente", Alert.AlertType.INFORMATION);
                } else {
                    mostrarMensaje("Error", "No se pudo actualizar la actividad", Alert.AlertType.ERROR);
                }
            }
        } catch (Exception e) {
            mostrarMensaje("Error", "Error al actualizar: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    @FXML
    public void onDeleteClicked() {
        ActividadTuristica seleccionada = tablaActividades.getSelectionModel().getSelectedItem();
        
        if (seleccionada == null) {
            mostrarMensaje("Advertencia", "Seleccione una actividad de la tabla", Alert.AlertType.WARNING);
            return;
        }
        
        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmar eliminación");
        confirmacion.setHeaderText("¿Está seguro de eliminar esta actividad?");
        confirmacion.setContentText(seleccionada.getNombre());
        
        if (confirmacion.showAndWait().get() == ButtonType.OK) {
            if (servicio.delete(seleccionada.getIdActividadTuristica())) {
                listaActividades.remove(seleccionada);
                servicio.saveToFile();
                limpiarFormulario();
                mostrarMensaje("Éxito", "Actividad eliminada correctamente", Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje("Error", "No se pudo eliminar la actividad", Alert.AlertType.ERROR);
            }
        }
    }
    
    @FXML
    public void onLoadClicked() {
        if (servicio.loadFromFile()) {
            listaActividades.clear();
            listaActividades.addAll(servicio.findAll());
            mostrarMensaje("Éxito", "Datos cargados correctamente", Alert.AlertType.INFORMATION);
        } else {
            System.out.println("No hay datos previos para cargar");
        }
    }
    
    private ActividadTuristica construirActividad() throws InvalidDataException {
        // Validaciones
        if (txtId.getText().trim().isEmpty()) {
            throw new InvalidDataException("El ID es obligatorio");
        }
        if (txtNombre.getText().trim().isEmpty()) {
            throw new InvalidDataException("El nombre es obligatorio");
        }
        if (cbTipo.getValue() == null) {
            throw new InvalidDataException("Debe seleccionar un tipo");
        }
        if (txtTiempo.getText().trim().isEmpty()) {
            throw new InvalidDataException("El tiempo es obligatorio");
        }
        if (txtAnio.getText().trim().isEmpty()) {
            throw new InvalidDataException("El año de creación es obligatorio");
        }
        
        String id = txtId.getText().trim();
        String nombre = txtNombre.getText().trim();
        String tipo = cbTipo.getValue();
        int tiempo = Integer.parseInt(txtTiempo.getText().trim());
        int anio = Integer.parseInt(txtAnio.getText().trim());
        
        // Crear lugar simple
        Lugar lugar = new Lugar();
        lugar.setIdLugar("L" + id);
        lugar.setNombre(txtLugarNombre.getText().isEmpty() ? "N/A" : txtLugarNombre.getText());
        
        ActividadTuristica actividad = null;
        
        switch (tipo) {
            case "Cultural":
                String idiomaGuia = txtAtributoEspecifico.getText().trim();
                if (idiomaGuia.isEmpty()) {
                    throw new InvalidDataException("El idioma del guía es obligatorio");
                }
                actividad = new ActividadCultural(id, nombre, tipo, lugar, tiempo, anio, idiomaGuia);
                break;
                
            case "Aventura":
                String nivelRiesgo = txtAtributoEspecifico.getText().trim();
                if (nivelRiesgo.isEmpty()) {
                    throw new InvalidDataException("El nivel de riesgo es obligatorio");
                }
                actividad = new ActividadAventura(id, nombre, tipo, lugar, tiempo, anio, nivelRiesgo);
                break;
                
            case "TourMuseo":
                String duracionGuiaStr = txtAtributoEspecifico.getText().trim();
                if (duracionGuiaStr.isEmpty()) {
                    throw new InvalidDataException("La duración del guía es obligatoria");
                }
                int duracionGuia = Integer.parseInt(duracionGuiaStr);
                actividad = new TourMuseo(id, nombre, tipo, lugar, tiempo, anio, duracionGuia, "Español");
                break;
        }
        
        return actividad;
    }
    
    private void cargarActividadEnFormulario(ActividadTuristica actividad) {
        txtId.setText(actividad.getIdActividadTuristica());
        txtNombre.setText(actividad.getNombre());
        cbTipo.setValue(actividad.getTipo());
        txtTiempo.setText(String.valueOf(actividad.getTiempo()));
        txtAnio.setText(String.valueOf(actividad.getAnioCreacion()));
        
        if (actividad.getLugar() != null) {
            txtLugarNombre.setText(actividad.getLugar().getNombre());
        }
        
        actualizarCampoEspecifico();
        
        if (actividad instanceof ActividadCultural) {
            ActividadCultural ac = (ActividadCultural) actividad;
            txtAtributoEspecifico.setText(ac.getIdiomaGuia());
        } else if (actividad instanceof ActividadAventura) {
            ActividadAventura aa = (ActividadAventura) actividad;
            txtAtributoEspecifico.setText(aa.getNivelRiesgo());
        } else if (actividad instanceof TourMuseo) {
            TourMuseo tm = (TourMuseo) actividad;
            txtAtributoEspecifico.setText(String.valueOf(tm.getDuracionGuia()));
        }
    }
    
    private void limpiarFormulario() {
        txtId.clear();
        txtNombre.clear();
        txtTiempo.clear();
        txtAnio.clear();
        txtLugarNombre.clear();
        txtAtributoEspecifico.clear();
        cbTipo.getSelectionModel().clearSelection();
        tablaActividades.getSelectionModel().clearSelection();
    }
    
    private void mostrarMensaje(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}