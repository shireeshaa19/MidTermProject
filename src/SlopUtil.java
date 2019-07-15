import java.util.ArrayList;
import java.util.List;

public class SlopUtil {
	
	private static FileLinesHelper linesHelper = new FileLinesHelper("itemList.txt");
	
	private static Product convertLineToItem(String line) {
	
		String[] parts = line.split(",");
		String[] category = line.split(",");
		String[] description = line.split(",");
		String[] price = line.split(",");
		Product product = new Product();
		product.setName(parts[0]);
		product.setCategory(category[1]);
		product.setDescription(description[2]);
		product.setPrice(Double.parseDouble(price[3]));
		
		
		return product;
	}
	
	private static String convertItemToLine(Product product) {
		return String.format("%s\t%s\t%s\t%f", product.getName(), product.getCategory(), product.getDescription(), product.getPrice());
	}
	
	public static List<Product> readFile() {
		List<String> lines = linesHelper.readFile();
		List<Product> items = new ArrayList<>(lines.size());
		for (String line : lines) {
			items.add(convertLineToItem(line));
		}
		return items;
//		Or with streams...
//		return linesHelper.readFile().stream().map(PlayerFileUtil::convertLineToItem).collect(Collectors.toList());
	}
	
	
}
