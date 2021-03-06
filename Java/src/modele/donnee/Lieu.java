package modele.donnee;

/**
 * Class representing a place
 *
 * @author Groupe SAE PNR 1D1
 */
public class Lieu {

    /**
     * The x lambert coordinate of the observation
     */
    private double xCoord;

    /**
     * The y lambert coordinate of the observation
     */
    private double yCoord;

    /**
     * Constructor for the class Lieu
     *
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Lieu(double x, double y) throws IllegalArgumentException {
        this.setXCoord(x);
        this.setYCoord(y);
    }

    /**
     * Getter for the x coordinate
     *
     * @return the x coordinate
     */
    public double getXCoord() {
        return xCoord;
    }

    /**
     * Getter for the y coordinate
     *
     * @return the y coordinate
     */
    public double getYCoord() {
        return yCoord;
    }

    /**
     * Setter for the x coordinate
     *
     * @param x the x coordinate
     */
    public void setXCoord(double x) throws IllegalArgumentException {
        if (x < 0 || x > 1300000) throw new IllegalArgumentException("X coordinate is out of range");
        else this.xCoord = x;
    }

    /**
     * Setter for the y coordinate
     *
     * @param y the y coordinate
     */
    public void setYCoord(double y) throws IllegalArgumentException {
        if (y < 6000000 || y > 7200000) throw new IllegalArgumentException("Y coordinate is out of range");
        else this.yCoord = y;
    }

    /**
     * Format the coordinates in a string
     * @return the coordinates as a string
     */
    public String toString() {
        return "Lieu{" + this.getXCoord() + ", " + this.getYCoord() + "}";
    }
}