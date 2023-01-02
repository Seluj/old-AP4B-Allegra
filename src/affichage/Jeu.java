package affichage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jeu extends JPanel implements Base, ActionListener {
    public Jeu() {
        setLayout(new GridLayout(5,5));
        for (int i = 0; i < 24; i++) {
            add(new JButton("Button " + i));
        }
        JButton b = new JButton("menu");
        b.addActionListener(this);
        add(b);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setSize(500, 500);
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "menu");
    }
}
