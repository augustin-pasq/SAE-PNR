package modele.donnee;

import java.util.ArrayList;
import java.sql.Date;

/**
 * Class to represent a GCI nest
 */
public class NidGCI implements IObs<ObsGCI> {
    
    /**
     * The list of observations of this GCI nest
     */
    private ArrayList<ObsGCI> lesObservations;
    /**
     * The id of the GCI nest
     */
    private int idNid;
    /**
     * The number of nest flies
     */
    private int nbEnvol;
    /**
     * The name of the beach the nest is on
     */
    private String nomPlage;

    /**
     * Constructor for the NidGCI class
     *
     * @param id    the id of the nest
     * @param plage the name of the beach
     */
    public NidGCI(int id, String plage) throws NullPointerException {
        this.setIdNid(id);
        this.setNomPlage(plage);
        this.setNbEnvol(0);
        this.setLesObservations(new ArrayList<ObsGCI>());
    }

    /**
     * Getter for the id of the GCI nest
     *
     * @return the id of the GCI nest
     */
    public int getIdNid() {
        return this.idNid;
    }

    /**
     * Getter for the number of nest flies
     *
     * @return the number of nest flies
     */
    public int getNbEnvol() {
        return this.nbEnvol;
    }

    /**
     * Getter for the name of the beach the nest is on
     *
     * @return the name of the beach the nest is on
     */
    public String getNomPlage() {
        return this.nomPlage;
    }

    /**
     * Getter for the list of observations of this GCI nest
     *
     * @return the list of observers
     */
    public ArrayList<ObsGCI> getLesObservateurs() {
        return this.lesObservations;
    }

    /**
     * Setter for the id of the GCI nest
     *
     * @param id the new id of the GCI nest
     */
    public void setIdNid(int id) throws IllegalArgumentException {
        if (id < 0) throw new IllegalArgumentException("ID can't be negative");
        else this.idNid = id;
    }

    /**
     * Setter for the number of nest flies
     *
     * @param nb the new number of nest flies
     */
    public void setNbEnvol(int nb) throws IllegalArgumentException {
        if (nb < 0) throw new IllegalArgumentException("ID can't be negative");
        else this.nbEnvol = nb;
    }

    /**
     * Setter for the name of the beach the nest is on
     *
     * @param nom the new name of the beach
     */
    public void setNomPlage(String nom) throws NullPointerException {
        if (nom == null || nom.isEmpty()) throw new NullPointerException("Nom can't be null or empty");
        else this.nomPlage = nom;
    }

    /**
     * Setter for the list of observations of this GCI nest
     * @param lesObs the new list of observations
     * @throws NullPointerException if the list of observations is null
     */
    private void setLesObservations(ArrayList<ObsGCI> lesObs) throws NullPointerException {
        if (lesObs == null) throw new NullPointerException("Observations is null");
        else this.lesObservations = new ArrayList<ObsGCI>(lesObs);
    }


    /**
     * Get the first observation date for this GCI nest
     *
     * @return the first observation date
     */
    public Date dateDebutObs() {
        return this.lesObservations.get(0).getDate();
    }

    /**
     * Get the last observation date for this GCI nest
     *
     * @return the last observation date
     */
    public Date dateFinObs() {
        return this.lesObservations.get(this.lesObservations.size() - 1).getDate();
    }

    /**
     * Add an observation to the list of observers of this GCI nest
     *
     * @param obs the observer to add
     */
    public void ajouterUneObs(ObsGCI obs) {
        if (obs == null) throw new NullPointerException("Observation can't be null");
        else this.lesObservations.add(obs);
    }

    /**
     * Add several observations to the list of observations of this GCI nest
     *
     * @param obs the observers to add
     */
    public void ajouterPlsObs(ArrayList<ObsGCI> obs) {
        if (obs == null) throw new NullPointerException("Observations can't be null");
        else this.lesObservations.addAll(obs);
    }

    /**
     * Remove all the observations of this GCI nest
     */
    public void videObs() {
        this.lesObservations.clear();
    }

    /**
     * Remove an observation from the list of observations of this GCI nest
     *
     * @param idObs the id of the observation to remove
     * @return true if the observation was removed, false otherwise
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
     * Get the number of observations for this GCI nest
     *
     * @return the number of observations
     */
    public int nbObs() {
        return this.lesObservations.size();
    }
}