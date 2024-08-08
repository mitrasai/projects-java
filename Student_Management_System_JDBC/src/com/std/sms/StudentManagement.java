package com.std.sms;

import java.util.*;

public class StudentManagement {

    public static void main(String[] args) {
        StudentData.readStudentData();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while(!exit){
            System.out.println("----- Student Management System -----");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Update Student");
            System.out.println("4. Display Students By Name (Ascending)");
            System.out.println("5. Display Students By GPA (Descending)");
            System.out.println("6. Exit");
            System.out.print("Choose a choice: ");
            int user_choice = sc.nextInt();

            switch (user_choice){
                case 1:
                    // inserting students
                    InsertStudent.addStudent(sc);
                    break;
                case 2:
                    // remove student
                    RemoveStudent.removeStudent(sc);
                    break;
                case 3:
                    // update student
                    UpdateStudent.updateStudent(sc);
                    break;
                case 4:
                    // displaying students by their name
                    StudentData.displayStudentsByName();
                    break;
                case 5:
                    // displaying student by their gpa
                    StudentData.displayStudentsByGPA();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Thank you for using the Student Management System.");
                    break;
                default:
                    System.out.println("Invalid Choice, Please choose again!!");
                    break;
            }
        }
    }
}