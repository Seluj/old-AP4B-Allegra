import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel implements Base, ActionListener {

    private JComboBox nbJoueurs;
    private JButton sub;
    JTextField username = new JTextField();
    private int joueurs;

    private String nb[] = { "2", "3", "4", "5", "6"};

    public Menu() {
        setName("menu");
        setLayout(null);

        JLabel usernameText = new JLabel(new ImageIcon("src\\Images\\login\\username.png"));
        usernameText.setBounds(50, 135, 100, 23);
        add(usernameText);
        this.username.setBounds(200, 134, 150, 32);
        add(this.username);

        JLabel passwordText = new JLabel(new ImageIcon("src\\Images\\login\\nb_joueur.png"));
        passwordText.setBounds(50, 195, 100, 28);
        add(passwordText);

        nbJoueurs = new JComboBox(nb);
        nbJoueurs.setBounds(200, 195, 150, 32);
        add(nbJoueurs);

        sub = new JButton("Submit");
        sub.setSize(100, 20);
        sub.setLocation((menuWidth/2)-50, 300);
        sub.addActionListener(this);
        add(sub);
        JLabel background = new JLabel(new ImageIcon("src\\Images\\login\\backgroun.jpg"));
        background.setBounds(0, 0, 400, 514);
        add(background);
    }


    public int getJoueurs(){
        return joueurs;
    }
    /**
     * Function used to return the number of players selected
     * @return number of players selected
     */
    public void setNbJoueurs(){
        String choixJ = (String)nbJoueurs.getSelectedItem();
        this.joueurs = Integer.parseInt(choixJ);
        System.out.println("Nombre de joueurs choisis:"+joueurs);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // We gather the info regarding the number of players selected
        setNbJoueurs();
        // Modify the frame size and location to fit the game
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "jeu");
    }


    public void paintComponent(Graphics g) {
        frame.setSize(menuWidth, menuHeight);
        frame.setLocationRelativeTo(null);
    }
}