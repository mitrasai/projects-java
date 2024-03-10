package Sound_Frequency;

import java.util.*;
import java.lang.Thread;

public class Sound_MeasuringSystem {
	
	static double observedFreq;
	static double soundVelocity;

	public static void main(String[] args) throws Exception {
		
		Scanner numInput = new Scanner(System.in);
		Scanner txtInput = new Scanner(System.in);
		
		System.out.printf("%50S %n","Welcome to the sound measuring system");
		System.out.println();
		System.out.println("Would you like to start?\n yes\n no");
		String user_res = txtInput.nextLine();
		
		Thread.sleep(1000);
		while(user_res.equalsIgnoreCase("yes")) {
			System.out.printf("%20s %n", "This system is calculated by Doppler Effect");
			
			Thread.sleep(2000);
			System.out.println("Enter the Source Sound Frequency(in Hz): ");
			double src_sound = numInput.nextDouble();
			Thread.sleep(1000);
			System.out.println("Enter the velocity of Source(m/s) & '0' is for the source if it is in stationary position: ");
			double src_velocity = numInput.nextDouble();
			Thread.sleep(1000);
			System.out.println("Enter the velocity of Observer(m/s) & '0' is for if the position of observer is stationary: ");
			double ob_velocity = numInput.nextDouble();
			Thread.sleep(2000);
			System.out.println("Do you know the velocity of the sound waves(yes/no): ");
			String sound_waves = txtInput.nextLine();
			sound_waves = sound_waves.toLowerCase();
			
			switch(sound_waves) {
			case "yes":
				System.out.println("Enter the velocity of sound(m/s): ");
				soundVelocity = numInput.nextDouble();
				break;
			case "no":
				System.out.println("velocity of sound waves calculation ---------> ");
				Thread.sleep(1000);
				System.out.println("Enter temperature(in degree celsius): ");
				double temp = numInput.nextDouble();
				
				soundVelocity = 331 + (6/10 * temp);
				break;
			default:
				System.out.println(" ----> invalid option <---- ");
				break;
			}
			
			Thread.sleep(2000);
			System.out.println("To being, please choose one option\n 1.Source is moving towards the observer at rest\n"
					+ " 2.Source is moving away from the observer at rest\n"
					+ " 3.Observer is moving towards the stationary Source\n"
					+ " 4.Observer is moving away from the stationary Source\n"
					+ " 5.Source and Observer are moving toward each other\n"
					+ " 6.Source and Observer are moving away from each other");
			int user_choice = numInput.nextInt();
			
			switch(user_choice) {
			case 1:
				observedFreq = src_sound * ((soundVelocity)/(soundVelocity - src_velocity));
				break;
			case 2:
				observedFreq = src_sound * ((soundVelocity)/(soundVelocity - src_velocity));
				break;
			case 3:
				observedFreq = src_sound * ((soundVelocity + ob_velocity)/(soundVelocity));
				break;
			case 4:
				observedFreq = src_sound * ((soundVelocity - ob_velocity)/(soundVelocity));
				break;
			case 5:
				observedFreq = src_sound * ((soundVelocity + ob_velocity)/(soundVelocity - src_velocity));
				break;
			case 6:
				observedFreq = (src_sound * (soundVelocity+src_velocity))/(soundVelocity - ob_velocity);
				break;
			default:
				System.out.println(" ----> invalid option");
				break;
			}
			
			System.out.println(" ----> Observed sound frequency(in Hz/F'): " + Math.ceil(observedFreq));
			System.out.println();
			System.out.println("Would you like to start again?\n yes\n no");
			user_res = txtInput.nextLine();
		}
		
		if(user_res.equalsIgnoreCase("no")) {
			System.out.println("Thank you!, -> Have a nice day <- ");
		}
			
	}

}
