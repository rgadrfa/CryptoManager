package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.Objects;

public class CryptoApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/main-view.fxml")));

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Мое приложение");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
