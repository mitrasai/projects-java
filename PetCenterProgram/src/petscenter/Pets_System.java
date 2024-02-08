package petscenter;

import java.util.*;
import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Pets_System {
	
	static double dogFactor;
	static double catFactor;
	static double mer;

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
		Scanner inputNum = new Scanner(System.in); // to store numbers
		Scanner inputStr = new Scanner(System.in); // to store character as well as string
		Scanner inputChoice = new Scanner(System.in); // to store choices
		System.out.println("Would you like to start the system\n yes\n no");
		String docResponse = inputStr.nextLine();
		docResponse = docResponse.toLowerCase();
		
		while(docResponse.equals("yes")) {
			System.out.println(Console_Colors.ORANGE + "-------- Welcome to the pet's center programmed system -------");
			System.out.println("Kindly please listen to our message");
			
			//inserting an audio
			File file = new File("petsAudio.wav");
			AudioInputStream stream = AudioSystem.getAudioInputStream(file); //throws exceptions
			//creating an clip object
			Clip clip = AudioSystem.getClip();
			clip.open(stream);
			System.out.println("Enter P to play the message");
			String mssg = inputChoice.nextLine();
			mssg = mssg.toLowerCase();
			
			if(mssg.equals("p")) {
				clip.start();
				
				Thread.sleep(15000);
				System.out.println(Console_Colors.RESET);
				System.out.println("-------- Information -------");
				System.out.println("Type of pet\n dog\n cat");
				String petType = inputStr.nextLine();
				petType = petType.toLowerCase();
				
				if(petType.equals("dog")) {
					System.out.print(Console_Colors.BROWN + "Enter the Dog's Name: ");
					String dogName = inputStr.nextLine();
					System.out.print(Console_Colors.FOREST_GREEN + "Enter the Dog's Breed: ");
					String dogBreed = inputStr.nextLine();
					System.out.print(Console_Colors.BLUE_BRIGHT + "Enter the Dog's Age: ");
					int dogAge = inputNum.nextInt();
					System.out.print(Console_Colors.CYAN + "Enter the Dog's Weight(in kg): ");
					double dogWeight = inputNum.nextDouble();
					System.out.println(Console_Colors.RESET);
					System.out.println("-------- Information -------");
					
					System.out.println(Console_Colors.RESET);
					System.out.println(Console_Colors.CYAN + "Calculations");
					System.out.println(Console_Colors.RESET);
					
					System.out.println("-------- Resting Energy Requirements(RER) --------");
					//factor table
					System.out.println(Console_Colors.WHITE_BOLD);
					System.out.println("Please have a look at the factor table below and select the dog type");
					System.out.printf("%30s %35s %25s %n", "Options", "Dog Type", "Factor");
					System.out.printf("%30s %35s %25s %n", "A", "Puppy(0-4 years)", "3.0");
					System.out.printf("%30s %35s %25s %n", "B", "Adult Puppy(4 years)", "2.0");
					System.out.printf("%30s %35s %25s %n", "C", "Adult(Inactive/obese)", "1.2");
					System.out.printf("%30s %35s %25s", "D", "Adult(neutered/spayed)", "1.6");
					System.out.println();
					
					System.out.println("Size of the dog(small, medium, large): ");
					String dogSize = inputStr.nextLine();
					dogSize = dogSize.toLowerCase();
					
					if(dogSize.equals("small") || dogSize.equals("large")) {
						//for small and large-sized = 70*(body weight in kilograms)^0.75
						//0.75 = 3/4
						
						double rer = Math.round(70 * Math.pow(dogWeight, 0.75));
						System.out.println(Console_Colors.RED_BOLD + "Resting Energy Requirements is(cal/day): " + rer);
						System.out.println(Console_Colors.RESET);
						System.out.println("-------- Resting Energy Requirements(RER) --------");
						System.out.println();
						
						System.out.println("-------- Maintenance Enegy Requirements(MER) --------");
						System.out.println("Dog Type(enter options A to D): ");
						String dogType = inputChoice.nextLine();
						dogType = dogType.toLowerCase();
						if(dogType.equals("a")) {
							dogFactor = 3.0;
						}
						else if(dogType.equals("b")) {
							dogFactor = 2.0;
						}
						else if(dogType.equals("c")) {
							dogFactor = 1.2;
						}
						else if(dogType.equals("d")) {
							dogFactor = 1.6;
						}
						else {
							System.out.println(Console_Colors.RED_BOLD_BRIGHT + "please enter valid options");
						}
						
						mer = rer * dogFactor;
						System.out.println(Console_Colors.RED_BOLD + "Maintenance Energy Requirements is(cal/day): " + mer);
						System.out.println(Console_Colors.RESET);
						System.out.println("-------- Maintenance Enegy Requirements(MER) --------");
					}
					
					else if(dogSize.equals("medium")) {
						//for medium-sized = 30*(body weight in kilograms)+70
						
						double rer = Math.round(30 * dogWeight + 70);
						System.out.println(Console_Colors.RED_BOLD + "Resting Energy Requirements is(cal/day): " + rer);
						System.out.println(Console_Colors.RESET);
						System.out.println("-------- Resting Energy Requirements(RER) --------");
						System.out.println();
						
						System.out.println("-------- Maintenance Enegy Requirements(MER) --------");
						System.out.println("Dog Type(enter options A to D): ");
						String dogType = inputChoice.nextLine();
						dogType = dogType.toLowerCase();
						if(dogType.equals("a")) {
							dogFactor = 3.0;
						}
						else if(dogType.equals("b")) {
							dogFactor = 2.0;
						}
						else if(dogType.equals("c")) {
							dogFactor = 1.2;
						}
						else if(dogType.equals("d")) {
							dogFactor = 1.6;
						}
						else {
							System.out.println(Console_Colors.RED_BOLD_BRIGHT + "please enter valid options");
						}
						
						mer = rer * dogFactor;
						System.out.println(Console_Colors.RED_BOLD + "Maintenance Energy Requirements is(cal/day): " + mer);
						System.out.println(Console_Colors.RESET);
						System.out.println("-------- Maintenance Enegy Requirements(MER) --------");
					}
					else {
						System.out.println(Console_Colors.RED_BOLD_BRIGHT + "Please choose correct dog type options(small, medium, large)");
					}
				}
				
				//cat
				else if(petType.equals("cat")) {
					System.out.print(Console_Colors.BROWN + "Enter the Cat's Name: ");
					String catName = inputStr.nextLine();
					System.out.print(Console_Colors.FOREST_GREEN + "Enter the Cat's Breed: ");
					String catBreed = inputStr.nextLine();
					System.out.print(Console_Colors.BLUE_BRIGHT + "Enter the Cat's Age: ");
					int catAge = inputNum.nextInt();
					System.out.print(Console_Colors.CYAN + "Enter the Cat's Weight(in kg): ");
					double catWeight = inputNum.nextDouble();
					System.out.println(Console_Colors.RESET);
					System.out.println("-------- Information -------");
					
					System.out.println(Console_Colors.RESET);
					System.out.println(Console_Colors.CYAN + "Calculations");
					System.out.println(Console_Colors.RESET);
					
					System.out.println("-------- Resting Energy Requirements(RER) --------");
					//factor table
					System.out.println(Console_Colors.WHITE_BOLD);
					System.out.println("Please have a look at the factor table below and select the dog type");
					System.out.printf("%30s %35s %25s %n", "Options", "Cat Type", "Factor");
					System.out.printf("%30s %35s %25s %n", "A", "Kitten(0-4 years)", "3.0");
					System.out.printf("%30s %35s %25s %n", "B", "Adult Kitten(4 years)", "2.0");
					System.out.printf("%30s %35s %25s %n", "C", "Adult(obese)", "1.0");
					System.out.printf("%30s %35s %25s", "D", "Adult(neutered/spayed)", "1.2");
					System.out.println();
					
					System.out.println("Size of the cat(small, medium, large): ");
					String catSize = inputStr.nextLine();
					catSize = catSize.toLowerCase();
					
					if(catSize.equals("small") || catSize.equals("large")) {
						//for small and large-sized = 70*(body weight in kilograms)^0.75
						//0.75 = 3/4
						
						double rer = Math.round(70 * Math.pow(catWeight, 0.75));
						System.out.println(Console_Colors.RED_BOLD + "Resting Energy Requirements is(cal/day): " + rer);
						System.out.println(Console_Colors.RESET);
						System.out.println("-------- Resting Energy Requirements(RER) --------");
						System.out.println();
						
						System.out.println("-------- Maintenance Enegy Requirements(MER) --------");
						System.out.println("Cat Type(enter options A to D): ");
						String catType = inputChoice.nextLine();
						catType = catType.toLowerCase();
						if(catType.equals("a")) {
							catFactor = 3.0;
						}
						else if(catType.equals("b")) {
							catFactor = 2.0;
						}
						else if(catType.equals("c")) {
							catFactor = 1.0;
						}
						else if(catType.equals("d")) {
							catFactor = 1.2;
						}
						else {
							System.out.println(Console_Colors.RED_BOLD_BRIGHT + "please enter valid options");
						}
						
						mer = rer * catFactor;
						System.out.println(Console_Colors.RED_BOLD + "Maintenance Energy Requirements is(cal/day): " + mer);
						System.out.println(Console_Colors.RESET);
						System.out.println("-------- Maintenance Enegy Requirements(MER) --------");
					}
					
					else if(catSize.equals("medium")) {
						//for medium-sized = 30*(body weight in kilograms)+70
						
						double rer = Math.round(30 * catWeight + 70);
						System.out.println(Console_Colors.RED_BOLD + "Resting Energy Requirements is(cal/day): " + rer);
						System.out.println(Console_Colors.RESET);
						System.out.println("-------- Resting Energy Requirements(RER) --------");
						System.out.println();
						
						System.out.println("-------- Maintenance Enegy Requirements(MER) --------");
						System.out.println("Cat Type(enter options A to D): ");
						String catType = inputChoice.nextLine();
						catType = catType.toLowerCase();
						if(catType.equals("a")) {
							catFactor = 3.0;
						}
						else if(catType.equals("b")) {
							catFactor = 2.0;
						}
						else if(catType.equals("c")) {
							catFactor = 1.2;
						}
						else if(catType.equals("d")) {
							catFactor = 1.6;
						}
						else {
							System.out.println(Console_Colors.RED_BOLD_BRIGHT + "please enter valid options");
						}
						
						mer = rer * catFactor;
						System.out.println(Console_Colors.RED_BOLD + "Maintenance Energy Requirements is(cal/day): " + mer);
						System.out.println(Console_Colors.RESET);
						System.out.println("-------- Maintenance Enegy Requirements(MER) --------");
					}
					else {
						System.out.println(Console_Colors.RED_BOLD_BRIGHT + "Please choose correct dog type options(small, medium, large)");
					}
				}

			}
			else {
				System.out.println("Please enter correct character to play the audio");
			}
			
			System.out.println();
			System.out.println("Would you like to continue the system\n yes\n no");
			docResponse = inputStr.nextLine();
			docResponse = docResponse.toLowerCase();
			
			if(docResponse.equals("no")) {
				System.out.println(Console_Colors.TEAL + "Thank You!!");
			}
		}
		if(docResponse.equals("no")) {
			System.out.println(Console_Colors.TEAL + "Thank You!!");
		}
		
	}

}
