import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Jeu extends JPanel implements Base, ActionListener, MouseListener {
    // Variables

    // Tableau de cartes
    // 12 cartes par joueur
    // 6 joueurs
    MyJLabel[][] display_cards = new MyJLabel[6][12];

    // Table of JPanel to fil the grid.
    // The grid is 5 raw and 5 column.
    // 24 JPanels for game et 1 case for the menu button
    JPanel[] panels = new JPanel[24];

    /**
     * Build the game panel
     */
    public Jeu() {
        // Set basic information about the panel
        setLayout(new GridLayout(5,5));
        setName("jeu");         // Set the name of the panel, it will be used to switch between panels
        
        // Set basic information about the frame
        frame.setSize(jeuWidth, jeuHeight);
        frame.setLocationRelativeTo(null);
        
        // Initialize the panels
        for (int i = 0; i < 24; i++) {
            panels[i] = new JPanel();
        }

        // Panels 7, 11, 13 and 17 are for the cards of players.
        // So we set those panels to display the cards with GridLayout and adding listener to the panels of cards

        panels[7].setLayout(new GridLayout(3,4, 5, 5));

        for (int i = 0; i < 12; i++) {
            // Initialize all JLabels
            display_cards[0][i] = new MyJLabel();
            // Add a listener to the JLabel
            display_cards[0][i].addMouseListener(this);
            // And add the JLabel to the panel
            panels[7].add(display_cards[0][i]);
        }

        // Same for the other panels
        panels[11].setLayout(new GridLayout(3, 4, 5, 5));
        for (int i = 0; i < 12; i++) {
            display_cards[1][i] = new MyJLabel();
            display_cards[1][i].addMouseListener(this);
            panels[11].add(display_cards[1][i]);
        }

        panels[13].setLayout(new GridLayout(3, 4, 5, 5));
        for (int i = 0; i < 12; i++) {
            display_cards[2][i] = new MyJLabel();
            display_cards[2][i].addMouseListener(this);
            panels[13].add(display_cards[2][i]);
        }

        panels[17].setLayout(new GridLayout(3, 4, 5, 5));
        for (int i = 0; i < 12; i++) {
            display_cards[3][i] = new MyJLabel();
            display_cards[3][i].addMouseListener(this);
            panels[17].add(display_cards[3][i]);
        }

        // Add the panels to the grid
        for (int i = 0; i < 24; i++) {
            add(panels[i]);
        }

        // Add the menu button and set the listener
        JButton b = new JButton("menu");
        b.addActionListener(this);
        add(b);

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
                if (p.getCache(i, j) == 0) {
                    display_cards[joueur][toInterface(i, j)].setIcon(new ImageIcon("src/images/back.png"));
                } else if (p.getCache(i, j) == 1) {
                    display_cards[joueur][toInterface(i, j)].setIcon(new ImageIcon("src/images/" + p.getCartes(i, j) + ".png"));
                } else {
                    display_cards[joueur][toInterface(i, j)].setIcon(new ImageIcon("src/images/back.png"));
                }
                display_cards[joueur][toInterface(i, j)].paintComponent(display_cards[joueur][toInterface(i, j)].getGraphics());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Modify the frame size and location to fit the menu
        frame.setSize(menuWidth, menuHeight);
        frame.setLocationRelativeTo(null);
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "menu");
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
        public MyJLabel(ImageIcon icon)
        {
            super();
            this.imageIcon = icon;
        }

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
}
