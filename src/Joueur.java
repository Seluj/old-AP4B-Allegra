public class Joueur {


    // ---------------------- ATTRIBUTES ---------------------- //

    private final String nom;       // Player's name
    private int score;              // Player's score [number of rounds won]
    private final Plateau plateau;  // Player's board


    // ---------------------- CONSTRUCTOR ---------------------- //

    /**
     * Constuctor with a given name and a draw pile to make his game
     * @param nom name of the player
     * @param p Draw pile
     */
    public Joueur(String nom, Pioche p) {
        this.nom = nom;
        this.score = 0;
        this.plateau = new Plateau(p);
    }


    // ---------------------- ACCESS Function ---------------------- //

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

    /**
     * Increment score of the player when he wins
     */
    public void setScore(int score) {
        this.score = score;
    }


    // ---------------------- OTHER Function ---------------------- //

    /**
     * Calculates the score of the player for that round
     * @param joueur_suivant We also need the player on the left's cards
     * @return the total score of the player
     */
    public int roundScore(Joueur joueur_suivant) {
        int score = 0;

        for (int i = 0; i < 3; i++) {
            if(joueur_suivant.plateau.getCache(i,3) != 2){
                score += joueur_suivant.plateau.getCartes(i, 3);
            }

            for (int j = 0; j < 4; j++) {
                if(plateau.getCache(i,j) != 2){
                    score += plateau.getCartes(i,j);
                }
            }
        }
        return score;
    }

    /**
     * Checks if there are three aligned identical cards, if it is the case they are removed from the player's "plateau"
     */
    public void cartesAllign() {
        for (int i =0; i < 4; i++){
            plateau.getCartes(i,2);
        }

    }
}
