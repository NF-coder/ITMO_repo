package ui;

import org.json.JSONObject;
import ui.utils.ReqController;

import javax.swing.*;

public class HelloLayout extends JFrame{
    private JPanel mainPanel;
    private JButton signIn;
    private JButton register;
    private JPasswordField passwordField1;
    private JTextField textField1;

    public HelloLayout(ReqController reqController) {
        this.setContentPane(this.mainPanel);
        this.setTitle("Auth Panel");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        register.addActionListener(e -> {
            StringBuilder passwd = new StringBuilder();
            for (char c : passwordField1.getPassword()) passwd.append(c);
            String login = textField1.getText();

            reqController.setUserInfo(login, passwd.toString());
            JSONObject result = reqController.call("register").build();

            if (result.get("status").equals("ERROR")) {
                JOptionPane.showMessageDialog(register, "Error: " + result.get("description"));
                return;
            }

            this.setVisible(false);
            this.setEnabled(false);
            SwingUtilities.invokeLater(() -> new MapLayout(reqController));
        });
        signIn.addActionListener(e -> {
            StringBuilder passwd = new StringBuilder();
            for (char c : passwordField1.getPassword()) passwd.append(c);

            reqController.setUserInfo(textField1.getText(), passwd.toString());
            JSONObject result = reqController.call("info").build();

            if (result.get("status").equals("ERROR")) {
                JOptionPane.showMessageDialog(register, "Error: " + result.get("description"));
                return;
            }

            //JOptionPane.showMessageDialog(signIn, "Login successfully with " + login + " password: " + passwd);

            this.setVisible(false);
            this.setEnabled(false);

            SwingUtilities.invokeLater(() -> new MapLayout(reqController));
        });
    }
}
