import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Jeu extends JPanel implements Base, ActionListener, MouseListener {
    MyJLabel bze[][] = new MyJLabel[6][12];

    public Jeu() {
        setLayout(new GridLayout(5,5));
        frame.setSize(jeuWidth, jeuHeight);
        frame.setLocationRelativeTo(null);

        JPanel[] panels = new JPanel[24];
        for (int i = 0; i < 24; i++) {
            panels[i] = new JPanel();

        }


        Image image;
        image = Toolkit.getDefaultToolkit().getImage("src/1.png");

        panels[7].setLayout(new GridLayout(3,4, 5, 5));

        for (int i = 0; i < 12; i++) {
            bze[0][i] = new MyJLabel(new ImageIcon(image));
            bze[0][i].addMouseListener(this);
            panels[7].add(bze[0][i]);
        }

        panels[11].setLayout(new GridLayout(3, 4, 5, 5));
        for (int i = 0; i < 12; i++) {
            bze[1][i] = new MyJLabel(new ImageIcon(image));
            bze[1][i].addMouseListener(this);
            panels[11].add(bze[1][i]);
        }

        panels[13].setLayout(new GridLayout(3, 4, 5, 5));
        for (int i = 0; i < 12; i++) {
            bze[2][i] = new MyJLabel(new ImageIcon(image));
            bze[2][i].addMouseListener(this);
            panels[13].add(bze[2][i]);
        }

        panels[17].setLayout(new GridLayout(3, 4, 5, 5));
        for (int i = 0; i < 12; i++) {
            bze[3][i] = new MyJLabel(new ImageIcon(image));
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

    /*
    public void printCard(Plateau p) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (p.getPlateau()[i][j] != null) {
                    // TODO
                }
            }
        }
    }

     */

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
        for (int i = 0; i < bze.length; i++) {
            for (int j = 0; j < bze[i].length; j++) {
                if (e.getSource() == bze[i][j]) {
                    System.out.println("i = " + i + " j = " + j + " clicked");
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


    class MyJLabel extends JLabel
    {
        ImageIcon imageIcon;
        public MyJLabel(ImageIcon icon)
        {
            super();
            this.imageIcon = icon;
        }
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
        }
    }
}
