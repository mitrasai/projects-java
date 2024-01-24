package medicine;

import java.util.*;
import java.lang.Math;

public class PatientMedication {

	public static void main(String[] args) {
		Scanner inputNum = new Scanner(System.in);
		Scanner inputUser = new Scanner(System.in);
		
		String docsName = "caretaker12";
		String docsPass = "caretaker1234@";
		
		//Welcome Page along with Staff's Authentication
		System.out.printf("%80s %n", "----------- Hello, we welcome you to our Clinical Registraion E-Portal! -----------");
		System.out.printf("%40s %n", "----------- Staff's Authentication Section -----------");
		System.out.print("User Name: ");
		String userName = inputUser.nextLine();
		System.out.print("User Password: ");
		String userPass = inputUser.nextLine();
		System.out.printf("%40s %n", "----------- Staff's Authentication Section -----------");
		System.out.println();
		
		//Validating Staff Details
		if(userName.equals(docsName) && userPass.equals(docsPass)) {
			
			//Receiving Patient Details from console
			System.out.printf("%20s %n", "---------- Patient Details ----------");
			System.out.print("Enter your Name: ");
			String patientName = inputUser.nextLine();
			
			System.out.print("Enter your weight(kg): ");
			double patientWeight = inputNum.nextDouble();
			
			System.out.print("Enter your height(m): ");
			double patientHeight = inputNum.nextDouble();
			System.out.printf("%20s %n", "---------- Patient Details ----------");
			System.out.println();
			
			//Validating Patient's Details
			if(patientWeight <= 0 || patientHeight <= 0) {
				System.out.println("You have entered invalid values for weight or height");
			}
			else {
				
				
				//Calculating BMI (Body Mass Index) = weight/(height*height)
				double bmi = patientWeight / (patientHeight * patientHeight);
				
				//Displaying Patient's BMI
				System.out.printf("%20s %n","--------- Patient's Body Mass Index (BMI) ----------");
				System.out.printf("%20s %.2f %s %n", "Patient's BMI Result: ", bmi, "kg/m^2");
				
				if(bmi < 18.5) {
					System.out.println("It comes under Underweight category.");
				}
				else if((bmi >= 18.5) && (bmi <= 24.9)) {
					System.out.println("Hurray, You seems to be an Healthy.");
				}
				else if ((bmi >= 25.0) && (bmi <= 29.9)){
					System.out.println("It comes under Overweight category.");
				}
				else if(bmi >= 30.0){
					System.out.println("Caution! -> Obesity Problem <-");
				}
				System.out.printf("%20s %n","--------- Patient's Body Mass Index (BMI) ----------");
				System.out.println();
				
				
				//Calculating BSA (Body Surface Area) = sqrt of ((height in cm times weight) / 3600)
				double patientHeightCm = patientHeight * 100;
				double bsa = Math.sqrt((patientHeightCm * patientWeight) / 3600);
				
				//Displaying Patient's BSA
				System.out.printf("%20s %n","--------- Patient's Body Surface Area (BSA) ----------");				
				System.out.printf("%20s %.2f %s %n", "Patient's BSA Result: ", bsa, "m^2");
				System.out.printf("%20s %n","--------- Patient's Body Surface Area (BSA) ----------");
				
				
				//Calculating CI (Cardiac Index) = patient cardiac output / body surface area of a patient
				System.out.println();
				System.out.printf("%20s %n","--------- Patient's Cardiac Index (CI) ----------");
				System.out.print("Patient's Cardiac Output(Liters/Minute): ");
				double patientCardiac = inputNum.nextDouble();
				
				double ci = patientCardiac / bsa;
				System.out.printf("%20s %.2f %s %n", "Patient's Cardia Index Result: ", ci, "liters/minute/m^2");
				System.out.printf("%20s %n","--------- Patient's Cardiac Index (CI) ----------");
				
				//For Both Child and Adult Medication Dosages
				System.out.println();
				System.out.printf("%20s %n","--------- Medical Dosages ----------");
				System.out.print("Drug Name: ");
				String drug = inputUser.nextLine();
				
				System.out.print("Drug dosage(mg): ");
				int dose = inputNum.nextInt();
				
				//formula = (bsa/1.73)*dose
				double medication = (bsa/1.73)*dose;
				
				System.out.println("Name of the drug is: " + drug);
				System.out.printf("%20s %.2f %s %n", "Patient's Medication Dosage: ", medication, "mg");
				System.out.printf("%20s %n","--------- Medical Dosages ----------");
			}
			inputUser.close();
			inputNum.close();
			System.out.println();
			System.out.println("Thank You for visiting us! Mr." + patientName);
		}
		
		else {
			System.out.println("Invalid credentials!!, come back later....");
		}
	}

}
