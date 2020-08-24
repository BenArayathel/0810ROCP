package com.cafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.cafe.models.FoodItem;
import com.cafe.models.Order;
import com.cafe.util.Communication;
import com.cafe.util.ConnectionLayer;

public class CafeDAOImplementation implements CafeDAOInterface {

	@Override
	public List<FoodItem> SelectAllFoodItems() {

		List<FoodItem> allFoodItems = new ArrayList<>();

		Connection connection = ConnectionLayer.getConnection();

		try {
			String sql = "SELECT * from food_item";
			PreparedStatement ps = connection.prepareStatement(sql);

			ResultSet results = ps.executeQuery();

			while (results.next()) {
				allFoodItems.add(new FoodItem(
						results.getInt(1), 
						results.getString(2), 
						results.getString(3),
						results.getString(4), 
						results.getFloat(5)));
			}

		} catch (SQLException e) {
			Communication.communicate("Can't connect to the Database.");
			e.printStackTrace();
		}
		return allFoodItems;
	}

	@Override
	public int insertOrder(String customerName) {

		String sql = "insert into cafe_order(order_id, customer_name) values (default, " + "?)";

		int orderNumber = 0;

		Connection connection = ConnectionLayer.getConnection();

		try {

			PreparedStatement preparedInsertStatement = connection.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);

			preparedInsertStatement.setString(1, customerName);

			int affectedRows = preparedInsertStatement.executeUpdate();

			if (affectedRows > 0) {

				try (ResultSet rs = preparedInsertStatement.getGeneratedKeys()) {
					if (rs.next()) {
						orderNumber = rs.getInt(1);
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} catch (SQLException e) {

			Communication.communicate("Can't Insert Customer");
			e.printStackTrace();
		}
		return orderNumber;
	}

	@Override
	public Order getOrderById(int id) {

		Connection conn = ConnectionLayer.getConnection();
		Map<FoodItem, Integer> orderMap = new HashMap<>();
		String customerName = new String();
				
		String sql = "	co.customer_name, " + 
				"	fi.item_id, " + 
				"	fi.dish_name, " + 
				"	fi.dish_category, " + 
				"	fi.description, " +
				"	cofi.price, " + 
				"	cofi.quantity " + 
				"from cafe_order co " + 
				"inner join cafe_order_food_items cofi on cofi.order_id = co.order_id " + 
				"inner join food_item fi on fi.item_id = cofi.item_id" +
				"where co.order_id = " +
				"(?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				customerName = rs.getString("co.customer_name");
				
				FoodItem orderedFood = new FoodItem(
						rs.getInt("fi.item_id"), 
						rs.getString("fi.dish_name"), 
						rs.getString("fi.dish_category"),
						rs.getString("fi.description"), 
						rs.getFloat("cofi.price"));
					
				orderMap.put(orderedFood, rs.getInt("cofi.quantity"));	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Order order = new Order(id, customerName, orderMap);	
		return order;
	}

	@Override
	public List<Order> displayAllOrders() {
		
		return null;
	}

	@Override
	public void enterOrderIntoRegister(Order order) {
				
		Connection conn = ConnectionLayer.getConnection();
		
		List<FoodItem> foodsOrdered = new ArrayList<>();
		
		Iterator<FoodItem> i = order.getOrderContents().keySet().iterator();
		
		while (i.hasNext()) {
			FoodItem item = i.next();
			foodsOrdered.add(item);
		}
		
		String sql = "insert into cafe_order_food_items (order_id, item_id, quantity, price)"
				+ " values(?,?,?,?);";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			for ( FoodItem item : foodsOrdered ) {
				ps.setInt(1, order.getOrderID());
				ps.setInt(2, item.getId());
				ps.setInt(3, order.getOrderContents().get(item));
				ps.setFloat(4, item.getCost());
				ps.execute();
			}

		} catch (SQLException e) {
			Communication.communicate("Couldn't save order");
			e.printStackTrace();
		}

	}

	@Override
	public void deleteOrder(Order order) {
		// TODO Auto-generated method stub

	}

}
