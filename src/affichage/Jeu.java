package affichage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jeu extends JPanel implements Base, ActionListener {
    public Jeu() {
        setLayout(new GridLayout(5,5));

        JPanel[] panels = new JPanel[24];
        for (int i = 0; i < 24; i++) {
            panels[i] = new JPanel();
        }


        panels[7].setLayout(new GridLayout(3, 4, 5, 5));
        for (int i = 0; i < 12; i++) {
            panels[7].add(new JButton("" + i));
        }

        panels[11].setLayout(new GridLayout(3, 4, 5, 5));
        for (int i = 0; i < 12; i++) {
            panels[11].add(new JButton("" + i));
        }

        panels[13].setLayout(new GridLayout(3, 4, 5, 5));
        for (int i = 0; i < 12; i++) {
            panels[13].add(new JButton());
        }

        panels[17].setLayout(new GridLayout(3, 4, 5, 5));
        for (int i = 0; i < 12; i++) {
            panels[17].add(new JButton("" + i));
        }




        for (int i = 0; i < 24; i++) {
            add(panels[i]);
        }
        JButton b = new JButton("menu");
        b.addActionListener(this);
        add(b);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Modify the frame size and location to fit the menu
        frame.setSize(menuWidth, menuHeight);
        frame.setLocationRelativeTo(null);
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "menu");
    }
}
