package vue;

import controleur.Main;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login extends Application implements Initializable {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load FXML file
        URL pathFXML = getClass().getResource("Login.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(pathFXML);
        AnchorPane root = (AnchorPane) fxmlLoader.load();

        // Add the stylesheet of the page
        Scene scene = new Scene(root);
        URL pathCSS = getClass().getResource("StyleLogin.css");
        scene.getStylesheets().addAll(pathCSS.toExternalForm());

        // primaryStage.getIcons().setAll(new Image(getClass().getResource("@../../../../data/Logo_PNR.png").toExternalForm())); // Application logo 
        primaryStage.setScene(scene);
        //primaryStage.setFullScreen(true); 
        primaryStage.setTitle("PNR");
        primaryStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public static void switchScene(String name, ActionEvent event) {
        Button target = (Button) event.getSource();
        Stage appStage = (Stage) target.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(Main.class.getResource("@../vue/" + name + ".fxml"));
            Scene scene = new Scene(root);
            appStage.setScene(scene);
            appStage.show();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}