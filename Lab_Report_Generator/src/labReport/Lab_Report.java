
package labReport;

/*
 * itextJar:- helps us to store information that the user is entering into a pdf file automatically
 * jfreechart:- helps us to generate line charts, line-charts will contain data information from the experiments
 *               or based on the experiments that the user has done. so to be insert a line-chart and to show that
 *               the data result and it can be also saved into the lab report, which is the final result in the pdf file
 */

import java.util.*;

//to take a screenshots, it is mostly for the chart(i.e., line-chart) that will be generated from the data that the user gonna be entering the results part
import java.awt.Dimension; 
import java.awt.Rectangle; //determines width and height of the screen
import java.awt.Robot; //handles the mouse and keyboard controls and actually do the part of taking the screen-shot
import java.awt.Toolkit;
import java.awt.event.KeyEvent; //handles what ever happens to our mouse and keyboard controls
import java.awt.image.BufferedImage; //opening and saving images to certain places, locations
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

//line-charts should be generated for user based on the data results that the user has been entering for the lab experiment
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; //to open an chart panel(i.e., opens an empty window, which contains the chart)
//to import data set, which allows us to be able to enter the x, y values for whatever data we want to plot on the line chart
import org.jfree.chart.JFreeChart; 
import org.jfree.data.category.DefaultCategoryDataset;

//packages that handles the opening files, cause we have to open image file and able to take screen-shots of the chart and save it in some sort of file and all those images we have to save it in the lab report
import java.io.File;
import java.io.FileOutputStream; //getting those files and save them in some place
import java.net.URI; //opening any locations or path of any thing we want to open up

//to store the information that the user is entering into the pdf file
import com.lowagie.text.Chunk; //handles any string font formating(i.e., under-lines, bold etc)
import com.lowagie.text.Document; //open up the pdf document
import com.lowagie.text.Element; //opening elements that are stored in the document
import com.lowagie.text.Image; //allows us to actually insert images into the pdf file
import com.lowagie.text.Paragraph; //allows us to store the information that the user is entering as a paragraph

//acts a pen writing on the actual pdf document itself
import com.lowagie.text.pdf.PdfWriter;

//to insert stuff like bullet-points, numbered list etc
import com.lowagie.text.List;

public class Lab_Report extends JFrame {
	
	/*
	 * it is not just only about generating a lab report based on the information that user entering
	 * but also about providing the user a proper guide what they need to include per-section of lab report and how many words should they include
	 */
	
	//counters to count the words
	static int title_wordcounter = 0;
	static int stmt_problem = 0;
	static int hypo_counter = 0;
	static int materials_counter = 0;
	static int method_counter = 0;
	static int conclusion_counter = 0;
	
	//setting the status of each section is valid
	static String report_title;
	static Document doc; //object of the document class, to open up the pdf file as a document
	static PdfWriter writer; //writing the information in the pdf file
	
	//setting flags saying that the section is valid or accepted
	//this will help us, when we actually want to start writing all the information into the pdf document
	static String title_accept_status = "";
	static String stmt_accept_status = "";
	static String hypo_accept_status = "";
	static String material_accept_status = "";
	static String method_accept_status = "";
	static String conclusion_accept_status = "";
	
	//setting method, materials section, cause for those sections we're going by list way(i.e., where we ask them to list out the materials they have used)
	static String material;
	static String method; //process that the user has to explain, that the user has taken to conduct the experiment
	static String material2; //fourth thing we have been adding (for the materials)
	static String method2;
	static String series_name = ""; //series of our line-chart, cause if we compare 2 or 3 data-sets
	
	/*if you want to compare 3 or 4 different type of data(i.e., anything more than one)
	 * static String series1_name = "";
	 * static String series2_name = "";
	 * static String series3_name = "";
	 * .......
	 * .....
	 * ...
	 */

	
	//creating a section that handle creating(generating, displaying) the line-chart according to the user's data-set entry
	public Lab_Report(String title, String chart_title, String X_Axis, String Y_Axis){
		//title for the main window
		super(title); //refers to the parent class object
		//creating data-set object
		DefaultCategoryDataset dset = Dataset(); //creating a method, that contains the x,y points that are needed to be plotted to create the line-chart
		//creating chart
		JFreeChart chart = ChartFactory.createLineChart(chart_title, X_Axis, Y_Axis, dset);
		ChartPanel panel = new ChartPanel(chart); //independent window that will contain chart, generated based on the chart
		setContentPane(panel); //putting the panel on the main window, which contains the panel which is going to have the chart in it
	}
	
