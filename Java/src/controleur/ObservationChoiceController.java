package controleur;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import modele.donnee.UseDatabase;
import org.jetbrains.annotations.NotNull;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ObservationChoiceController extends InteractivePage {

    @FXML
    private VBox scrollPaneContainer;

    private ArrayList<ArrayList<String>> allObservations;

    private String espece;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle);

        setEspece("Loutre");
        setAllObservations();
        VBox observationsContainer = new VBox(10);
        for (int i = 1; i < allObservations.size(); i++) {
            Button obs = createButton(allObservations.get(i));
            observationsContainer.getChildren().add(obs);
        }

        ScrollPane scrollPane = new ScrollPane(observationsContainer);
        scrollPaneContainer.getChildren().add(scrollPane);
    }

    public void setAllObservations() {
        allObservations = UseDatabase.selectQuery("SELECT * FROM vue_allFrom" + this.espece);
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    private Button createButton(@NotNull ArrayList<String> observation) {
        Button button = new Button((observation.get(observation.size() - 4) + "   -   " + observation.get(observation.size() - 3) + "   -   " + observation.get(observation.size() - 2) + "   -   " + observation.get(observation.size() - 1) + "   -   " + observation.get(observation.size() - 5) + "   -   " + observation.get(observation.size() - 6)).toUpperCase());
        button.setFont(new Font("DejaVu Sans Bold", 20));
        button.setAlignment(Pos.CENTER);
        button.setContentDisplay(ContentDisplay.CENTER);
        button.setTextAlignment(TextAlignment.CENTER);
        button.setPrefWidth(1225);
        button.setPrefHeight(76);
        button.setMnemonicParsing(false);
        button.setId("observation");
        button.setOnAction(e -> {

            Main.switchScene("Consult" + this.espece + "Obs", button);
        });
        return button;
    }
}
