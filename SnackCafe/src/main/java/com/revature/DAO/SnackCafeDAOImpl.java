package com.revature.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.Connection;
import com.revature.model.Item;
import com.revature.model.Order;
import com.revature.util.ConnectionLayer;

public class SnackCafeDAOImpl implements SnackCafeDAO  {
	
	

	
	@Override
	public void insertOrder(Order order) {
		Connection conn = ConnectionLayer.getConnection();
		
		String sql = "INSERT INTO orders (customer_name ,number_of_items, order_total, order_details) VALUES "
				+ "(?,?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, order.getCustomerName());
			ps.setInt(2, order.getNumberOfItems());
			ps.setDouble(3, order.getOrderTotal());
			ps.setString(4, order.toString());
			
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<Item> selectAllItems(){
		ArrayList<Item> items = new ArrayList<>();
		Connection conn = ConnectionLayer.getConnection();
		
		String sql = "SELECT * FROM items";
		
		try {
			Statement s =  conn.createStatement();
			ResultSet rs = s.executeQuery(sql); 
			
			while(rs.next()) {
				items.add(new Item(
				rs.getInt("item_id"),
				rs.getString("name"),
				rs.getString("category"),
				rs.getDouble("price")));
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return items;
	}

}

