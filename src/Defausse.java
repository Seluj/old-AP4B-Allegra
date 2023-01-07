public class Defausse {

    // Attributes
    private Carte defausse = new Carte();


    // Constructor
    public Defausse() {
        this.defausse = new Carte();
    }

    // Getters and setters

    // Get the card on the discard pile
    public Carte getDefausse() {
        return defausse;
    }

    // Set the card on the discard pile
    public void setDefausse(Carte defausse) {
        this.defausse = defausse;
    }
}
