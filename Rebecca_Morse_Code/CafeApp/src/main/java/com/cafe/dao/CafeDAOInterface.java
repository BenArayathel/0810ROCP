package com.cafe.dao;

import java.util.List;

import com.cafe.models.FoodItem;
import com.cafe.models.Order;

public interface CafeDAOInterface {
	//FOOD 
	//create
	public void insertFoodItem(FoodItem item);

	//read
	public FoodItem selectFoodItemByName(String foodName);
	public FoodItem selectFoodItemById(int id);
	public List<FoodItem> SelectAllFoodItems();
	
	//update
	public void updateFoodItem(FoodItem item);
	
	//delete
	public void deleteFoodItem(FoodItem item);
	
	//ORDERS
	//create
	public int insertOrder(String customerName);
	
	public Order getOrderById(int id);
	
	public List<Order> displayAllOrders();
	
	//update
	public void addFoodToOrder(Order order, FoodItem item, int quantity);
	
	//delete
	public void removeFoodFromOrder(Order order, FoodItem item, int quantity);

	

}
