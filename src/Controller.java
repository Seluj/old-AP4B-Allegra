import javax.swing.*;
import java.awt.*;

public class Controller implements Base{
    private int nbJoueurs;
    Menu menu = new Menu();
    Jeu jeu;
    Fenetre f = new Fenetre(menu);
    Pioche p = new Pioche();
    Joueur[] listJoueurs;
    //Int to keep track of if a player has turned all of his cards, therefore initialising the last round
    int cartesRet = 6; //we initialise on 6 because the last player number is 5
    //Int indicating the winner of the game [you must win 3 rounds to win the game]
    int winner = 6; //we initialise on 6 because the last player number is 5


    public Controller() {
        System.out.println(p);
        // Loop to get the number of players and wait for the game to be ready
        do {
            System.out.print("");
        } while ((nbJoueurs = menu.getJoueurs()) == 0);
        init();
        //Changes JPanel to "Jeu"
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "jeu");
        frame.setSize(jeuWidth, jeuHeight);
        frame.setLocationRelativeTo(null);
        // Print the cards of the players by starting from the first player (player 0)
        printGame(0);
    }

    /**
     * Function used to initialise the players and the game once the user has selected the number of players
     */
    private void init(){
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
            System.out.println("boucle printGame"+i);
            jeu.printCard(this.listJoueurs[j%nbJoueurs].getPlateau(), i);
            j++;
        }
        jeu.revalidate();
    }

    /**
     * Checks the different players to see if one of them has won three rounds
     * @return true if a player has won, false if no player has won yet
     */
    private boolean checkWinner(){
        int i = 0;
        while (i < nbJoueurs && winner == 6){
            if (listJoueurs[i].getScore() == 3){
                winner = i;
            }
            i++;
        }
        return winner != 6;
    }


}
