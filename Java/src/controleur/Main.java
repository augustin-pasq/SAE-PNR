package controleur;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Popup;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

/**
 * Entrypoint for the application
 *
 * @author Groupe SAE PNR 1D1
 */
public class Main extends Application implements Initializable {
    public static final Main instance = new Main();
    public ArrayList<String> prevScene = new ArrayList<>(Collections.singleton("Login"));
    private String currScene = "Login";

    /**
     * Entrypoint for the application
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Switch the current scene to a new one
     *
     * @param name   the name of the new scene
     * @param target An element belonging to the current scene
     */
    public static void switchScene(@NotNull String name, @NotNull Control target) {
        Stage appStage = (Stage) target.getScene().getWindow();
        Main main = new Main();
        try {
            Scene scene = main.loadScene(name);
            appStage.setScene(scene);

            if (Main.instance.prevScene.size() > 15) {
                Main.instance.prevScene.remove(0);
            }
            Main.instance.prevScene.add(Main.instance.currScene);
            Main.instance.currScene = name;
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    /**
     * Switch the current scene to a new one
     *
     * @param name  the name of the new scene
     * @param event the event that triggered the switch
     */
    public static void switchScene(@NotNull String name, @NotNull Event event) {
        Button target = (Button) event.getSource();
        switchScene(name, target);
    }

    /**
     * Go back to the previous scene
     *
     * @param event the event that triggered the method
     */
    public static void goBack(@NotNull Event event) {
        if (Main.instance.prevScene.size() > 1) {
            int lastIndex = Main.instance.prevScene.size() - 1;
            switchScene(Main.instance.prevScene.get(lastIndex), event);
            lastIndex = Main.instance.prevScene.size() - 1;
            Main.instance.prevScene.remove(lastIndex);
            Main.instance.prevScene.remove(--lastIndex);
        }
    }

    /**
     * Display a popup with a message
     *
     * @param message the message to display
     * @param event   the event that triggered the method
     * @return the popup
     */
    public static Popup showPopup(String message, Event event) {
        Control target = (Control) event.getSource();
        return showPopup(message, target);
    }

    /**
     * Display a popup with a message
     *
     * @param message the message to display
     * @param target  An element belonging to the current scene
     * @return the popup
     */
    public static Popup showPopup(String message, Control target) {
        Stage appStage = (Stage) target.getScene().getWindow();
        Popup popup = new Popup();
        VBox vbox = new VBox();

        Label label = new Label(message);
        label.setMinWidth(80);
        label.setMinHeight(50);
        label.setAlignment(Pos.CENTER);
        label.setFont(new Font("DejaVu Sans Bold", 20));

        Button okButton = new Button("OK");
        okButton.setOnAction(event ->
                popup.hide()
        );
        okButton.setStyle("-fx-background-color: #00936E;" +
                "-fx-background-radius: 30px;" +
                "-fx-text-fill: white;" +
                "-fx-cursor: hand;");
        okButton.setFont(new Font("Berlin Sans FB", 20));

        vbox.getChildren().addAll(label, okButton);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        vbox.setStyle("-fx-border-color: black;" +
                "-fx-border-width: 2px;" +
                "-fx-border-radius: 5px;" +
                "-fx-background-color: white;");
        vbox.setPrefSize(600, 300);

        popup.getContent().add(vbox);
        popup.setAutoHide(true);
        popup.setAutoFix(true);
        popup.show(appStage);
        return popup;
    }

    /**
     * Start the application with the Login Screen
     *
     * @param primaryStage the primary stage
     * @throws IOException if the application fails to start
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        Scene scene = loadScene("Login");
        // primaryStage.getIcons().setAll(new Image(getClass().getResource("@../../../../data/Logo_PNR.png").toExternalForm())); // Application logo
        primaryStage.setScene(scene);
        //primaryStage.setFullScreen(true);
        primaryStage.setTitle("PNR");
        primaryStage.show();
    }

    /**
     * Inherited form Initializable
     *
     * @see javafx.fxml.Initializable
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    /**
     * Load a scene from a FXML file
     *
     * @param name the name of the scene
     */
    private Scene loadScene(@NotNull String name) throws IOException {
        System.out.println("Loading scene " + name);
        // Load FXML file
        URL pathFXML = getClass().getResource("../vue/" + name + ".fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(pathFXML);
        AnchorPane root = fxmlLoader.load();

        // Add the stylesheet of the page
        Scene scene = new Scene(root);
        URL pathCSS = getClass().getResource("../vue/Style" + name + ".css");
        scene.getStylesheets().addAll(pathCSS.toExternalForm());

        return scene;
    }
}