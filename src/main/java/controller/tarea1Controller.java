package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class tarea1Controller {

    @FXML
    private TextField txtOperando1;

    @FXML
    private TextField txtOperando2;

    @FXML
    private TextField txtResultado;

    @FXML
    private void sumar() {
        try {
            // Obtener valores y convertirlos a números
            double numero1 = Double.parseDouble(txtOperando1.getText());
            double numero2 = Double.parseDouble(txtOperando2.getText());

            // Calcular la suma
            double resultado = numero1 + numero2;

            // Mostrar el resultado
            txtResultado.setText(String.valueOf(resultado));

        } catch (NumberFormatException e) {
            // Mostrar alerta si hay un error en la conversión
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Entrada no válida");
            alert.setContentText("Por favor, ingrese números válidos.");
            alert.showAndWait();
        }
    }
}
