package com.cafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cafe.models.FoodItem;
import com.cafe.models.Order;
import com.cafe.util.Communication;
import com.cafe.util.ConnectionLayer;

public class CafeDAOImplementation implements CafeDAOInterface {

	@Override
	public void insertFoodItem(FoodItem item) {
		// TODO Auto-generated method stub

	}

	@Override
	public FoodItem selectFoodItemByName(String foodName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodItem selectFoodItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodItem> SelectAllFoodItems() {

		List<FoodItem> allFoodItems = new ArrayList<>();

		Connection connection = ConnectionLayer.getConnection();

		try {
			String sql = "SELECT * from food_item";
			PreparedStatement ps = connection.prepareStatement(sql);

			ResultSet results = ps.executeQuery();

			while (results.next()) {
				allFoodItems.add(new FoodItem(results.getInt(1), results.getString(2), results.getString(3),
						results.getString(4), results.getFloat(5)));
			}

		} catch (SQLException e) {
			Communication.communicate("Can't connect to the Database.");
			e.printStackTrace();
		}
		return allFoodItems;
	}

	@Override
	public void updateFoodItem(FoodItem item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteFoodItem(FoodItem item) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("static-access")
	@Override
	public int insertOrder(String customerName) {
//should this be a string and return the order number? 
		int orderNumber = 0;
		Connection connection = ConnectionLayer.getConnection();

		try {
//			String sql = "insert into cafe_order(customer_name) values " + "(?)";

			String sql = "insert into cafe_order(order_id, customer_name) values (default, " + "?)"; 
			//+ " returning order_id";
			PreparedStatement preparedInsertStatement = connection.prepareStatement(sql);
			preparedInsertStatement.setString(1, customerName);

			preparedInsertStatement.execute();
			
			ResultSet rs = preparedInsertStatement.getGeneratedKeys();
			
			if (rs != null & rs.next()) {
				System.out.println(rs.toString());
//				orderNumber = rs.getInt(1);
			}

		} catch (SQLException e) {

			Communication.communicate("Can't Insert Customer");
			e.printStackTrace();
		}
		System.out.println("order "+ orderNumber);
		return orderNumber;
		//order number not returning the key yet
	}

	@Override
	public void getOrderIdByCustomerName(String customerName) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionLayer.getConnection();
		
		String sql = "select order_id from cafe_order co where customer_name = " + "(?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, customerName);
			ResultSet rs = ps.executeQuery();
			
			
			//the problem is multiple customers could have same name.  
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

	@Override
	public List<Order> displayAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFoodToOrder(Order order, FoodItem item, int quantity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeFoodFromOrder(Order order, FoodItem item, int quantity) {
		// TODO Auto-generated method stub

	}

}
