package com.cafe.dao;

import java.util.List;

import com.cafe.models.FoodItem;
import com.cafe.models.Order;

public class cafeDAOImplementation implements cafeDAOInterface{

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateFoodItem(FoodItem item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFoodItem(FoodItem item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertOrder(String customerName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getOrderByCustomerName(String customerName) {
		// TODO Auto-generated method stub
		
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
