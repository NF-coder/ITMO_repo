package ui;

import core.Engine;
import textWorkers.Invokers.UIInvoker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;

public class HelloLayout extends JFrame implements Runnable{
    private JPanel mainPanel;
    private JButton signIn;
    private JButton register;
    private JPasswordField passwordField1;
    private JTextField textField1;

    public UIInvoker uiInvoker = new UIInvoker();

    public HelloLayout() {
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder passwd = new StringBuilder();
                for (char c : passwordField1.getPassword()) passwd.append(c);
                String login = textField1.getText();

                HashMap<String,String> data = new HashMap<>();
                data.put("password", passwd.toString());
                data.put("login", login);
                uiInvoker.setInfo("register", data);

                JOptionPane.showMessageDialog(register, "Register successfully with " + login + " password: " + passwd);
            }
        });
        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passwd = Arrays.toString(passwordField1.getPassword());
                String login = textField1.getText();
                JOptionPane.showMessageDialog(signIn, "Login successfully with " + login + " password: " + passwd);
            }
        });
    }

    public void run() {
        HelloLayout frame = new HelloLayout();
        frame.setContentPane(frame.mainPanel);

        frame.setTitle("Hello World");
        frame.setSize(800, 600);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
