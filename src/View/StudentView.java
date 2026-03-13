package View;

import Controller.StudentController;
import DAO.StudentDAO;
import Model.StudentModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class StudentView extends JFrame {


     public JTextField first_name;
     public JTextField last_name;
     public JTextField phone_no;
     public JTextField email;
     public JTextField gender;
     public JTextField dob;
     public JTextField age;
     public JTextField address;

     public JButton add;
     public JButton delete;
     public JButton edit;
     public JButton reset;


     public DefaultTableModel tableModel;
     public JTableHeader tableHeader;
     public JTable table;

     @SuppressWarnings("unused")
     private final StudentController controller;

     public StudentView() {

          // Create frame
          setTitle("Student Details");
          setSize(1300, 900);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setLayout(null);
          setLocationRelativeTo(null);


          //Font Details
          Font font = new Font("Arial", Font.BOLD, 18);

          //Text and font details
          JLabel label = new JLabel("First Name:");
          label.setBounds(20, 20, 120, 25);
          label.setFont(font);
          add(label);


          label = new JLabel("Last Name:");
          label.setBounds(20, 55, 120, 25);
          label.setFont(font);
          add(label);

          label = new JLabel("Phone No:");
          label.setBounds(20, 90, 120, 25);
          label.setFont(font);
          add(label);

          label = new JLabel("Email:");
          label.setBounds(20, 125, 120, 25);
          label.setFont(font);
          add(label);

          label = new JLabel("Age:");
          label.setBounds(20, 160, 120, 25);
          label.setFont(font);
          add(label);

          label = new JLabel("Gender:");
          label.setBounds(20, 195, 120, 25);
          label.setFont(font);
          add(label);

          label = new JLabel("Date of Birth:");
          label.setBounds(20, 230, 120, 25);
          label.setFont(font);
          add(label);

          label = new JLabel("Address:");
          label.setBounds(20, 265, 120, 25);
          label.setFont(font);
          add(label);


          // Text Fields
          first_name = new JTextField();
          first_name.setBounds(160, 20, 250, 25);
          add(first_name);

          last_name = new JTextField();
          last_name.setBounds(160, 55, 250, 25);
          add(last_name);

          phone_no = new JTextField();
          phone_no.setBounds(160, 90, 250, 25);
          add(phone_no);

          email = new JTextField();
          email.setBounds(160, 125, 250, 25);
          add(email);

          age = new JTextField();
          age.setBounds(160, 160, 250, 25);
          add(age);

          gender = new JTextField();
          gender.setBounds(160, 195, 250, 25);
          add(gender);

          dob = new JTextField();
          dob.setBounds(160, 230, 250, 25);
          add(dob);

          address = new JTextField();
          address.setBounds(160, 265, 250, 25);
          add(address);


          //TABLE

          String[] columns = {
                  "First Name", "Last Name", "Phone No",
                  "Email", "Age", "Gender", "DOB", "Address"
          };

          tableModel = new DefaultTableModel(columns, 0);
          table = new JTable(tableModel);

          // table text styling
          table.setFont(font);
          table.setRowHeight(20);
          table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

          // Table header styling
          JTableHeader header = table.getTableHeader();
          header.setFont(font);
          header.setPreferredSize(new Dimension(header.getWidth(), 25));

          // Scroll pane
          JScrollPane scrollPane = new JScrollPane(table);
          scrollPane.setBounds(30, 330, 1150, 400);
          add(scrollPane);

          //button

          add = new JButton("Add");
          add.setBounds(20, 800, 200, 30);
          add.setFont(font);
          add(add);

          delete = new JButton("Delete");
          delete.setBounds(230, 800, 200, 30);
          delete.setFont(font);
          add(delete);

          edit = new JButton("Edit");
          edit.setBounds(440, 800, 200, 30);
          edit.setFont(font);
          add(edit);

          reset = new JButton("Reset");
          reset.setBounds(650, 800, 200, 30);
          reset.setFont(font);
          add(reset);


          setVisible(true);

          StudentModel studentModel = new StudentModel();
          StudentDAO studentDAO = new StudentDAO();
          this.controller = new StudentController(studentDAO, this, studentModel);
     }
}


