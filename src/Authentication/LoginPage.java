package Authentication;


import View.StudentView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.WHITE;

public class LoginPage extends JFrame implements ActionListener {


    JTextField username;
    JPasswordField password;
    JButton button;

    LoginPage() {

        //Fonts
        Font font = new Font("Arial", Font.BOLD, 18);
        Font fontB = new Font("Arial", Font.BOLD, 38);

        //Image -> ClzBuilding
        ImageIcon i1 = new ImageIcon(LoginPage.class.getResource("/imgs/BuildLogo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(720, 478, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(0, 0, 720, 478);
        add(image);

        // Glass Panel
        JPanel glass = new JPanel() {
            protected void paintComponent(Graphics g) {
                Graphics2D g2 =
                        (Graphics2D) g.create();
                g2.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setColor(new Color(255,255,255,120));
                g2.fillRoundRect(0,0,getWidth(),getHeight(),30,30);
                g2.dispose();
                super.paintComponent(g);
            }
        };

        //Glass
        glass.setOpaque(false);
        glass.setBounds(45, 50, 330, 280);
        glass.setLayout(null);
        image.add(glass);


        //Heading details
        JLabel label = new JLabel("Login");
        label.setBounds(120, 15, 180, 58);
        label.setFont(fontB);
        glass.add(label);

        label = new JLabel("Username: ");
        label.setBounds(20, 95, 180, 18);
        label.setFont(font);
        glass.add(label);

        label = new JLabel("Password: ");
        label.setBounds(20, 155, 180, 18);
        label.setFont(font);
        glass.add(label);


        //Text field
        username = new JTextField();
        username.setBounds(120, 90, 200, 30);
        glass.add(username);

        password = new JPasswordField();
        password.setBounds(120, 150, 200, 30);
        glass.add(password);


        //button
        button = new JButton("Log in");
        button.setBounds(115, 220, 100, 30);
        button.setFont(font);
        button.setForeground(WHITE);
        button.setBackground(Color.GREEN);
        button.addActionListener(this);
        glass.add(button);


        setTitle("Login Page");
        setBounds(500, 200, 720, 478);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button){

            String user = username.getText();
            String pass = new String(password.getPassword());

            if (user.equals("admin") && pass.equals("1234")){

                JOptionPane.showMessageDialog(null, "Login Successful");

                new StudentView();
                dispose();


            }else {
                JOptionPane.showMessageDialog(null, "Wrong username or password");
            }
        }


    }

    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage();
    }
}
