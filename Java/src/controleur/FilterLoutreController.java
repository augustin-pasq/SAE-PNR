package controleur;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * Controller for the FilterLoutre page
 */
public class FilterLoutreController extends InteractivePage {

    /**
     * The animal value
     */
    private final String ANIMAL = "Loutre";

    /**
     * The indication list
     */
    ObservableList<String> indiceList = FXCollections.observableArrayList("Positif", "Négatif", "Non prospection");

    /**
     * The last name of the observer
     */
    @FXML
    private TextField lastNameField;

    /**
     * The first name of the observer
     */
    @FXML
    private TextField firstNameField;

    /**
     * The date of the observation
     */
    @FXML
    private DatePicker dateField;

     /**
     * The time of the observation
     */
    @FXML
    private TextField timeField;

    /**
     * The X Lambert93 coordinates of the observation
     */
    @FXML
    private TextField lambertXField;

    /**
     * The Y Lambert93 coordinates of the observation
     */
    @FXML
    private TextField lambertYField;

    /**
     * The village where the otter is observed
     */
    @FXML
    private TextField communeField;

    /**
     * The hamlet where the otter is observed
     */
    @FXML
    private TextField lieuDitField;

    /**
     * Indicates if the index is positive, negative or not determined
     */
    @FXML
    private ComboBox<String> indiceComboBox;

    /**
     * The observation to display
     */
    @FXML
    private Button validateButton;

    /**
     * Inherited method from Initializable
     * @see javafx.fxml.Initializable
     */
    @Override
    public void initialize(URL url, ResourceBundle ressourceBundle) {
        super.initialize(url, ressourceBundle);
        indiceComboBox.setItems(indiceList);
    }

    /**
     * Filter the select query
     * 
     * @param event the event that triggered the method
     */
    @FXML
    public void filter(ActionEvent event) {

        // Init //
        String lastName = lastNameField.getText().toUpperCase();
        String firstName = firstNameField.getText().toUpperCase();
        LocalDate date = dateField.getValue();
        String time = timeField.getText();
        String lambertX = lambertXField.getText();
        String lambertY = lambertYField.getText();
        String commune = communeField.getText();
        String lieuDit = lieuDitField.getText();
        String indice = indiceComboBox.getValue();

        //

        try {
            // Check the validity of the data
            checkFields(lastName, firstName, date, time, lambertX, lambertY, commune, lieuDit);
            HashMap<Object, String> filter = new HashMap<>();
            this.initFilter(filter, lastName, firstName, date, time, lambertX, lambertY, commune, lieuDit, indice);
            String restriction = this.makeRestriction(filter);

            Data userData = (Data) this.homeButton.getScene().getUserData();
            Data data = new Data(userData.get(0), ANIMAL, restriction);
            data.setAdmin(userData.isAdmin());
            ObservationChoiceController.setAllObservations(ANIMAL, restriction);
            Main.switchScene("ObservationChoice", this.validateButton, data);

        } catch (IllegalArgumentException e) {
            // If one of the fields is invalid, show a popup with the error message
            Main.showPopup(e.getMessage(), event, true);
        }
    }


