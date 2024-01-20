package playlist;

import java.util.*;
import java.io.File; //able to create file object
import javax.sound.sampled.*; 
import java.io.IOException; //handle errors such as not able to read file path

public class MusicPlaylist {
	
	/*
	 * 
	 * clip -> going to be getting the audio clips so that it can play it and we will get an error, 
	 * reason: we have to throw another exception [ineUnavailableException] that's gonna be handling some porblem (i.e., when it is not
	 *         being able to read the path of our audio file from where we have stored.)
	 */

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to the Music Diversifer Phonograph, what would you like to listen\n A.English Music\n B.Telugu Music\n C.Tamil Music");
		String user_response = input.nextLine();
		user_response = user_response.toUpperCase();
		
		if(user_response.equals("A")) {
			
			/*
			 * create the file object (object for our file class), then we create the audio stream object to be able to 
			 * open the audio clip and then we give them option to play the music(& stop music and then resume)
			 * 
			 */
			
			File file = new File("english.wav");
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
			
			//create object for our clip class
			Clip clip = AudioSystem.getClip();
			clip.open(audioStream); //we can open the audio file so it can play
			
			System.out.println("This is an English Music by Jutin Bieber");
			
			System.out.println("Enter P to play audio");
			
			//create a variable to receive response from the user
			String response = input.nextLine();
			response = response.toUpperCase();
			
			if(response.equals("P")) { // to play
				clip.start();
				
				System.out.println("Enter S to stop the audio, PS is to pause the audio");
				response = input.nextLine();
				response = response.toUpperCase();
				
				if(response.equals("S")){ // to stop
					clip.stop();
					System.out.println("Thank you!! for choosing our playlist");
				}
				
				if(response.equals("PS")) {
					long cliptimePosition = clip.getMicrosecondPosition(); //to store the time position where the audio is stopped
					clip.stop();
					
					System.out.println("Enter R to resume the audio, PB to play from beginning");
					response = input.nextLine();
					response = response.toUpperCase();
					
					if(response.equals("R")) {
						clip.setMicrosecondPosition(cliptimePosition); //to resume the audio from where it stopped
						clip.start();
						
						System.out.println("Enter EXIT to exit");
						response = input.nextLine();
						response = response.toUpperCase();
						
						System.out.println("Thank you");
					}
					
					if(response.equals("PB")) {
						clip.setMicrosecondPosition(0); //sets the micro position back to Zero
						clip.start();
						
						System.out.println("Enter EXIT to exit");
						response = input.nextLine();
						response = response.toUpperCase();
						
						System.out.println("Thank you");
					}
				}
			}
		}
		
		
		else if(user_response.equals("B")) {
					
					File file2 = new File("telugu.wav");
					AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(file2);
					
					//create object for our clip class
					Clip clip2 = AudioSystem.getClip();
					clip2.open(audioStream2); //we can open the audio file so it can play
					
					System.out.println("This is an Telugu Music from the moive RRR");
					
					System.out.println("Enter P to play audio");
					
					//create a variable to receive response from the user
					String response = input.nextLine();
					response = response.toUpperCase();
					
					if(response.equals("P")) { // to play
						clip2.start();
						
						System.out.println("Enter S to stop the audio, PS is to pause the audio");
						response = input.nextLine();
						response = response.toUpperCase();
						
						if(response.equals("S")){ // to stop
							clip2.stop();
							System.out.println("Thank you!! for choosing our playlist");
						}
						
						if(response.equals("PS")) {
							long cliptimePosition2 = clip2.getMicrosecondPosition(); //to store the time position where the audio is stopped
							clip2.stop();
							
							System.out.println("Enter R to resume the audio, PB to play from beginning");
							response = input.nextLine();
							response = response.toUpperCase();
							
							if(response.equals("R")) {
								clip2.setMicrosecondPosition(cliptimePosition2); //to resume the audio from where it stopped
								clip2.start();
								
								System.out.println("Enter EXIT to exit");
								response = input.nextLine();
								response = response.toUpperCase();
								
								System.out.println("Thank you");
							}
							
							if(response.equals("PB")) {
								clip2.setMicrosecondPosition(0); //sets the micro position back to Zero
								clip2.start();
								
								System.out.println("Enter EXIT to exit");
								response = input.nextLine();
								response = response.toUpperCase();
								
								System.out.println("Thank you");
							}
						}
					}
				}
		
		else if(user_response.equals("C")) {
			
			File file3 = new File("tamil.wav");
			AudioInputStream audioStream3 = AudioSystem.getAudioInputStream(file3);
			
			//create object for our clip class
			Clip clip3 = AudioSystem.getClip();
			clip3.open(audioStream3); //we can open the audio file so it can play
			
			System.out.println("This is an Tamil Music from the moive LEO");
			
			System.out.println("Enter P to play audio");
			
			//create a variable to receive response from the user
			String response = input.nextLine();
			response = response.toUpperCase();
			
			if(response.equals("P")) { // to play
				clip3.start();
				
				System.out.println("Enter S to stop the audio, PS is to pause the audio");
				response = input.nextLine();
				response = response.toUpperCase();
				
				if(response.equals("S")){ // to stop
					clip3.stop();
					System.out.println("Thank you!! for choosing our playlist");
				}
				
				if(response.equals("PS")) {
					long cliptimePosition3 = clip3.getMicrosecondPosition(); //to store the time position where the audio is stopped
					clip3.stop();
					
					System.out.println("Enter R to resume the audio, PB to play from beginning");
					response = input.nextLine();
					response = response.toUpperCase();
					
					if(response.equals("R")) {
						clip3.setMicrosecondPosition(cliptimePosition3); //to resume the audio from where it stopped
						clip3.start();
						
						System.out.println("Enter EXIT to exit");
						response = input.nextLine();
						response = response.toUpperCase();
						
						System.out.println("Thank you");
					}
					
					if(response.equals("PB")) {
						clip3.setMicrosecondPosition(0); //sets the micro position back to Zero
						clip3.start();
						
						System.out.println("Enter EXIT to exit");
						response = input.nextLine();
						response = response.toUpperCase();
						
						System.out.println("Thank you");
					}
				}
			}
		}
		
		else {
			System.out.println("Please enter the Options which are mentioned.");
		}
	}

}
