package quiz;

import java.util.Scanner;
import java.util.Properties;
import java.awt.Color;
import java.lang.Thread;
import javax.swing.*;
import javax.mail.*;
import javax.mail.internet.*;


public class Math_Quizz {
	
	static int userScore = 0;
	static double answer;
	
	public static void sendEmail(String recepient) throws MessagingException{
		
		/*setting up over ssl or tls to send an mail
		 * properties class gives key and corresponding to its element
		 */
		Properties prop = new Properties();
		System.out.println("SSLEmail Starts");
		//SMTP Host
		prop.put("mail.smtp.host", "smtp.gmail.com");
		//SSL port
		prop.put("mail.smtp.port", "465");
		//enabiling authentication
		prop.put("mail.smtp.auth","true");
		//enable protocol STARTSSL
		prop.put("mail.smtp.ssl.enable", "true");
		//protocol version name
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
		//socket factory
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		//indicating what email gonna be
		String my_email_account = "saimithraakuthota068@gmail.com";
		String pass_key = "tdqyoawyyxtahcfn";
		
		/*creating a session
		 * to get the properties and authenicate the mail and password, to be able to grant the access to send an mail to 
		 * participant from our mail*/
		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(my_email_account, pass_key);
			}
		});
		
		try {
			//setting up an email
			Message mssg = new MimeMessage(session);//allows us to send an message connecting to internet.
			mssg.setFrom(new InternetAddress(my_email_account));//allocating the address
			mssg.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));//sending the message to someone
			
			//email subject
			mssg.setSubject("Congratulations on Your Quizzer Game Victory!");
			
			//rewarding him/her
			//attaching something to email
			Multipart emailcontent = new MimeMultipart();
			//indicating the body text
			MimeBodyPart txt_body = new MimeBodyPart();
			txt_body.setText("Hello, From Quizzer Game team, India");
			//reward secion
			MimeBodyPart prize = new MimeBodyPart();
			prize.attachFile("prize.pdf");
			//attaching body parts
			emailcontent.addBodyPart(txt_body);
			emailcontent.addBodyPart(prize);
			mssg.setContent(emailcontent);
			//attach multipart to our message
			Transport.send(mssg);
			System.out.println("Your reward has been sent successfully, Thank You:)");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception, MessagingException {
		
		Scanner number_input = new Scanner(System.in);
		Scanner txt_input = new Scanner(System.in);
		
		System.out.println(Colors.ORANGE);
		System.out.printf("%20s %n", "---- Welcome to Math Quiz ----");
		System.out.println();
		
		Thread.sleep(2000);
		System.out.println(Colors.WHITE_ITALIC);
		System.out.printf("%50s %n", "---- Instructions ----");
		System.out.println("-> You will need to answer 3 questions from different math topics.");
		System.out.println("-> If you answer all the questions correctly, there will be an reward for you!!");
		System.out.println("-> Have fun!!");
		System.out.printf("%50s %n", "---- Instructions ----");
		
		Thread.sleep(5000);
		System.out.println(Colors.RESET);
		System.out.println("You will be starting the quizz in the countdown of 5 seconds, Get Ready! -> Have Fun <- ");
		int count_down = 5;
		while(count_down!=0) {
			count_down = count_down - 1;
			
			if(count_down==0) {
				System.out.println(Colors.GREEN_BOLD_BRIGHT + "-> Let's Begin");
				System.out.println();
				
				System.out.println(Colors.GREEN + "Question 1 -> Angle of Elevation");
				Thread.sleep(1000);
				System.out.println("The Pyramid of the Sun is in the city of Egypt. The base is square with sides about 800ft long.");
				System.out.println("The height of pyramind is about 300ft. Find the angle of elevation(a)?");
				Thread.sleep(1000);
				System.out.println(Colors.YELLOW+ "Hint -> the base of the triangle has measure half the diagonal of the square base of the pyramid");
				Thread.sleep(5000);
				System.out.println(Colors.WHITE_BOLD);
				System.out.println("        B #");
				System.out.println("          | #");
				System.out.println("          |  #");
				System.out.println("          |   #");
				System.out.println("          |    #");
				System.out.println("    300ft |     # ");
				System.out.println("         _|   a _#");
				System.out.println("A ______|_|____|__#  C");
				System.out.println("   800ft  M 800ft");
				System.out.println();
				
				//time limit
				System.out.println("You have 4 seconds to solve this question");
				Thread.sleep(4000);//480000 for 8 minutes
				System.out.println(Colors.RED + "Time is up!");
				
				//calculating the answer for Question-1
				double side_AC = 0.5*(Math.sqrt(Math.pow(800, 2) + Math.pow(800, 2)));
				double tan_theta = Math.toDegrees(Math.atan(300/side_AC));
				double result1 = Math.round(tan_theta);
				System.out.println(Colors.RESET + "Please enter your answer, rounded it to a whole number: ");
				answer = number_input.nextDouble();
				
				//validating the answer
				Thread.sleep(1000);
				if(answer == result1) {
					System.out.println(Colors.GREEN + "Correct!");
					userScore = userScore + 1;
				}
				else if(answer != result1) {
					System.out.println(Colors.RED_BRIGHT + "Incorrect!");
					System.out.println(Colors.CYAN + "Correct answer is -> " + result1);
				}
				
				Thread.sleep(2000);
				System.out.println(Colors.GREEN_BOLD_BRIGHT + "Get Ready for Question 2");
				System.out.println();
				
				//Question-2
				System.out.println(Colors.GREEN + "Question 2 -> ");
				Thread.sleep(1000);
				System.out.println("In your neighbourhood there is one tree of angle(a) is 60 degrees, which is quite tall.\nFind out the height of that tree(Side AB) in bleow, here using one of the trigonometric ratio formula(SOH CAH TOA).");
				Thread.sleep(5000);
				System.out.println(Colors.WHITE_BOLD);
				System.out.println("   A");
			    System.out.println("    #");
			    System.out.println("    | #");
			    System.out.println("    |   #");
			    System.out.println("    |     #");
			    System.out.println("    |       #");
			    System.out.println("    |_      a _#");
			    System.out.println("    |_|______|____#");
			    System.out.println("    B    21.6      C");
			    System.out.println();
			    
			  //time limit
				System.out.println("You have 4 seconds to solve this question");
				Thread.sleep(4000);//480000 for 8 minutes
				System.out.println(Colors.RED + "Time is up!");
				
				//calculating answer for Question-2
				double tree_height = 21.6 * (Math.tan(Math.toRadians(60)));
				double result2 = Math.round(tree_height);
				System.out.println(Colors.RESET + "Please enter your answer, rounded it to a whole number: ");
				answer = number_input.nextDouble();
				
				Thread.sleep(1000);
				if(answer == result2) {
					System.out.println(Colors.GREEN + "Correct!");
					userScore = userScore + 1;
				}
				else if(answer != result2) {
					System.out.println(Colors.RED_BRIGHT + "Incorrect!");
					System.out.println(Colors.CYAN + "Correct answer is -> " + result2);
				}
				
				Thread.sleep(2000);
				System.out.println(Colors.GREEN_BOLD_BRIGHT + "Get Ready for Question 3");
				System.out.println();
				
				//Question-3
				System.out.println(Colors.GREEN + "Question 3 -> ");
				Thread.sleep(1000);
				System.out.println("There are two friends, A and B. Friend A owns a imports and exports company.");
				System.out.println("Friend A borrows 40 horses to use for transporting goods from Friend B.");
				System.out.println("To re-pay the loan A must give the lender 400 ruppes every month per donkey.");
				System.out.println("A uses each horse for 14 days per month for transporting goods and he earns 40 rupees per day for this work.");
				System.out.println(Colors.GREEN_BOLD + "How much money does A makes per month??");
				Thread.sleep(1000);
				
				  //time limit
				System.out.println();
				System.out.println(Colors.GREEN + "You have 4 seconds to solve this question");
				Thread.sleep(4000);//480000 for 8 minutes
				System.out.println(Colors.RED + "Time is up!");
				
				//calculating answer for Question-3
				int cost_A = 40 * 400; //number of horses times monthly cost per horse
				int earnings = 40 * 14 * 40; //number of horses times number of days that the horse works per month times horse charges per day.
				int result3 = earnings - cost_A;
				System.out.println(Colors.RESET+"enter your answer rounded to a whole number: ");
				answer = number_input.nextDouble();
				
				Thread.sleep(1000);
				if(answer == Math.round(result3)) {
					System.out.println(Colors.GREEN + "Correct!");
					userScore = userScore + 1;
				}
				else if(answer != Math.round(result3)) {
					System.out.println(Colors.RED_BRIGHT + "Incorrect!");
					System.out.println(Colors.CYAN + "Correct answer is -> " + Math.round(result3));
				}
				
				//if the user answers all the 3 questions
				if(userScore == 3) {
					System.out.println(Colors.BLUE_BOLD + "Congratulations on completing all the questions correctly!");
					Thread.sleep(1000);
					System.out.println(Colors.RED_BRIGHT + "Please enter your e-mail address here, to receive an award for your performance");
					String email = txt_input.nextLine();
					Math_Quizz.sendEmail(email);
				}
				else if(userScore != 3) {
					System.out.println(Colors.BLUE_BOLD + "Your Score is -> " + userScore + " out of 3 points.");
					System.out.println(Colors.RESET + "Thank you for taking the quiz!");
				}
			}
			else {
				System.out.println(Colors.TEAL + count_down);
				Thread.sleep(1000);
			}
		}
	}

}
