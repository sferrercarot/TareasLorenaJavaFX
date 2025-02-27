package controller;

import applications.Tarea3.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class tarea3Controller {
    @FXML
    private TextField nombreField;
    @FXML
    private TextField apellidosField;
    @FXML
    private TextField edadField;
    @FXML
    private TableView<Persona> tableView;
    @FXML
    private TableColumn<Persona, String> nombreColumn;
    @FXML
    private TableColumn<Persona, String> apellidosColumn;
    @FXML
    private TableColumn<Persona, Integer> edadColumn;
    @FXML
    private Button agregarButton;

    private ObservableList<Persona> personaList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        nombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        apellidosColumn.setCellValueFactory(cellData -> cellData.getValue().apellidosProperty());
        edadColumn.setCellValueFactory(cellData -> cellData.getValue().edadProperty().asObject());

        tableView.setItems(personaList);

        agregarButton.setOnAction(event -> agregarPersona());
    }

    private void agregarPersona() {
        String nombre = nombreField.getText();
        String apellidos = apellidosField.getText();
        int edad = Integer.parseInt(edadField.getText());

        Persona persona = new Persona(nombre, apellidos, edad);
        personaList.add(persona);

        nombreField.clear();
        apellidosField.clear();
        edadField.clear();
    }
}

