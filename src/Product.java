
public class Product {
	
	private String name;
	private String category;
	private String description;
	private double price;
	private int quantity;
	
	public Product(){
		super();
	}
	
	public Product(String name,String category,String description,double price, int quantity){
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
		this.quantity = 0;
	}

	@Override
	public String toString() {
		return (String.format("%-22s%-12s%-10s%-18.2f", getName(), getCategory(), getDescription(), getPrice()));
			
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
