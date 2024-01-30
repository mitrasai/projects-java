package movies;

import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;

public class Movielist extends JFrame {
	/*
	 * Jframe - we're using this package cause, we want to display an image
	 * ImageIcon - is present in swing package
	 */
	
	private ImageIcon image1; // for image to be displayed itself
	private JLabel label1; // acts placeholder for an image
	private ImageIcon image2;
	private JLabel label2;
	
	//inorder to display above value, first we need to initialize them using constructors
	Movielist(String image_1, String image_2){
		
		setLayout(new FlowLayout());
		
		image1 = new ImageIcon(getClass().getResource(image_1));
		label1 = new JLabel(image1);
		add(label1);
		
		image2 = new ImageIcon(getClass().getResource(image_2));
		label2 = new JLabel(image2);
		add(label2);
	}
	
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		String sixSigmaVal = "";
		Scanner adminObj = new Scanner(System.in);
		Scanner customerObj = new Scanner(System.in);
		Scanner number = new Scanner(System.in);
		
		Movielist teluguImg = new Movielist("Hanuman-pic.jpg", "RRR-pic.jpg");
		Movielist tamilImg = new Movielist("leo-pic.jpg", "vikram-pic.jpg");
		
		String authorizedName = "Mithra12";
		String authorizedPassword = "Mithra@2024";
		System.out.println();
		System.out.println("-------- Welcome To Our Movie Tickets E-Booking Portal --------");
		System.out.println("Please select the following options\n 1.Administrator\n 2.Customer");
		String response = adminObj.nextLine();
		
