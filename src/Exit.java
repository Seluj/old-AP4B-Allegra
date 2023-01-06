import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Exit implements ActionListener {

    // Exit the program and close the window
    private final JFrame j;

    // Constructor
    public Exit(JFrame j) {
        this.j = j;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Close the window
        j.dispose();
    }
}
