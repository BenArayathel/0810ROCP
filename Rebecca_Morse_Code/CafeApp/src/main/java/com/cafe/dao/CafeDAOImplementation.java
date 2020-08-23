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

	@Override
	public Order getOrderById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
