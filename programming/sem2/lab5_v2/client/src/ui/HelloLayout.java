package ui;

import textWorkers.Invokers.UIInvoker;
import ui.storage.AuthStorage;

import javax.swing.*;
import java.util.HashMap;

public class HelloLayout extends JFrame implements Runnable{
    private JPanel mainPanel;
    private JButton signIn;
    private JButton register;
    private JPasswordField passwordField1;
    private JTextField textField1;

    public UIInvoker uiInvoker;

    public HelloLayout() {
        this.setContentPane(this.mainPanel);
        this.setTitle("Auth Panel");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        register.addActionListener(e -> {
            StringBuilder passwd = new StringBuilder();
            for (char c : passwordField1.getPassword()) passwd.append(c);
            String login = textField1.getText();

            HashMap<String,String> data = new HashMap<>();
            data.put("password", passwd.toString());
            data.put("login", login);
            uiInvoker.setInfo("register", data);

            //JOptionPane.showMessageDialog(register, "Register successfully with " + login + " password: " + passwd);

            this.setVisible(false);
            this.setEnabled(false);
            new MapLayout().setVisible(true);
        });
        signIn.addActionListener(e -> {
            StringBuilder passwd = new StringBuilder();
            for (char c : passwordField1.getPassword()) passwd.append(c);

            AuthStorage.login = textField1.getText();
            AuthStorage.password = passwd.toString();

            //JOptionPane.showMessageDialog(signIn, "Login successfully with " + login + " password: " + passwd);

            this.setVisible(false);
            this.setEnabled(false);
            new MapLayout().setVisible(true);
        });
    }

    public void run() {
        HelloLayout frame = new HelloLayout();
        frame.setVisible(true);
    }
}
