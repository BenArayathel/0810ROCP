package com;

import com.dao.CafeDAO;
import com.dao.CafeDAOImpl;
import com.model.MenuItem;
import com.model.Order;
import com.model.OrderItem;

public class Driver {

	public static void main(String[] args) {

		CafeDAO cDao = new CafeDAOImpl();
		System.out.println(cDao.getMenu());
		System.out.println(cDao.getOrders());
		System.out.println(cDao.getOrderItemsByOrder(1));
		cDao.deleteOrderItem(1);
		cDao.deleteOrder(1);
		cDao.deleteMenuItem(3);
		System.out.println(cDao.getMenu());
		System.out.println(cDao.getOrders());
		System.out.println(cDao.getOrderItemsByOrder(1));
	}

}
