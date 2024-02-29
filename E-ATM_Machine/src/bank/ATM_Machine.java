package bank;

import java.util.*;
import java.lang.*;

public class ATM_Machine {
	static double balance = 100;

	public static void main(String[] args) throws Exception {
		//it catches any errors that may occur, specially when we import Thread package
		
		Scanner txtInput = new Scanner(System.in);
		Scanner numInput = new Scanner(System.in);
		System.out.printf("%30s %n","Welcome to our ATM Machine");
		System.out.println(Colors.GREEN_BRIGHT + "Please hit ----> ENTER <---- to start");
		String cst_response = txtInput.nextLine();
		System.out.print(Colors.RESET);
		System.out.printf("%30s %n","Welcome to our ATM Machine");
		System.out.println();
		
		System.out.println(Colors.ORANGE + "Enter your 12-digit account number: ");
		String accNum = txtInput.nextLine();
		System.out.println(Colors.ORANGE + "Enter your 4-digit pin: ");
		String accPin = txtInput.nextLine();
		
		while(cst_response.equals("")) {
			if(accNum.length() == 12 && accPin.length() == 4) {
				System.out.println(Colors.CYAN + "Please wait, while we are verifying your details");
				Thread.sleep(2000);
				System.out.println(Colors.RESET+"--------> MENU <--------");
				Thread.sleep(1000);
				System.out.println("Select an operation, you would like to do?");
				System.out.printf("%20s %n","1. Display Balance");
				System.out.printf("%19s %n","2. Withdraw Funds");
				System.out.printf("%18s %n","3. Deposit Funds");
				System.out.printf("%21s %n","4. Return your card");
				System.out.println("--------> MENU <--------");
				int choice = numInput.nextInt();
				
				Thread.sleep(1000);
				if(choice == 1) {
					System.out.println(Colors.GREEN_BOLD + "Current Balance is: " + balance + " INR");
				}
				else if(choice == 2) {
					System.out.println(Colors.RESET + "How much would you like to withdraw?");
					double withdraw = numInput.nextDouble();
					
					if(withdraw > balance) {
						System.out.println(Colors.RED_BOLD + "----> Insufficent Balance!! <----");
					}
					else if(withdraw <= balance) {
						Thread.sleep(1000);
						System.out.println(Colors.RESET + "Please wait to collect your money from the cas dispenser");
						
						balance = balance - withdraw;
						System.out.println(Colors.GREEN_BOLD + "Updated Balance is: " + balance + " INR");
					}
				}
				else if(choice == 3) {
					System.out.println(Colors.RESET + "How much would you like to deposit?");
					double deposit = numInput.nextDouble();
					System.out.println("Please enter the amount into the deposit slot");
					Thread.sleep(2000);
					
					balance = balance + deposit;
					System.out.println(Colors.GREEN_BOLD + "Updated Balance is: " + balance + " INR");
				}
				else if(choice == 4) {
					System.out.println(Colors.GREEN_BRIGHT + "Please collect your card from the card reader");
				}
				else {
					System.out.println(Colors.RED_BOLD + "Sorry, Entered an incorrect option!!");
				}
			}
			else {
				System.out.println(Colors.RED_BOLD + "Please enter valid account details!!");
				System.exit(0);
			}
			
			System.out.println();
			Thread.sleep(3000);
			System.out.println(Colors.RESET + "Please hit ----> ENTER <---- to start again");
			cst_response = txtInput.nextLine();
		}
		if(!cst_response.equals("")) {
			System.out.println("Thank you, Have a nice day!!");
			System.exit(0);
		}
		txtInput.close();
		numInput.close();
	}

}
