public class Joueur {
    private final String nom;
    private int score;
    private final Plateau plateau;

    /**
     * Default constructor
     */
    public Joueur() {
        nom = "Joueur";
        score = 0;
        plateau = new Plateau();
    }

    /**
     * Constructor with name of the player
     * @param nom name of the player
     */
    public Joueur(String nom) {
        this.nom = nom;
        score = 0;
        plateau = new Plateau();
    }

    /**
     * Constuctor with a given name and a draw pile to make his game
     * @param nom name of the player
     * @param p Draw pile
     */
    public Joueur(String nom, Pioche p) {
        this.nom = nom;
        score = 0;
        plateau = new Plateau(p);
    }


    /**
     * Increment score of the player when he win
     */
    public void incrementScore() {
        score++;
    }

    // ---------------------- ACCESS Function ---------------------- //
    // All of these function will transfer data to the view part     //

    /**
     * Access to the name of the player
     * @return name of the player
     */
    public String getNom() {
        return nom;
    }

    /**
     * Access to the score of the player
     * @return score of the player
     */
    public int getScore() {
        return score;
    }

    /**
     * Access to the game of the player
     * @return game of the player
     */
    public Plateau getPlateau() {
        return plateau;
    }

}