    /**
     * Check if all fields are valid
     *
     * @param lastName last name of the observer
     * @param firstName first name of the observer
     * @param date date of the observation
     * @param time time of the observation
     * @param lambertX lambert X coordinate of the observation
     * @param lambertY lambert Y coordinate of the observation
     * @param commune village where the otter is observed
     * @param lieuDit hamlet where the otter is observed
     * @throws IllegalArgumentException if one of the fields is invalid, with a detailed message
     */
    private void checkFields(String lastName, String firstName, LocalDate date, String time, String lambertX, String lambertY, String commune, String lieuDit) throws IllegalArgumentException {
        if (!lastName.matches("[a-zA-Z\\-éèàçëê\\ ]+") && !lastName.isEmpty())
            throw new IllegalArgumentException("Le nom ne peut pas être vide et ne doit contenir que des lettres, espaces et tirets");

        if (!firstName.matches("[a-zA-Z\\-éèàçëê\\ ]+") && !firstName.isEmpty())
            throw new IllegalArgumentException("Le prénom ne peut pas être vide et ne doit contenir que des lettres, espaces et tirets");

        if (time != null && !time.isEmpty()) {
            if (!time.matches("\\d{2}:\\d{2}"))
                throw new IllegalArgumentException("L'heure doit être au format hh:mm");
            else {
                String[] timeSplit = time.split(":");
                int h = Integer.parseInt(timeSplit[0]);
                int m = Integer.parseInt(timeSplit[1]);
                if (!(0 <= h && h < 24 && 0 <= m && m < 60))
                    throw new IllegalArgumentException("L'heure doit être valide");

            }
        }

        if (!lambertX.isEmpty()) {
            if (!lambertX.matches("\\d+(\\.\\d+)?"))
                throw new IllegalArgumentException("La coordonnée ne peut pas être vide et Lambert X doit être un nombre");

            float lambertXInt = Float.parseFloat(lambertX);
            if (0 > lambertXInt || lambertXInt > 1300000)
                throw new IllegalArgumentException("La coordonnée Lambert X doit être comprise entre 0 et 1300000");
        }

        if (!lambertY.isEmpty()) {
            if (!lambertY.matches("\\d+(\\.\\d+)?"))
                throw new IllegalArgumentException("La coordonnée ne peut pas être vide et Lambert Y doit être un nombre");

            float lambertYInt = Float.parseFloat(lambertY);
            if (lambertYInt < 6000000 || lambertYInt > 7200000)
                throw new IllegalArgumentException("La coordonnée Lambert Y doit être comprise entre 6000000 et 7200000");

        }

        if (!commune.matches("[a-zA-Z\\-éèàçëê\\ ]+") && !commune.isEmpty())
            throw new IllegalArgumentException("La commune ne peut pas être vide et ne doit contenir que des lettres, espaces et tirets");

        if (!lieuDit.matches("[a-zA-Z\\-éèàçëê\\ ]+") && !lieuDit.isEmpty())
            throw new IllegalArgumentException("Le lieu ne peut pas être vide et dit ne doit contenir que des lettres, espaces et tirets");
    }

    /**
     * Initialize the filter with the data entered by the user
     *
     * @param filter the filter to initialize
     * @param lastName last name of the observer
     * @param firstName first name of the observer
     * @param date date of the observation
     * @param time time of the observation
     * @param lambertX lambert X coordinate of the observation
     * @param lambertY lambert Y coordinate of the observation
     * @param commune village of the observation
     * @param lieuDit hamlet of the observation
     * @param indice index of the observation
     */
    private void initFilter(HashMap<Object, String> filter, String lastName, String firstName, LocalDate date, String time, String lambertX, String lambertY, String commune, String lieuDit, String indice) {
        filter.put(lastName, "nom");
        filter.put(firstName, "prenom");
        filter.put(date, "dateObs");
        filter.put(time, "heureObs");
        filter.put(lambertX, "lieu_Lambert_X");
        filter.put(lambertY, "lieu_Lambert_Y");
        filter.put(commune, "commune");
        filter.put(lieuDit, "lieuDit");
        filter.put(indice, "indice");
    }

    /**
     * Edit the select query to get data from the database
     * 
     * @param filter the filter containing the values of the fields with the associated database column names.
     * @return the end of the query, corresponding to the restriction of a query.
     */
    private String makeRestriction(HashMap<Object, String> filter) {
        String query = "";
        int nbRestriction = 0;

        for (Object o : filter.keySet()) {
            if (!(o == null)) {
                String value = o.toString();
                if (!value.equals("")) {
                    if (nbRestriction > 0) {
                        query = query + " AND " + filter.get(o) + " =\"" + value + "\"";
                    } else {
                        query = query + " WHERE " + filter.get(o) + " =\"" + value + "\"";
                    }
                    nbRestriction++;
                }
            }
        }
        return query;
    }
}