	//creating the method that generate actual data that will be use to construct the chart, which receives the x,y values to plot the line chart
	private DefaultCategoryDataset Dataset() {
		Scanner numinput = new Scanner(System.in);
		Scanner txtinput = new Scanner(System.in);
		
		System.out.println("Enter the name of the series: ");
		String name = txtinput.nextLine();
		series_name = name; //sampling plants, Monthly_data, Quaterly_data etc
		
		DefaultCategoryDataset dset = new DefaultCategoryDataset();
		
		System.out.println(Colors.RED_UNDERLINED + series_name + " series");
		
		//asking how many sets of data is needed
		System.out.println(Colors.RESET + "How many enteries or data results would you like to enter to plot the line chart?: ");
		int data_results = numinput.nextInt();
		for(int y=0; y<data_results; y++) {
			System.out.println(Colors.BLUE + "Enter the Y-Axis value(should be a number value): ");
			int y_axis = numinput.nextInt();
			System.out.println(Colors.BLUE + "Enter the X-Axis value(should be a text value): ");
			String x_axis = txtinput.nextLine();
			
			dset.addValue(y_axis, series_name, x_axis); //putting a key what line chart representing
		}
		
		return dset;
	}
	
	
	
	public static void main(String[] args) throws Exception {
		Scanner numobj = new Scanner(System.in);
		Scanner textobj = new Scanner(System.in);
		
		System.out.println(Colors.CYAN + "--> Welcome to the lab report generator system <--");
		
		Thread.sleep(1000);
		System.out.println(Colors.GREEN + "Do you want to start creating a lab report?(yes or no): ");
		String response = textobj.nextLine();
		
		while(response.equalsIgnoreCase("yes")) {
			System.out.println(Colors.RESET + "Enter your Name: ");
			String user_name = textobj.nextLine();
			System.out.println("Hello " + user_name + ", let's get started!");
			//handles the title of the lab report
			StringBuilder sb_title = new StringBuilder(user_name.toUpperCase() + "'S LAB REPORT");
			report_title = user_name + "'s Lab Report" + ".pdf"; //name of the pdf
			String user_naam = sb_title.toString(); //converting the stringbuilder into string which contains the user_name and then lab-report
			Thread.sleep(2000);
			
			//entering the title of lab experiment
			System.out.println();
			System.out.println(Colors.ORANGE + "-------------------------------------------------------------------------");
			System.out.println(Colors.RESET);
			System.out.println("we will start by entering the title of your experiment");
			System.out.println("Title Guideline(should provide a brief concise, yet descriptive tile)");
			System.out.println("Title word count limit: 100(1 word = approx 6 characters)");
			System.out.println();
			System.out.println("Enter your Title: ");
			String user_title = textobj.nextLine();
			//formatting
			String add = " " + user_title;
			System.out.println(Colors.ORANGE + "-------------------------------------------------------------------------");
			System.out.println(Colors.RESET);
			
			//validating the correct amount of characters
			StringBuilder user_title_count = new StringBuilder(user_title);
			//to count the number of words in the title information the user entered
			for(int ch=0; ch<add.length(); ch++) {
				if(add.charAt(ch) == ' ') {
					//if it detects a space, followed by that space it counted as a word
					title_wordcounter = title_wordcounter + 1;
				}
			}
			//to calculate the number of characters
			int title_capacity = user_title_count.capacity() - 16; //16 is for default stringbuilder object capacity
			while(title_capacity > 600 || title_capacity < 140) {
				System.out.println(Colors.RED + "You have entered more or less number of words\nYou need to enter between 140 and 600 characters\nYour word count is -> " + title_wordcounter +"\nYour character count is -> " + title_capacity);
				System.out.println(Colors.RESET);
				
				System.out.println("Re-Enter your Title: ");
				user_title = textobj.nextLine();
				//formatting
				add = " " + user_title;
				title_wordcounter = 0; //calculates freshly with new user_title entry
				
				//validating the correct amount of characters
				user_title_count.setLength(0); //calculates the new StringBuilder length from starting
				user_title_count = new StringBuilder(user_title);
				title_capacity = user_title_count.capacity() - 16; //calculates the new capacity of the StringBuilder
				//to count the number of words in the title information the user entered
				for(int ch=0; ch<add.length(); ch++) {
					if(add.charAt(ch) == ' ') {
						//if it detects a space, followed by that space it counted as a word
						title_wordcounter = title_wordcounter + 1;
					}
				}
			}
			if(title_capacity >= 140 && title_capacity <= 600) {
				System.out.println("You have entered an acceptable number of words!\nYour word count is -> " + title_wordcounter);
				title_accept_status = "Valid";
			}
			
			
			//entering statement of the problem for the lab experiment
			Thread.sleep(2000);
			System.out.println();
			System.out.println(Colors.ORANGE + "-------------------------------------------------------------------------");
			System.out.println(Colors.RESET);
			System.out.println("Next you will need to enter the statement problem or research question for your experiment");
			System.out.println("Problem Statement Guideline -> \nWhat questions are you trying to answer \nProvide any preliminary background information about the subject/project");
			System.out.println("Problem Statement Word count limit: 100(1 word = approx 6 characters)");
			System.out.println();
			System.out.println("Enter your Problem Statement: ");
			String user_problem_stmt = textobj.nextLine();
			//formatting
			String add2 = " " + user_problem_stmt;
			System.out.println(Colors.ORANGE + "-------------------------------------------------------------------------");
			System.out.println(Colors.RESET);
			
			//validating the correct amount of characters
			StringBuilder user_problem_count = new StringBuilder(user_problem_stmt);
			//to count the number of words in the problem statement information the user entered
			for(int ch=0; ch<add2.length(); ch++) {
				if(add2.charAt(ch) == ' ') {
					//if it detects a space, followed by that space it counted as a word
					stmt_problem = stmt_problem + 1;
				}
			}
			//to calculate the number of characters
			int stmt_capacity = user_problem_count.capacity() - 16; //16 is for default stringbuilder object capacity
			while(stmt_capacity > 600 || stmt_capacity < 140) {
				System.out.println(Colors.RED + "You have entered more or less number of words\nYou need to enter between 140 and 600 characters\nYour word count is -> " + stmt_problem + "\nYour character count is -> " + stmt_capacity);
				System.out.println(Colors.RESET);
				
				System.out.println("Re-Enter your Problem Statement: ");
				user_problem_stmt = textobj.nextLine();
				//formatting
				add2 = " " + user_problem_stmt;
				stmt_problem = 0;
				
				//validating the correct amount of characters
				user_problem_count.setLength(0);
				user_problem_count = new StringBuilder(user_problem_stmt);
				stmt_capacity = user_problem_count.capacity() - 16;
				//to count the number of words in the problem statement information the user entered
				for(int ch=0; ch<add2.length(); ch++) {
					if(add2.charAt(ch) == ' ') {
						//if it detects a space, followed by that space it counted as a word
						stmt_problem = stmt_problem + 1;
					}
				}
			}
			if(stmt_capacity >= 140 && stmt_capacity <= 600) {
				System.out.println("You have entered an acceptable number of words!\nYour word count is -> " + stmt_problem + "\nYour character count is -> " + stmt_capacity);
				stmt_accept_status = "Valid";
			}
			
			
			//entering hypothesis of the lab experiment
			Thread.sleep(2000);
			System.out.println();
			System.out.println(Colors.ORANGE + "-------------------------------------------------------------------------");
			System.out.println(Colors.RESET);
			System.out.println("Next you will need to enter your hypothesis for your experiment");
			System.out.println("Hypothesis Guideline -> \nWrite a prediction what will happen in the experiment (or) what you think will be the result \nMake sure the predicition, you have written is a complete sentence \nMake sure the predicition statement is testable");
			System.out.println("Hypothesis Word count limit: 100(1 word = approx 6 characters)");
			System.out.println();
			System.out.println("Enter your Hypothesis: ");
			String user_hypo = textobj.nextLine();
			//formatting
			String add3 = " " + user_hypo;
			System.out.println(Colors.ORANGE + "-------------------------------------------------------------------------");
			System.out.println(Colors.RESET);
			
			//validating the correct amount of characters
			StringBuilder user_hypo_count = new StringBuilder(user_hypo);
			//to count the number of words in the hypothesis information the user entered
			for(int ch=0; ch<add3.length(); ch++) {
				if(add3.charAt(ch) == ' ') {
					//if it detects a space, followed by that space it counted as a word
					hypo_counter = hypo_counter + 1;
				}
			}
			//to calculate the number of characters
			int hypo_capacity = user_hypo_count.capacity() - 16; //16 is for default stringbuilder object capacity
			while(hypo_capacity > 600 || hypo_capacity < 140) {
				System.out.println(Colors.RED + "You have entered more or less number of words\nYou need to enter between 140 and 600 characters\nYour word count is -> " + hypo_counter + "\nYour character count is -> " + hypo_capacity);
				System.out.println(Colors.RESET);
				
				System.out.println("Re-Enter your Hypothesis: ");
				user_hypo = textobj.nextLine();
				//formatting
				add3 = " " + user_hypo;
				hypo_counter = 0;
				
				//validating the correct amount of characters
				user_hypo_count.setLength(0);
				user_hypo_count = new StringBuilder(user_hypo);
				hypo_capacity = user_hypo_count.capacity() - 16;
				//to count the number of words in the problem statement information the user entered
				for(int ch=0; ch<add3.length(); ch++) {
					if(add3.charAt(ch) == ' ') {
						//if it detects a space, followed by that space it counted as a word
						hypo_counter = hypo_counter + 1;
					}
				}
			}
			if(hypo_capacity >= 140 && hypo_capacity <= 600) {
				System.out.println("You have entered an acceptable number of words!\nYour word count is -> " + hypo_counter + "\nYour character count is -> " + hypo_capacity);
				hypo_accept_status = "Valid";
			}
			
			
			//entering materials that have been used for lab experiment
			Thread.sleep(2000);
			System.out.println();
			System.out.println(Colors.ORANGE + "-------------------------------------------------------------------------");
			System.out.println(Colors.RESET);
			System.out.println("Next you will need to enter your materials used for your experiment");
			System.out.println("Materials Guideline -> \nMake a list of materials used for the lab experiment");
			System.out.println("Materials Word count limit: 160(1 word = approx 6 characters)");
			System.out.println("How many materials or Technologies would you like to list out for your experiment?: ");
			int user_material = numobj.nextInt();
			
			//creating an object of an list class, which is helpful for list the different materials that have been used in experiment
			List list1 = new List(List.ORDERED); //numbered-format
			list1.setFirst(1); //starts from any number, we set it
			for(int i=0; i<user_material; i++) {
				System.out.println("Enter material - " + (i+1) + " -> ");
				material = textobj.nextLine();
				list1.add(material);
				//compiler starts counting from the starting sentence
				material2 = " " + (i+1) + "." + " " + material;
				//counting the number of words
				for(int j=0; j<material2.length(); j++) {
					 //if space has been detected, then it will start to count anything after the space as a word
					if(material2.charAt(j) == ' ') { 
						materials_counter = materials_counter + 1;
					}
				}
			}
			//check and see if the user enters reasonable amount of words
			while(materials_counter > 160 || materials_counter < 25) {
				System.out.println(Colors.RED + "You have entered more or less number of words\nYou need to enter between 25 to 160\nYour word count is -> " + materials_counter);
				System.out.println(Colors.RESET);
				
				//counting the new amount of words based on the new entries
				materials_counter = 0;
				
				System.out.println("How many materials or Technologies would you like to list out for your experiment?: ");
				user_material = numobj.nextInt();
				
				//creating an object of an list class, which is helpful for list the different materials that have been used in experiment
				list1 = new List(List.ORDERED); //numbered-format
				list1.setFirst(1); //starts from any number, we set it
				for(int i=0; i<user_material; i++) {
					System.out.println("Enter material - " + (i+1) + " -> ");
					material = textobj.nextLine();
					list1.add(material);
					//compiler starts counting from the starting sentence
					material2 = " " + (i+1) + "." + " " + material;
					//counting the number of words
					for(int j=0; j<material2.length(); j++) {
						 //if space has been detected, then it will start to count anything after the space as a word
						if(material2.charAt(j) == ' ') { 
							materials_counter = materials_counter + 1;
						}
					}
				}
			}
			//if material word count is actually between 80 to 160
			if(materials_counter >= 25 && materials_counter <= 160) {
				System.out.println("You have entered an acceptable number of words!\nYour word count is -> " + materials_counter);
				material_accept_status = "Valid";
			}
			
		
			//entering methods that have been used for lab experiment
			Thread.sleep(2000);
			System.out.println();
			System.out.println(Colors.ORANGE + "-------------------------------------------------------------------------");
			System.out.println(Colors.RESET);
			System.out.println("Next you will need to enter your methods (or) procedure used for your experiment");
			System.out.println("Methods Guideline -> \nWrite a list of steps, which explains what you did in the lab experiment");
			System.out.println("Methods Word count limit: 160(1 word = approx 6 characters)");
			System.out.println("How many method or approach steps would you like to list out for your experiment?: ");
			int user_methods = numobj.nextInt();
			
			//creating an object of an list class, which is helpful for list the different materials that have been used in experiment
			List list2 = new List(List.ORDERED); //numbered-format
			list2.setFirst(1); //starts from any number, we set it
			for(int i=0; i<user_methods; i++) {
				System.out.println("Enter method - " + (i+1) + " -> ");
				method = textobj.nextLine();
				list2.add(method);
				//compiler starts counting from the starting sentence
				method2 = " " + (i+1) + "." + " " + method;
				//counting the number of words
				for(int j=0; j<method2.length(); j++) {
					 //if space has been detected, then it will start to count anything after the space as a word
					if(method2.charAt(j) == ' ') { 
						method_counter = method_counter + 1;
					}
				}
			}
			//check and see if the user enters reasonable amount of words
			while(method_counter > 160 || method_counter < 25) {
				System.out.println(Colors.RED + "You have entered more or less number of words\nYou need to enter between 25 to 160\nYour word count is -> " + method_counter);
				System.out.println(Colors.RESET);
				
				//counting the new amount of words based on the new entries
				method_counter = 0;
				
				System.out.println("How many method or approach steps would you like to list out for your experiment?: ");
				user_methods = numobj.nextInt();
				
				//creating an object of an list class, which is helpful for list the different materials that have been used in experiment
				list2 = new List(List.ORDERED); //numbered-format
				list2.setFirst(1); //starts from any number, we set it
				for(int i=0; i<user_methods; i++) {
					System.out.println("Enter method - " + (i+1) + " -> ");
					method = textobj.nextLine();
					list2.add(method);
					//compiler starts counting from the starting sentence
					method2 = " " + (i+1) + "." + " " + method;
					//counting the number of words
					for(int j=0; j<method2.length(); j++) {
						 //if space has been detected, then it will start to count anything after the space as a word
						if(method2.charAt(j) == ' ') { 
							method_counter = method_counter + 1;
						}
					}
				}
			}
			//if method word count is actually between 80 to 160
			if(method_counter >= 25 && method_counter <= 160) {
				System.out.println("You have entered an acceptable number of words!\nYour word count is -> " + method_counter);
				method_accept_status = "Valid";
			}
			System.out.println(Colors.ORANGE + "-------------------------------------------------------------------------");
			System.out.println(Colors.RESET);
			
			
			//Adding an image of the lab experiment set up
			//the user also had to put a screen-shot or picture of lab or project set-up of How they conducted experiment
			Thread.sleep(2000);
			System.out.println("Please enter the location (or) path of the image for your lab experiment set-up(For reference, check below example)");
			System.out.println("C:\\Users\\sai mithra\\Dropbox\\PC\\Downloads\\img.png \nYou need to add image or pic name, extension(i.e., jpg, png)");
			System.out.println("Please enter here -> ");
			String img_setup = textobj.nextLine();
			
			//getting the image from the location that the user will enter and store it in pdf file
			//image object is used to add the image to the pdf document using the pdfWriter
			Image img = Image.getInstance(img_setup); //get it from where it is saved or path (within a folder)
			System.out.println(Colors.ORANGE + "-------------------------------------------------------------------------");
			System.out.println(Colors.RESET);
			
			//Results Section for the lab experiment
			//asking user to enter the amount of data
			Thread.sleep(2000);
			//asking them to enter main title for the charts
			System.out.println("A line chart will be created, based on your lab experiment data results!");
			System.out.println("Please enter your main title for you main method -> ");
			String main_title = textobj.nextLine();
			//chart-title
			System.out.println("Please enter your chart title -> ");
			String chart_title = textobj.nextLine();
			//X-Axis title
			System.out.println("Please enter your X-Axis title -> ");
			String x_axis_title = textobj.nextLine();
			//Y-Axis title
			System.out.println("Please enter your Y-Axis title -> ");
			String y_axis_title = textobj.nextLine();
			//calling the constructor
			Lab_Report chart_results = new Lab_Report(main_title, chart_title, x_axis_title, y_axis_title);
			//creating a line-chart using constructor object
			chart_results.setAlwaysOnTop(true); //put chart at very top of our window (putting chart at the top of the window)
			//packing the data
			chart_results.pack();
			//size of the graph
			chart_results.setSize(500, 500);
			//closing the operation on when user clicks x-button or exits the window
			chart_results.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			//showing the chart using JFrames
			chart_results.setVisible(true);
			System.out.println(Colors.ORANGE + "-------------------------------------------------------------------------");
			System.out.println(Colors.RESET);
			
			Thread.sleep(2000);
			//handles opening, taking the screen-shot of the image and writing that to the location where the user wants to save that image
			try {
				//asking location
				Robot robot = new Robot();
				System.out.println(Colors.YELLOW + "please enter the file location, where the image can be stored along with name of the image and extension \nFor you reference, please check below \nC:\\Users\\sai mithra\\Dropbox\\PC\\Downloads\\image.png -> ");
				String img_path_store = textobj.nextLine();
				
				//open back up the line-chart
				System.out.println(Colors.RED_BOLD + "Notification\n -> please open up the line-chart image <-,\n -> wait for some seconds so the screen-short can be taken <-");
				Thread.sleep(4000);
				//taking screen-shorts, for this we're gonna create an object of dimension class so we can specify how wide the screen-short will be
				Dimension dimension = new Dimension(500, 500); //to specify the size of the screen-short in terms of resolution of the image
				//specifying screen-size
				Rectangle screen_size_capture = new Rectangle(dimension);
				//taking the screen-short of the image itself and write to the location that the user has entered
				BufferedImage image = robot.createScreenCapture(screen_size_capture);
				//saving the image and later on using it in the lab report file
				ImageIO.write(image, "png", new File(img_path_store));
				System.out.println(Colors.GREEN + " -> The image has been successfully saved! <-");
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			//getting the image and save it on our pdf
			System.out.println(Colors.RESET + "Enter the file location, for the line chart image inorder to save in pdf file: ");
			String result_img = textobj.nextLine();
			Image img2 = Image.getInstance(result_img);
			
			
			//Conclusion Section for your experiment
			Thread.sleep(2000);
			System.out.println();
			System.out.println(Colors.ORANGE + "-------------------------------------------------------------------------");
			System.out.println(Colors.RESET);
			System.out.println("Finally you will need to enter your conclusion for your experiment");
			System.out.println("Conclusion Guideline -> \nState if you Accept or Reject the hypothesis? \nExplain why you accepted or rejected the hypothesis? \nExplain how the experiment applies to our real-life situtation?");
			System.out.println("Conclusion Word count limit: 100(1 word = approx 6 characters)");
			System.out.println();
			System.out.println("Enter your Conclusion: ");
			String user_conclusion = textobj.nextLine();
			//formatting
			String add6 = " " + user_conclusion;
			System.out.println(Colors.ORANGE + "-------------------------------------------------------------------------");
			System.out.println(Colors.RESET);
			
			//validating the correct amount of characters
			StringBuilder user_conclusion_count = new StringBuilder(user_conclusion);
			//to count the number of words in the hypothesis information the user entered
			for(int ch=0; ch<add6.length(); ch++) {
				if(add6.charAt(ch) == ' ') {
					//if it detects a space, followed by that space it counted as a word
					conclusion_counter = conclusion_counter + 1;
				}
			}
			//to calculate the number of characters
			int conclusion_capacity = user_conclusion_count.capacity() - 16; //16 is for default stringbuilder object capacity
			while(conclusion_capacity > 600 || conclusion_capacity < 140) {
				System.out.println(Colors.RED + "You have entered more or less number of words\nYou need to enter between 140 and 600 characters\nYour word count is -> " + conclusion_counter + "\nYour character count is -> " + conclusion_capacity);
				System.out.println(Colors.RESET);
				
				System.out.println("Re-Enter your Conclusion: ");
				user_conclusion = textobj.nextLine();
				//formatting
				add6 = " " + user_conclusion;
				conclusion_counter = 0;
				
				//validating the correct amount of characters
				user_conclusion_count.setLength(0);
				user_conclusion_count = new StringBuilder(user_conclusion);
				conclusion_capacity = user_conclusion_count.capacity() - 16;
				//to count the number of words in the problem statement information the user entered
				for(int ch=0; ch<add6.length(); ch++) {
					if(add6.charAt(ch) == ' ') {
						//if it detects a space, followed by that space it counted as a word
						conclusion_counter = conclusion_counter + 1;
					}
				}
			}
			if(conclusion_capacity >= 140 && conclusion_capacity <= 600) {
				System.out.println("You have entered an acceptable number of words!\nYour word count is -> " + conclusion_counter + "\nYour character count is -> " + conclusion_capacity);
				conclusion_accept_status = "Valid";
			}
			
			
			
			//if all the flags are valid, then it will be entered or written to the pdf file using pdfWriter
			//which means now this information can be successfully written to generate the lab report for the user
			if(title_accept_status.equalsIgnoreCase("valid") && stmt_accept_status.equalsIgnoreCase("valid")
					&& hypo_accept_status.equalsIgnoreCase("valid") && material_accept_status.equalsIgnoreCase("valid")
					&& method_accept_status.equalsIgnoreCase("valid") && conclusion_accept_status.equalsIgnoreCase("valid")) {
				//writing down all the information into pdf
				try {
					//first creating a document
					doc = new Document();
					
					//second write information into a document using writer
					writer = PdfWriter.getInstance(doc, new FileOutputStream(report_title)); //writing name of the pdf
					doc.open(); //opening an document
					
					//center-align the name of the person lab report(title)
					Paragraph center_align = new Paragraph(user_naam);
					center_align.setAlignment(Element.ALIGN_CENTER);
					//adding into our document file
					doc.add(center_align);
					
					//creating object of chunk class, so with this we can decorate our lines (under-line, bold etc)
					Chunk txt_underline = new Chunk(user_title);
					txt_underline.setUnderline(0.8f, -1f); //positioning under the text itself
					Paragraph center_align_title = new Paragraph(txt_underline);
					center_align_title.setAlignment(Element.ALIGN_CENTER);
					doc.add(center_align_title);
					
					//adding the titles for the sections of lab-report and adding the information under those titles
					doc.add(new Paragraph("\nProblem Statement: \n" + user_problem_stmt));
					doc.add(new Paragraph("\nHypothesis: \n" + user_hypo));
					doc.add(new Paragraph("\nMaterials: \n"));
					doc.add(list1);
					doc.add(new Paragraph("\nMethods: \n"));
					doc.add(list2);
					//adding a new page
					doc.newPage(); //creates a page and start adding the remaining things
					//adding images
					doc.add(new Paragraph("\nLab Set-up: \n"));
					doc.add(img);
					doc.newPage();
					doc.add(new Paragraph("\nData Results: \n"));
					doc.add(img2);
					doc.newPage();
					doc.add(new Paragraph("\nConclusion: \n" + user_conclusion));
					doc.close();
					writer.close();
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			else {
				System.out.println(Colors.RED + "Some of the information you have entered is in-valid");
			}
			
			
			//in-order create a lab-report again
			title_wordcounter = 0;
			stmt_problem = 0;
			hypo_counter = 0;
			materials_counter = 0;
			method_counter = 0;
			conclusion_counter = 0;
			
			System.out.println(Colors.GREEN + "Do you want to start creating a lab report again?(yes or no): ");
			response = textobj.nextLine();
		}
		if(response.equalsIgnoreCase("no")) {
			System.out.println(Colors.RESET + "Thank you, Have a nice day!");
			System.exit(0);
		}

	}

}
