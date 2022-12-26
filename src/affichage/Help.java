package affichage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Help implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Help button pressed");
    }
}
