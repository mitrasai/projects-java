package lift;

import java.util.*;
import java.lang.Thread;
import java.lang.Math;

public class Aircraft_Measures {
	static double lift;

	public static void main(String[] args) throws Exception{
		
		Scanner txtInput = new Scanner(System.in);
		Scanner numInput = new Scanner(System.in);
		
		System.out.printf("%50S %n","Welcome to the Aircraft lift measuring system");
		System.out.println();
		System.out.println("Would you like to start the system?\n yes\n no");
		String user_res = txtInput.nextLine();
		
		Thread.sleep(1000);
		System.out.println();
		System.out.println(" _____ _");
		System.out.println("|  ___| |");
		System.out.println("| |_  | |_   _");
		System.out.println("|  _| | | | | |");
		System.out.println("| |   | | |_| |");
		System.out.println("|_|   |_|#__, |");
		System.out.println("          __/ |");
		System.out.println("         |____|");
		System.out.println();
		
		Thread.sleep(2000);
		while(user_res.equalsIgnoreCase("yes")) {
			System.out.printf("%20s %n", "It is an aricraft lift measuring programmed system to calculate"
					+ " the lift of any aricraft using lift equation.");
			
			Thread.sleep(1000);
			System.out.println("");
			
			//lift equation = Coefficient of lift * 0.5*rho*(velocity*velocity)*surface area of wing
			System.out.println("Enter the aricraft type: ");
			String air_crafttype = txtInput.nextLine();
			System.out.println("Enter the Coefficient of lift(CL): ");
			double cl = numInput.nextDouble();
			System.out.println("Enter the air density -> (rho in kg/m^3): ");
			double rho = numInput.nextDouble();
			System.out.println("Enter the velocity(in m/s): ");
			double velocity = numInput.nextDouble();
			System.out.println("Enter the surface area of wing(in m^2): ");
			double surface = numInput.nextDouble();
			
			lift = cl * 0.5 * rho * Math.pow(velocity, 2) * surface;
			
			Thread.sleep(1000);
			System.out.println("Your Aircraft is of type -> " + air_crafttype);
			System.out.printf("%20s %20s", "Lift of the Aircraft is ->", "");
			System.out.printf("%.2f %4s %n", Math.ceil(lift), " newtons.");
			
			lift = 0;
			System.out.println();
			Thread.sleep(1000);
			System.out.println("Would you like to start again?\n yes\n no");
			user_res = txtInput.nextLine();
		}
		if(user_res.equalsIgnoreCase("no")) {
			System.out.println("Thank you!, -> Have a nice day! <- ");
		}
		
		numInput.close();
		txtInput.close();
	}

}
