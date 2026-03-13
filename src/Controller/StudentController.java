package Controller;

import DAO.StudentDAO;
import Model.StudentModel;
import View.StudentView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class StudentController {
    private StudentDAO studentDAO;
    private StudentView studentView;
    private StudentModel student;

    public StudentController(StudentDAO studentDAO, StudentView studentView, StudentModel student) {
        this.studentDAO = studentDAO;
        this.studentView = studentView;
        this.student = student;

        // Attach action listeners to buttons
        studentView.add.addActionListener(e -> saveStudent());
        studentView.delete.addActionListener(e -> deleteStudent());
        studentView.edit.addActionListener(e -> updateStudent());
        studentView.reset.addActionListener(e -> clearFields());

        loadStudents();

        studentView.table.getSelectionModel().addListSelectionListener(e -> fillFieldsFromSelectedRow());
    }

    private void saveStudent() {
        populateStudentFromFields();
        try {
            int result = studentDAO.saveStudent(student);
            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Student saved successfully");
                clearFields();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        refreshTable();
    }

    private void deleteStudent() {
        String phone = studentView.phone_no.getText();
        if (phone.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter phone number to delete student");
            return;
        }
        try {
            int result = studentDAO.deleteStudent(phone);
            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Student deleted successfully");
                clearFields();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        refreshTable();
    }

    private void updateStudent() {
        populateStudentFromFields();
        try {
            int result = studentDAO.updateStudent(student);
            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Student updated successfully");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        refreshTable();
    }

    private void populateStudentFromFields() {
        student.setFirst_name(studentView.first_name.getText());
        student.setLast_name(studentView.last_name.getText());
        student.setPhone_no(studentView.phone_no.getText());
        student.setEmail(studentView.email.getText());
        student.setAge(studentView.age.getText());
        student.setGender(studentView.gender.getText());
        student.setAddress(studentView.address.getText());

        try {
            String dobText = studentView.dob.getText();
            if (!dobText.isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                student.setDob(sdf.parse(dobText));
            } else {
                student.setDob(null);
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    private void clearFields() {
        studentView.first_name.setText("");
        studentView.last_name.setText("");
        studentView.phone_no.setText("");
        studentView.email.setText("");
        studentView.age.setText("");
        studentView.gender.setText("");
        studentView.dob.setText("");
        studentView.address.setText("");
        studentView.first_name.requestFocus();
    }

    public void loadStudents() {
        try {
            List<StudentModel> students = studentDAO.getAllStudents();
            DefaultTableModel model = (DefaultTableModel) studentView.table.getModel();
            model.setRowCount(0); // clear table
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for (StudentModel s : students) {
                model.addRow(new Object[]{
                        s.getFirst_name(),
                        s.getLast_name(),
                        s.getPhone_no(),
                        s.getEmail(),
                        s.getAge(),
                        s.getGender(),
                        s.getDob() != null ? sdf.format(s.getDob()) : "",
                        s.getAddress()
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void refreshTable() {
        studentView.tableModel.setRowCount(0);
        loadStudents();
    }

    private void fillFieldsFromSelectedRow() {
        int row = studentView.table.getSelectedRow();
        if (row >= 0) {
            studentView.first_name.setText(studentView.table.getValueAt(row, 0).toString());
            studentView.last_name.setText(studentView.table.getValueAt(row, 1).toString());
            studentView.phone_no.setText(studentView.table.getValueAt(row, 2).toString());
            studentView.email.setText(studentView.table.getValueAt(row, 3).toString());
            studentView.age.setText(studentView.table.getValueAt(row, 4).toString());
            studentView.gender.setText(studentView.table.getValueAt(row, 5).toString());
            studentView.dob.setText(studentView.table.getValueAt(row, 6).toString());
            studentView.address.setText(studentView.table.getValueAt(row, 7).toString());
        }
    }
}
