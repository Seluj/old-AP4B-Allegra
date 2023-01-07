import java.awt.*;

public class Controller implements Base{
    private int nbJoueurs;
    private final Menu menu = new Menu();
    private Jeu jeu;
    private final Fenetre f = new Fenetre(menu);
    private Pioche p;
    private Defausse d;
    private Joueur[] listJoueurs;
    //Int to keep track of if a player has turned all of his cards, therefore initialising the last round
    private int cartesRet = 6; //we initialise on 6 because the last player number is 5
    //Int indicating the winner of the game [you must win 3 rounds to win the game]
    private int winner = 6; //we initialise on 6 because the last player number is 5


    public Controller() {
        // Loop to get the number of players and wait for the game to be ready
        do {
            System.out.print("");
        } while ((nbJoueurs = menu.getJoueurs()) == 0);
        //A DEPLACER!!!! DANS LA BOUCLE CHECKWINNER
        init();
        System.out.println(p);
        //Changes JPanel to "Jeu"
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "jeu");
        frame.setSize(jeuWidth, jeuHeight);
        frame.setLocationRelativeTo(null);

        for(int i=0; i<nbJoueurs-1;i++){
            System.out.println("Score joueur " + i + " = " + listJoueurs[i].roundScore(listJoueurs[i+1]));
        }

        System.out.println(p);
        jeu.printDiscardPile(d);
        jeu.printRevealedDrawPile(p);
        jeu.printHiddenDrawPile();

        //Loop until the 3 rounds are over
        for (int i = 0; i < 3; i++){
            // We start the round so we start with the first player
            int joueur = 0;
            //Each players gets a turn to play.We loop until the round of the game is over [one player has turned all his cards]
            while(!listJoueurs[joueur].getPlateau().allRetourner()){
                printGame(joueur);
                //
                //We move on to the next player
                if(joueur == nbJoueurs-1){
                    joueur = 0;
                } else {
                    joueur++;
                }
            }
           // setScores(joueur);
        }
    }

    /**
     * Function used to initialise the players and the game once the user has selected the number of players
     */
    private void init(){
        p = new Pioche();
        d = new Defausse();
        //Allocate list size
        listJoueurs = new Joueur[nbJoueurs];
        //Initialising each player
        for (int i=0; i < nbJoueurs; i++){
            listJoueurs[i] = new Joueur("j"+i,p);
        }
        jeu = new Jeu(nbJoueurs);
        f.addPanel(jeu);
    }

    /**
     * Displays the different cards for each player depending on who's turn it is
     * @param j Indicates which player is the first to play
     */
    private void printGame(int j){
        for (int i=0; i < nbJoueurs; i++) {
            //System.out.println("boucle printGame"+i);
            jeu.printCard(this.listJoueurs[j%nbJoueurs].getPlateau(), i);
            j++;
        }
        jeu.revalidate();
    }

    /**
     * The user chooses to pick a card from the "Défausse"
     */
    private void actDefausse(){

    }

    /**
     * Compares everyone's number of credits at the end of the round of the game to award the victory to the correct player
     */
    private int playerLowestScore(){
        int joueur_min = 0, score;

        for(int i=0; i<nbJoueurs-1; i++){
            score = listJoueurs[i].roundScore(listJoueurs[i+1]);

            if(listJoueurs[joueur_min].roundScore(listJoueurs[joueur_min+1]) < score) {
                joueur_min = i;
            }
        }
        score = listJoueurs[nbJoueurs-1].roundScore(listJoueurs[0]);

        if(listJoueurs[joueur_min].roundScore(listJoueurs[joueur_min+1]) < score) {
            joueur_min = nbJoueurs-1;
        }

        System.out.println("Le gagnant de la manche est : " + listJoueurs[joueur_min]);

        return joueur_min;
    }
    private boolean shareLowestScore(){
        int playerScoreMin = playerLowestScore();
        int scoreMin = listJoueurs[playerScoreMin].getScore();

        for(int i=0; i<nbJoueurs; i++){
            if((listJoueurs[i].getScore() == scoreMin) && (playerScoreMin != i)){
                return true;
            }
        }
        return false;
    }
    private void setScores(int joueurFirstFinish){
        int playerScoreMin = playerLowestScore();

        for(int i=0; i<nbJoueurs-1; i++){
            listJoueurs[i].setScore(listJoueurs[i].roundScore(listJoueurs[i+1]));
        }
        listJoueurs[nbJoueurs-1].setScore(listJoueurs[nbJoueurs-1].roundScore(listJoueurs[0]));

        if(playerScoreMin != joueurFirstFinish || shareLowestScore()){
            listJoueurs[joueurFirstFinish].setScore(2*listJoueurs[joueurFirstFinish].getScore());
        }

    }

}
