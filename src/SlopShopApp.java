import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SlopShopApp {
	static Scanner scnr = new Scanner(System.in);

	public static void main(String[] args) {
		boolean newOrder = true;
		do {
			Path path = Paths.get("itemList.txt");
			List<Product> itemsList = SlopUtil.readFile();
			List<String> name = new ArrayList<>();
			List<Double> price = new ArrayList<>();
			List<Integer> quantity = new ArrayList<>();
			List<Receipt> receiptList = new ArrayList<>();

			for (int i = 0; i < itemsList.size(); i++) {
				Product p = itemsList.get(i);
				String temp = p.getName();
				name.add(temp);
			}

			for (int i = 0; i < itemsList.size(); i++) {
				Product p = itemsList.get(i);
				double temp = p.getPrice();
				price.add(temp);
			}

			for (int i = 0; i < itemsList.size(); i++) {
				quantity.add(0);

			}

			System.out.println("\t\tWelcome to the Slop Shop!");
			System.out.println();
			System.out
					.println(String.format("%-26s%-12s%-15s%-12s", "    Product", "Category", "Description", "Price"));
			System.out.println("----------------------------------------------------------");
			boolean valid = true;
			do {
				SlopMethods.printItemsList(itemsList);
				int userSelection = 0;
				boolean tryCatch = true;

				do {
					System.out.println("What item would you like to buy?");
					try {
						userSelection = scnr.nextInt();
						scnr.nextLine(); // clear scanner
					} catch (InputMismatchException e) {
						System.out.println("Please only enter a valid number.");
						scnr.nextLine();
					}
					if (userSelection >= 1 && userSelection <= 12) {
						tryCatch = true;
					} else {
						System.out.println("Please select any product number on the menu(1-12).");
						tryCatch = false;
					}
				} while (!tryCatch);

				userSelection = userSelection - 1;

				int tempQuantity = 0;
				do {
					tryCatch = true;

					System.out.println(name.get(userSelection) + " are $" + df2.format(price.get(userSelection))
							+ ". How many would you like to purchase?");
					try {
						tempQuantity = scnr.nextInt();
						scnr.nextLine();
					} catch (InputMismatchException e) {
						System.out.println("Please enter a valid quantity.");
						scnr.nextLine();
						tryCatch = false;
					}
				} while (!tryCatch);
				quantity.add(userSelection, quantity.get(userSelection) + tempQuantity);

				System.out.println("The total for " + quantity.get(userSelection) + " " + name.get(userSelection)
						+ " is $" + df2.format(price.get(userSelection) * quantity.get(userSelection)));

				System.out.println("Would you like to purchase something else? (y/n)");
				String userInput = scnr.nextLine();
				if (userInput.equalsIgnoreCase("y")) {
					valid = true;
				} else {
					valid = false;
				}
			} while (valid);

			double subtotal = SlopMethods.subtotal(price, quantity);
			System.out.println("Subtotal: $" + df2.format(subtotal));
			double salesTax = subtotal * 0.06;
			System.out.println("Sales Tax: $" + df2.format(salesTax));
			double grandTotal = subtotal + salesTax;
			System.out.println("Grand Total: $" + df2.format(grandTotal));
			System.out.println();
			
			for (int i = 0; i < itemsList.size(); i++) {
				if (quantity.get(i) > 0 ) {
					receiptList.add(new Receipt(name.get(i),quantity.get(i),(quantity.get(i)*price.get(i))));
					
				}
			}
			
			
			double userCash = 0;
			do {
				valid = true;
				System.out.println("How would you like to pay? (cash/credit/check): ");
				String userPayment = scnr.nextLine();
				if (userPayment.equalsIgnoreCase("cash")) {
					System.out.println("Enter cash amount.");
					try {
					userCash = scnr.nextDouble();
					scnr.nextLine();
					}catch (InputMismatchException e){
						scnr.nextLine();
						System.out.println("Please enter a valid cash amount.");
					}
					double change = SlopMethods.cash(grandTotal, scnr, userCash);
					SlopMethods.cashReciept(subtotal, salesTax, grandTotal, userCash, change, receiptList);
				} else if (userPayment.equalsIgnoreCase("credit")) {
					SlopMethods.card(scnr);
				} else if (userPayment.equalsIgnoreCase("check")) {
					SlopMethods.check(scnr);
				} else {
					System.out.println("You didnt enter a valid payment method.");
					valid = false;
				}
			} while (!valid);

			System.out.println("Thank you for your order.");

			System.out.println("Would you like to start a new order? (y/n)");
			String input = scnr.nextLine();
			if (input.equalsIgnoreCase("y")) {
				newOrder = true;
			} else {
				newOrder = false;
			}
		} while (newOrder);
		scnr.close();
		System.out.println("Goodbye!");
	}// main

	private static DecimalFormat df2 = new DecimalFormat("#.##");

}// class
