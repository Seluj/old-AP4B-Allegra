package affichage;

import javax.swing.*;
import java.awt.*;


public class Fenetre {
    int width = 1280;
    int height = 720;

    JPanel cards; //a panel that uses CardLayout

    public Fenetre() {
        JFrame frame = new JFrame("A Windows");
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel menu = new Menu();


        JPanel jeu = new Jeu();

        frame.getContentPane().add(BorderLayout.NORTH, new MenuBar(frame));


        cards = new JPanel(new CardLayout());
        cards.add(jeu, "jeu");
        cards.add(menu, "menu");
        frame.add(BorderLayout.CENTER, cards);

        frame.setVisible(true);
    }
}
