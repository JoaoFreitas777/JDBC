package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListStudents {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM students";
            try (Statement stmt = connection.createStatement()) {
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    String email = rs.getString("email");

                    System.out.println(id + "\t" + name + "\t" + age + "\t" + email);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}