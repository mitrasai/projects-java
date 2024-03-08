package Number_Guess;

import java.util.*;

public class Guessing_Game {
	
	static int score = 0;

	public static void main(String[] args) throws Exception {
		
		Scanner numInput = new Scanner(System.in);
		Scanner txtInput = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.printf("%60s %n", "---- Weclome to the Random Number Guessing Game ----");
		System.out.println();
		System.out.println("In this game, you have been given 3 chances to guess the number correctly");
		System.out.println("The number ranges from 1 to 50");
		System.out.println();
		
		System.out.println("Would you like to start the game?\n yes\n no");
		String response = txtInput.nextLine();
		
		while(response.equalsIgnoreCase("yes")) {
			
			Thread.sleep(1000);
			for(int num=1; num<=3; num++) {
				if(num == 1) {
					int choice = rand.nextInt(50);
					System.out.println("1st Chance, guess the number that computer picked from 1 to 50:- ");
					int user_res = numInput.nextInt();
					
					if(user_res == choice) {
						System.out.println("Great!, Guessed number is correct");
						score = score + 1;
					}
					else if(user_res != choice) {
						System.out.println("You are guess is incorrect!");
					}
				}
				else if(num == 2) {
					int choice = rand.nextInt(50);
					System.out.println("2nd Chance, guess the number that computer picked from 1 to 50:- ");
					int user_res = numInput.nextInt();
					
					if(user_res == choice) {
						System.out.println("Great!, Guessed number is correct");
						score = score + 1;
					}
					else if(user_res != choice) {
						System.out.println("You are guess is incorrect!");
					}
				}
				else if(num == 3) {
					int choice = rand.nextInt(50);
					System.out.println("3rd Chance, guess the number that computer picked from 1 to 50:- ");
					int user_res = numInput.nextInt();
					
					if(user_res == choice) {
						System.out.println("Great!, Guessed number is correct");
						score = score + 1;
					}
					else if(user_res != choice) {
						System.out.println("You are guess is incorrect!");
					}
				}
				System.out.println("You have passed " + score + " out of 3 guesses in total");
			}
			
//			System.out.println("Final Score is -> " + score);
			
			System.out.println("Would you like to play again?\n yes\n no");
			response = txtInput.nextLine();
			
			score = 0;
		}
		if(response.equalsIgnoreCase("no")) {
			System.out.println("Have a nice day");
		}
		
	}

}
