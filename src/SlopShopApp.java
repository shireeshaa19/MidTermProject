import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SlopShopApp {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		Path path = Paths.get("itemList.txt");
		List<Product> itemsList = SlopUtil.readFile();
		List<String> name = new ArrayList<>();
		List<Double> price = new ArrayList<>();
		List<Integer> quantity = new ArrayList<>();
		
		for(int i = 0; i < itemsList.size(); i++) {
			Product p = itemsList.get(i);
			String temp = p.getName();
			name.add(temp);
		}
		
		for(int i = 0; i < itemsList.size(); i++) {
			Product p = itemsList.get(i);
			double temp = p.getPrice();
			price.add(temp);
		}
		
		for(int i = 0; i < itemsList.size(); i++) {
			quantity.add(0);
			
		}
		
		
		
		System.out.println("Welcome to the Slop Shop!");
		
		boolean valid = true;
		do {
			SlopMethods.printItemsList(itemsList);
			System.out.println("What item would you like to buy?");
			int userSelection = scnr.nextInt();
			scnr.nextLine(); // clear scanner
			userSelection = userSelection - 1;
			
			System.out.println(name.get(userSelection) + " are $" + df2.format(price.get(userSelection)) + ". How many would you like to purchase?");
			int tempQuantity = scnr.nextInt();
			scnr.nextLine();
			quantity.add(userSelection, quantity.get(userSelection) + tempQuantity);
			
						
			
			System.out.println("The total for " + quantity.get(userSelection) + " " + name.get(userSelection) + " is $" + (price.get(userSelection) * quantity.get(userSelection) ));
			
			
			System.out.println("would you like to purchase something else? (y/n)");
			String userInput = scnr.nextLine();
			if(userInput.equalsIgnoreCase("y")) {
				valid = true;
			}else {
				valid = false;
			}
		}while(valid);
		
		double subtotal = SlopMethods.subtotal(price, quantity);
		System.out.println("subtotal: $" + df2.format(subtotal));
		double salesTax = subtotal * 0.06;
		System.out.println("Sales Tax: $" + df2.format(salesTax));
		System.out.println("Grand Total :$ " + df2.format(subtotal + salesTax));
		
		
		System.out.println("GoodBye");
		scnr.close();
		
		
		
	}//main

	private static DecimalFormat df2 = new DecimalFormat("#.##");
	
}//class
