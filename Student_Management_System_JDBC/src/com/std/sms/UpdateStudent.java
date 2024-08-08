package com.std.sms;

import com.std.sms.config.StudentDataBaseConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.util.InputMismatchException;

public class UpdateStudent {
    public static void updateStudent(Scanner sc){
        System.out.println("----- Update Student -----");
        int id = 0;
        while (true) {
            System.out.print("Enter the ID of the student to update: ");
            try {
                id = sc.nextInt();
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for ID.");
                sc.next();
            }
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        double gpa = 0.0;
        while (true) {
            System.out.print("Enter Student GPA: ");
            try {
                gpa = sc.nextDouble();
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number for GPA.");
                sc.next();
            }
        }

        System.out.print("Enter Student City: ");
        String city = sc.nextLine();

        try{
            Connection connection = StudentDataBaseConfiguration.createConnection();
            String update = "UPDATE students SET std_name = ?, std_gpa = ?, city = ? WHERE std_id = ?";
            PreparedStatement st = connection.prepareStatement(update);
            st.setString(1, name);
            st.setDouble(2, gpa);
            st.setString(3, city);
            st.setInt(4, id);

            int rowsUpdated = st.executeUpdate();
            if(rowsUpdated > 0){
                System.out.println("Student updated successfully.");
            }else{
                System.out.println("Student not found!!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
