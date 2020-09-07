
package com.revature.main;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import com.revature.model.Order;
import com.revature.model.Item;
import com.revature.DAO.SnackCafeDAOImpl;

public class Main {

	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		SnackCafeDAOImpl dao = new SnackCafeDAOImpl();
		ArrayList<Item> menu = dao.selectAllItems();
		boolean orderMore = true;
		Order order = new Order();
		
		System.out.println("Welcome to Yodit's Cafe");
		System.out.print("Your name : ");
		String customerName = null;
		try {
			customerName = br.readLine();
			
			order.setCustomerName(customerName);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("");
		System.out.println("Hi " + customerName + "!");
		
		while(orderMore) {
			System.out.println("What would you like to add to your order?");
			System.out.println("");
			for(int i=0; i<menu.size(); i++) {
				System.out.println(menu.get(i));
			}
			System.out.println("");
			System.out.println("Punch in the item number : ");
			
			int itemIdToOrder = 0;
			try {
				itemIdToOrder = Integer.parseInt(br.readLine());
			}
			catch(Exception e){
				System.out.println("Enter a valid item number");
			}
			Item itemToOrder = menu.get(itemIdToOrder-1);
			
			System.out.println("How many " + itemToOrder.getName() + "?");
			int quantityToOrder = 0;
			try {
				quantityToOrder = Integer.parseInt(br.readLine());
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			order.addItem(itemToOrder, quantityToOrder);
			System.out.println(order);
			System.out.println("Want to add more items? (Y/N) : ");
			String yesOrNo = null;
			try {
				yesOrNo = br.readLine();
			}
			catch(Exception e) {
				System.out.println("Enter a valid response.");
			}
			if(yesOrNo.toLowerCase().charAt(0) == 'n') {
				orderMore = false;
			}
		}
		System.out.println("");
		order.calcOrderTotal();
		dao.insertOrder(order);
		System.out.println(order);
		System.out.println("Your order total is $" + order.getOrderTotal());
	}
}