import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Jeu extends JPanel implements Base, ActionListener, MouseListener {
    // Variables

    private int colonne;    // Column of the grid
    private int ligne;      // Raw of the grid
    private int nbPanel;    // Number of panel in the grid

    // Tableau de cartes
    // 12 cartes par joueur
    // 6 joueurs
    private MyJLabel[][] display_cards;

    // Table of JPanel to fil the grid.
    // The grid is 5 raw and 5 column.
    // 24 JPanels for game et 1 case for the menu button
    private final JPanel[] panels;

    private int[] playerJPanels;    // Table to know which panel is for which player

    /**
     * Build the game panel
     */
    public Jeu(int nombreJoueur) {

        // Set basic information about the panel
        setName("jeu");         // Set the name of the panel, it will be used to switch between panels

        // Set Size of the panel and location
        frame.setSize(jeuWidth, jeuHeight);
        frame.setLocationRelativeTo(null);

        // Generate the table to store Icon to be displayed of each player
        display_cards = new MyJLabel[nombreJoueur][12];

        // Initialize the column and raw of the grid of the panel
        switch (nombreJoueur) {
            case 2, 3, 4 -> {
                colonne = 5;
                ligne = 5;
            }
            case 5, 6 -> {
                colonne = 7;
                ligne = 5;
            }
            default -> System.out.println("Nombre de joueurs invalide");
        }

        // Initialize the number of panel in the grid minus the menu button
        nbPanel = (colonne * ligne) - 1;

        // Initialize the table of JPanel and set the layout of the panel to GridLayout
        this.panels = new JPanel[nbPanel];
        setLayout(new GridLayout(ligne, colonne));

        // Initialize the panels and set the layout of the panel to GridLayout with 3 raw and 4 column
        for (int i = 0; i < nbPanel; i++) {
            this.panels[i] = new JPanel();
            this.panels[i].setLayout(new GridLayout(3,4));
        }

        // Initialize the table to know which panel is for which player with a given number of player
        switch (nombreJoueur) {
            case 2 -> deuxJoueurs();
            case 3 -> troisJoueurs();
            case 4 -> quatreJoueurs();
            case 5 -> cinqJoueurs();
            case 6 -> sixJoueurs();
            default -> System.out.println("Nombre de joueur invalide");
        }

        // Then initialize all cards panel of each player
        initPanel();

        // Add the panels to the grid
        for (int i = 0; i < nbPanel; i++) {
            add(panels[i]);
        }

        // Add the menu button and set the listener
        JButton b = new JButton("menu");
        b.addActionListener(this);
        add(b);
        revalidate();
    }

    private void initPanel() {
        // For each player and each card of the player initialize the display of the card, add it to the panel and set the listener
        for (int i = 0; i < playerJPanels.length; i++) {
            for (int j = 0; j < 12; j++) {
                display_cards[i][j] = new MyJLabel();
                display_cards[i][j].addMouseListener(this);
                panels[playerJPanels[i]].add(display_cards[i][j]);
            }
        }
    }

    /**
     * Initialize the table to know which panel is for which player with 2 players
     */
    private void deuxJoueurs() {
        playerJPanels = new int[2];
        playerJPanels[0] = 17;      // Player 1
        playerJPanels[1] = 7;       // Player 2
    }

    /**
     * Initialize the table to know which panel is for which player with 3 players
     */
    private void troisJoueurs() {
        playerJPanels = new int[3];
        playerJPanels[0] = 17;      // Player 1
        playerJPanels[1] = 6;       // Player 2
        playerJPanels[2] = 8;       // Player 3
    }

    /**
     * Initialize the table to know which panel is for which player with 4 players
     */
    private void quatreJoueurs() {
        playerJPanels = new int[4];
        playerJPanels[0] = 17;      // Player 1
        playerJPanels[1] = 11;      // Player 2
        playerJPanels[2] = 7;       // Player 3
        playerJPanels[3] = 13;      // Player 4
    }

    /**
     * Initialize the table to know which panel is for which player with 5 players
     */
    private void cinqJoueurs() {
        playerJPanels = new int[5];
        playerJPanels[0] = 25;      // Player 1
        playerJPanels[1] = 23;      // Player 2
        playerJPanels[2] = 8;       // Player 3
        playerJPanels[3] = 10;      // Player 4
        playerJPanels[4] = 12;      // Player 5
    }

    /**
     * Initialize the table to know which panel is for which player with 6 players
     */
    private void sixJoueurs() {
        playerJPanels = new int[6];
        playerJPanels[0] = 24;      // Player 1
        playerJPanels[1] = 22;      // Player 2
        playerJPanels[2] = 8;       // Player 3
        playerJPanels[3] = 10;      // Player 4
        playerJPanels[4] = 12;      // Player 5
        playerJPanels[5] = 26;      // Player 6
    }


    /**
     * Translate coordinates of the card pressed to the coordinates of the card in the table of the player
     * @param y The y coordinate of the card pressed
     * @return The x and y coordinates of the card in the table of the player
     */
    public int[] toTable(int y) {
        int[] tab = new int[2];

        for (int i = 0; i < y; i++) {
            tab[1] ++;
            if (tab[1] == Y) {
                tab[1] = 0;
                tab[0] ++;
            }
        }

        return tab;
    }


    /**
     * Translate coordinates of the card in the table of the player to the coordinates of the card in the table of the game
     * @param x The x coordinate of the card in the table of the player
     * @param y The y coordinate of the card in the table of the player
     * @return The y coordinates of the card in the table of the game
     */
    public int toInterface(int x, int y) {
        return y + (x * 3 + x);
    }


    /**
     * Display the cards of the player
     * @param p The cards of the player
     * @param joueur The number of the player to know where to display the cards
     */
    public void printCard(Plateau p, int joueur) {
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                // If the card is hidden display the back of the card
                if (p.getCache(i, j) == 0) {
                    display_cards[joueur][toInterface(i, j)].setIcon(new ImageIcon("src\\images\\back.png"));

                // If the card is visible display the front of the card
                } else if (p.getCache(i, j) == 1) {
                    display_cards[joueur][toInterface(i, j)].setIcon(new ImageIcon("src/images/" + p.getCartes(i, j) + ".png"));

                // If the card is removed display a blank card
                } else {
                    display_cards[joueur][toInterface(i, j)].setIcon(new ImageIcon("src\\images\\blank.png"));
                }

                // Then display the card
                display_cards[joueur][toInterface(i, j)].paintComponent(display_cards[joueur][toInterface(i, j)].getGraphics());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Modify the frame size and location to fit the menu
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "menu");
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("click");
        int[] tab;
        for (int i = 0; i < display_cards.length; i++) {
            for (int j = 0; j < display_cards[i].length; j++) {
                if (e.getSource() == display_cards[i][j]) {
                    System.out.println("i = " + i + " j = " + j + " clicked");
                    tab = toTable(j);
                    System.out.println("X = " + tab[0] + " Y = " + tab[1]);
                    System.out.println("i = " + i + " Y = " + toInterface(tab[0], tab[1]));
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * A subclass of JLabel to add a method to paint the component and resize the image
     */
    static class MyJLabel extends JLabel
    {
        ImageIcon imageIcon;

        public MyJLabel()
        {
            super();
            this.imageIcon = null;
        }

        public void setIcon(ImageIcon imageIcon) {
            this.imageIcon = imageIcon;
        }

        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            if (this.imageIcon != null)
                g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
        }
    }

    public void paintComponent(Graphics g) {
        frame.setSize(jeuWidth, jeuHeight);
    }
}
