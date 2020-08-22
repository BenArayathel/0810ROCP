package cafeDb;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import cafe.Items;
import cafe.Menu;
import cafe.Order;

public class CafeDAOimpl implements CafeDAO {
	
	
	@Override
	public void insertOrder(Order o) {
		try {
			Connection conn = ConnectionFactory.getConnection();
			
			String sql = "INSERT INTO cafe (customer_name, customer_order, total_price) values " + "(?,?,?)";
			
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, o.get_name());
			
			Map<Items,Integer> li = o.get_order();
			int siz = 0;
			for (Map.Entry<Items, Integer> entry : li.entrySet()) {
				
				siz += (1 * entry.getValue());
				
			}
			Object[] ob = new Object[siz];
			
			int x = 0;
			for (Map.Entry<Items, Integer> entry : li.entrySet()) {
				int id = entry.getKey().getId();
				for(int h=0; h < entry.getValue(); h++) {
					ob[x] = id;
					x += 1;
				}
			}
			
			Array a = conn.createArrayOf("int", ob);
			ps.setArray(2, a);
			ps.setFloat(3, o.get_total());
			
			
			
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertItem(Items p) {
		try {
			Connection conn = ConnectionFactory.getConnection();
			
			String sql = "INSERT INTO menu (item_name, item_price) values " + "(?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setFloat(2, p.getPrice());
			
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateItems(Items i, int id, String d) {
		try {
			Connection conn = ConnectionFactory.getConnection();
			String sql = "UPDATE menu SET item_name = ?, item_price = ?, item_description = ? WHERE item_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, i.getName());
			ps.setFloat(2, i.getPrice());
			ps.setString(3, d);
			ps.setInt(4, id);
			ps.execute();
			
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public Set<Items> selectAllItems() {
		// TODO Auto-generated method stub
		Set<Items> items = new HashSet<>();
		
		
		String sql = " SELECT * FROM menu";
		
		try {
			Connection conn = ConnectionFactory.getConnection();
			
			Statement s = conn.createStatement(); //Allows us to send SQL statements
			
			ResultSet rs = s.executeQuery(sql); //We are executing our SQL statement
			
			while(rs.next()) {
				items.add(new Items(
				rs.getInt("item_id"),
				rs.getString("item_name"),
				rs.getFloat("item_price")
						));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return items;
	}

	@Override
	public Items selectItemByName(String name) {
		// TODO Auto-generated method stub
		Items p = null;
		
		try {
			
			Connection conn = ConnectionFactory.getConnection();
			
			String sql = "SELECT * FROM menu where item_name = '" + name + "'";
			
			Statement s = conn.createStatement(); 
			
			ResultSet rs = s.executeQuery(sql);
			
			
			if(rs.next()) {
			
				p = new Items(
					rs.getInt("item_id"),
					rs.getString("item_name"),
					rs.getFloat("item_price")
					);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Items selectItemById(int id) {
		// TODO Auto-generated method stub
		Items p = null;
		
		try {
			
			Connection conn = ConnectionFactory.getConnection();
			
			String sql = "SELECT * FROM menu where item_id = " + id;
			
			Statement s = conn.createStatement(); 
			
			ResultSet rs = s.executeQuery(sql);
			
			
			if(rs.next()) {
			
				p = new Items(
					rs.getInt("item_id"),
					rs.getString("item_name"),
					rs.getFloat("item_price")
					);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void deleteItem(int id) {
		// TODO Auto-generated method stub
		try {
			Connection conn = ConnectionFactory.getConnection();
			
			String sql = "DELETE FROM menu where item_id = ?";
			
			//Statement s = conn.createStatement(); 
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			
			//p = (Planet) rs;
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static int whatsID() {
		int retval = 0;
		try {
			Connection conn = ConnectionFactory.getConnection();
			String sql = "SELECT count(*) FROM cafe";
			Statement s = conn.createStatement(); 
			ResultSet rs = s.executeQuery(sql);
			if (rs.next()) {
				retval = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retval+1;
	}
	
	public float whatsTotal(Map<Items,Integer> o) {
		float f = 0;
		for (Map.Entry<Items, Integer> e : o.entrySet()) {
			Items i = e.getKey();
			int v = e.getValue();
			float p = i.getPrice();
			f += (v * p);
		}
		return f;
	}
	
	
	
	public static void main(String[] args) {
		CafeDAO cafe = new CafeDAOimpl();
		
		//Items i = cafe.selectItemById(1);
		//Items i = cafe.selectItemByName("Iced Coffee");
		//System.out.println(i);
		
		//Items i = new Items("Water", (float) 0.49);
		//cafe.insertItem(i);
		
		
		//Items i = new Items("Water", (float) 0.99);
		//cafe.updateItems(i, 5, null);
		//cafe.deleteItem(5);
		
		//List<Order> o = cafe.selectAllOrders(cafe);
		//System.out.println(o);
		
		Set<Items> menu = cafe.selectAllItems();
		//System.out.println(menu_);
//		Items i = menu.get(1);
//		Order o = new Order(1, "Arya", menu, (float)1.50);
//		cafe.insertOrder(o);
//		System.out.println("hope");
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		Scanner s = new Scanner(System.in);
		
		//Map<String, Map<Items, Integer>> orders = new HashMap<String, Map<Items, Integer>>();
		
		
		while(true) {
			
			System.out.print("Customer or Employee or Exit? ");
			Menu m = new Menu();
			String w = s.nextLine();
			
			if(w.toLowerCase().equals("employee") || w.toLowerCase().equals("e")) {
				System.out.println("Here is a list of all the orders");
				System.out.println();
				List<Order> oOo = cafe.selectAllOrders(cafe);
				System.out.println(oOo);
				
			}
			else if (w.toLowerCase().equals("customer") || w.toLowerCase().equals("c")) {
			
				
				
				String customerName = m.getCustomerName(s);
				System.out.println("Hello " + customerName + ", Here is our menu:");
				
				System.out.println(menu);

				
				Boolean willMakeOrder = m.willMakeOrder(s);
				if(willMakeOrder == true) {
					Map<Items, Integer> order = m.createOrder(s, menu);
					
					order = m.confirmOrEdit(s, order, menu);
					
					float tot = cafe.whatsTotal(order);
					
					if (tot == 0) {
						//System.out.println("get tf outta here");
						continue;
					}
					
					Order ord = new Order(whatsID(), customerName, order, tot);
					cafe.insertOrder(ord);
					
					//order = m.confirmOrEdit(s, order, menu);
					//orders.put(customerName, order);
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
	


	@Override
	public List<Order> selectAllOrders(CafeDAO cafe) {
		List<Order> o = new ArrayList<>();
		
		
		String sql = " SELECT * FROM cafe";
		
		try {
			Connection conn = ConnectionFactory.getConnection();
			
			Statement s = conn.createStatement(); //Allows us to send SQL statements
			
			ResultSet rs = s.executeQuery(sql); //We are executing our SQL statement
			
			
			while(rs.next()) {
				
				
				
				Object[] b;
				Array arr;
						
				arr = rs.getArray("customer_order");
				b = (Object[]) arr.getArray();
				int[] a = new int[b.length];
				
				int z = 0;
				for(Object obb : b) {
					Integer integ = (Integer) obb;
					a[z] = integ.intValue();
					z += 1;
				}
				Map<String, Integer> temp = new HashMap<String, Integer>();
				//System.out.println("2");
				for(int x=0; x < a.length; x++) {
					int id = a[x];
					/*
					String sql2 = "select * from menu where item_id = " + id;
					Connection conn2 = ConnectionFactory.getConnection();
					Statement s2 = conn2.createStatement();
					ResultSet rs2 = s2.executeQuery(sql2);
					if (rs2.next()) {
						Items itt = new Items(
								rs2.getInt("item_id"),
								rs2.getString("item_name"),
								rs2.getFloat("item_price")
								);
						
						if (temp.containsKey(itt)) {
							temp.put(itt, temp.get(itt) + 1);
						}
						else {
							temp.put(itt, 1);
						}
					}
					
					*/
					//System.out.println("a");
					//System.out.println(id);
					Items i = cafe.selectItemById(id);
					
					//System.out.println("b");
					
					String itt = i.getName();
					//System.out.println("c");
					if (temp.containsKey(itt)) {
						temp.put(itt, temp.get(itt) + 1);
					}
					else {
						temp.put(itt, 1);
					}
					//System.out.println("d");
				}
				//System.out.println("3");
				Map<Items, Integer> temp2 = new HashMap<Items, Integer>();
				// iterate thru 
				Iterator it = temp.entrySet().iterator();
			    while (it.hasNext()) {
			        Map.Entry pair = (Map.Entry)it.next();
			        String i = (String) pair.getKey();
			        int val = (int) pair.getValue();
			        Items item_ = cafe.selectItemByName(i);
			        temp2.put(item_, val);
			        //it.remove();
			    }
			    //System.out.println("4");
				o.add(new Order(
				rs.getInt("order_id"),
				rs.getString("customer_name"),
				temp2,
				rs.getFloat("total_price")
						));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return o;
	}

}
