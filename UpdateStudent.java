package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateStudent {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter student ID to update:");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.println("Enter new student name:");
            String name = scanner.nextLine();

            System.out.println("Enter new student age:");
            int age = scanner.nextInt();

            System.out.println("Enter new student email:");
            String email = scanner.next();

            String sql = "UPDATE students SET name = ?, age = ?, email = ? WHERE id = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, name);
                pstmt.setInt(2, age);
                pstmt.setString(3, email);
                pstmt.setInt(4, id);
                pstmt.executeUpdate();
                System.out.println("Student updated successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}