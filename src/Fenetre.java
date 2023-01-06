import javax.swing.*;
import java.awt.*;


public class Fenetre implements Base {

    /**
     * Build the window and panels to cardLayout
     * @param panels the panels to add to the cardLayout. Warning: Panels must have a name
     */
    public Fenetre(JPanel... panels) {
        frame.setTitle("Jeu de la vie");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.getContentPane().add(BorderLayout.NORTH, new MenuBar(frame));

        cards.setLayout(new CardLayout());
        for (JPanel i : panels) {
            cards.add(i, i.getName());
        }
        frame.add(BorderLayout.CENTER, cards);

        frame.setVisible(true);
    }
}
