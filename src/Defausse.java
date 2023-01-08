public class Defausse {

    // ---------------------- ATTRIBUTES ---------------------- //

    private Carte defausse = new Carte();


    // ---------------------- CONSTRUCTOR ---------------------- //

    public Defausse() {
        this.defausse = new Carte();
    }


    // ---------------------- ACCESS Function ---------------------- //

    // Get the card on the discard pile
    public Carte getDefausse() {
        return defausse;
    }

    // Set the card on the discard pile
    public void setDefausse(Carte defausse) {
        this.defausse = defausse;
    }
}
