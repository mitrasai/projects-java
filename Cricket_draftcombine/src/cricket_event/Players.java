package cricket_event;

import java.util.*;

public class Players {
	
	private String player_name;
	private int player_age;
	private String player_team;

	/*
	 * This CRICKET stats programmed system is designed and developed to record physical measurements and personal
	 * information of players respectively.
	 * 
	 * 2 scanner objects have been created to record number and string inputs
	 */
	
	public static void main(String[] args) {
		/*
		 * Here, I will be creating 2 player objects and 2 cricket official objects (who will note down the measurements)
		 * And Cricket_Officials can be able to access the variables that have been declared in measurements class.
		 * so, they can intitalize them with the values that they will be taking from the players.
		 */
		
		Scanner player = new Scanner(System.in); //To record String data inputs
		Scanner playermeasure = new Scanner(System.in); //To record Integer data inputs
		
		Date date = new Date();
		
		Measurements cricket_official1 = new Measurements(); //need to declare the players team
		Measurements cricket_official2 = new Measurements();
		Players player1 = new Players();
		Players player2 = new Players();
		
		System.out.println("Welcome to the Cricket Measurement taking section");
		
		//personal information taking
		player1.player_team = "Batters";
		player2.player_team = "Bowlers";
		
		//asking players information
		System.out.println("Enter your Name(Player-1): ");
		player1.player_name = player.nextLine();
		System.out.println("Enter your Name(Player-2): ");
		player2.player_name = player.nextLine();
		
		System.out.println("Enter your Age(Player-1): ");
		player1.player_age = playermeasure.nextInt();
		System.out.println("Enter your Age(Player-2): ");
		player2.player_age = playermeasure.nextInt();
		
		
		//Measurements Taking Section
		System.out.println("Player-1 Height(in feet and inches): ");
		cricket_official1.player_height = playermeasure.nextDouble();
		System.out.println("Player-2 Height(in feet and inches): ");
		cricket_official2.player_height = playermeasure.nextDouble();
		
		System.out.println("Player-1 Weight(in pounds): ");
		cricket_official1.player_weight = playermeasure.nextDouble();
		System.out.println("Player-2 Weight(in pounds): ");
		cricket_official2.player_weight = playermeasure.nextDouble();
		
		
		//calculate BMI
		
		//feet to inches (1 feet = 12 inches)
		double conversionfeetintoinches1 = cricket_official1.player_height * 12;
		double conversionfeetintoinches2 = cricket_official2.player_height * 12;
		
		//BMI = (703*WEIGHT in pounds)/(HEIGHT in inches*HEIGHT in inches)
		double BMI1 = (cricket_official1.player_weight * 703)/(conversionfeetintoinches1 * conversionfeetintoinches1);
		double BMI2 = (cricket_official2.player_weight * 703)/(conversionfeetintoinches2 * conversionfeetintoinches2);
		System.out.println("----------------- Players BMI -----------------");
		System.out.printf("%s %.2f\n","Player-1 BMI", BMI1);
		System.out.printf("%s %.2f\n","Player-2 BMI", BMI2);
		System.out.println("----------------- Players BMI -----------------");
		
		cricket_official1.player_BMI = BMI1;
		cricket_official2.player_BMI = BMI2;
		
		//Display of the information on the Cricket Board Draft Combine
		System.out.println();
		System.out.println("----------------- Cricket Board Draft Combine Event -----------------");
		System.out.printf("%tB %td %tY %n", date, date, date);
		System.out.printf("%30s", "Player's Name");
		System.out.printf("%30s", "Player's Age");
		System.out.printf("%30s", "Height");
		System.out.printf("%30s", "Weight");
		System.out.printf("%30s", "Body Mass Index (BMI)");
		
		System.out.println();
		System.out.printf("%30s", player1.player_name);
		System.out.printf("%30s", player1.player_age);
		System.out.printf("%30s", cricket_official1.player_height);
		System.out.printf("%30s", cricket_official1.player_weight);
		System.out.printf("%30.2f", cricket_official1.player_BMI);
		
		System.out.println();
		System.out.printf("%30s", player2.player_name);
		System.out.printf("%30s", player2.player_age);
		System.out.printf("%30s", cricket_official2.player_height);
		System.out.printf("%30s", cricket_official2.player_weight);
		System.out.printf("%30.2f", cricket_official2.player_BMI);
		
	}

}
