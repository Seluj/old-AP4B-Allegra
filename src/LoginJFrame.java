import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class LoginJFrame extends JFrame implements MouseListener {
    static ArrayList<User> list = new ArrayList<User>();
    static {
        list.add(new User ("Jules","123"));
        list.add(new User ("Zhangsan","1234"));
    }


    JButton login = new JButton();
    JButton register = new JButton();
    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();
    JTextField code = new JTextField();
    JLabel rightCode = new JLabel();

    public LoginJFrame() {
        this.initJFrame();
        this.initView();
        this.setVisible(true);
    }

    public void initView() {
        JLabel usernameText = new JLabel(new ImageIcon("src\\Images\\login\\username.png"));
        usernameText.setBounds(50, 135, 100, 23);
        this.getContentPane().add(usernameText);
        this.username.setBounds(200, 134, 150, 32);
        this.getContentPane().add(this.username);

        JLabel passwordText = new JLabel(new ImageIcon("src\\Images\\login\\P.png"));
        passwordText.setBounds(50, 195, 100, 28);
        this.getContentPane().add(passwordText);
        this.password.setBounds(200, 195, 150, 32);
        this.getContentPane().add(this.password);

        JLabel codeText = new JLabel(new ImageIcon("src\\Images\\login\\vc.png"));
        codeText.setBounds(50, 256, 100, 22);
        this.getContentPane().add(codeText);
        this.code.setBounds(200, 256, 150, 32);
        this.getContentPane().add(this.code);
        String codeStr = CodeUtil.getCode();
        this.rightCode.setText(codeStr);
        this.rightCode.addMouseListener(this);
        this.rightCode.setBounds(350, 256, 100, 27);
        this.rightCode.setForeground(new Color(0xff0000));
        this.getContentPane().add(this.rightCode);
        this.login.setBounds(123, 310, 128, 47);
        this.login.setIcon(new ImageIcon("src\\Images\\login\\s0.png"));
        this.login.setBorderPainted(false);
        this.login.setContentAreaFilled(false);
        this.login.addMouseListener(this);
        this.getContentPane().add(this.login);
        this.register.setBounds(256, 310, 128, 47);
        this.register.setIcon(new ImageIcon("src\\Images\\login\\r0.png"));
        this.register.setBorderPainted(false);
        this.register.setContentAreaFilled(false);
        this.register.addMouseListener(this);
        this.getContentPane().add(this.register);
        JLabel background = new JLabel(new ImageIcon("src\\Images\\login\\backgroun.jpg"));
        background.setBounds(0, 0, 400, 514);
        this.getContentPane().add(background);
    }

    public void initJFrame() {
        this.setSize(415,555);
        this.setTitle("Allegra V1.0");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo((Component)null);
        this.setAlwaysOnTop(true);
        this.setLayout((LayoutManager)null);
    }

    public void mouseClicked(MouseEvent e) {
        String code;
        if (e.getSource() == this.login) {
            System.out.println("Clicked on the button of sign in");
            code = this.username.getText();
            String passwordInput = this.password.getText();
            String codeInput = this.code.getText();
            User userInfo = new User(code, passwordInput);
            System.out.println("The username is" + code);
            System.out.println("The password is" + passwordInput);

            if (codeInput.length() == 0) {
                this.showJDialog("Please entre the Verification code!");
            } else if (code.length() != 0 && passwordInput.length() != 0) {
                if (!codeInput.equalsIgnoreCase(this.rightCode.getText())) {
                    this.showJDialog("The Verification code is not correct!");
                } else if (this.contains(userInfo)) {
                    System.out.println("You can play right now!");
                    this.setVisible(false);

                } else {
                    System.out.println("The username or the password is wrong!");
                    this.showJDialog("The username or the password is wrong");
                }
            } else {
                System.out.println("The username or the password is empty!");
                this.showJDialog("The username or the password is empty");
            }
        } else if (e.getSource() == this.register) {
            System.out.println("Click on the button of Register");
        } else if (e.getSource() == this.rightCode) {
            System.out.println("Change the verification code");
            code = CodeUtil.getCode();
            this.rightCode.setText(code);
        }

    }

    public void showJDialog(String content) {
        JDialog jDialog = new JDialog();
        jDialog.setSize(200, 150);
        jDialog.setAlwaysOnTop(true);
        jDialog.setLocationRelativeTo((Component)null);
        jDialog.setModal(true);
        JLabel warning = new JLabel(content);
        warning.setBounds(0, 0, 200, 150);
        jDialog.getContentPane().add(warning);
        jDialog.setVisible(true);
    }

    public void mousePressed(MouseEvent e) {
        if (e.getSource() == this.login) {
            this.login.setIcon(new ImageIcon("src\\Images\\login\\S.png"));
        } else if (e.getSource() == this.register) {
            this.register.setIcon(new ImageIcon("src\\Images\\login\\R.png"));
        }

    }

    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == this.login) {
            this.login.setIcon(new ImageIcon("src\\Images\\login\\s0.png"));
        } else if (e.getSource() == this.register) {
            this.register.setIcon(new ImageIcon("src\\Images\\login\\r0.png"));
        }

    }

    public void mouseEntered(MouseEvent e){}

     @Override
     public void mouseExited(MouseEvent e) {

     }
 }