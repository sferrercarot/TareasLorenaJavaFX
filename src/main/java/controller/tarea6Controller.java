package controller;

import applications.Tarea6.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class tarea6Controller {

    @FXML
    private TextField nombreField;
    @FXML
    private TextField apellidosField;
    @FXML
    private TextField edadField;
    @FXML
    private TableView<Persona> tabla;
    @FXML
    private TableColumn<Persona, String> nombreCol;
    @FXML
    private TableColumn<Persona, String> apellidosCol;
    @FXML
    private TableColumn<Persona, Integer> edadCol;

    private ObservableList<Persona> listaPersonas = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        nombreCol.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        apellidosCol.setCellValueFactory(cellData -> cellData.getValue().apellidosProperty());
        edadCol.setCellValueFactory(cellData -> cellData.getValue().edadProperty().length().asObject());
    }

    @FXML
    public void agregarPersona() {
        String nombre = nombreField.getText();
        String apellidos = apellidosField.getText();
        int edad = Integer.parseInt(edadField.getText());

        listaPersonas.add(new Persona(nombre, apellidos, edad));
        limpiarCampos();
    }

    @FXML
    public void modificarPersona() {
        Persona personaSeleccionada = tabla.getSelectionModel().getSelectedItem();
        if (personaSeleccionada != null) {
            nombreField.setText(personaSeleccionada.getNombre());
            apellidosField.setText(personaSeleccionada.getApellidos());
            edadField.setText(String.valueOf(personaSeleccionada.getEdad()));
            listaPersonas.remove(personaSeleccionada);
        }
    }

    @FXML
    public void eliminarPersona() {
        Persona personaSeleccionada = tabla.getSelectionModel().getSelectedItem();
        if (personaSeleccionada != null) {
            listaPersonas.remove(personaSeleccionada);
        }
    }

    private void limpiarCampos() {
        nombreField.clear();
        apellidosField.clear();
        edadField.clear();
    }
}

