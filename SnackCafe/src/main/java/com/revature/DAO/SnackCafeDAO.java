package com.revature.DAO;

import java.util.ArrayList;

import com.revature.model.Item;
import com.revature.model.Order;

public interface SnackCafeDAO {
	
	
	//DAO - Data Access Object:Provide CRUD Operations 
			// enables database interaction with business logic. 
			
			//CREATE
			public void insertOrder(Order order);
			
			/*
			//READ
			public ArrayList<Order> selectAllOrders();
			
			public Order selectCustomerByOrderId(int id);
			
			//DELETE
			public void deleteOrder(Order order);
			*/					
			public ArrayList<Item> selectAllItems();


}
