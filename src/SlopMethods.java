import java.util.List;

public class SlopMethods {

	public static void printItemsList(List<Product> itemList) {
		List<Product> itemsList = itemList;
		int count = 1;
		for (Product p : itemsList) {
			if(count < 10) {
				System.out.print(count + ")  ");
			}else {
			System.out.print(count + ") ");
			}
			System.out.println(p.toString());
			count++;
		}
		System.out.println();
	}
	
}
