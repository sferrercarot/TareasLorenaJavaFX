package applications;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utilities.Paths;

import java.io.IOException;

public class Tarea2 extends Application {
        @Override
        public void start(Stage primaryStage) {
            try {
                AnchorPane load = FXMLLoader.load(getClass().getResource(Paths.TAREA2));
                Scene scene = new Scene(load);
                primaryStage.setTitle("Calculadora JavaFX");
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            launch(args);
        }
    }
