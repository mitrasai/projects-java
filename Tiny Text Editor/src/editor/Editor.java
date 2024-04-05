package editor;

import java.io.*;

public class Editor {

	public static void main(String[] args) throws IOException, InterruptedException {
		//create a BufferedReader using System.in
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//create an array of string object, that reads in lines of text and storing each line in the array
		String str[] = new String[100];
		
		//stopping condition
		System.out.println("Enter 'Stop' to quit");
		
		//asking the lines of text
		System.out.println("Enter lines of text: ");
		
		for(int i=0; i<100; i++) {
			str[i] = br.readLine();
			
			//break condition
			if(str[i].equalsIgnoreCase("stop")) {
				break;
			}
		}
		
		Thread.sleep(1000);
		System.out.println("----------------------------------------------");
		System.out.println("Here is your file: ");
		
		//displaying the line
		for(int i=0; i<100; i++) {
			if(str[i].equalsIgnoreCase("stop")) {
				Thread.sleep(1000);
				System.out.println();
				System.out.println("Thank you");
				break;
			}
			
			System.out.println(str[i]);
		}

	}

}
