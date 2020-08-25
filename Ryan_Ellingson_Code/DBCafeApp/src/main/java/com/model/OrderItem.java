package com.model;

public class OrderItem {
	private int id;
	private int orderId;
	private int menuItemId;
	
	public OrderItem() {
		super();
	}

	public OrderItem(int id, int orderId, int menuItemId) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.menuItemId = menuItemId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getMenuItemId() {
		return menuItemId;
	}

	public void setMenuItemId(int menuItemId) {
		this.menuItemId = menuItemId;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", orderId=" + orderId + ", menuItemId=" + menuItemId + "]";
	}
	
	
}
