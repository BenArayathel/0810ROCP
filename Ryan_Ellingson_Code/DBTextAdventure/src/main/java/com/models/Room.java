package com.models;

public class Room {
	private int id;
	private String name;
	private String item;
	private boolean hasItem;
	private Room forward;
	private Room back;
	private Room left;
	private Room right;
	
	public Room() {
		super();
	}

	public Room(int id, String name, String item, boolean hasItem) {
		super();
		this.id = id;
		this.name = name;
		this.item = item;
		this.hasItem = hasItem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public boolean isHasItem() {
		return hasItem;
	}

	public void setHasItem(boolean hasItem) {
		this.hasItem = hasItem;
	}

	public Room getForward() {
		return forward;
	}

	public void setForward(Room forward) {
		this.forward = forward;
	}

	public Room getBack() {
		return back;
	}

	public void setBack(Room back) {
		this.back = back;
	}

	public Room getLeft() {
		return left;
	}

	public void setLeft(Room left) {
		this.left = left;
	}

	public Room getRight() {
		return right;
	}

	public void setRight(Room right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", name=" + name + ", item=" + item + ", hasItem=" + hasItem + "]";
	}
	
	
}
