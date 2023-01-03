import javax.swing.*;

public interface Base {
    JFrame frame = new JFrame();
    JPanel cards = new JPanel(); //a panel that uses CardLayout

    int jeuWidth = 1980;
    int jeuHeight = 1080;

    int menuWidth = 300;
    int menuHeight = 500;
}