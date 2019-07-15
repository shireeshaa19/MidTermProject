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

	public static double cash(double grandTotal, Scanner scnr) {
		boolean valid = true;
		double change = 0;
		do {
			System.out.println("Enter cash amount.");

			double userCash = scnr.nextDouble();
			scnr.nextLine();
			if (userCash > grandTotal) {
				change = userCash - grandTotal;
				valid = true;

			} else {
				System.out.println("That isn't enough to pay for your order");
				valid = false;
			}
		} while (valid);
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

			} else {
				System.out.println("That is not a valid check number");
				valid = false;
			}

		} while (valid);
		return true;
	}

	public static boolean card(Scanner scnr) {
		boolean valid = true;
		String number = "";
		String expiration = "";
		String ccv = "";

		do {
			valid = true;
			System.out.println(
					"Please enter your card information (xxxx-xxxx-xxxx-xxxx). WE DO NOT TAKE AMERICAN EXPRESS");
			number = scnr.nextLine();
			if (number.matches("\\d{4}-\\d{4}-\\d{4}-\\d{4}")) {
			} else {
				System.out.println("Thats not a valid card type");
				valid = false;
			}

		} while (valid);

		do {
			valid = true;
			System.out.println("Please enter your expiration date (xx-xxxx)");
			expiration = scnr.nextLine();
			if (expiration.matches("\\d{2}-\\d{4}")) {
			} else {
				System.out.println("Thats not a valid expiration date");
				valid = false;
			}

		} while (valid);

		do {
			valid = true;
			System.out.println("Please enter your cv2 (xxx)");
			ccv = scnr.nextLine();
			if (ccv.matches("\\d{3}")) {
			} else {
				System.out.println("Thats not a valid security code");
				valid = false;
			}

		} while (valid);

		return true;
	}
}
