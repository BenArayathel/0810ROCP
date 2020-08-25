package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.models.Room;
import com.models.User;

public class RoomGameDAOImpl implements RoomGameDAO {
	
	private Connection conn;
	
	public RoomGameDAOImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public int insertUser(User user) {
		String sql = "INSERT INTO users (name, current_room) VALUES (?,?)";
		int insertId = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getName());
			ps.setInt(2, user.getCurrentRoom());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				insertId = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insertId;
	}

	@Override
	public void insertRoomInst(User user, Room room) {
		String sql = "INSERT INTO room_inst (user_id, room_id) VALUES (?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.setInt(2, room.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Map<Integer, User> getAllUsers() {
		Map<Integer, User> users = new HashMap<>();
		String sql = "SELECT * FROM users";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User currentUser = new User(
					rs.getInt(1),
					rs.getString(2),
					rs.getInt(3)
				);
				users.put(currentUser.getId(), currentUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User getUserById(int id) {
		User user = new User();
		String sql = "SELECT * FROM users WHERE user_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setCurrentRoom(rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	@Override
	public List<Room> getAllRooms() {
		List<Room> rooms = new ArrayList<>();
		String sql = "SELECT * FROM rooms";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				rooms.add(new Room(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					true
					)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rooms;
	}
	
	@Override
	public Map<Integer, Room> getRoomsByUser(int userId) {
		Map<Integer, Room> rooms = new HashMap<>();
		String sql = "SELECT rooms.room_id, rooms.name, rooms.item, room_inst.has_item from room_inst INNER JOIN rooms ON room_inst.room_id = rooms.room_id WHERE room_inst.user_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Room currentRoom = new Room(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getBoolean(4)
				);
				rooms.put(currentRoom.getId(), currentRoom);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rooms;
	}

	@Override
	public Room getRoomById(int userId, int roomId) {
		Room room = new Room();
		String sql = "SELECT rooms.room_id, rooms.name, rooms.item, room_inst.has_item FROM room_inst INNER JOIN rooms ON room_inst.room_id = rooms.room_id WHERE room_inst.user_id = ? AND room_inst.room_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, roomId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				room.setId(rs.getInt(1));
				room.setName(rs.getString(2));
				room.setItem(rs.getString(3));
				room.setHasItem(rs.getBoolean(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return room;
	}
	
	@Override
	public void updateUser(User user) {
		System.out.println(user);
		String sql = "UPDATE users SET current_room = ? WHERE user_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getCurrentRoom());
			ps.setInt(2, user.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateRoom(int userId, Room room) {
		String sql = "UPDATE room_inst SET has_item = ? WHERE user_id = ? AND room_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, room.isHasItem());
			ps.setInt(2, userId);
			ps.setInt(3, room.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
