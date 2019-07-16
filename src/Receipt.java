
public class Receipt {
	
	private String name;
	private double price;
	private int quantity;
	
	public Receipt( ){
		
	}
   public Receipt(String name,int quantity, double price) {
	   this.name = name;
	   this.price = price;
	   this.quantity = quantity;
   }
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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
@Override
public String toString() {
	return (String.format("%-22s%-12d$%-10.2f", getName(),getQuantity(),getPrice()));
}


}
