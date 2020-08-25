package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.MenuItem;
import com.model.Order;
import com.model.OrderItem;
import com.util.ConnectionFactory;

public class CafeDAOImpl implements CafeDAO {

	@Override
	public void insertMenuItem(MenuItem item) {
		String sql = "INSERT INTO menu_items (name, price) values " + "(?,?)";
		
		try(Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, item.getName());
			ps.setDouble(2, item.getPrice());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insertOrderItem(OrderItem item) {
		String sql = "INSERT INTO order_items (order_id, menuitem_id) values " + "(?,?)";
		
		try(Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, item.getOrderId());
			ps.setInt(2, item.getMenuItemId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertOrder(Order order) {
		String sql = "INSERT INTO orders (customer_name) values " + "(?)";
		
		try(Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, order.getName());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MenuItem> getMenu() {
		List<MenuItem> items = new ArrayList<>();
		
		String sql = "SELECT * FROM menu_items";
		
		try(Connection conn = ConnectionFactory.getConnection()) {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				items.add(new MenuItem(
					rs.getInt(1),
					rs.getString(2),
					rs.getDouble(3)
					)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return items;
	}

	@Override
	public List<Order> getOrders() {
		List<Order> orders = new ArrayList<>();
		
		String sql = "SELECT * FROM orders";
		
		try(Connection conn = ConnectionFactory.getConnection()) {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				orders.add(new Order(
					rs.getInt(1),
					rs.getString(2)
					)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orders;
	}

	@Override
	public List<OrderItem> getOrderItemsByOrder(int orderId) {
		List<OrderItem> orderItems = new ArrayList<>();
		
		String sql = "SELECT * FROM order_items WHERE order_id = ?";
		
		try(Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				orderItems.add(new OrderItem(
					rs.getInt(1),
					rs.getInt(2),
					rs.getInt(3)
					)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orderItems;
	}

	@Override
	public void updateMenuItem(MenuItem item) {
		
		String sql = "UPDATE menu_items SET name = ?, price = ? where menuitem_id = ?";
		
		try(Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,  item.getName());
			ps.setDouble(2,  item.getPrice());
			ps.setInt(3, item.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateOrder(Order order) {
		String sql = "UPDATE orders SET customer_name = ? WHERE order_id = ?";
		
		try(Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,  order.getName());
			ps.setInt(2,  order.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateOrderItem(OrderItem item) {
		String sql = "UPDATE order_items SET order_id = ?, menuitem_id = ? WHERE orderitem_id = ?";
		
		try(Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,  item.getOrderId());
			ps.setInt(2,  item.getMenuItemId());
			ps.setInt(3, item.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMenuItem(int id) {
		String sql = "DELETE from menu_items WHERE menuitem_id = ?";
		
		try(Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrderItem(int id) {
		String sql = "DELETE from order_items WHERE orderitem_id = ?";
		
		try(Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrder(int id) {
		String sql = "DELETE from orders WHERE order_id = ?";
		
		try(Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
