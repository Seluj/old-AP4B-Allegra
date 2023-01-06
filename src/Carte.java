public class Carte {

    // Attributes
    private int credits; // Number of credits on the card

    // Constructor
    public Carte() {
        this.credits = -2;
    }

    // Constructor
    public Carte(int nb) {
        this.credits = nb;
    }

    // Getters and setters

    // Get the number of credits on the card
    public int getCredits() {
        return credits;
    }

    // Set the number of credits on the card
    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "" + credits;
    }
}
