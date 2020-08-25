package com.dao;

import java.util.List;
import java.util.Map;

import com.models.Room;
import com.models.User;

public interface RoomGameDAO {
//	CREATE
	public int insertUser(User user);
	
	public void insertRoomInst(User user, Room room);
	
//	READ
	public Map<Integer, User> getAllUsers();
	
	public User getUserById(int id);
	
	public List<Room> getAllRooms();
	
	public Map<Integer, Room> getRoomsByUser(int userId);
	
	public Room getRoomById(int userId, int roomId);
	
//	UPDATE
	public void updateUser(User user);
	
	public void updateRoom(int userId, Room room);
}
