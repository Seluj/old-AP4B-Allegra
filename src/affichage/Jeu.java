package affichage;

import javax.swing.*;
import java.awt.*;

public class Jeu extends JPanel {
    public Jeu() {
        setLayout(new GridLayout(5,5));
        for (int i = 0; i < 24; i++) {
            add(new JButton("Button " + i));
        }
        JButton b = new JButton("menu");

        add(b);

    }
}
