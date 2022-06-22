package controleur;

import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Controller for the SpeciesChoice page
 *
 * @author Groupe SAE PNR 1D1
 */
public class SpeciesChoiceController extends InteractivePage {

    @FXML
    private Button consultObsBatracienButton;

    @FXML
    private Button consultObsChouetteButton;

    @FXML
    private Button consultObsGCIButton;

    @FXML
    private Button consultObsHippocampeButton;

    @FXML
    private Button consultObsLoutreButton;

    @FXML
    private void consultBatracienObs (ActionEvent event) {
        ObservationChoiceController.setAllObservations("Batracien");
        Main.switchScene("ObservationChoice", consultObsBatracienButton);
    }

    @FXML
    private void consultChouetteObs (ActionEvent event) {
        ObservationChoiceController.setAllObservations("Chouette");
        Main.switchScene("ObservationChoice", consultObsChouetteButton);
    }

    @FXML
    private void consultGCIObs (ActionEvent event) {
        ObservationChoiceController.setAllObservations("GCI");
        Main.switchScene("ObservationChoice", consultObsGCIButton);
    }

    @FXML
    private void consultHippocampeObs (ActionEvent event) {
        ObservationChoiceController.setAllObservations("Hippocampe");
        Main.switchScene("ObservationChoice", consultObsHippocampeButton);
    }

    @FXML
    private void consultLoutreObs (ActionEvent event) {
        ObservationChoiceController.setAllObservations("Loutre");
        Main.switchScene("ObservationChoice", consultObsLoutreButton);
    }
}
