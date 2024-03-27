package grocer_list;

import java.util.*;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.*;

public class Groccer {
	
	static String temp;
	static String item_code;
	static String item_name;
	static int item_quantity;
	static double item_rate;
	static double final_rate;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException, AWTException, InterruptedException{
		Scanner input_txt = new Scanner(System.in);
		System.out.println("Do you want to start(yes or no)?: ");
		String user_res = input_txt.nextLine();
		
		while(user_res.equalsIgnoreCase("yes")) {
			System.out.printf("%40S %n", "--> welcome to our Groccer System <--");
			
			Scanner input_num = new Scanner(System.in);
			Thread.sleep(2000);

			//generating item codes randomly for n items
				String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
				
				//created a stringbuilder class in-order to append all the strings
				StringBuilder str_build = new StringBuilder();
				
				//created a random class inorder to generate code
				Random rand = new Random();
				int code_length = 4;
				for(int j=0; j<code_length; j++) {
					int index = rand.nextInt(letters.length());
					//fetching all the characters from specified index position
					char rand_chars = letters.charAt(index);
					//appending all random letters into our stringbuilder
					str_build.append(rand_chars);
					//and store in it our variable
					temp = str_build.toString();
					
				}
				//assigned our item codes
				item_code = temp;
				
				//assigning item codes
				System.out.println(Colors.WHITE_BOLD + "Item Code -> " + item_code);
				//item name
				System.out.println(Colors.CYAN + "Enter Item Name: ");
				item_name = input_txt.nextLine();
				//quantity
				System.out.println("Enter Item Quantity: ");
				item_quantity = input_num.nextInt();
				System.out.println("Enter Item Rate: ");
				item_rate = input_num.nextDouble();
				
				final_rate = item_quantity * item_rate;
			
			Thread.sleep(2000);
			//opening up text editor, so we can able to write all the information that user has finalized into a text file
			String cmd = "";
			String os = System.getProperty("os.name").toString();
			if(os.startsWith("Windows")) {
				cmd = "notepad";
			}
			else if(os.startsWith("Mac OS")) {
				cmd = "TextEdit";
			}
			
			//opening up notepad or textedit for an user to store al the information
			Runtime rt = Runtime.getRuntime();
			rt.exec(cmd);
			
			Thread.sleep(2000);
			Robot robot = new Robot();
			String header = "\t\t\t\t Grocery Application System\n";
			System.out.println();
			StringBuilder sb = new StringBuilder("Item Code" + "\t" + "Item Name" + "\t" + "Item Qauntity" + "\t" + "Item Rate" + "\t" + "Total Rate" + "\n"
			+ item_code + "\t\t" + item_name + "\t\t" + item_quantity + "\t\t" + item_rate + "\t\t" + final_rate);
			String str = header + sb;
			
			//String selection object is for copying all of this information and store it in clip-board
			StringSelection str_selection = new StringSelection(str);
			Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
			clip.setContents(str_selection, str_selection);
			
			//copying all the information from clip-board into a text editor
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			//to release keys
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			System.out.println(Colors.RESET);
			System.out.printf("%40S %n", "--> welcome to our Groccer System <--");
			
			Thread.sleep(2000);
			System.out.println("Do you want to start again(yes or no)?: ");
			user_res = input_txt.nextLine();
		}
		if(user_res.equalsIgnoreCase("no")) {
			System.out.println("Thank you, Have a nice day");
		}
	}

}
