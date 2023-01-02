package affichage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel implements Base, ActionListener {
    private JLabel name;
    private JTextField tname;
    private JLabel nbj;
    private JComboBox nbJoueurs;
    private JButton sub;

    private String nb[]
            = { "2", "3", "4", "5", "6"};
    public Menu() {

         setLayout(null);
         name = new JLabel("Name");
         name.setFont(new Font("Arial", Font.PLAIN, 20));
         name.setSize(100, 20);
         name.setLocation(100, 100);
         add(name);

         tname = new JTextField();
         tname.setFont(new Font("Arial", Font.PLAIN, 15));
         tname.setSize(190, 20);
         tname.setLocation(200, 100);
         add(tname);

         nbj = new JLabel("Nombre de joueurs");
         nbj.setSize(100, 20);
         nbj.setLocation(100, 250);
         add(nbj);

         nbJoueurs = new JComboBox(nb);
         nbJoueurs.setSize(50, 20);
         nbJoueurs.setLocation(220, 250);
         add(nbJoueurs);

         sub = new JButton("Submit");
         sub.setSize(100, 20);
         sub.setLocation(150, 300);
         sub.addActionListener(this);
         add(sub);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setSize(1280, 720);
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "jeu");
    }
}