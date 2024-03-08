package PH_Analyzer;

import java.util.*;
import java.lang.Math;

/*
 * -log10 * ion concentration -> pH for Acids
 * 14 - pH -> pOH for Acids
 * 
 * Base, find pOH -> -log10 * ion concentration and then pH -> 14 - pOH
 * 
 * for finding Hydrogen ion concentration / hydroxide ion concentration
 * Hydrogen ion -> 10 ^ -pH
 * Hydroxide ion -> 10 ^ -pOH
 * To Calculate pOH -> 14 - pH
 */

public class PH_Scale {
	
	static double soln_con;
	static double pH;
	static double pOH;
	static String user_response;

	public static void main(String[] args)throws Exception {
		
		Scanner numInput = new Scanner(System.in);
		Scanner txtInput = new Scanner(System.in);
		
		System.out.printf("%50s %n", "This System calcualtes the PH Scale for Acids, Bases");
		System.out.println("Would you like to start the system?\n yes\n no");
		String response = txtInput.nextLine();
		
		Thread.sleep(1000);
		while(response.equalsIgnoreCase("yes")) {
			
			System.out.println("     _");
			System.out.println("    | |");
			System.out.println("   {   }");
			System.out.println("  {     }");
			System.out.println(" (_______)");
			
			System.out.println();
			
			//menu section
			Thread.sleep(1000);
			System.out.printf("%50S %n","--------- pH Scale Analyzer ---------");
			System.out.println("What would you like to find?\n 1.pH\n 2.pOH\n 3.[H+]\n 4.[OH-]");
			int choice = numInput.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Is this solution is an\n A.Acidic\n B.Basic?");
				user_response = txtInput.nextLine();
				if(user_response.equalsIgnoreCase("A")) {
					System.out.println("Hydrogen Concentration of the solution(in moles): ");
					soln_con = numInput.nextDouble();
					pH = (-Math.log10(soln_con));
					System.out.printf("%20s %.2f %n","pH value is: ", pH);
				}
				else if(user_response.equalsIgnoreCase("B")) {
					System.out.println("Do you know the pOH value\n 1.Yes\n 2.No");
					int new_res = numInput.nextInt();
					
					if(new_res == 1) {
						System.out.println("Enter pOH value: ");
						pOH = numInput.nextDouble();
						pH = 14 - pOH;
						System.out.printf("%20s %.2f %n","pH value is: ", pH);
					}
					else if(new_res == 2) {
						System.out.println("Hydroxide Concentration of the solution(in moles): ");
						soln_con = numInput.nextDouble();
						pOH = (-Math.log10(soln_con));
						System.out.printf("%20s %.2f %n","pOH value is: ", pOH);
						pH = 14 - pOH;
						System.out.printf("%20s %.2f %n","pH value is: ", pH);
						
					}
					else {
						System.out.println("Enter an valid choice");
					}
				}
				break;
			case 2:
				System.out.println("Is this solution is an\n A.Acidic\n B.Basic?");
				user_response = txtInput.nextLine();
				
				if(user_response.equalsIgnoreCase("A")) {
					System.out.println("Do you know the pH value\n 1.Yes\n 2.No");
					int new_res = numInput.nextInt();
					
					if(new_res == 1) {
						System.out.println("Enter pH value: ");
						pH = numInput.nextDouble();
						pOH = 14 - pH;
						System.out.printf("%20s %.2f %n","pH value is: ", pOH);
					}
					else if(new_res == 2) {
						System.out.println("Enter Hydrogen Concentration of the solution(in moles): ");
						soln_con = numInput.nextDouble();
						pH = (-Math.log10(soln_con));
						System.out.printf("%20s %.2f %n","pOH value is: ", pH);
						pOH = 14 - pH;
						System.out.printf("%20s %.2f %n","pH value is: ", pOH);
					}
				}
				else if(user_response.equalsIgnoreCase("B")) {
					System.out.println("Enter the Hydroxide Concentration of solution (in moles): ");
					soln_con = numInput.nextDouble();
					pOH = (-Math.log10(soln_con));
					System.out.printf("%20s %.2f %n","pH value is: ", pOH);
					}
				break;
				
			case 3:
				//Hydrogen ion concentration of an acidic solution
				System.out.println("Enter pH value of acidic solution (in moles): ");
				pH = numInput.nextDouble();
				double hydro_con = Math.pow(10, (-pH));
				System.out.println("Hydrogen ion concentrarion is --> " + hydro_con + " moles.");
				break;
			case 4:
				//Hydroxide ion concentration of an base solution
				System.out.println("Enter pOH value of base solution (in moles): ");
				pOH = numInput.nextDouble();
				double hydroxide_con = Math.pow(10, (-pOH));
				System.out.println("Hydroxide ion concentrarion is --> " + hydroxide_con + " moles.");
				break;
			default:
				System.out.println("Please choose valid option!!");
				break;
			}
			
			System.out.printf("%50S %n","--------- pH Scale Analyzer ---------");
			System.out.println("would you like to start again?\n yes\n no");
			response = txtInput.nextLine();
		}
		if(response.equalsIgnoreCase("no")) {
			System.out.println("----> Have a nice day!! <----");
		}
	}
}
