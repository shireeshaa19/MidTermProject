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
		
		
		
		
		System.out.println("Welcome to the Slop Shop!");
		
		boolean valid = true;
		do {
			SlopMethods.printItemsList(itemsList);
			System.out.println("What item would you like to buy?");
			int userSelection = scnr.nextInt();
			scnr.nextLine(); // clear scanner
			userSelection = userSelection - 1;
			
			System.out.println(name.get(userSelection) + " price " + df2.format(price.get(userSelection)));
			
			
			System.out.println("true or no");
			String userInput = scnr.nextLine();
			if(userInput.equalsIgnoreCase("true")) {
				valid = true;
			}else {
				valid = false;
			}
		}while(valid);
		
		
		
	}//main

	private static DecimalFormat df2 = new DecimalFormat("#.##");
	
}//class
