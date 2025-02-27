package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class tarea2Controller {
    @FXML
    private TextField txtOperando1;

    @FXML
    private TextField txtOperando2;

    @FXML
    private TextField txtResultado;

    @FXML
    private ToggleGroup operaciones;

    @FXML
    private RadioButton rbSuma;

    @FXML
    private RadioButton rbResta;

    @FXML
    private RadioButton rbMultiplicacion;

    @FXML
    private RadioButton rbDivision;

    @FXML
    private Button btnOperar;

    @FXML
    public void initialize() {
        operaciones = new ToggleGroup(); // Corregido aquí
        rbSuma.setToggleGroup(operaciones);
        rbResta.setToggleGroup(operaciones);
        rbMultiplicacion.setToggleGroup(operaciones);
        rbDivision.setToggleGroup(operaciones);
    }

    @FXML
    private void realizarOperacion() {
        try {
            double num1 = Double.parseDouble(txtOperando1.getText());
            double num2 = Double.parseDouble(txtOperando2.getText());
            double resultado = 0;

            RadioButton selected = (RadioButton) operaciones.getSelectedToggle();
            String operacion = selected.getText();

            switch (operacion) {
                case "Suma":
                    resultado = num1 + num2;
                    break;
                case "Resta":
                    resultado = num1 - num2;
                    break;
                case "Multiplicación":
                    resultado = num1 * num2;
                    break;
                case "División":
                    if (num2 == 0) {
                        txtResultado.setText("Error: División por 0");
                        return;
                    }
                    resultado = num1 / num2;
                    break;
            }

            txtResultado.setText(String.valueOf(resultado));

        } catch (NumberFormatException e) {
            txtResultado.setText("Error: Ingresa números válidos");
        }
    }
}
