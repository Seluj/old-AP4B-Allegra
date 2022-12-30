package affichage;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    public MenuBar(JFrame frame) {
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

        add(menuBar);
    }
}
