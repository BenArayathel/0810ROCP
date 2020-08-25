package com.dao;

import java.util.List;

import com.model.MenuItem;
import com.model.Order;
import com.model.OrderItem;

public interface CafeDAO {
//	CREATE
	public void insertMenuItem(MenuItem item);
	
	public void insertOrderItem(OrderItem item);
	
	public void insertOrder(Order order);
	
//	READ
	public List<MenuItem> getMenu();
	
	public List<Order> getOrders();
	
	public List<OrderItem> getOrderItemsByOrder(int orderId);
	
//	UPDATE
	public void updateMenuItem(MenuItem item);
	
	public void updateOrder(Order order);
	
	public void updateOrderItem(OrderItem item);
	
//	DESTROY
	public void deleteMenuItem(int id);
	
	public void deleteOrderItem(int id);
	
	public void deleteOrder(int id);
}
