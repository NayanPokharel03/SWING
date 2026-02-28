package View;

import javax.swing.*;
import java.awt.*;

public class StudentView extends JFrame {


       public StudentView() {

            // Create frame
            JFrame frame = new JFrame("Student Details");
            frame.setSize(1300, 900);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            //Font Details
            Font font = new Font("Arial", Font.BOLD, 18);

            //Text and font details
            JLabel label = new JLabel("First Name:");
            label.setBounds(10, 50, 1000, 18);
            label.setFont(font);
            frame.add(label);

            label = new JLabel("Last Name:");
            label.setBounds(10, 75, 1000, 18);
            label.setFont(font);
            frame.add(label);

            label = new JLabel("Roll no:");
            label.setBounds(10, 100, 1000, 18);
            label.setFont(font);
            frame.add(label);

            label = new JLabel("Email:");
            label.setBounds(10, 125, 1000, 18);
            label.setFont(font);
            frame.add(label);

            label = new JLabel("Age:");
            label.setBounds(10, 150, 1000, 22);
            label.setFont(font);
            frame.add(label);

            label = new JLabel("Gender:");
            label.setBounds(10, 175, 1000, 18);
            label.setFont(font);
            frame.add(label);

            label = new JLabel("Date of Birth:");
            label.setBounds(10, 200, 1000, 18);
            label.setFont(font);
            frame.add(label);

            label = new JLabel("Address:");
            label.setBounds(10, 225, 1000, 18);
            label.setFont(font);
            frame.add(label);

            //button
            JButton button = new JButton("Save");
            button.setBounds(10, 800, 200, 30);
            button.setFont(font);
            frame.add(button);

            JButton button1 = new JButton("Cancel");
            button1.setBounds(250, 800, 200, 30);
            button1.setFont(font);
            frame.add(button1);

            //Text field
            JTextField first_name = new JTextField();
            first_name.setBounds(200, 50, 300, 18);
            frame.add(first_name);
            frame.setVisible(true);


            JTextField last_name = new JTextField();
            last_name.setBounds(200, 75, 300, 18);
            frame.add(last_name);
            frame.setVisible(true);

            JTextField roll_no = new JTextField();
            roll_no.setBounds(200, 100, 300, 18);
            frame.add(roll_no);
            frame.setVisible(true);

            JTextField email = new JTextField();
            email.setBounds(200, 125, 300, 18);
            frame.add(email);
            frame.setVisible(true);

            JTextField gender = new JTextField();
            gender.setBounds(200, 150, 300, 18);
            frame.add(gender);
            frame.setVisible(true);

            JTextField age = new JTextField();
            age.setBounds(200, 175, 300, 18);
            frame.add(age);
            frame.setVisible(true);

            JTextField dob = new JTextField();
            dob.setBounds(200, 200, 300, 18);
            frame.add(dob);
            frame.setVisible(true);

            JTextField address = new JTextField();
            address.setBounds(200, 225, 300, 18);
            frame.add(address);
            frame.setVisible(true);


        }
    public static void main(String[] args){
           new StudentView();
    }
}


