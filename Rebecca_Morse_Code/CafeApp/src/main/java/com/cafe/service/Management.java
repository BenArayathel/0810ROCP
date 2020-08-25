package com.cafe.service;

import com.cafe.dao.CafeDAOImplementation;
import com.cafe.models.Order;

public class Management {
	public void viewOrderById(int id) {
		CafeDAOImplementation cafeDAO = new CafeDAOImplementation();
		Order thisOrder = cafeDAO.getOrderById(id);
		OrderTaker.displayOrder(thisOrder);
	}
	
	public void viewAllOrders() {
		
	}
}
