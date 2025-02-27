package applications.Tarea6;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Persona {
    private final StringProperty nombre = new SimpleStringProperty(this, "nombre", "");
    private final StringProperty apellidos = new SimpleStringProperty(this, "apellidos", "");
    private final StringProperty edad = new SimpleStringProperty(this, "edad", "");

    public Persona(String nombre, String apellidos, int edad) {
        this.nombre.set(nombre);
        this.apellidos.set(apellidos);
        this.edad.set(String.valueOf(edad)); // Convertimos edad a String
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public StringProperty apellidosProperty() {
        return apellidos;
    }

    public StringProperty edadProperty() {
        return edad;
    }

    public String getNombre() {
        return nombre.get();
    }

    public String getApellidos() {
        return apellidos.get();
    }

    public String getEdad() {
        return edad.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public void setApellidos(String apellidos) {
        this.apellidos.set(apellidos);
    }

    public void setEdad(int edad) {
        this.edad.set(String.valueOf(edad)); // Convertimos edad a String
    }

    public Persona asObject() {
        return this; // o la lógica que necesites
    }
}
