package cafe;

//import java.text.DecimalFormat;
//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
//import java.util.List;
import java.util.Map;

public class Order {
	
	private int order_id;
	private String customer_name;
	private Map<Items,Integer> order;
	private float total_price;
	
	public Order(int id, String name, Map<Items, Integer> o, float t) {
		this.order_id = id;
		this.customer_name = name;
		this.order = o;
		this.total_price = t;
	}
	
	public Order(int id, String name) {
		this.order_id = id;
		this.customer_name = name;
		this.order = new HashMap<Items, Integer>();
		this.total_price = (float) 0.00;
	}
	
	public int get_id() {
		return this.order_id;
	}
	
	public String get_name() {
		return this.customer_name;
	}
	
	public Map<Items, Integer> get_order() {
		return this.order;
	}
	
	public float get_total() {
		return this.total_price;
	}
	
	public String printOrderHelper(Map<Items,Integer> order) {
		String retval = "{";
		//System.out.println("Here is your order:");
		//Float total = (float) 0.00;
		Iterator it = order.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        //Items i = (Items) pair.getKey();
	        //i.getN
	        //Integer inte = (Integer) pair.getValue();
	        //Float count = inte.floatValue();
	        //Float t = count * i.getPrice();
	        //total += t;
	        //System.out.println(pair.getKey() + " * " + pair.getValue() + " = " + t);
	        retval += pair.getKey() + " * " + pair.getValue() ;
	        if (it.hasNext()) {
	        	retval = retval + ", ";
	        }
	        //it.remove(); // avoids a ConcurrentModificationException
	    }
	    //System.out.println("Total = $" + String.format("%.2g%n", total));
	    //DecimalFormat df = new DecimalFormat("#.##");
	    //System.out.println("Total = $" + df.format(total));
	    retval += "}";
	    return retval;
	}
	
	/*
	public String printOrderHelper(Map<Items,Integer> order) {
		String s = "";
		Iterator it = order.entrySet().iterator();
	    while (it.hasNext()) {
	    	 Map.Entry pair = (Map.Entry)it.next();
		     Items i = (Items) pair.getKey();
	    }
		return s;
	}
	*/
	
	
	
	@Override
	public String toString() {
		return "" + order_id + ": " + customer_name + ", order: " + printOrderHelper(order) + ", total: " + total_price + "\n";
	}
}