		switch(response) {
		case ("1"):
			System.out.println();
			System.out.println("------------ Admin Authentication Section ------------");
			System.out.print("User Name: ");
			String userName = adminObj.nextLine();
			System.out.print("Password: ");
			String userPassword = adminObj.nextLine();
			
			//verifying the admin
			if(userName.equals(authorizedName) && userPassword.equals(authorizedPassword)) {
				System.out.println("Login Successful");
				System.out.println();
				System.out.println("Choose the options, How you want to analyze the business\n I.Cost Of Goods Computation(COGS)\n II.Profit Margin\n III.Six Sigma Value\n");
				String adminOptions = adminObj.nextLine();
				adminOptions = adminOptions.toUpperCase();
				
				if(adminOptions.equals("I")) {
					System.out.println();
					System.out.println("-------- Cost Of Goods Computation(COGS) --------");
					
					//Formula = Beginning Inventory Price + Purchase Price - End Inventory Price
					System.out.print("Enter your Beginning Inventory Price($): ");
					int begInvenPrice = adminObj.nextInt();
					
					System.out.print("Enter your Purchase Price($): ");
					int purchasePrice = adminObj.nextInt();
					
					System.out.print("Enter your End Inventory Price($): ");
					int endInvenPrice = adminObj.nextInt();
					
					int cog = begInvenPrice + purchasePrice - endInvenPrice;
					System.out.println("Cost of goods sold is: " + cog);
					System.out.println("-------- Cost Of Goods Computation(COGS) --------");
				}
				
				else if(adminOptions.equals("II")) {
					System.out.println();
					System.out.println("-------- Profit Margin(PM) --------");
					System.out.printf("%20s %n", "It is a percentage earnings that a business company gets to keep.");
					
					//Formual = (Net Value / Revenue) * 100
					System.out.print("Enter your Net Income($): ");
					double netIncome = adminObj.nextDouble();
					
					System.out.print("Enter your Revenue($): ");
					double revenue = adminObj.nextDouble();
					
					double profitMargin = (netIncome / revenue) * 100;
					System.out.println("Profit Margin of our business is " + profitMargin + "%");
					System.out.println("-------- Profit Margin(PM) --------");
				}
				
				else if(adminOptions.equals("III")) {
					/*
					 * 1. Going to calculate Defects Per Opporunity (DPO): defects/(units*opporunity)
					 * 2. yield = (1 - dpo) * 100
					 */
					System.out.println();
					System.out.println("-------- Six Sigma Value --------");
					System.out.printf("%20s %n", "A set of management techniques, which is said to be improve business process by reducing the probability that an error will be occur.");
					System.out.print("Number of Defects in our business: ");
					double defects = adminObj.nextDouble();
					
					System.out.print("How much possibility to have defects of a product?: ");
					double oppo = adminObj.nextDouble();
					
					System.out.print("Total number of units: ");
					double units = adminObj.nextDouble();
					
					//dpo
					double total = units * oppo;
					double dpo = defects / total;
					
					//yield
					double yield = (1 - dpo) * 100;
					if(yield >= 69.10 && yield <= 93.33) {
						sixSigmaVal = "2";
					}
					else if(yield >= 93.33 && yield <= 99.38) {
						sixSigmaVal = "3";
					}
					else if(yield >= 99.38 && yield <= 99.97) {
						sixSigmaVal = "4";
					}
					else if(yield >= 99.97 && yield <= 99.99) {
						sixSigmaVal = "5";
					}
					else if(yield >= 99.99 && yield <=100) {
						sixSigmaVal = "6";
					}
					System.out.println("The Six Sigma Value of our business is: " + sixSigmaVal);
					System.out.println("-------- Six Sigma Value --------");
				}
			}
			
			
			else {
				System.out.println("Invalid Credentails, Please try again!!");
				System.exit(0); //ends the program without continuing
				System.out.println("------------ Admin Authentication Section ------------");
			}
		break;	
		case("2"):
			System.out.println();
			System.out.println("------------ Customer Section ------------");
			System.out.println("What movies would you like to watch\n A.Telugu\n B.Tamil");
			String custSelection = customerObj.nextLine();
			custSelection = custSelection.toUpperCase();
			
			if(custSelection.equals("A")) {
				System.out.println();
				System.out.println("-------- Telugu Movies List --------");
				System.out.println("--> Hanu-Man");
				System.out.println("Find out more by\n 1.Play the audio track\n 2.Read about it");
				String userChoice1 = customerObj.nextLine();
				
				if(userChoice1.equals("1")) {
					File file1 = new File("Hanumanaudio.wav");
					AudioInputStream audiostream1 = AudioSystem.getAudioInputStream(file1);
					
					Clip clip1 = AudioSystem.getClip();
					clip1.open(audiostream1);
					
					System.out.print("Enter P to Play: ");
					String choice1 = customerObj.nextLine();
					choice1 = choice1.toUpperCase();
					
					if(choice1.equals("P")) {
						clip1.start();
						
						System.out.print("Enter S to Stop: ");
						choice1 = customerObj.nextLine();
						choice1 = choice1.toUpperCase();
						
						if(choice1.equals("S")) {
							clip1.stop();
							System.out.println("Thank You!!");
						}
					}
				}
				
				else if(userChoice1.equals("2")) {
					System.out.println("---- An imaginary place called Anjanadri where the protagonist gets the powers of Hanuman and fights for Anjanadri. ----");
				}
				
				else {
					System.out.println("Please enter correct options!!");
				}
				
				System.out.println();
				System.out.println("--> RRR");
				System.out.println("Find out more by\n 1.Play the audio track\n 2.Read about it");
				String userChoice2 = customerObj.nextLine();
				
				if(userChoice2.equals("1")) {
					File file2 = new File("RRRaudio.wav");
					AudioInputStream audiostream2 = AudioSystem.getAudioInputStream(file2);
					
					Clip clip2 = AudioSystem.getClip();
					clip2.open(audiostream2);
					
					System.out.print("Enter P to Play: ");
					String choice2 = customerObj.nextLine();
					choice2 = choice2.toUpperCase();
					
					if(choice2.equals("P")) {
						clip2.start();
						
						System.out.print("Enter S to Stop: ");
						choice2 = customerObj.nextLine();
						choice2 = choice2.toUpperCase();
						
						if(choice2.equals("S")) {
							clip2.stop();
							System.out.println("Thank You!!");
						}
					}
				}
				
				else if(userChoice2.equals("2")) {
					System.out.println("---- A fictitious story about two legendary revolutionaries and their journey away from home before they started fighting for their country in the 1920s. ----");
				}
				
				else {
					System.out.println("Please enter correct options!!");
				}
				
				System.out.println("The Hanu-Man movie is on the left(cost: $250.55), RRR movie is on the right(cost: $300.87)");
				
				//display the photos
				teluguImg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				teluguImg.setVisible(true);
				teluguImg.pack(); //displays horizontally on the same line
				teluguImg.setTitle("Telugu Movies");
				
				System.out.println("-------- Telugu Movies List --------");
			}
			
			else if(custSelection.equals("B")) {
				System.out.println();
				System.out.println("-------- Tamil Movies List --------");
				System.out.println("--> Leo");
				System.out.println("Find out more by\n 1.Play the audio track\n 2.Read about it");
				String userChoice3 = customerObj.nextLine();
				
				if(userChoice3.equals("1")) {
					File file3 = new File("Leoaudio.wav");
					AudioInputStream audiostream3 = AudioSystem.getAudioInputStream(file3);
					
					Clip clip3 = AudioSystem.getClip();
					clip3.open(audiostream3);
					
					System.out.print("Enter P to Play: ");
					String choice3 = customerObj.nextLine();
					choice3 = choice3.toUpperCase();
					
					if(choice3.equals("P")) {
						clip3.start();
						
						System.out.print("Enter S to Stop: ");
						choice3 = customerObj.nextLine();
						choice3 = choice3.toUpperCase();
						
						if(choice3.equals("S")) {
							clip3.stop();
							System.out.println("Thank You!!");
						}
					}
				}
				
				else if(userChoice3.equals("2")) {
					System.out.println("---- Parthiban is a mild-mannered cafe owner in Kashmir, who fends off a gang of murderous thugs and gains attention from a drug cartel claiming he was once a part of them. ----");
				}
				
				else {
					System.out.println("Please enter correct options!!");
				}
				
				System.out.println();
				System.out.println("--> Vikram");
				System.out.println("Find out more by\n 1.Play the audio track\n 2.Read about it");
				String userChoice4 = customerObj.nextLine();
				
				if(userChoice4.equals("1")) {
					File file4 = new File("Vikramaudio.wav");
					AudioInputStream audiostream4 = AudioSystem.getAudioInputStream(file4);
					
					Clip clip4 = AudioSystem.getClip();
					clip4.open(audiostream4);
					
					System.out.print("Enter P to Play: ");
					String choice4 = customerObj.nextLine();
					choice4 = choice4.toUpperCase();
					
					if(choice4.equals("P")) {
						clip4.start();
						
						System.out.print("Enter S to Stop: ");
						choice4 = customerObj.nextLine();
						choice4 = choice4.toUpperCase();
						
						if(choice4.equals("S")) {
							clip4.stop();
							System.out.println("Thank You!!");
						}
					}
				}
				
				else if(userChoice4.equals("2")) {
					System.out.println("---- A special investigator discovers a case of serial killings is not what it seems to be, and leading down this path is only going to end in a war between everyone involved. ----");
				}
				
				else {
					System.out.println("Please enter correct options!!");
				}
				
				System.out.println("The Leo movie is on the left(cost: $249.87), RRR movie is on the right(cost: $218.87)");
				
				//display the photos
				tamilImg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				tamilImg.setVisible(true);
				tamilImg.pack(); //displays horizontally on the same line
				tamilImg.setTitle("Tamil Movies");
				
				System.out.println("-------- Tamil Movies List --------");
			}
			
			System.out.println("------------ Customer Section ------------");
			
			//giving the opportunity to an user to buy tickets
			System.out.println("Which movie you want to buy our tickets for? (Hanuman, RRR, Leo, Vikram)");
			String movieSelection = customerObj.nextLine();
			movieSelection = movieSelection.toLowerCase();
			
			if(movieSelection.equals("hanuman")) {
				double price = 250.55;
				System.out.println("How many tickets you want to buy? ");
				int quantity = number.nextInt();
				
				double amount = quantity * price;
				System.out.println("Please collect your tickets");
				
				System.out.println("------------ Hanum-Man Telugu Movie Receipt ------------");
				System.out.printf("%40s %n", "Reciept");
				System.out.printf("%40s %n", "Hanu-Man");
				System.out.printf("%40s %.3f", "Total Cost($): ",amount);
				System.out.println();
				System.out.println("------------ Hanum-Man Telugu Movie Receipt ------------");	
			}
			
			else if(movieSelection.equals("rrr")) {
				double price1 = 300.87;
				System.out.println("How many tickets you want to buy? ");
				int quantity1 = number.nextInt();
				
				double amount1 = quantity1 * price1;
				System.out.println("Please collect your tickets");
				
				System.out.println("------------ RRR Telugu Movie Receipt ------------");
				System.out.printf("%40s %n", "Reciept");
				System.out.printf("%40s %n", "RRR");
				System.out.printf("%40s %.3f", "Total Cost($): ",amount1);
				System.out.println();
				System.out.println("------------ RRR Telugu Movie Receipt ------------");
			}
			
			else if(movieSelection.equals("leo")) {
				double price2 = 249.87;
				System.out.println("How many tickets you want to buy? ");
				int quantity2 = number.nextInt();
				
				double amount2 = quantity2 * price2;
				System.out.println("Please collect your tickets");
				
				System.out.println("------------ Leo Tamil Movie Receipt ------------");
				System.out.printf("%40s %n", "Reciept");
				System.out.printf("%40s %n", "Leo");
				System.out.printf("%40s %.3f", "Total Cost($): ",amount2);
				System.out.println();
				System.out.println("------------ Leo Tamil Movie Receipt ------------");
			}
			
			else if(movieSelection.equals("vikram")) {
				double price3 = 218.87;
				System.out.println("How many tickets you want to buy? ");
				int quantity3 = number.nextInt();
				
				double amount3 = quantity3 * price3;
				System.out.println("Please collect your tickets");
				
				System.out.println("------------ Vikram Tamil Movie Receipt ------------");
				System.out.printf("%40s %n", "Reciept");
				System.out.printf("%40s %n", "Vikram");
				System.out.printf("%40s %.3f", "Total Cost($): ",amount3);
				System.out.println();
				System.out.println("------------ Vikram Tamil Movie Receipt ------------");
			}
		}
		
		System.out.println("-------- Welcome To Our Movie Tickets E-Booking Portal --------");
	}
}
