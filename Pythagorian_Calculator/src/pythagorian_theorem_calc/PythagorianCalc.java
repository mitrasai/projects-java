package pythagorian_theorem_calc;

import java.util.*;
import java.lang.Math;

public class PythagorianCalc {

	public static void main(String[] args) throws Exception {
		
		Scanner txtInput = new Scanner(System.in);
		Scanner numInput = new Scanner(System.in);
		
		System.out.println("This Calculator calculates the Hypothesis of an right-angled triangle.");
		System.out.println();
		Thread.sleep(2000);
		System.out.println("|\"");
		System.out.println("| \"");
		System.out.println("|  \"");
		System.out.println("|   \"");
		System.out.println("|    \"");
		System.out.println("|     \"");
		System.out.println("|      \"");
		System.out.println("|       \"");
		System.out.println("|        \"");
		System.out.println("|         \"");
		System.out.println("|__________\"");
		
		Thread.sleep(1000);
		System.out.println();
		
		System.out.println("Would you like to start?\n yes\n no");
		String response = txtInput.nextLine();
		
		while(response.equalsIgnoreCase("yes")) {
			System.out.println("Which side of the right-angle triangle would you like to find?\n A.Hypothesis\n B.Perpendicular(Altitude)\n C.Opposite(Base)");
			String side = txtInput.nextLine();
			side = side.toUpperCase();
			
			//double hypo_len,altitude_len, base_len;
			switch(side) {
			case "A":
				System.out.println("Length of the Perpendicular(Altitude) side of an right-angle triangle:- ");
				double altitude_len = numInput.nextDouble();
				System.out.println("Length of the Opposite(Base) side of an right-angle triangle:- ");
				double base_len = numInput.nextDouble();
				
				Thread.sleep(1000);
				double hypo_len = Math.hypot(altitude_len, base_len);
				hypo_len = Math.round(hypo_len);
				System.out.println("Length of the Hypothesis side of an right-angle triangle:- " + hypo_len);
				break;
				
			case "B":
				System.out.println("Length of the Hypothesis side of an right-angle triangle:- ");
				double hypo_len1 = numInput.nextDouble();
				System.out.println("Length of the Opposite(Base) side of an right-angle triangle:- ");
				double base_len1 = numInput.nextDouble();
				
				Thread.sleep(1000);
				double altitude_len1 = Math.sqrt(Math.pow(hypo_len1, 2) - Math.pow(base_len1, 2));
				altitude_len1 = Math.round(altitude_len1);
				System.out.println("Length of the Perpendicular(Altitude) side of an right-angle triangle:- " + altitude_len1);
				break;
				
			case "C":
				System.out.println("Length of the Hypothesis side of an right-angle triangle:- ");
				double hypo_len2 = numInput.nextDouble();
				System.out.println("Length of the Perpendicular(Altitude) side of an right-angle triangle:- ");
				double altitude_len2 = numInput.nextDouble();
				
				Thread.sleep(1000);
				double base_len2 = Math.sqrt(Math.pow(hypo_len2, 2) - Math.pow(altitude_len2, 2));
				base_len2 = Math.round(base_len2);
				System.out.println("Length of the Opposite(Base) side of an right-angle triangle:- " + base_len2);
				break;
				
			default:
				System.out.println("Please enter correct option!!");
			}
			
			System.out.println("Would you like to start again?\n yes\n no");
			response = txtInput.nextLine();
		}
		if(response.equalsIgnoreCase("no")) {
			System.out.println("Have a nice day!!");
		}
		
	}

}
