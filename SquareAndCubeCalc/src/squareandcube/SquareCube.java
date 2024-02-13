package squareandcube;

import java.util.*;
import java.lang.Math;

public class SquareCube {

	public static void main(String[] args) {
		Scanner inputStr = new Scanner(System.in);
		Scanner inputNum = new Scanner(System.in);
		
		System.out.println("Do you want to play a game, which calcualtes the square, cube of a numbers\n yes\n no");
		String userResponse = inputStr.nextLine();
		
		while(userResponse.equalsIgnoreCase("yes")) {
			System.out.println("------- Welcome to the square, cube calculator -------");
			System.out.print("Enter an Number: ");
			int number = inputNum.nextInt();
			
			System.out.println("which operation do you want to perform?\n 1.Square of an number\n 2.Cube of an number");
			int userChoice = inputNum.nextInt();
			
			switch(userChoice) {
			case 1:
				double resultSqr = Math.pow(number, 2);
				System.out.println("Square of an " + number + " is: " + resultSqr);
				break;
			case 2:
				double resultCub = Math.pow(number, 3);
				System.out.println("Cube of an " + number + " is: " + resultCub);
				break;
			default:
				System.out.println("Please Enter an valid option");
			}
			System.out.println("------- Welcome to the square, cube calculator -------");
			System.out.println();
			
			System.out.println("Do you want to play again\n yes\n no");
			userResponse = inputStr.nextLine();
			
			if(userResponse.equalsIgnoreCase("no")) {
				System.out.println("Thank you!!");
			}
		}
		if(userResponse.equalsIgnoreCase("no")) {
			System.out.println("Thank you!!");
		}
	}

}
