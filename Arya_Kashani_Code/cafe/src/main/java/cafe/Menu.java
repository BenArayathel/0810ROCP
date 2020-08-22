package cafe;

import java.text.DecimalFormat;

import java.util.HashMap;
//import java.util.HashSet;
import java.util.Iterator;
//import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import cafeDb.CafeDAO;
//import java.util.Set;
import cafeDb.CafeDAOimpl;

public class Menu {
	
	
	public String getCustomerName(Scanner s) {
		//Scanner s = new Scanner(System.in);
		System.out.print("Customer, what is your name? ");
		String customerName = s.nextLine();
		//s.close();
		return customerName;
	}

	
	public Set<Items> presentMenuItems() {
		CafeDAO c = new CafeDAOimpl();
		return c.selectAllItems();
		//return set_items;
	}
	
	
	public boolean willMakeOrder(Scanner s) {
		System.out.print("Would you like to make an order? ");
		//Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		input = stringClean(input);
		if (input.toLowerCase().equals("yes") || input.toLowerCase().equals("y")) {
			return true;
		}
		else if (input.toLowerCase().equals("no") || input.toLowerCase().equals("n")) {
			return false;
		}
		else {
			return willMakeOrder(s);
		}
	}
	
	public String stringClean(String s) {
		
		int l = s.length();
		char c = s.charAt(l-1);
		if (c == ' ') {
			return s.substring(0, l-1);
		}
		return s;
	}
	
	
	public Items find(Set<Items> seti, String s) {
		s = stringClean(s);
		for(Items i: seti) {
			if(i.getName().equals(s) || i.getName().toLowerCase().equals(s.toLowerCase())) {
				//System.out.println("worked");
				return i;
			}
		}
		return null;
	}
	
	
	public Map<Items, Integer> createOrder(Scanner s, Set<Items> menu) {
		Map<Items, Integer> order = new HashMap<Items, Integer>();
		System.out.println("When your order is complete, type & enter the word 'done': ");
		String input = s.nextLine();
		while(!input.toLowerCase().equals("done")) {
			Items i = find(menu, input);
			if(i != null) {
				
				boolean b = true;
				while(b) {
					try {
						System.out.print("How many of " + i.getName() + " would you like? ");
						String quantity = s.nextLine();
						int q = Integer.parseInt(quantity);
						order.put(i, q);
						b = false;
					}
					catch (Exception e) {
						System.out.println("Invalid input. Needs to be a number, try again.");
					}
				}
				
			}
			else {
				System.out.println("Invalid input. Try again!");
			}
			System.out.print("What else would you like? ");
			input = s.nextLine();
		}
		return order;
	}
	
	
	public void printOrder(Map<Items,Integer> order) {
		//System.out.println("Here is your order:");
		Float total = (float) 0.00;
		Iterator it = order.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        Items i = (Items) pair.getKey();
	        //i.getN
	        Integer inte = (Integer) pair.getValue();
	        Float count = inte.floatValue();
	        Float t = count * i.getPrice();
	        total += t;
	        System.out.println(pair.getKey() + " * " + pair.getValue() + " = " + t);
	        //it.remove(); // avoids a ConcurrentModificationException
	    }
	    //System.out.println("Total = $" + String.format("%.2g%n", total));
	    DecimalFormat df = new DecimalFormat("#.##");
	    System.out.println("Total = $" + df.format(total));
	}
	
	public Map<Items,Integer> addFunction(Scanner s, Map<Items,Integer> order, Set<Items> menu) {
		System.out.print("What item would you like to add? ");
		String input = s.nextLine();
		Set<Items> seti = order.keySet();
		Items i = find(menu, input);
		Items j = find(seti, input);
		if(i == null) {
			System.out.println("Item entered not on the menu");
			
		}
		else if (j != null) {
			int q = order.get(j);
			System.out.println(j.getName() + " already on menu with quantity of " + q);
			
			boolean b = true;
			while(b) {
				try {
					System.out.print("What would you like the total quantity of " + j.getName() + " to be? ");
					String temp = s.nextLine();
					int temp2 = Integer.parseInt(temp);
					if(temp2 == 0) {
						order.remove(j);
					}
					else {
						order.replace(j, temp2);
					}
					b = false;
				}
				catch (Exception e) {
					System.out.println("Invalid input. Needs to be a number, try again.");
				}
			}
			
		}
		else {
			System.out.print("How many of " + i.getName() + " would you like? ");
			String temp = s.nextLine();
			while(true ) {
				try {
					int temp2 = Integer.parseInt(temp);
					if(temp2 == 0) {
						order.remove(i);
					}
					else {
						order.put(i, temp2);
					}
					break;
				}
				catch (Exception e) {
					System.out.println("Invalid input. Needs to be a number, try again!");
				}
			}
			
		}
		return order;
	}
	
	public Map<Items,Integer> addOrEdit(Scanner s, Map<Items,Integer> order, Set<Items> menu) { 
		System.out.print("Would you like to Add items or Edit? ");
		String input = s.nextLine();
		if(input.toLowerCase().equals("edit")) {
			order = editFunction(s,order);
		}
		else if(input.toLowerCase().equals("add")) {
			order = addFunction(s, order, menu);
		}
		else {
			System.out.println("Invalid input. Try again");
			addOrEdit(s,order, menu);
		}
		return order;
	}
	
	public Map<Items,Integer> editFunction(Scanner s, Map<Items,Integer> order) {
		System.out.print("What item would you like to edit? ");
		String input = s.nextLine();
		Set<Items> seti = order.keySet();
		Items i = find(seti, input);
		if(i != null) {
			
			boolean b = true;
			while(b) {
				try {
					System.out.print("What would you like to change the quantity to? ");
					String quantity = s.nextLine();
					int q = Integer.parseInt(quantity);
					if(q == 0) {
						order.remove(i);
					}
					else {
						order.replace(i, q);
					}
					b = false;
				}
				catch (Exception e) {
					System.out.println("Invalid input. Needs to be a number, try again.");
				}
			}
		}
		else {
			System.out.println("That item isn't in your cart. You have to add it!");
		}
		return order;
	}
	
	public static float whatsTotal(Map<Items,Integer> o) {
		float f = 0;
		for (Map.Entry<Items, Integer> e : o.entrySet()) {
			Items i = e.getKey();
			int v = e.getValue();
			float p = i.getPrice();
			f += (v * p);
		}
		return f;
	}
	
	public Map<Items,Integer> confirmOrEdit(Scanner s, Map<Items,Integer> order, Set<Items> menu) {
		System.out.println("Here is your order:");
		printOrder(order);
		System.out.print("Confirm or Edit? ");
		
		String confirmOrEdit = s.nextLine();
		confirmOrEdit = stringClean(confirmOrEdit);
		if( confirmOrEdit.toLowerCase().equals("confirm")) {
			if (whatsTotal(order) == 0 ) {
				System.out.println("Didn't find anything on our menu to your liking? Well, thanks for coming! Goodbye\n");
				
			}
			else {
				System.out.println("Great! Thanks for ordering.");
				printOrder(order);
			}
		} 
		else if( confirmOrEdit.toLowerCase().equals("edit")) {
			//editFunction(s,order);
			order = addOrEdit(s,order, menu);
			confirmOrEdit(s, order, menu);
		}
		else {
			System.out.println("Invalid Input. Try again!");
			confirmOrEdit(s, order, menu);
		}
		return order;
	}
	
	
	
	
	public static void main(String[] args) {
		//break;
		
		Scanner s = new Scanner(System.in);
		
		Map<String, Map<Items, Integer>> orders = new HashMap<String, Map<Items, Integer>>();
		
		
		while(true) {
			
			System.out.print("Customer or Employee or Exit? ");
			Menu m = new Menu();
			String w = s.nextLine();
			
			if(w.toLowerCase().equals("employee") || w.toLowerCase().equals("e")) {
				System.out.println("Here is a list of all the orders");
				System.out.println();
				
				Iterator it = orders.entrySet().iterator();
			    while (it.hasNext()) {
			        Map.Entry pair = (Map.Entry)it.next();
			        //String i = (String) pair.getKey();
			        //i.getN
			        Map<Items, Integer> inte = (Map<Items, Integer>) pair.getValue();
			        //Float count = inte.FloatValue();
			        //Float t = count * i.getPrice();
			        //total += t;
			        System.out.println(pair.getKey() + ":");
			        m.printOrder(inte);
			        System.out.println();
			        //it.remove(); // avoids a ConcurrentModificationException
			    }
			}
			else if (w.toLowerCase().equals("customer") || w.toLowerCase().equals("c")) {
			
				
				
				String customerName = m.getCustomerName(s);
				System.out.println("Hello " + customerName + ", Here is our menu:");
				
				Set<Items> menu = m.presentMenuItems();
				System.out.println(menu);
				
				Boolean willMakeOrder = m.willMakeOrder(s);
				if(willMakeOrder == true) {
					Map<Items, Integer> order = m.createOrder(s, menu);
					
					order = m.confirmOrEdit(s, order, menu);
					orders.put(customerName, order);
				}
				else {
					System.out.println("Didn't find anything on our menu to your liking? Well, thanks for coming! Goodbye");
				}
			}
			else if(w.toLowerCase().equals("exit")) {
				break;
			}
			else {
				System.out.println("Invalid input. Try again!");
			}
		}
		
		s.close();
	}
	
}





