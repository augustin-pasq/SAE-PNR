package vue;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;

public class Login extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load FXML file
        URL pathFXML = getClass().getResource(getClass().getSimpleName() + ".fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(pathFXML);
        AnchorPane root = (AnchorPane) fxmlLoader.load();

        Scene scene = new Scene(root, 600, 550);
        scene.getStylesheets().addAll(this.getClass().getResource("StyleLogin.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
