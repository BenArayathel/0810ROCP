package com.cafeapp.dao;

import java.util.List;

import com.cafeapp.Order;
import com.cafeapp.models.Item;

public interface CafeDAO {
	
	public int insertOrder(Order o);
	
	public void insertOrderMenuItem(Order o, Item i);

	public List<String> selectCategories();
	
	public List<Item> selectMenuItemsByCategory(String category);
	
	public List<Order> selectAllOrders();
	
	public Order selectOrderByID();

	
	
}
