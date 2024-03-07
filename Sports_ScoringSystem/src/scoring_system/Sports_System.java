package scoring_system;

import java.util.*;
import java.lang.*;

public class Sports_System {

	public static void main(String[] args) throws Exception{
		Scanner txtInput = new Scanner(System.in);
		Scanner numInput = new Scanner(System.in);
		
		System.out.printf("%50s %n", "Welcome to the sports scoring system");
		System.out.println("Would you like to start calculating your scores?\n yes\n no");
		String response = txtInput.nextLine();
		Thread.sleep(1000);
		
		do {
			System.out.println("");
			System.out.println("Choose a sport\n 1.Golf\n 2.Soccer");
			int choice = numInput.nextInt();
			
			if(choice == 1) {
				System.out.println("---------- Golf Scoring System ----------");
				
				Thread.sleep(2000);
				//calculating score
				System.out.printf("%20s", "----> Golf Scoring System - Stableford\n");
				System.out.println("Enter the number of strokes: ");
				int strokes = numInput.nextInt();
				System.out.println("Enter the par value: ");
				int par = numInput.nextInt();
				
				Thread.sleep(1000);
				int score = strokes - par;
				if(score == 2) {
					System.out.println("Stableford point: Double Bogey/Wipe\n Point Value: 0 points");
				}
				else if(score == 1) {
					System.out.println("Stableford point: Bogey\n Point Value: 1 point");
				}
				else if(strokes == par) {
					System.out.println("Stableford point: par\n Point Value: 2 points");
				}
				else if(score == -1) {
					System.out.println("Stableford point: Birdie\n Point Value: 3 points");
				}
				else if(score == -2) {
					System.out.println("Stableford point: Eagle\n Point Value: 4 points");
				}
				else if(score == -3) {
					System.out.println("Stableford point: Albatross\n Point Value: 5 points");
				}
				else if(score == -4) {
					System.out.println("Stableford point: Condor\n Point Value: 6 points");
				}
				else {
					System.out.println("Par value is greater than Strokes value");
				}
				
				System.out.println("---------- Golf Scoring System ----------");
			}
			else if(choice == 2) {
				System.out.println("---------- Soccer Scoring System ----------");
				
				Thread.sleep(2000);
				//calculating score
				System.out.printf("%20s", "----> Soccer Scoring System\n");
				System.out.println("Number of Shots: ");
				double shots = numInput.nextDouble();
				System.out.println("Number of Saves: ");
				double saves = numInput.nextDouble();
				System.out.println("Number of Goals: ");
				double goals = numInput.nextDouble();
				
				//save percentage calculation and shooting percentage
				Thread.sleep(1000);
				double save_percent = Math.round((saves/shots)*100);
				double shoot_percent = Math.round((goals/shots)*100);
				
				//pdo calculation(adding save percentage with shooting percentage)
				double pdo = save_percent + shoot_percent;
				
				Thread.sleep(1000);
				System.out.println("Save Percentage(%) --> " + save_percent);
				System.out.println("Shooting Percentage(%) --> " + shoot_percent);
				System.out.println("PDO score: " + pdo + "%");
				
				//checking team performance
				if(pdo > 100) {
					System.out.println("Performing better than expect");
				}
				else if(pdo < 100) {
					System.out.println("Performing worst than expect, needs a luck!");
				}
				else {
					System.out.println("PDO is at 100%, performing --> better");
				}
				System.out.println("---------- Soccer Scoring System ----------");
				
				System.out.println("Would you like to start calculating your scores again?\n yes\n no");
				response = txtInput.nextLine();
			}
			
		}while(response.equalsIgnoreCase("yes"));
		
		if(response.equalsIgnoreCase("no")) {
			System.out.println("Have a nice day!!");
		}

	}

}
