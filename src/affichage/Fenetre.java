package affichage;

import javax.swing.*;
import java.awt.*;


public class Fenetre {
    int width = 500;
    int height = 500;


    public Fenetre() {
        JFrame frame = new JFrame("A Windows");
        frame.setSize(1280,720);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GridLayout g = new GridLayout(5,5);

        JPanel grid = new JPanel(g);

        frame.add(BorderLayout.CENTER, grid);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("FILE");
        JMenu helpMenu = new JMenu("help");
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem helpItem = new JMenuItem("Help");
        exitItem.addActionListener(new Exit(frame));
        helpItem.addActionListener(new Help());
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        helpMenu.add(helpItem);


        frame.getContentPane().add(BorderLayout.NORTH, menuBar);


        frame.setVisible(true);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
