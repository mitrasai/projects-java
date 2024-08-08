package com.std.sms;

import com.std.sms.config.StudentDataBaseConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class StudentData {
    private static List<Student> students = new ArrayList<>();
    public static void readStudentData(){
        try{
            Connection connection = StudentDataBaseConfiguration.createConnection();
            String query = "SELECT std_id, std_name, std_gpa, city, university FROM students";
            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                int std_id = rs.getInt("std_id");
                String std_name = rs.getString("std_name");
                double std_gpa = rs.getDouble("std_gpa");
                String city = rs.getString("city");
                String university = rs.getString("university");

                Student student = new Student(std_id, std_name, std_gpa, city, university);
                students.add(student);
            }
            System.out.println("Student data loaded successfully.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void displayStudentsByName(){
        System.out.println("----- Students by Name (Ascending) -----");
        List<Student> sortedStudents = new ArrayList<>(students);
        Collections.sort(sortedStudents, Comparator.comparing(Student :: getStd_name));
        System.out.println("Std_id\tStd_name\tStd_gpa\tCity\tUniversity");
        System.out.println("*******************************************************");
        displayStudents(sortedStudents);
    }

    public static void displayStudentsByGPA(){
        System.out.println("----- Students by GPA (Descending) -----");
        List<Student> sortedStudents = new ArrayList<>(students);
        Collections.sort(sortedStudents, Comparator.comparing(Student :: getStd_gpa).reversed());
        System.out.println("Std_id\tStd_name\tStd_gpa\tCity\tUniversity");
        System.out.println("*******************************************************");
        displayStudents(sortedStudents);
    }

    public static void displayStudents(List<Student> students){
        for(Student student : students){
            System.out.println(student);
        }
    }
}
