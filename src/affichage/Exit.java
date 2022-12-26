package affichage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Exit implements ActionListener {
    private final JFrame j;
    public Exit(JFrame j) {
        this.j = j;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        j.dispose();
    }
}
