package applications.Tarea4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utilities.Paths;

public class Tarea4 extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            AnchorPane load = FXMLLoader.load(getClass().getResource(Paths.TAREA4));
            Scene scene = new Scene(load);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Gestión de Personas");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}