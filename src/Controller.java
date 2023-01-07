import javax.swing.*;

public class Controller {
    private int nbJoueurs;
    Menu menu = new Menu();
    Jeu jeu;
    Fenetre f = new Fenetre(menu);
    Pioche p = new Pioche();
    Joueur[] listJoueurs;

    public Controller() {

        System.out.println(p);

        // Loop to get the number of players and wait for the game to be ready
        do {
            // Temporary variable to store the number of players
            int tmp;

            // Loop until the number of players is valid
            do {
                System.out.print("");
            } while ((tmp = menu.getJoueurs()) == 0);

            // Test if the temporary variable is different to the number of players
            // then update the number of players and initialize the game
            if (tmp != nbJoueurs) {
                nbJoueurs = tmp;
                init();
            }
        } while (!menu.isGameReady());

        // Print the cards of the players by starting from the first player (player 0)
        printGame(0);

    }

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

}
