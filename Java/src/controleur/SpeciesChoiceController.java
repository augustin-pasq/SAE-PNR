package controleur;

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
        goTo(event, "Batracien");
    }

    @FXML
    private void consultChouetteObs (ActionEvent event) {
        goTo(event, "Chouette");
    }

    @FXML
    private void consultGCIObs (ActionEvent event) {
        goTo(event, "GCI");
    }

    @FXML
    private void consultHippocampeObs (ActionEvent event) {
        goTo(event, "Hippocampe");
    }

    @FXML
    private void consultLoutreObs (ActionEvent event) {
        goTo(event, "Loutre");
    }

    private void goTo(ActionEvent event, String name) {
        Button target = (Button) event.getSource();
        Data data = (Data) target.getScene().getUserData();

        String suffix = data.get(0).equals("Data") ? name : "";
        Data newData = new Data(data.get(0), name);

        ObservationChoiceController occ = new ObservationChoiceController();
        occ.setEspece(name);
        Main.switchScene(data.get(0) + suffix, this.homeButton, newData);
    }
}
