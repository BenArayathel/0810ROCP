package com.kash.dao;

import java.util.List;

import com.kash.models.Item;
import com.kash.models.Room;

public interface Dao {
	
	//public boolean checkBackpackForItem(Item i);
	
	public int[] selectAllFromBackpackAsIntArray();
	
	public List<Item> IntToListItems(int[] a);
	
	public Item retrieveItemById(int id);
	
	public int[] ListItemsIntoIntArray(List<Item> i);
	
	public int retrieveItemIdByName(String n);
//	 * add to backpack
	public void addToBackpack(Item i);
//	 * remove from room
	public void removeFromBackpack(Item i);

//	 * drop to rome
	public boolean addToRoom(Room r, Item i);
//	 * remove from backpack
	public void removeFromRoom(Room r);
	
	
//	 * check bag
	public void checkBackpack();
//	 * check room
	public Item checkRoom(Room r);

//	 * rooms table
//	 * backpack table
	 
	public void playerEnteredRoom(Room r); //update rooms table 
	
	public void playerLeftRoom(Room r);
	 
	public Room playerInWhichRoom();
}
