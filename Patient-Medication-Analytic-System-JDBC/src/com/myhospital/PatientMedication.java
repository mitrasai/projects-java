package com.myhospital;

import java.util.*;

public class PatientMedication {
    public static void main(String[] args) throws InterruptedException{
        Scanner numInput = new Scanner(System.in);
        Scanner txtInput = new Scanner(System.in);
        String docName = "caretaker12";
        String docPassword = "caretaker1234@";

        // Welcome page along with staff authentication
        System.out.printf("%80s %n", "----------- Hello, Welcome To Our Clinical Registration E-Portal! -----------");
        Thread.sleep(2000);
        System.out.printf("%40s %n", "----------- Staff's Authentication Section -----------");
        System.out.print("User Name: ");
        String userName = txtInput.nextLine();
        System.out.print("User Password: ");
        String userPass = txtInput.nextLine();
        System.out.printf("%40s %n", "----------- Staff's Authentication Section -----------");
        System.out.println();
        Thread.sleep(2000);

        // validating staff details
        if(userName.equalsIgnoreCase(docName) && userPass.equalsIgnoreCase(docPassword)){
            boolean continueEnrolling = true;
            while(continueEnrolling){
                // receiving patient details
                System.out.printf("%20s %n", "---------- Patient Details ----------");
                System.out.println("Disclaimer: Must and should enter valid patient details");
                Thread.sleep(4000);
                System.out.println();
                System.out.print("Enter Your Name: ");
                String patientName = txtInput.nextLine();
                System.out.print("Enter Your Weight(kg): ");
                double patientWeight = numInput.nextDouble();
                System.out.print("Enter Your Height(m): ");
                double patientHeight = numInput.nextDouble();
                System.out.print("Enter Your Contact Number: ");
                String contactNumber = txtInput.nextLine();
                System.out.print("Enter Your Email: ");
                String email = txtInput.nextLine();
                System.out.printf("%20s %n", "---------- Patient Details ----------");
                System.out.println();
                Thread.sleep(2000);

                // validate patients details
                if(patientWeight <= 0 || patientHeight <=0){
                    System.out.println("You have entered invalid values for weight or height");
                }
                else{
                    System.out.printf("%20s %n","--------- Patient's Body Mass Index (BMI) ----------");
                    // calculate BMI
                    double bmi = patientWeight / (patientHeight * patientHeight);
                    String bmiCategory = categorizeBMI(bmi);
                    // displaying patient's bmi
                    Thread.sleep(2000);
                    System.out.printf("%20s %.2f %s %s %s %n", "Patient's BMI Result: ", bmi, "kg/m^2", "and category is: ", bmiCategory);
                    System.out.printf("%20s %n","--------- Patient's Body Mass Index (BMI) ----------");
                    System.out.println();
                    Thread.sleep(2000);

                    System.out.printf("%20s %n","--------- Patient's Body Surface Area (BSA) ----------");
                    // calculate BSA
                    double patientHeightCM = patientHeight * 100;
                    double bsa = Math.sqrt((patientHeightCM * patientWeight) / 3600);
                    // displaying patient's bsa
                    Thread.sleep(2000);
                    System.out.printf("%20s %.2f %s %n", "Patient's BSA Result: ", bsa, "m^2");
                    System.out.printf("%20s %n","--------- Patient's Body Surface Area (BSA) ----------");
                    System.out.println();
                    Thread.sleep(2000);

                    System.out.printf("%20s %n","--------- Patient's Cardiac Index (CI) ----------");
                    // calculate CI - for this we must know their cardiac output
                    System.out.print("Patient's Cardiac Output(liters/minute): ");
                    double patientCardiac= numInput.nextDouble();
                    double ci = patientCardiac / bsa;
                    System.out.printf("%20s %.2f %s %n", "Patient's Cardiac Index Result: ", ci, "liters/minute/m^2");
                    System.out.printf("%20s %n","--------- Patient's Cardiac Index (CI) ----------");
                    System.out.println();
                    Thread.sleep(2000);

                    System.out.printf("%20s %n","--------- Medical Dosages ----------");
                    // calculate medication dosage, we must know the drug dose along with name
                    System.out.print("Enter Drug Name: ");
                    String drug = txtInput.nextLine();
                    System.out.print("Drug dosage(mg): ");
                    int dose = numInput.nextInt();
                    double medication = (bsa / 1.73) * dose;
                    System.out.println("Name of the drug is: " + drug);
                    System.out.printf("%20s %.2f %s %n", "Patient's Medication Dosage: ", medication, "mg");
                    System.out.printf("%20s %n","--------- Medical Dosages ----------");

                    // inserting patient details in the database
                    StorePatientDetails.insertPatientInfo(patientName, contactNumber, email,
                            patientWeight, patientHeight, bmi, bmiCategory, bsa, patientCardiac,
                            ci, drug, dose, medication);
                }
                // ask if the doctor wants to continue enrolling new patients;
                System.out.println();
                System.out.print("Do you want to continue enrolling new patient details? (yes/no): ");
                String response = txtInput.nextLine();
                if(response.equalsIgnoreCase("no")) {
                    continueEnrolling = false;
                    System.out.println("Thank You! For Visiting Us Mr." + patientName);
                }
            }
        }else System.out.println("Invalid Credentials!");
        numInput.close();
        txtInput.close();
    }

    private static String categorizeBMI(double bmi){
        if(bmi < 18.5) return "Under-Weight";
        else if(bmi <= 24.9) return "Healthy";
        else if(bmi <= 29.9) return "Over-Weight";
        else return "Obesity";
    }

}