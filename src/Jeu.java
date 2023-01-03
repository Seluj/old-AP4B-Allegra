import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Jeu extends JPanel implements Base, ActionListener, MouseListener {
    MyJLabel bze[][] = new MyJLabel[6][12];
    JPanel[] panels = new JPanel[24];

    public Jeu() {
        setLayout(new GridLayout(5,5));
        frame.setSize(jeuWidth, jeuHeight);
        frame.setLocationRelativeTo(null);
        setName("jeu");

        for (int i = 0; i < 24; i++) {
            panels[i] = new JPanel();

        }

        panels[7].setLayout(new GridLayout(3,4, 5, 5));

        for (int i = 0; i < 12; i++) {
            bze[0][i] = new MyJLabel();
            bze[0][i].addMouseListener(this);
            panels[7].add(bze[0][i]);
        }

        panels[11].setLayout(new GridLayout(3, 4, 5, 5));
        for (int i = 0; i < 12; i++) {
            bze[1][i] = new MyJLabel();
            bze[1][i].addMouseListener(this);
            panels[11].add(bze[1][i]);
        }

        panels[13].setLayout(new GridLayout(3, 4, 5, 5));
        for (int i = 0; i < 12; i++) {
            bze[2][i] = new MyJLabel();
            bze[2][i].addMouseListener(this);
            panels[13].add(bze[2][i]);
        }

        panels[17].setLayout(new GridLayout(3, 4, 5, 5));
        for (int i = 0; i < 12; i++) {
            bze[3][i] = new MyJLabel();
            bze[3][i].addMouseListener(this);
            panels[17].add(bze[3][i]);
        }




        for (int i = 0; i < 24; i++) {
            add(panels[i]);
        }
        JButton b = new JButton("menu");
        b.addActionListener(this);
        add(b);

    }

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

    public int toInterface(int x, int y) {
        int tab;
        tab = y + (x * 3 + x);
        return tab;
    }


    public void printCard(Plateau p, int joueur) {
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (p.getCache(i, j) == 0) {
                    bze[joueur][toInterface(i, j)].setIcon(new ImageIcon("src/images/back.png"));
                } else if (p.getCache(i, j) == 1) {
                    bze[joueur][toInterface(i, j)].setIcon(new ImageIcon("src/images/" + p.getCartes(i, j) + ".png"));
                } else {
                    bze[joueur][toInterface(i, j)].setIcon(new ImageIcon("src/images/back.png"));
                }
                bze[joueur][toInterface(i, j)].paintComponent(bze[joueur][toInterface(i, j)].getGraphics());
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
        int tab[] = new int[2];
        for (int i = 0; i < bze.length; i++) {
            for (int j = 0; j < bze[i].length; j++) {
                if (e.getSource() == bze[i][j]) {
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
