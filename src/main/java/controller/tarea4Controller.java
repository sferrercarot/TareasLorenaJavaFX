package controller;

import applications.Tarea4.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.*;

public class tarea4Controller {
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtEdad;
    @FXML
    private TableView<Persona> tableView;
    @FXML
    private TableColumn<Persona, String> colNombre;
    @FXML
    private TableColumn<Persona, String> colApellidos;
    @FXML
    private TableColumn<Persona, Integer> colEdad;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;

    private ObservableList<Persona> personas;

    public void initialize() {
        personas = FXCollections.observableArrayList();

        // Configuración de columnas
        colNombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        colApellidos.setCellValueFactory(cellData -> cellData.getValue().apellidosProperty());
        colEdad.setCellValueFactory(cellData -> cellData.getValue().edadProperty().asObject());

        tableView.setItems(personas);

        // Listener para mostrar datos en los campos al seleccionar un registro
        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtNombre.setText(newValue.getNombre());
                txtApellidos.setText(newValue.getApellidos());
                txtEdad.setText(String.valueOf(newValue.getEdad()));
            }
        });

        loadData();
    }

    @FXML
    private void agregarPersona() {
        if (!txtNombre.getText().isEmpty() && !txtApellidos.getText().isEmpty() && !txtEdad.getText().isEmpty()) {
            Persona nuevaPersona = new Persona(txtNombre.getText(), txtApellidos.getText(), Integer.parseInt(txtEdad.getText()));
            personas.add(nuevaPersona);
            saveData();
            clearFields();
        }
    }

    @FXML
    private void modificarPersona() {
        Persona personaSeleccionada = tableView.getSelectionModel().getSelectedItem();
        if (personaSeleccionada != null && !txtNombre.getText().isEmpty() && !txtApellidos.getText().isEmpty() && !txtEdad.getText().isEmpty()) {
            personaSeleccionada.setNombre(txtNombre.getText());
            personaSeleccionada.setApellidos(txtApellidos.getText());
            personaSeleccionada.setEdad(Integer.parseInt(txtEdad.getText()));
            saveData();
            clearFields();
        }
    }

    @FXML
    private void eliminarPersona() {
        Persona personaSeleccionada = tableView.getSelectionModel().getSelectedItem();
        if (personaSeleccionada != null) {
            personas.remove(personaSeleccionada);
            saveData();
            clearFields(); // Limpia los campos después de eliminar
        }
    }

    private void loadData() {
        try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) { // validar si hay 3 partes
                    personas.add(new Persona(parts[0], parts[1], Integer.parseInt(parts[2])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("datos.txt"))) {
            for (Persona persona : personas) {
                bw.write(persona.getNombre() + "," + persona.getApellidos() + "," + persona.getEdad());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        txtNombre.clear();
        txtApellidos.clear();
        txtEdad.clear();
    }
}