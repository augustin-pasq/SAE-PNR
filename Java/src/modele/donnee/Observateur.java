package modele.donnee;

/**
 * Class to represent an observer
 *
 * @author Groupe PNR 1D1
 */
public class Observateur {
    /**
     * The id of the observer
     */
    private int idObservateur;
    /**
     * The name of the observer
     */
    private String nom;
    /**
     * The firstname of the observer
     */
    private String prenom;

    /**
     * Constructor of the class
     *
     * @param id       the id of the observer
     * @param leNom    the name of the observer
     * @param lePrenom the first name of the observer
     */
    public Observateur(int id, String leNom, String lePrenom) throws IllegalArgumentException,NullPointerException {
        this.setIdObservateur(id);
        this.setNom(leNom);
        this.setPrenom(lePrenom);
    }

    /**
     * Getter of the id of the observer
     * @return the id of the observer
     */
    public int getIdObservateur() {
        return idObservateur;
    }

    /**
     * Getter of the name of the observer
     * @return the name of the observer
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter of the first name of the observer
     * @return the first name of the observer
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Setter of the id of the observer
     * @param idObservateur the id of the observer
     */
    public void setIdObservateur(int idObservateur) throws IllegalArgumentException {
        if (idObservateur < 0) throw new IllegalArgumentException("Id can't be negative");
        else this.idObservateur = idObservateur;
    }

    /**
     * Setter of the name of the observer
     * @param nom the name of the observer
     */
    public void setNom(String nom) throws NullPointerException {
        if (nom == null) throw new NullPointerException("Nom can't be null");
        else this.nom = nom;
    }

    /**
     * Setter of the first name of the observer
     * @param prenom the first name of the observer
     */
    public void setPrenom(String prenom) throws NullPointerException {
        if (prenom == null) throw new NullPointerException("Prenom can't be null");
        else this.prenom = prenom;
    }

    public String toString() {
        return "Observateur{" + idObservateur + ", " + nom + ", " + prenom + '}';
    }
}