package Authentication;


import javax.swing.*;
import java.awt.*;

import static java.awt.Color.WHITE;

public class LoginPage extends JFrame {


    LoginPage() {

        //Fonts
        Font font = new Font("Arial", Font.BOLD, 18);
        Font fontB = new Font("Arial", Font.BOLD, 38);

        //Heading details
        JLabel label = new JLabel("Login");
        label.setBounds(165, 55, 180, 58);
        label.setFont(fontB);
        add(label);

        label = new JLabel("Username: ");
        label.setBounds(60, 145, 180, 18);
        label.setFont(font);
        add(label);

        label = new JLabel("Password: ");
        label.setBounds(60, 215, 180, 18);
        label.setFont(font);
        add(label);


        //Text field
        JTextField username = new JTextField();
        username.setBounds(160, 140, 200, 30);
        add(username);

        JPasswordField password = new JPasswordField();
        password.setBounds(160, 210, 200, 30);
        add(password);


        //button
        JButton button = new JButton("Log in");
        button.setBounds(165, 280, 100, 30);
        button.setFont(font);
        button.setForeground(WHITE);
        button.setBackground(Color.GREEN);
        add(button);


        //Glass Panel
        glass g = new glass();
        g.setBounds(45, 50, 335, 280);
        g.setLayout(null);
        add(g);


        //Image -> ClzBuilding
        ImageIcon i1 = new ImageIcon(LoginPage.class.getResource("/imgs/BuildLogo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(720, 478, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(0, 0, 720, 478);
        add(image);


        setTitle("Login Page");
        setBounds(500, 200, 720, 478);
        setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage();
    }
}
