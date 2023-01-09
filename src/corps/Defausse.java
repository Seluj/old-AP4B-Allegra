package corps;

public class Defausse {

    // ---------------------- ATTRIBUTES ---------------------- //

    private Carte defausse;


    // ---------------------- CONSTRUCTOR ---------------------- //

    public Defausse() {
        this.defausse = new Carte();
    }


    // ---------------------- ACCESS Methods ---------------------- //

    // Get the card on the discard pile
    public Carte getDefausse() {
        return defausse;
    }

    // Set the card on the discard pile
    public void setDefausse(Carte defausse) {
        this.defausse = defausse;
    }
}
