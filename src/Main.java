public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        Jeu jeu = new Jeu();

        Fenetre f = new Fenetre(menu, jeu);
        Pioche p = new Pioche();
        System.out.println(p);
        Joueur j1 = new Joueur("Jules", p);
        jeu.printCard(j1.getPlateau(), 0);
        jeu.revalidate();
    }
}