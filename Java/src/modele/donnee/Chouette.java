package modele.donnee;

import java.util.ArrayList;

/**
 * Class representing an owl
 *
 * @author Groupe PNR 1D1
 */
public class Chouette implements IObs<ObsChouette> {
    /**
     * Sex of the owl
     */
    private Sexe sexe;
    /**
     * The species of the owl
     */
    private EspeceChouette espece;
    /**
     * The id of the owl
     */
    private String idChouette;
    /**
     * The list of the owl's observations
     */
    private ArrayList<ObsChouette> lesObservations;

    /**
     * Constructor for the class Chouette
     *
     * @param id      owl identifier
     * @param leSexe  owl sex
     * @param lEspece owl species
     */
    public Chouette(String id, Sexe leSexe, EspeceChouette lEspece) {
        this.setIdChouette(id);
        this.setSexe(leSexe);
        this.setEspece(lEspece);
        this.lesObservations = new ArrayList<ObsChouette>();
    }

    /**
     * Getter for the owl's sex
     *
     * @return the owl's sex
     */
    public Sexe getSexe() {
        return sexe;
    }

    /**
     * Getter for the owl's species
     *
     * @return the owl's species
     */
    public EspeceChouette getEspece() {
        return espece;
    }

    /**
     * Getter for the owl's id
     *
     * @return the owl's id
     */
    public String getIdChouette() {
        return idChouette;
    }

    /**
     * Getter for the owl's list of observations
     *
     * @return list of observations
     */
    public ArrayList<ObsChouette> getLesObservations() {
        return lesObservations;
    }

    /**
     * Setter for the owl's sex
     *
     * @param sexe the owl's sex
     * @throws NullPointerException if the sex is null
     */
    public void setSexe(Sexe sexe) throws NullPointerException {
        if (sexe == null) throw new NullPointerException("Sexe can't be null");
        else this.sexe = sexe;
    }

    /**
     * Setter for the species
     *
     * @param espece the species
     * @throws NullPointerException if the species is null
     */
    public void setEspece(EspeceChouette espece) throws NullPointerException {
        if (espece == null) throw new NullPointerException("Espece can't be null");
        else this.espece = espece;
    }

    /**
     * Setter for the id
     *
     * @param idChouette the new id
     * @throws NullPointerException if the id is null
     */
    public void setIdChouette(String idChouette) throws NullPointerException {
        if (idChouette == null) throw new NullPointerException("Id can't be null");
        else this.idChouette = idChouette;
    }

    /**
     * Setter for the list of observations
     *
     * @param lesObservations the list of observations
     * @throws NullPointerException if the list is null
     */
    public void setLesObservations(ArrayList<ObsChouette> lesObservations) throws NullPointerException {
        if (lesObservations == null) throw new NullPointerException("Observations can't be null");
        else this.lesObservations = lesObservations;
    }

    /**
     * Add an observation to the list of observations
     *
     * @param obs the observation to add
     * @see modele.donnee.IObs
     */
    public void ajouterUneObs(ObsChouette obs) {
        if (obs == null) throw new NullPointerException("Observation can't be null");
        else this.lesObservations.add(obs);
    }

    /**
     * Add several observations to the list of observations
     *
     * @param obs the list of observations to add
     * @see modele.donnee.IObs#ajouterPlsObs(ArrayList)
     */
    public void ajouterPlsObs(ArrayList<ObsChouette> obs) {
        if (obs == null || obs.size() == 0)
            throw new NullPointerException("List of observations can't be null or empty");
        else this.lesObservations.addAll(obs);
    }

    /**
     * Remove all observations from the list of observations
     *
     * @see modele.donnee.IObs#videObs()
     */
    public void videObs() {
        this.lesObservations.clear();
    }

    /**
     * Remove an observation from the list of observations
     *
     * @param idObs the id of the observation to remove
     * @see modele.donnee.IObs#retireObs(int)
     */
    public boolean retireObs(int idObs) {
        try {
            this.lesObservations.remove(idObs);
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    /**
     * Get the number of observations
     *
     * @see modele.donnee.IObs#nbObs()
     */
    public int nbObs() {
        return this.lesObservations.size();
    }

    /**
     * Format the object to a string
     *
     * @return the object as a string
     */
    public String toString() {
        return "Chouette " + this.getIdChouette() + " : " + this.getEspece() + " " + this.getSexe() + " " + this.getLesObservations();
    }
}