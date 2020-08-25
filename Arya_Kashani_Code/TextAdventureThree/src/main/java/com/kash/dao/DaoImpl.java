package com.kash.dao;

import java.sql.Array;  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kash.models.Item;
import com.kash.models.Player;
import com.kash.models.Room;


public class DaoImpl implements Dao {
	
	public List<Item> IntToListItems(int[] a) {
		List<Item> backpack = new ArrayList<Item>();
		try {
			Connection conn = ConnectionFactory.getConnection();
			for (int id: a) {
				//System.out.println(id);
				Item i = retrieveItemById(id);
				//System.out.println(i);
				backpack.add(i);
				/*
				String sql = "SELECT * FROM txt_items WHERE item_id = " + id;
				Statement s = conn.createStatement(); 
				ResultSet rs = s.executeQuery(sql);
				
				if (rs.next()) {
					String item_name = rs.getString("item_name");
					Item i = Item.getItem(item_name);
					//Item j = retrieveItemById()
					System.out.println(i);
					backpack.add(i);
				}
				*/
			}
			conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return backpack;
	}
	
	public int[] selectAllFromBackpackAsIntArray() {
		int[] a = null;
		try {
			Connection conn = ConnectionFactory.getConnection();
			
			String sql = "SELECT * from backpack";
			
			Statement s = conn.createStatement(); 
			ResultSet rs = s.executeQuery(sql);
			
			if (rs.next()) {
				
				Array ar = rs.getArray("items");

				Object[] o = (Object[]) ar.getArray();
				/*
				a = new int[o.length];
				int counter = 0;
				for(Object oo: o) {
					Integer i = (Integer) oo;
					int ii = i.intValue();
					a[counter] = ii;
					counter += 1;
				}
				*/
 				a = objectArrayToIntArray(o);
			}
			
			conn.close();
			
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(a);
		return a;
	}
	
	
	
	public Item retrieveItemById(int id) {
		Item i = null;
		try {
			Connection conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM txt_items WHERE item_id = " + id;
			Statement s = conn.createStatement(); 
			ResultSet rs = s.executeQuery(sql);
			if (rs.next()) {
				String str = rs.getString("item_name");
				i = Item.getItem(str);
			}
			
			conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	
	
	public int retrieveItemIdByName(String n) {
		int i = -1;
		try {
			Connection conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM txt_items where item_name = '" + n + "'";
			Statement s = conn.createStatement(); 
			ResultSet rs = s.executeQuery(sql);
			
			if (rs.next()) {
				i = rs.getInt("item_id");
			}
			
			
			conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int[] ListItemsIntoIntArray(List<Item> i) {
		int[] a = new int[i.size()];
		try {
			Connection conn = ConnectionFactory.getConnection();
			
			int c = 0;
			for(Item it: i) {
				int id = retrieveItemIdByName(it.getName());
				a[c] = id;
				c += 1;
			}
			
			
			conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	

	
	public void addToBackpack(Item i) {
		// TODO Auto-generated method stub
		try {
			Connection conn = ConnectionFactory.getConnection();
			
			
			// read item array
			int[] items = selectAllFromBackpackAsIntArray();
			List<Item> backpack = IntToListItems(items);
			// add item to array
			backpack.add(i);
			
			
			
			// create func List items into int_array
			int[] x = ListItemsIntoIntArray(backpack);
			/*
			Object[] o = new Object[x.length];
			int z = 0;
			for (int y: x) {
				o[z] = (Object) y;
				z += 1;
			}
			*/
			Object[] o = intArrayToObjectArray(x);
			
			Array a = conn.createArrayOf("int", o);
			
			try {
				// update item array
				String sql = "UPDATE backpack set items = '" + a + "'";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.execute();
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			
			conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
	public void removeFromBackpack(Item i) {
		//
		
		
		// get backpack as int array from db
		int[] a =  selectAllFromBackpackAsIntArray();
		// convert int array to list of items
		List<Item> l = IntToListItems( a);
		// check if backpack has this item
		System.out.println(l);
		boolean b = false;
		for (Item j : l) {
			if (j.getName() == i.getName()) {
				b = true;
			}
		}
		// remove item i from backpack
		if (b == true) {
			System.out.println("SUPRISE!");
			l.remove(i);
			// turn backpack into int array
			int[] ar = ListItemsIntoIntArray(l);

			Object[] o = intArrayToObjectArray(ar);
			
			// update int array in db
			
			try {
				Connection conn = ConnectionFactory.getConnection();
				//turn obj array int sql array
				Array sql_ar = conn.createArrayOf("int", o);
				
				String sql = "UPDATE backpack SET items = '" + sql_ar + "'";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.execute();
				
				
				conn.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			//System.out.println("Item #here1 " + i + " not in backpack!");
			System.out.println("here here here");
		}
		
		
		
		
	}
	
	public boolean checkBackpackForItem(Item i) {
		boolean retval = false;
		try {
			int[] items = selectAllFromBackpackAsIntArray();
			List<Item> backpack = IntToListItems(items);
			for(Item iii : backpack) {
				if(i.getName() == iii.getName()) {
					retval = true;
				}
			}
			//retval = backpack.contains(i);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return retval;
	}

	
	
	public boolean addToRoom(Room r, Item i) {
		// TODO Auto-generated method stub
		boolean retval = false;
		try {
			//Connection conn = ConnectionFactory.getConnection();
			
			// check backpack for item
			boolean b = checkBackpackForItem(i);
			// make sure room empty
			String s = checkRoomForItem(r);
			if (b == false) {
				System.out.println("Item " + i + " not in backpack");
			}
			else if ( s != null) {
				System.out.println("Can't drop " + i + "! The room isn't empty.");
			}
			else {
				//  remove item from backpack
				int[] items = selectAllFromBackpackAsIntArray();
				List<Item> backpack = IntToListItems(items);
				backpack.remove(i);
				// update room to have item
				int[] a = ListItemsIntoIntArray(backpack);
				// int array into obj array
				Object[] o = intArrayToObjectArray(a);
				// obj array into sql array
				try {
					Connection conn = ConnectionFactory.getConnection();
					
					Array ar = conn.createArrayOf("int", o);
					
					String sql = "UPDATE backpack SET items = '" + ar + "'";
					
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.execute();
					
					String sql2 = "UPDATE rooms SET (item_id, item_name) = (?,?) WHERE room_name = '" + r.getName() + "'";
					
					int id = retrieveItemIdByName(i.getName());
					//System.out.println("id: "  + id);
					PreparedStatement ps2 = conn.prepareStatement(sql2);
					
					ps2.setInt(1, id);
					ps2.setString(2, i.getName());
					
					ps2.execute();
					
					retval = true;
					conn.close();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				// update backpack set items = sql_array
				
				// update room to have item
			}
			
			
			
			//conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return retval;
	}
	
	public String checkRoomForItem(Room r) {
		String retval = null;
		try {
			Connection conn = ConnectionFactory.getConnection();
			
			String sql = "SELECT * FROM rooms where room_name = '" + r.getName() + "'";
			
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if (rs.next()) {
				String str = rs.getString("item_name");
				if (str != null) {
					retval = str;
				}
			}
			
			conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return retval;
	}

	
	
	public void removeFromRoom(Room r) {
		// TODO Auto-generated method stub
		try {
			// check room for item_name
			String item_name = checkRoomForItem(r);
			// turn item_name string into Item object
			Item i = Item.getItem(item_name);
			// update room to null
			try {
				Connection conn = ConnectionFactory.getConnection();
				
				String sql = "UPDATE rooms SET (item_id, item_name) = (null,null) WHERE room_name = '" + r.getName() + "'";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.execute();
				
				
				conn.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			// add item to backpack
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public void checkBackpack() {
		// TODO Auto-generated method stub
		try {
			
			int[] items = selectAllFromBackpackAsIntArray();
			List<Item> backpack = IntToListItems(items);
			System.out.println(backpack);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public Item checkRoom(Room r) {
		// TODO Auto-generated method stub
		Item i = null;
		try {
			// select * from rooms where room_name = ' r '
			Connection conn = ConnectionFactory.getConnection();
			
			String sql = "SELECT * FROM rooms WHERE room_name = '" + r.getName() + "'";
			
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if (rs.next()) {
				String item_name = rs.getString("item_name");
				if (item_name == null) {
					System.out.println("Room " + r + " is empty");
					
				}
				else {
					//System.out.println("Room " + r + " has " + item_name);
					i = Item.getItem(item_name);
				}
			}
			
			
			conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public void playerEnteredRoom(Room r) {
		// TODO Auto-generated method stub
		try {
			Connection conn = ConnectionFactory.getConnection();
			
			//String sql = "SELECT * FROM rooms WHERE room_name = '" + r.getName() + "'";
			
			String sql = "UPDATE rooms SET player_in_room = true WHERE room_name = '" + r.getName() + "'";
			
			//Statement s = conn.createStatement();
			//ResultSet rs = s.executeQuery(sql);
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.execute();
			
			conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void playerLeftRoom(Room r) {
		// TODO Auto-generated method stub
		try {
			Connection conn = ConnectionFactory.getConnection();
			String sql = "UPDATE rooms SET player_in_room = false WHERE room_name = '" + r.getName() + "'";
			PreparedStatement ps = conn.prepareStatement(sql);	
			ps.execute();
			
			conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Object[] intArrayToObjectArray(int[] ar) {
		//Object[] a = null;
		Object[] o = new Object[ar.length];
		// turn int array into object array
		int index = 0;
		for(int j : ar) {
			o[index] = (Object) j;
			index += 1;
		}
		return o;
	}
	
	private int[] objectArrayToIntArray(Object[] o) {
		//int[] a = null;
		int[] a = new int[o.length];
		int counter = 0;
		for(Object oo: o) {
			Integer i = (Integer) oo;
			int ii = i.intValue();
			a[counter] = ii;
			counter += 1;
		}
		return a;
	}
	
	public Room playerInWhichRoom() {
		Room r = null;
		try {
			Connection conn = ConnectionFactory.getConnection();
			
			String sql = "SELECT * FROM rooms WHERE player_in_room = true";
			
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if (rs.next()) {
				String room_name = rs.getString("room_name");
				
				r = Room.getRoom(room_name);
			}
			
			
			conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}


}
