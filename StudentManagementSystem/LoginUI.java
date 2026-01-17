import javax.swing.*;
import java.awt.*;

public class LoginUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Login");
        frame.setSize(420, 320);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Login", JLabel.CENTER);
        title.setBounds(0, 0, 420, 50);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        frame.add(title);

        JLabel l1 = new JLabel("Username");
        JLabel l2 = new JLabel("Password");

        JTextField txtUser = new JTextField();
        JPasswordField txtPass = new JPasswordField();

        JCheckBox show = new JCheckBox("Show Password");
        JButton login = new JButton("Login");

        l1.setBounds(60, 70, 100, 25);
        txtUser.setBounds(60, 95, 300, 30);

        l2.setBounds(60, 130, 100, 25);
        txtPass.setBounds(60, 155, 300, 30);

        show.setBounds(60, 190, 150, 25);
        login.setBounds(150, 230, 120, 35);

        frame.add(l1); frame.add(txtUser);
        frame.add(l2); frame.add(txtPass);
        frame.add(show); frame.add(login);

        show.addActionListener(e ->
                txtPass.setEchoChar(show.isSelected() ? (char) 0 : '•')
        );

        login.addActionListener(e -> {
            User u = UserStore.authenticate(
                    txtUser.getText(),
                    String.valueOf(txtPass.getPassword())
            );

            if (u != null) {
                JOptionPane.showMessageDialog(frame,
                        "Welcome " + u.username + " (" + u.role + ")");
                frame.dispose();
                new StudentSwingUI();
            } else {
                JOptionPane.showMessageDialog(frame,
                        "Invalid Login",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setVisible(true);
    }
}
