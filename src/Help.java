import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Help implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Help button pressed");
        JDialog jDialog = new JDialog();
        JLabel jLabel = new JLabel(new ImageIcon("src\\Images\\rule.png"));
        jLabel.setBounds(0,0,599,727);
        jDialog.getContentPane().add(jLabel);
        jDialog.setSize(800,800);
        jDialog.setAlwaysOnTop(true);
        jDialog.setLocationRelativeTo(null);
        jDialog.setModal(true);
        jDialog.setVisible(true);
    }
}
