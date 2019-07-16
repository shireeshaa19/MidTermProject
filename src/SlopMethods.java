import java.util.List;
import java.util.Scanner;

public class SlopMethods {
	static Scanner scnr = new Scanner(System.in);

	public static void printItemsList(List<Product> itemList) {
		List<Product> itemsList = itemList;
		int count = 1;
		for (Product p : itemsList) {
			if (count < 10) {
				System.out.print(count + ")  ");
			} else {
				System.out.print(count + ") ");
			}
			System.out.println(p.toString());
			count++;
		}
		System.out.println();
	}

	public static double subtotal(List<Double> price, List<Integer> quantity) {
		double subtotal = 0;

		for (int i = 0; i < price.size(); i++) {
			subtotal += price.get(i) * quantity.get(i);
		}

		return subtotal;

	}

	public static double cash(double grandTotal, Scanner scnr, double userCash) {
		double change = userCash - grandTotal;
		return change;
	}

	public static boolean check(Scanner scnr) {
		boolean valid = true;
		String checkNumber = "";
		do {
			System.out.println("Please provide your 9-digit check number now.");
			checkNumber = scnr.nextLine();
			if (checkNumber.matches("[0-9]{9}")) {
				valid = true;
				// System.out.println("Check accepted!");
			} else {
				System.out.println("That is not a valid check number");
				valid = false;
			}

		} while (!valid);
		return true;
	}

	public static boolean card(Scanner scnr) {
		boolean valid = true;
		String number = "";
		String expiration = "";
		String ccv = "";

		do {
			valid = true;
			System.out.println("Please enter your card information (xxxx-xxxx-xxxx-xxxx)");
			System.out.println("WE DO NOT TAKE AMERICAN EXPRESS");
			number = scnr.nextLine();
			if (number.matches("\\d{4}-\\d{4}-\\d{4}-\\d{4}")) {
			} else {
				System.out.println("Thats not a valid card type");
				valid = false;
			}

		} while (!valid);

		do {
			valid = true;
			System.out.println("Please enter your expiration date (xx-xxxx)");
			expiration = scnr.nextLine();
			if (expiration.matches("\\d{2}-\\d{4}")) {
			} else {
				System.out.println("Thats not a valid expiration date");
				valid = false;
			}

		} while (!valid);

		do {
			valid = true;
			System.out.println("Please enter your cv2 (xxx)");
			ccv = scnr.nextLine();
			if (ccv.matches("\\d{3}")) {
			} else {
				System.out.println("Thats not a valid security code");
				valid = false;
			}

		} while (!valid);
		return true;
	}

	public static void cashReciept(double subtotal, double salesTax, double grandTotal, double userCash, double change,
			List<Receipt> list) {
		double subytotal = subtotal;
		double tax = salesTax;
		double grandyTotal = grandTotal;
		double useryCash = userCash;
		double changey = change;
		List<Receipt> reciptList = list;

		System.out.println("Here is your reciept!");
		System.out.println();
		System.out.println("Slop Hut");
		System.out.println("--------");
		for (Receipt r : reciptList) {
			System.out.println(r.toString());

		}
		System.out.println("------------------------------------------");
		System.out.printf("%30s%5s%.2f\n", "Subtotal:", "$", subytotal);
		System.out.printf("%30s%5s%.2f\n", "Tax:", "$", tax);
		System.out.printf("%30s%5s%.2f\n", "Total:", "$", grandyTotal);
		System.out.printf("%30s%5s%.2f\n", "Payment:", "$", useryCash);
		System.out.printf("%30s%5s%.2f\n", "Change Tendered:", "$", changey);
		System.out.println();

	}

	public static void checkReciept(double subtotal, double salesTax, double grandTotal, List<Receipt> list) {
		double subytotal = subtotal;
		double tax = salesTax;
		double grandyTotal = grandTotal;
		List<Receipt> reciptList = list;

		System.out.println("Here is your reciept!");
		System.out.println();
		System.out.println("Slop Hut");
		System.out.println("--------");
		for (Receipt r : reciptList) {
			System.out.println(r.toString());

		}
		System.out.println("------------------------------------------");
		System.out.printf("%30s%5s%.2f\n", "Subtotal:", "$", subytotal);
		System.out.printf("%30s%5s%.2f\n", "Tax:", "$", tax);
		System.out.printf("%30s%5s%.2f\n", "Total:", "$", grandyTotal);
		System.out.printf("%30s%5s", "Payment:", " Approved");
		System.out.println();

	}

	public static void cardReciept(double subtotal, double salesTax, double grandTotal, List<Receipt> list) {
		double subytotal = subtotal;
		double tax = salesTax;
		double grandyTotal = grandTotal;
		List<Receipt> reciptList = list;

		System.out.println("Here is your reciept!");
		System.out.println();
		System.out.println("Slop Hut");
		System.out.println("--------");
		for (Receipt r : reciptList) {
			System.out.println(r.toString());

		}
		System.out.println("------------------------------------------");
		System.out.printf("%30s%5s%.2f\n", "Subtotal:", "$", subytotal);
		System.out.printf("%30s%5s%.2f\n", "Tax:", "$", tax);
		System.out.printf("%30s%5s%.2f\n", "Total:", "$", grandyTotal);
		System.out.printf("%30s%5s", "Payment:", " Approved");
		System.out.println();

	}

}
