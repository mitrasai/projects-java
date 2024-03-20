package logbook;

import java.util.*;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.*;

//for images
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon; //uri
import javax.swing.JFrame; //opens an image in new tab
import javax.swing.JLabel; //acts as a placeholder for our image

public class Assignment_Logbook {
	
	static String temp;
	//code for 2 subjects
	static String subject_code1;
	static String subject_code2;
	//subject keys
	static String subject_key1;
	static String subject_key2;
	//subject names
	static String subject_name1;
	static String subject_name2;
	//subject status
	static String status1;
	static String status2;
	//assessment type (test(t), homework(h), project(p))
	static String assessment_type1;
	static String assessment_type2;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException, AWTException, InterruptedException{
		
		Scanner input1 = new Scanner(System.in);
		System.out.println("Do you want to start(yes or no)?: ");
		String user_response = input1.nextLine();
		
		while(user_response.equalsIgnoreCase("yes")) {
			System.out.println(Colors.ORANGE + "----> Welcome to our assessment logbook! <----");
			Thread.sleep(2000);
			
			Scanner input2 = new Scanner(System.in);
			//displaying gif image
			JFrame frame = new JFrame();
//			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//icons
			ImageIcon img_icon = new ImageIcon("C:\\Users\\sai mithra\\eclipse-workspace2\\Java\\Student_Assignment_Logbook\\src\\logbook\\pic.gif"); //allocation path of our image
			Image img = img_icon.getImage(); //getting that image
			Icon icon = new ImageIcon(img);
			JLabel label = new JLabel(icon); //to show image in window
			//adjusting the frame sizes
			frame.add(label, "Center");
			frame.setSize(600,600);
			//to show our image
			frame.setVisible(true);
			//sizing option
			frame.setResizable(false); //can't resize the image
			
			//generating subject codes randomly for two subjects
			Thread.sleep(1000);
			for(int i=0; i<2; i++) {
				String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
				
				//Creating a stringbuilder inorder to append all the strings
				StringBuilder str_build = new StringBuilder();
				
				//inorder to generate random subject codes we have to use random class
				Random random = new Random();
				//initially for any subject code, let's say we have 5 characters length
				int length = 5;
				for(int j=0; j<length; j++) {
					int index = random.nextInt(letters.length());
					//fetching the characters from specified index position
					char random_char = letters.charAt(index);
					//appending all random letters to out stringbuilder
					str_build.append(random_char);
					//and storing it in our variable of type string
					temp = str_build.toString();
				}
				//assigning our subject codes for each subject
				if(i==0) {
					subject_code1 = temp;
				}
				else if(i==1) {
					subject_code2 = temp;
				}
			}
			
			//assigning subject code for subject-1
			System.out.println(Colors.WHITE_BOLD_BRIGHT + "Subject Code -> " + subject_code1);
			//subject name
			System.out.println("Enter name of the first subject for first key: ");
			subject_name1 = input2.nextLine();
			System.out.println("Enter the two lettered subject key for first subject(like OS - Operating System): ");
			subject_key1 = input2.nextLine();
			subject_key1 = subject_key1.toUpperCase();
			//validating
			while(subject_key1.length() != 2) {
				System.out.println("Enter two lettered subject key for first subject correctly(like OS - Operaring System): ");
				subject_key1 = input2.nextLine();
				subject_key1 = subject_key1.toUpperCase();
			}
			
			//if subject key length matches
			if(subject_key1.length() == 2) {
				System.out.println();
				//subject assignment type
				System.out.println("Enter the type of assignment(t->test, h->homework, p->project): ");
				assessment_type1 = input2.nextLine();
				assessment_type1 = assessment_type1.toLowerCase();
				//status on that subject assignment
				System.out.println("Enter the status of assignment(C->completed, NC->not completed, P->pending");
				status1 = input2.nextLine();
				status1 = status1.toUpperCase();
			}
			
			System.out.println();
			//assigning subject code for subject-2
			System.out.println(Colors.BLUE_BOLD_BRIGHT + "Subject Code -> " + subject_code2);
			//subject name
			System.out.println("Enter name of the second subject for second key: ");
			subject_name2 = input2.nextLine();
			System.out.println("Enter the two lettered subject key for second subject(like DS - Data Structures): ");
			subject_key2 = input2.nextLine();
			subject_key2 = subject_key2.toUpperCase();
			//validating
			while(subject_key2.length() != 2) {
				System.out.println("Enter two lettered subject key for second subject correctly(like DS - Data Structures): ");
				subject_key2 = input2.nextLine();
				subject_key2 = subject_key2.toUpperCase();
			}
			
			//if subject key length matches
			if(subject_key2.length() == 2) {
				System.out.println();
				//subject assignmet type
				System.out.println("Enter the type of assignment(t->test, h->homework, p->project): ");
				assessment_type2 = input2.nextLine();
				assessment_type2 = assessment_type2.toLowerCase();
				//status on that subject assignment
				System.out.println("Enter the status of assignment(C->completed, NC->not completed, P->pending): ");
				status2 = input2.nextLine();
				status2 = status2.toUpperCase();
			}
			
			//asking whether the user make changes in assignment status section
			System.out.println("Would you like to make a change for assignment status for any subject you have included(yes or no)?: ");
			String user_response2 = input2.nextLine();
			while(user_response2.equalsIgnoreCase("yes")) {
				System.out.println("Would you like to replace first subject assignment status(yes or no)?: ");
				String user_response3 = input2.nextLine();
				
				if(user_response3.equalsIgnoreCase("yes")) {
					System.out.println("Enter the new assignment status(C->completed, NC->not completed, P->pending) for first subject: ");
					status1 = input2.nextLine();
					status1 = status1.toUpperCase();
				}
				else if(user_response3.equalsIgnoreCase("no")) {
					System.out.println("Would you like to replace second subject assignment status(yes or no)?: ");
					user_response3 = input2.nextLine();
					
					if(user_response3.equalsIgnoreCase("yes")) {
						System.out.println("Enter the new assignment status(C->completed, NC->not completed, P->pending) for second subject: ");
						status2 = input2.nextLine();
						status2 = status2.toUpperCase();
					}
					else if(user_response3.equalsIgnoreCase("no")) {
						System.out.println("Okay, Thank you");
					}
				}
				Thread.sleep(3000);
				System.out.println(Colors.RED_BOLD_BRIGHT + "Would you like to make a change for assignment status for any subject you have included again(yes or no)?: ");
				user_response2 = input2.nextLine();
			}
			if(user_response2.equalsIgnoreCase("no")) {
				
				Thread.sleep(2000);
				//opening up text editor, so we can able to write all the information that the use has finalized into a text file
				String cmd = "";//depending upon what type of text editor file
				String os = System.getProperty("os.name").toString();// to get name of the operating system properties
				if(os.startsWith("Mac OS")) {
					cmd = "TextEdit";
				}
				else if(os.startsWith("Windows")) {
					cmd = "notepad";
				}
				
				//opening up notepad for user to store all the information
				Runtime runtime = Runtime.getRuntime();
				runtime.exec(cmd);
				Thread.sleep(1000);
				
				Robot robot = new Robot();
				String title = "\t\t\t\t Student Assignment Logbook\n";
				String keys = "Subject keys ->\n" + subject_key1 + " -> " + subject_name1 + "\n" + subject_key2 + " -> " + subject_name2 + "\n";
				String assignment_keys = "Assignment Key: \n" + "t->test, h->homework, p->project" +"\n";
				System.out.println();
				StringBuilder sb = new StringBuilder("Course Code" + "\t" + "Course Name" + "\t" + "Course Key" + "\t" + "Assignment Type" + "\t\t" + "Status" + "\n"
				+ subject_code1 + "\t" + subject_name1 + "\t\t" + subject_key1 + "\t\t" + assessment_type1 + "\t\t" + status1 + "\n"
				+ subject_code2 + "\t\t" + subject_name2 + "\t\t" + subject_key2 + "\t\t" + assessment_type2 + "\t\t" + status2);
				String str = title + keys + assignment_keys + sb;
				
				//String selections object for copying all of this information and put it in the clipboard
				StringSelection str_selection = new StringSelection(str);
				Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
				clip.setContents(str_selection, str_selection);
				
				//copying all the information from clipboard into notepad
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				//to release the key
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
			}
			
			Thread.sleep(3000);
			System.out.println(Colors.RESET + "Do you want to start again(yes or no)?: ");
			user_response = input1.nextLine();
		}
		if(user_response.equalsIgnoreCase("no")) {
			System.out.println("Thank you, Have a nice day!");
			System.exit(0);
		}
	}

}
