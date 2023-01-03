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
        setName("menu");

        setLayout(null);
        name = new JLabel("Name");
        name.setSize(100, 20);
        name.setLocation(100, 100);
        add(name);

        tname = new JTextField();
        tname.setSize(190, 20);
        tname.setLocation(200, 100);
        add(tname);


        nbj = new JLabel("Nombre de joueurs");
        nbj.setSize(120, 20);
        nbj.setLocation(100, 250);
        add(nbj);

        nbJoueurs = new JComboBox(nb);
        nbJoueurs.setSize(50, 20);
        nbJoueurs.setLocation(220, 250);
        add(nbJoueurs);

        sub = new JButton("Submit");
        sub.setSize(100, 20);
        sub.setLocation((menuWidth/2)-50, 300);
        sub.addActionListener(this);
        add(sub);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Modify the frame size and location to fit the game
        frame.setSize(jeuWidth, jeuHeight);
        frame.setLocationRelativeTo(null);
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "jeu");
    }

    public void paintComponent(Graphics g){
        System.out.println("Je suis exécutée !");

        g.setColor(Color.BLACK);
        g.drawRect(100,250,120,20);
        g.drawLine(0, 0, this.getWidth(), this.getHeight());
        g.drawLine(0, this.getHeight(), this.getWidth(), 0);

        for (int i = 0; i < getWidth(); i+=10) {
            g.drawLine(i, 0, i, this.getHeight());
        }
        for (int i = 0; i < getHeight(); i+=5) {
            g.drawLine(0, i, this.getWidth(), i);
        }
    }
}