package cafe;

public class Items {
	private int id;
	private String name;
	private float price;
	private String description;
	
	
	public Items(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = null;
	}
	
	public Items(int id, String name, float price, String d) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = d;
	}
	
	@Override
	public String toString() {
		return this.name + ": $" + this.price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Float getPrice() {
		return this.price;
	}
	
	public int getId() {
		return this.id;
	}
	/*
	@Override
	public boolean equals(Object i) {
		boolean b = false;
		if(this.name == ((Items) i).getName() && this.id == ((Items) i).getId()) {
			b = true;
		}
		return b;
	}
	*/
	
}
