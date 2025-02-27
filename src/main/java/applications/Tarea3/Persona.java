package applications.Tarea3;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Persona {
    private SimpleStringProperty nombre;
    private SimpleStringProperty apellidos;
    private SimpleIntegerProperty edad;

    public Persona(String nombre, String apellidos, int edad) {
        this.nombre = new SimpleStringProperty(nombre);
        this.apellidos = new SimpleStringProperty(apellidos);
        this.edad = new SimpleIntegerProperty(edad);
    }

    public SimpleStringProperty nombreProperty() {
        return nombre;
    }

    public SimpleStringProperty apellidosProperty() {
        return apellidos;
    }

    public SimpleIntegerProperty edadProperty() {
        return edad;
    }
}

