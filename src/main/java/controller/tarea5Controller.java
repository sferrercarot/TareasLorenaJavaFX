package controller;

import applications.Tarea5.Persona;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class tarea5Controller {

    @FXML
    private TableView<Persona> tableView;
    @FXML
    private TableColumn<Persona, String> nombreColumn;
    @FXML
    private TableColumn<Persona, String> apellidosColumn;
    @FXML
    private TableColumn<Persona, Integer> edadColumn;

    private ObservableList<Persona> personas = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        nombreColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        apellidosColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellidos()));
        edadColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getEdad()).asObject());

        tableView.setItems(personas);
    }

    @FXML
    private void handleAgregarPersona() {
        Dialog<Persona> dialog = new Dialog<>();
        dialog.setTitle("Agregar Persona");

        ButtonType guardarButtonType = new ButtonType("Guardar", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(guardarButtonType, ButtonType.CANCEL);

        VBox vbox = new VBox();
        TextField nombreField = new TextField();
        TextField apellidosField = new TextField();
        TextField edadField = new TextField();
        vbox.getChildren().addAll(new Label("Nombre:"), nombreField, new Label("Apellidos:"), apellidosField, new Label("Edad:"), edadField);
        dialog.getDialogPane().setContent(vbox);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == guardarButtonType) {
                return new Persona(nombreField.getText(), apellidosField.getText(), Integer.parseInt(edadField.getText()));
            }
            return null;
        });

        dialog.showAndWait().ifPresent(persona -> {
            personas.add(persona);
        });
    }
}