package DAO;

import Model.StudentModel;
import Connection.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public int saveStudent(StudentModel student) throws SQLException {
        String sql = """
            INSERT INTO student
            (first_name, last_name, phone_no, email, age, gender, dob, address)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """;

        Connection conn = DbConnection.getConnection();
        if (conn != null) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, student.getFirst_name());
            ps.setString(2, student.getLast_name());
            ps.setString(3, student.getPhone_no());
            ps.setString(4, student.getEmail());
            ps.setString(5, student.getAge());
            ps.setString(6, student.getGender());
            ps.setDate(7, student.getDob() != null ? new java.sql.Date(student.getDob().getTime()) : null);
            ps.setString(8, student.getAddress());

            ps.executeUpdate();
            ps.close();
            System.out.println("Student saved successfully");
            return 1;
        }
        return 0;
    }

    // Retrieve all students from the database
    public List<StudentModel> getAllStudents() throws SQLException {
        List<StudentModel> students = new ArrayList<>();
        String sql = "SELECT * FROM student";

        Connection conn = DbConnection.getConnection();
        if (conn != null) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StudentModel student = new StudentModel();
                student.setFirst_name(rs.getString("first_name"));
                student.setLast_name(rs.getString("last_name"));
                student.setPhone_no(rs.getString("phone_no"));
                student.setEmail(rs.getString("email"));
                student.setAge(rs.getString("age"));
                student.setGender(rs.getString("gender"));
                student.setDob(rs.getDate("dob"));
                student.setAddress(rs.getString("address"));
                students.add(student);
            }
            rs.close();
            ps.close();
        }

        return students;
    }

    // Delete a student by phone number (or any unique column)
    public int deleteStudent(String phone_no) throws SQLException {
        String sql = "DELETE FROM student WHERE phone_no = ?";

        Connection conn = DbConnection.getConnection();
        if (conn != null) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, phone_no);
            int rows = ps.executeUpdate();
            ps.close();
            return rows;
        }
        return 0;
    }

    // Update a student record
    public int updateStudent(StudentModel student) throws SQLException {
        String sql = """
            UPDATE student
            SET first_name = ?, last_name = ?, email = ?, age = ?, gender = ?, dob = ?, address = ?
            WHERE phone_no = ?
        """;

        Connection conn = DbConnection.getConnection();
        if (conn != null) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, student.getFirst_name());
            ps.setString(2, student.getLast_name());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getAge());
            ps.setString(5, student.getGender());
            ps.setDate(6, student.getDob() != null ? new java.sql.Date(student.getDob().getTime()) : null);
            ps.setString(7, student.getAddress());
            ps.setString(8, student.getPhone_no());

            int rows = ps.executeUpdate();
            ps.close();
            return rows;
        }
        return 0;
    }
}

