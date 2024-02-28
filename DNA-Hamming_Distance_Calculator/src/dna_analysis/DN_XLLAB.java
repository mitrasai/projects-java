package dna_analysis;

import java.util.*;

public class DN_XLLAB {
	
	static char dna1;
	static char dna2;
	static int hamming_distance = 0;

	public static void main(String[] args) {
		Scanner txt = new Scanner(System.in);
		System.out.println("Do you want to initiate the system\n yes\n no");
		String user_response = txt.nextLine();
		
		while(user_response.equalsIgnoreCase("yes")) {
			System.out.println(Colors.ORANGE + "Welcome to the XL Lab DNA analysis program");
			System.out.println(Colors.RESET + "Enter the first DNA strand: ");
			String dna_1 = txt.nextLine();
			System.out.println("Enter the second DNA strand: ");
			String dna_2 = txt.nextLine();
			
			int dna1_length = dna_1.length();
			int dna2_length = dna_2.length();
			
			if(dna1_length == dna2_length) {
				System.out.println(Colors.GREEN_BOLD + "DNA strands are matched");
				
				for(int i=0; i<dna_1.length(); i++) {
					dna1 = dna_1.charAt(i);
					dna2 = dna_2.charAt(i);
					
					if(dna1 == dna2) {
						continue;
					}
					else if(dna1 != dna2) {
						hamming_distance++;
					}
				}
				
				
				System.out.println(Colors.RESET+ "Hamming Distance of DNA strand is: " + hamming_distance);
				hamming_distance = 0;
			}
			else if(dna1_length != dna2_length) {
				System.out.println(Colors.RED_BOLD + "No match in DNA strands");
			}
			
			System.out.println("Do you want to repeat again\n yes\n no");
			user_response = txt.nextLine();
			
			if(user_response.equalsIgnoreCase("no")) {
				System.out.println("Thank you, Have a great day");
			}
		}
	}

}
