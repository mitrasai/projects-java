package mitrarestaurant;

import java.util.*;

public class Customer_Orders {
	private int starterportion;
	private int mainmeal_portion;
	private int dessert_portion;
	private int tea_portion;
	
	/*
	 * This is an E-waiter program for a restaurant called "Mitra"
	 * And the objective of the program is to collect orders from customers and process their orders based on 
	 * the portion selections they choose.
	 * And finally issuing a bill.
	 */

	public static void main(String[] args) {
		/*
		 * we must tell the customers, the protocols of the restaurant
		 */

		Scanner obj = new Scanner(System.in); //to receive input from customer
		Date date = new Date(); //To generate bill with proper details
		
		Main_Restaurantt waiter = new Main_Restaurantt(); //readout the menu from the restaurant
		Customer_Orders customer1 = new Customer_Orders();
		Customer_Orders customer2 = new Customer_Orders();
		
		System.out.println("Namaste! Welcome to the Mitra restaurant");
		System.out.println("Please take your seats");
		System.out.println();
		System.out.println("---------------- Mitra Restaurant Menu ----------------");
		System.out.printf("%44s%n", "Here is the menu for today");
		System.out.printf("%32s %5s%n", "Starter Section: ", waiter.mealcourse_starter);
		System.out.printf("%32s %s%n","Main Meal Section: ", waiter.main_mealcourse );
		System.out.printf("%32s %5s%n", "Dessert Section: ", waiter.dessert);
		System.out.printf("%32s %5s%n", "Tea Section: ", waiter.tea);
		System.out.println("---------------- Mitra Restaurant Menu ----------------");
		
		//displaying portion sizes to customer
		System.out.println();
		System.out.println("We also offer portion sizes for starters, main meals, dessert and tea");
		System.out.println("---------------- Mitra Restaurant Portion Sizes ----------------");
		System.out.printf("%40s%n", "Small portion(x1)");
		System.out.printf("%40s%n", "Large portion(x2)");
		System.out.printf("%40s%n", "X-Large portion(x3)");
		System.out.println("---------------- Mitra Restaurant Portion Sizes ----------------");
		
		//receiving orders from customer-1
		System.out.println();
		System.out.println("Hello customer 1, What portion would your like for starters(1 or 2 or 3)? ");
		customer1.starterportion = obj.nextInt(); 
		System.out.println("and what portion would your like for main meal course(1 or 2 or 3)? ");
		customer1.mainmeal_portion = obj.nextInt();
		System.out.println("the dessert(1 or 2 or 3)? ");
		customer1.dessert_portion = obj.nextInt(); 
		System.out.println("and finally the tea portion(1 or 2 or 3)? ");
		customer1.tea_portion = obj.nextInt();
		System.out.println("Thank you sir!");
		
		//receiving orders from customer-2
		System.out.println("Hello customer 2, What portion would your like for starters(1 or 2 or 3)? ");
		customer2.starterportion = obj.nextInt(); 
		System.out.println("and what portion would your like for main meal course(1 or 2 or 3)? ");
		customer2.mainmeal_portion = obj.nextInt();
		System.out.println("the dessert(1 or 2 or 3)? ");
		customer2.dessert_portion = obj.nextInt(); 
		System.out.println("and finally the tea portion(1 or 2 or 3)? ");
		customer2.tea_portion = obj.nextInt();
		System.out.println("Thank you sir!");
		
		//calculating the bill
		System.out.println("Your meals will be brought right away!");
		
		double customer1_bill = (customer1.starterportion * waiter.starter_price)+(customer1.mainmeal_portion * waiter.mainmealcourse_price)+(customer1.dessert_portion * waiter.dessert_price)+(customer1.tea_portion * waiter.tea_price);
		double customer2_bill = (customer2.starterportion * waiter.starter_price)+(customer2.mainmeal_portion * waiter.mainmealcourse_price)+(customer2.dessert_portion * waiter.dessert_price)+(customer2.tea_portion * waiter.tea_price);
		
		double total_bill = customer1_bill + customer2_bill;
		
		//to display final bill to customers
		System.out.println();
		System.out.println("---------------- Mitra Restaurant Bill ----------------");
		System.out.printf("%20s %tH: %tM: %tS", "Current Time: ", date, date,date);
		System.out.printf("%20s %td - %tm - %ty %n", "Current Date: ", date, date,date);
		System.out.printf("%40s %10s%n", "Customer 1 Meal Cost: ", customer1_bill);
		System.out.printf("%40s %10s%n", "Customer 2 Meal Cost: ", customer2_bill);
		System.out.printf("%40s %10s%n", "Total Bill: ", total_bill);
		System.out.printf("%50s%n", "Please pay the bill at reception");
		System.out.println("---------------- Mitra Restaurant Bill ----------------");
		
	}

}
