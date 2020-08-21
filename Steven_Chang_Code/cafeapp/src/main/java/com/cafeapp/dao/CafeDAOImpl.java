package com.cafeapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cafeapp.Order;
import com.cafeapp.models.Item;
import com.cafeapp.util.ConnectionFactory;

public class CafeDAOImpl implements CafeDAO {

	@Override
	public int insertOrder(Order o) {
		int orderID = 0;
		
		String sql = "insert into orders (name) values(?);"
					+ "select order_id from orders order by order_id desc limit 1";
		// add order and get the order_id to be passed back to whatever
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, o.getName());
			ResultSet rs = ps.executeQuery();
			orderID = rs.getInt("order_id");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderID;
	}

	@Override
	public void insertOrderMenuItem(Order o, Item i) {
		
		String sql = "insert into orders_menu_items (order_id, item_id) values(?,?)";
		
		try (Connection conn = ConnectionFactory.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, o.getOrderID());
			ps.setInt(2, i.getItemID());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<String> selectCategories() {
		List<String> categories = new ArrayList<>();
		String sql = "select category from menu_items group by category";
		try (Connection conn = ConnectionFactory.getConnection()) {	
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				categories.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public List<Item> selectMenuItemsByCategory(String category) {
		List<Item> menuItems = new ArrayList<>();
		String sql = "select * from menu_items where category = ?";
		try (Connection conn = ConnectionFactory.getConnection()) {	
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, category);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				menuItems.add(new Item(rs.getInt("item_id"), 
									rs.getString("category"), 
									rs.getString("item_name"),
									rs.getDouble("item_cost")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Order> selectAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order selectOrderByID() {
		// TODO Auto-generated method stub
		return null;
	}

}
