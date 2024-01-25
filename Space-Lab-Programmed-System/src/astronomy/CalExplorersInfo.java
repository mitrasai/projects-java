package astronomy;

import java.util.*;
import java.io.File; //able to read the file, locate the file
import javax.sound.sampled.*; //
import java.io.IOException; //handle errors such as not able to read file path

public class CalExplorersInfo {
	
	/* Name: Sai Mithra
	 * Program Name: Sapcelab_exploration.java
	 * Description: finds the age and weight of the explorers on other planets in solar system
	 * 
	 * clip -> going to be getting the audio clips so that it can play it and we will get an error, 
	 * reason: we have to throw another exception [ineUnavailableException] that's gonna be handling some porblem (i.e., when it is not
	 *         being able to read the path of our audio file from where we have stored.)
	 */

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		Scanner inputNum = new Scanner(System.in);
		Scanner inputStr = new Scanner(System.in);
		
		//creating two telescope objects, one is for focal length and aperture variables and another is for weight and age
		ExplorersInfo telescope_1 = new ExplorersInfo();
		ExplorersInfo telescope_2 = new ExplorersInfo();
		ExplorersInfo expInfo = new ExplorersInfo();
		
		System.out.println("-------------- Welcome -------------");
		
		//Audio insertion
		File file = new File("sampleaudioorg.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		
		//Clip object creation
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		
		System.out.println("This is an Welcome Message along with instructions, which you need to follow!");
		
		System.out.println("Enter P to play audio");
		String userResponse = inputStr.nextLine();
		userResponse = userResponse.toUpperCase();
		
		if(userResponse.equals("P")) {
			clip.start();
			
			
			System.out.println("Enter S to stop or PS to pause");
			userResponse = inputStr.nextLine();
			userResponse = userResponse.toUpperCase();
			
			if(userResponse.equals("S")) {
				clip.stop();
				System.out.println("Thank You! you are ready to go");
			}
			
			else if(userResponse.equals("PS")) {
				long audioPosition = clip.getMicrosecondPosition();
				clip.stop();
				
				System.out.println("Enter R to resume or PB to play from beginning");
				userResponse = inputStr.nextLine();
				userResponse = userResponse.toUpperCase();
				if(userResponse.equals("R")) {
					clip.setMicrosecondPosition(audioPosition);
					clip.start();
					
					System.out.println("Enter EXIT to exit");
					userResponse = inputStr.nextLine();
					userResponse = userResponse.toUpperCase();
					clip.stop();
					
					System.out.println("Thank You! you are ready to go");
				}
				
				else if(userResponse.equals("PB")) {
					clip.setMicrosecondPosition(0);
					clip.start();
					
					System.out.println("Enter EXIT to exit");
					userResponse = inputStr.nextLine();
					userResponse = userResponse.toUpperCase();
					clip.stop();
					
					System.out.println("Thank you");
				}
			}
		}
		
		System.out.println("-------------- Welcome -------------");
		System.out.println();
		
		System.out.println("-------------- Telescopes Focal Ratio's Information -------------");
		System.out.println("Higher focal ratio means higher magnification, which is great for observing Moons, Planets and Stars");
		System.out.println("Lower focal ratio means lower magnification, which is great for observing Clusters and Galaxies.");
		System.out.println("-------------- Telescopes Focal Ratio's Information -------------");
		
		//Telescope-1 Focal Ratio Calculation
		System.out.println();
		System.out.print("Enter Telescope-1 Focal Length(mm): ");
		telescope_1.focalLength = inputNum.nextInt(); //1000
		System.out.print("Enter Telescope-1 Aperture(mm): ");
		telescope_1.aperture = inputNum.nextInt(); //102
		
		telescope_1.focalRatio = telescope_1.focalLength / telescope_1.aperture;
		
		//Telescope-2 Focal Ratio Calculation
		System.out.print("Enter Telescope-2 Focal Length(mm): ");
		telescope_2.focalLength = inputNum.nextInt(); //1270
		System.out.print("Enter Telescope-2 Aperture(mm): ");
		telescope_2.aperture = inputNum.nextInt(); //250
				
		telescope_2.focalRatio = telescope_2.focalLength / telescope_2.aperture;
		System.out.println();
		
		//Displaying focal ratios of telescopes in a tabular form
		System.out.println("---------------------- Telescopes Focal Ratio's Mesurements ---------------------");
		System.out.printf("%20s", "Focal Ratio");
		System.out.printf("%20s", "Telescope Name");
		System.out.printf("%40s", "Capacity Description");
		System.out.println();
		
		System.out.printf("%10s %.2f", "", telescope_1.focalRatio);
		System.out.printf("%30s", "The Skwatcher Evostar");
		System.out.printf("%5s", "");
		if(telescope_1.focalRatio > 7) {
			System.out.printf("%s", "Great for observing Moon, Planets and Stars.");
		}
		else if(telescope_1.focalRatio >= 1 && telescope_1.focalRatio <= 7) {
			System.out.printf("%s","Great for observing Clusters and Galaxies.");
		}
		System.out.println();
		
		System.out.printf("%10s %.2f", "", telescope_2.focalRatio);
		System.out.printf("%30s", "The Celestron Starhopper");
		System.out.printf("%5s", "");
		if(telescope_2.focalRatio > 7) {
			System.out.printf("%s", "Great for observing Moon, Planets and Stars.");
		}
		else if(telescope_2.focalRatio >= 1 && telescope_2.focalRatio <= 7) {
			System.out.printf("%s","Great for observing Clusters and Galaxies.");
		}
		System.out.println();
		System.out.println("---------------------- Telescopes Focal Ratio's Mesurements ---------------------");
		
		//telescope selection
		System.out.println();
		System.out.println("---------------------- Telescopes Selection ---------------------");
		System.out.println("Which telescope would you like to use?\n A.The Skwatcher Evorstar \n B.The celestron Starhooper");
		String chooses = inputStr.nextLine();
		chooses = chooses.toUpperCase();
		
		if(chooses.equals("A") || chooses.equals("B")) {
			System.out.println("Great!");
			
			//age calculations
			System.out.println();
			System.out.println("---------------------- Age and Weight Calculations in other planets ---------------------");
			System.out.print("Enter you age: ");
			expInfo.explorersAge = inputNum.nextDouble();
			System.out.print("Enter you Weight(kg): ");
			expInfo.explorersWeight = inputNum.nextDouble();
			
			//to calculate age in earth days rather than years
			double userAgeInEarth = expInfo.explorersAge * 365;
			
			//to calculate age in every planet
			System.out.println("For which terrestrail planets do you want to calculate your age?\n A.Inner Terrestrail Planets \n B.Outer Terrestrail Planets");
			String choices = inputStr.nextLine();
			choices = choices.toUpperCase();
			
			if(choices.equals("A")) {
				System.out.println("This is Inner Terrestrail Zone, To which planet do you want to check your age?\n A.Mercury\n B.Venus\n C.Mars");
				String plant_choices = inputStr.nextLine();
				plant_choices = plant_choices.toUpperCase();
				
				if(plant_choices.equals("A")) {
					
					//Mercury = 88 earth days (planet orbital period)
					double mercury = 88;
					double userAgeInMercury = userAgeInEarth / mercury;
					
					//formula: wt.of other planet = wt on earth * Planet's gravity that are higher than earth
					double userWeightInMercury = expInfo.explorersWeight * 0.38;
					
					System.out.printf("%.2f %20s %n", userAgeInMercury, "years old on Mercury!");
					System.out.printf("%.2f %20s %n", userWeightInMercury, "kg weighs on Mercury!");
				}
				else if(plant_choices.equals("B")) {
					
					//Venus = 225 earth days
					double venus = 225;
					double userAgeInVenus = userAgeInEarth / venus;
					
					//formula: wt.of other planet = wt on earth * Planet's gravity that are higher than earth
					double userWeightInVenus = expInfo.explorersWeight * 0.91;
					System.out.printf("%.2f %20s %n", userAgeInVenus, "years old on Venus!");
					System.out.printf("%.2f %20s %n", userWeightInVenus, "kg weighs on Venus!");
				}
				else if(plant_choices.equals("C")) {
					
					//Mars = 687 earth days
					double mars = 687;
					double userAgeInMars = userAgeInEarth / mars;
					
					//formula: wt.of other planet = wt on earth * Planet's gravity that are higher than earth
					double userWeightInMars = expInfo.explorersWeight * 0.38;
					System.out.printf("%.2f %20s %n", userAgeInMars, "years old on Mars!");
					System.out.printf("%.2f %20s %n", userWeightInMars, "kg weighs on Mars!");
				}
				else {
					System.out.println("Sorry, we can't get you!!");
				}
			}
			
			else if(choices.equals("B")) {
				System.out.println("This is outer Terrestrail Zone, To which planet do you want to check your age?\n A.Jupiter\n B.Saturn\n C.Uranus\n D.Neptune");
				String outer_choices = inputStr.nextLine();
				outer_choices = outer_choices.toUpperCase();
				
				// age/planet year
				if(outer_choices.equals("A")) {
					
					//Jupiter = 12 earth years
					double jupiter = 12;
					double userAgeInJupiter = expInfo.explorersAge / jupiter;
					
					//formula: wt.of other planet = wt on earth * Planet's gravity that are higher than earth
					double userWeightInJupiter = expInfo.explorersWeight * 2.34;
					System.out.printf("%.2f %20s %n", userAgeInJupiter, "years old on Jupiter!");
					System.out.printf("%.2f %20s %n", userWeightInJupiter, "kg weighs on Jupiter!");
				}
				else if(outer_choices.equals("B")) {
					
					//Saturn = 29.5 earth years;
					double saturn = 29.5;
					double userAgeInSaturn = expInfo.explorersAge / saturn;
					
					//formula: wt.of other planet = wt on earth * Planet's gravity that are higher than earth
					double userWeightInSaturn = expInfo.explorersWeight * 1.06;
					System.out.printf("%.2f %20s %n", userAgeInSaturn, "years old on Saturn!");
					System.out.printf("%.2f %20s %n", userWeightInSaturn, "kg weighs on Saturn!");
				}
				else if(outer_choices.equals("C")) {
					
					//Uranus = 84 earth years;
					double uranus = 84;
					double userAgeInUranus = expInfo.explorersAge / uranus;
					
					//formula: wt.of other planet = wt on earth * Planet's gravity that are higher than earth
					double userWeightInUranus = expInfo.explorersWeight * 0.92;
					System.out.printf("%.2f %20s %n", userAgeInUranus, "years old on Uranus!");
					System.out.printf("%.2f %20s %n", userWeightInUranus, "kg weighs on Uranus!");
				}
				else if(outer_choices.equals("D")) {
					
					//Neptune = 165 earth years
					double neptune = 165;
					double userAgeInNeptune = expInfo.explorersAge / neptune;
					
					//formula: wt.of other planet = wt on earth * Planet's gravity that are higher than earth
					double userWeightInNeptune = expInfo.explorersWeight * 1.19;
					System.out.printf("%.2f %20s %n", userAgeInNeptune, "years old on Neptune!");
					System.out.printf("%.2f %20s %n", userWeightInNeptune, "kg weighs on Neptune!");
				}
				
				else {
					System.out.println("Sorry, we can't get you!!");
				}
			}
			else {
				System.out.println("Sorry, we can't get you!!");
			}
			System.out.println("Thank you for using the space lab programmed system, have a wonderful experience");
		}
		
		else {
			System.out.println("Please choose valid options, which have mentioned above...");
		}
		
	}

}
