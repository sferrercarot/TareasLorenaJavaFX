package applications;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utilities.Paths;

public class Tarea1 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane load = FXMLLoader.load(getClass().getResource(Paths.TAREA1));
        Scene scene = new Scene(load);
        primaryStage.setTitle("Calculadora Suma");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}