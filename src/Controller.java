public class Controller {
    private int nbJoueurs;
    Menu menu = new Menu();
    Jeu jeu = new Jeu();
    Fenetre f = new Fenetre(menu, jeu);
    Pioche p = new Pioche();
    Joueur[] listJoueurs;

    public Controller() {
        System.out.println(p);
        do {
            System.out.print("");
        } while ((nbJoueurs = menu.getJoueurs()) == 0);
        //Initialise the game
        init();
        printGame(0);

    }

    private void init(){
        //Allocate list size
        listJoueurs = new Joueur[nbJoueurs];
        //Initialising each player
        for (int i=0; i < nbJoueurs; i++){
            listJoueurs[i] = new Joueur("j"+i,p);
        }
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
