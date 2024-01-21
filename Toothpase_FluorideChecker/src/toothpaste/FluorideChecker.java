package toothpaste;

import java.util.*;

public class FluorideChecker {

	public static void main(String[] args) {
		String auth_name = "beginner@123";
		String auth_pass = "Codewithfun@123";
		
		Scanner inputInt = new Scanner(System.in); // to store integer responses from user
		Scanner inputStr = new Scanner(System.in); // to store String responses from user
		
		System.out.printf("%80s %n", "Hi, Welcome to Flouride Percentage(%) Checker");
		System.out.println("Calcuates the flouride percentage, which is present in tooth pastes.");
		System.out.printf("%80s %n", "This System Calculates the percentage upto maximum two toothpastes");
		
		System.out.printf("%80s %n", "-------------- Login Ceredentials -------------");
		System.out.println("Enter Your Name: ");
		String user_name = inputStr.nextLine();
		System.out.println("Enter your Password: ");
		String user_pass = inputStr.nextLine();
		System.out.printf("%80s %n", "-------------- Login Ceredentials -------------");
		
		if(user_name.equals(auth_name) && user_pass.equals(auth_pass)) {
			System.out.println("Welcome " + user_name);
			System.out.printf("%80s %n","How many toothpastes entries you want to enter?");
			
			System.out.println("Entries: ");
			int toothpaste_num = inputInt.nextInt();
			
			if(toothpaste_num == 1) {
				System.out.printf("%80s %n", "-------------- Flouride Percentage(%) Checker in Toothpastes --------------");
				System.out.println("Toothpaste Name: ");
				String toothpaste_name = inputStr.nextLine();
				System.out.println("Flouride Content(g): ");
				double flouride_content = inputInt.nextDouble();
				System.out.println("Toothpaste Weighs in total(g): ");
				double paste_weight = inputInt.nextDouble();
				
				
				// percentage of flouride = (content of flouride present / total paste weight)*100
				double flouride_percent = (flouride_content / paste_weight) * 100;
				System.out.printf("%80s %n", "---------------------- Thank You ----------------------");
				System.out.println();
				
				//displaying our data in a tabular form
				System.out.printf("%20s", "Toothpaste Name");
				System.out.printf("%20s", "Toothpaste Weighs(g)");
				System.out.printf("%20s", "Flouride Content(g)");
				System.out.printf("%25s", "Flouride Percentage(%)");
				System.out.println();
			
				System.out.printf("%15s", toothpaste_name);
				System.out.printf("%20s", paste_weight);
				System.out.printf("%20s", flouride_content);
				System.out.printf("%15s %.2f", "", flouride_percent);
				System.out.println();
			}
			
			else if(toothpaste_num ==2) {
				System.out.printf("%80s %n", "-------------- Flouride Percentage(%) Checker in Toothpastes --------------");
				System.out.println("First Toothpaste Name: ");
				String toothpaste_name1 = inputStr.nextLine();
				System.out.println("Toothpaste Weighs in total(g): ");
				double paste_weight1 = inputInt.nextDouble();
				System.out.println("Flouride Content(g): ");
				double flouride_content1 = inputInt.nextDouble();
				
				// percentage of flouride = (content of flouride present / total paste weight)*100
				double flouride_percent1 = (flouride_content1 / paste_weight1) * 100;
				System.out.printf("%80s %n", "---------------------- Thank You ----------------------");
				System.out.println();
				
				System.out.printf("%80s %n", "-------------- Flouride Percentage(%) Checker in Toothpastes --------------");
				System.out.println("Second Toothpaste Name: ");
				String toothpaste_name2 = inputStr.nextLine();
				System.out.println("Toothpaste Weighs in total(g): ");
				double paste_weight2 = inputInt.nextDouble();
				System.out.println("Flouride Content(g): ");
				double flouride_content2 = inputInt.nextDouble();
				
				// percentage of flouride = (content of flouride present / total paste weight)*100
				double flouride_percent2 = (flouride_content2 / paste_weight2) * 100;
				System.out.printf("%80s %n", "---------------------- Thank You ----------------------");
				System.out.println();
				
				//displaying our data in a tabular form
				System.out.printf("%20s", "Toothpaste Name");
				System.out.printf("%20s", "Toothpaste Weighs(g)");
				System.out.printf("%20s", "Flouride Content(g)");
				System.out.printf("%25s", "Flouride Percentage(%)");
				System.out.println();
			
				System.out.printf("%15s", toothpaste_name1);
				System.out.printf("%20s", paste_weight1);
				System.out.printf("%20s", flouride_content1);
				System.out.printf("%15s %.2f", "", flouride_percent1);
				System.out.println();
				
				System.out.printf("%15s", toothpaste_name2);
				System.out.printf("%20s", paste_weight2);
				System.out.printf("%20s", flouride_content2);
				System.out.printf("%15s %.2f", "", flouride_percent2);
				System.out.println();
				
				System.out.printf("%80s %n", "-------------- Flouride Percentage(%) Analytics --------------");
				if(flouride_percent1 > flouride_percent2) {
					System.out.println("Toothpaste " + toothpaste_name1 + " has high amount of flouride percent, when compared to " + toothpaste_name2);
				}
				else if(flouride_percent2 > flouride_percent1){
					System.out.println("Toothpaste " + toothpaste_name2 + " has high amount of flouride percent, when compared to " + toothpaste_name1);
				}
				else {
					System.out.println("Toothpaste " + toothpaste_name1 + " and " + toothpaste_name2 + ", both has equal amount of flouride percent.");
				}
				System.out.printf("%80s %n", "-------------- Flouride Percentage(%) Analytics --------------");
			}
			
		}
		else {
			System.out.println("Sorry! Invalid Ceredentials, Please re-enter the valid details.");
		}
	}

}
