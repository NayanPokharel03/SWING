package Authentication;


import javax.swing.*;
import java.awt.*;

import static java.awt.Color.WHITE;

public class LoginPage extends JFrame {


    LoginPage() {

        //Text and font details
        JLabel label = new JLabel("Username: ");
        label.setBounds(10, 50, 200, 18);
        Font font = new Font("Arial", Font.BOLD, 18);
        label.setFont(font);
        add(label);

        label = new JLabel("Password: ");
        label.setBounds(10, 90, 200, 18);
        font = new Font("Arial", Font.BOLD, 18);
        label.setFont(font);
        add(label);



        //Text field
        JTextField username = new JTextField();
        username.setBounds(200, 50, 300, 25);
        add(username);

        JPasswordField password = new JPasswordField();
        password.setBounds(200, 90, 300, 25);
        add(password);



        //button
        JButton button = new JButton("Login");
        button.setBounds(10, 400, 200, 30);
        button.setFont(font);
        button.setBackground(Color.GREEN);
        add(button);

        JButton button1 = new JButton("Cancel");
        button1.setBounds(300, 400, 200, 30);
        button1.setFont(font);
        button1.setBackground(Color.RED);
        add(button1);


        //Image -> clzLogo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("imgs/ClzLogo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 100, 200, 200);
        setLayout(null);
        add(image);


        setTitle("Login Page");
        setBounds(500, 200, 700, 500);
        setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage();
    }
}
