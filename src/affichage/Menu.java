package affichage;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {
    public Menu() {
        setLayout(new BorderLayout());
        add(new JButton("North"), BorderLayout.NORTH);
        add(new JButton("South"), BorderLayout.SOUTH);
        add(new JButton("East"), BorderLayout.EAST);
        add(new JButton("West"), BorderLayout.WEST);
        JButton b = new JButton("jeu");
        add(b, BorderLayout.CENTER);
    }
}