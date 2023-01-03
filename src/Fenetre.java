import javax.swing.*;
import java.awt.*;


public class Fenetre implements Base {
    int width = 1280;
    int height = 720;


    public Fenetre() {
        frame.setTitle("Jeu de la vie");
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel menu = new Menu();


        JPanel jeu = new Jeu();

        frame.getContentPane().add(BorderLayout.NORTH, new MenuBar(frame));


        cards.setLayout(new CardLayout());
        cards.add(jeu, "jeu");
        cards.add(menu, "menu");
        frame.add(BorderLayout.CENTER, cards);

        frame.setVisible(true);
    }
}
