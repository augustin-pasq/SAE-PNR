package controleur;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import modele.donnee.UseDatabase;

public class ConsultLoutreObsControler extends InteractivePage {

    @FXML
    private Label nom;
    @FXML
    private Label prenom;
    @FXML
    private Label date;
    @FXML
    private Label heure;
    @FXML
    private Label coordX;
    @FXML
    private Label coordY;
    @FXML
    private Label commune;
    @FXML
    private Label lieudit;
    @FXML
    private Label indice;
    private ArrayList<String> observation;
    private String espece;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle);

        setEspece("Loutre");
        setObs(756);

        nom.setText(observation.get(4));
        prenom.setText(observation.get(5));
        date.setText(observation.get(6));
        heure.setText(observation.get(7));
        coordX.setText(observation.get(8));
        coordY.setText(observation.get(9));
        commune.setText(observation.get(1));
        lieudit.setText(observation.get(2));
        indice.setText(observation.get(3));
    }

    public void setObs(int numObs) {
        this.observation = UseDatabase.selectQuery("SELECT * FROM vue_allFrom" + this.espece + " WHERE ObsL = " + numObs + ";").get(1);
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }
}
