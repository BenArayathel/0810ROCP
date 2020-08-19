package cafe;

public class Items {
	private String name;
	private Double price;
	
	
	public Items(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return this.name + ": $" + this.price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Double getPrice() {
		return this.price;
	}
}
