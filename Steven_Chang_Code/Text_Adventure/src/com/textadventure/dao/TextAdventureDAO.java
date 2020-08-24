package com.textadventure.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.textadventure.models.Item;
import com.textadventure.models.Player;
import com.textadventure.models.Room;
import com.textadventure.util.ConnectionFactory;

public class TextAdventureDAO {
	
	public void insertPlayer(String p) {
		String sql = "insert into player (name) values (?)";
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public Player selectPlayerByName(String p) {
		String sql = "select * from player where name = ?";
		Player foundPlayer = null;
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				foundPlayer = new Player(rs.getInt("id"), rs.getString("name"), selectRoomById(rs.getInt("current_room")));
				foundPlayer.setInventory(selectPlayerItems(foundPlayer));
				foundPlayer.setRooms(selectAllRooms());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foundPlayer; 
	}
	
	public void updatePlayer(Player p) {
		String sql = "update player set name = ?, current_room = ? where id = ?";
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setInt(2, p.getCurrentRoom().getId());
			ps.setInt(3, p.getId());
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Room selectRoomById(int id) {
		String sql = "select * from rooms where id = ?";
		Room foundRoom = null;
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				foundRoom = new Room(rs.getInt("id"), rs.getString("name"), rs.getString("description"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foundRoom;
	}
	
	public Room selectRoomByName(String name) {
		String sql = "select * from rooms where name = ?";
		Room foundRoom = null;
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
//				foundRoom = new Room(rs.getInt("id"), rs.getString("name"), rs.getString("description"));
				for(Room room:selectAllRooms()) {
					foundRoom = (room.getId() == rs.getInt("id")) ? room : foundRoom;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foundRoom;
	}
	
	public List<Room> selectAllRooms() {
		String sql = "select * from rooms";
		List<Room> rooms = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			HashMap<Integer, Integer[]> mapping = new HashMap<>();
			while (rs.next()) {
				rooms.add(new Room(rs.getInt("id"), rs.getString("name"), rs.getString("description")));
				Integer[] map = {rs.getInt("north"), rs.getInt("south"), rs.getInt("east"), rs.getInt("west")};
				mapping.put(rs.getInt("id"), map);
			}
			for (Room room:rooms) {
				Integer[] map = mapping.get(room.getId());
				room.setnorth((rooms.get(map[0]).getId() != 0) ? rooms.get(map[0]) : null);
				room.setsouth((rooms.get(map[1]).getId() != 0) ? rooms.get(map[1]) : null);
				room.seteast((rooms.get(map[2]).getId() != 0) ? rooms.get(map[2]) : null);
				room.setwest((rooms.get(map[3]).getId() != 0) ? rooms.get(map[3]) : null);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rooms;
	}
	
	public List<Item> selectPlayerItems(Player p) {
		String sql = "select * from player_items where player_id = ?";
		List<Item> inventory = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, p.getId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				inventory.add(selectItemById(rs.getInt("id")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inventory;
	}
	
	public void insertItem(Room r, Item i) {
		String sql = "insert into room_items values room_id = ?, item_id = ?";
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r.getId());
			ps.setInt(2, i.getId());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertItem(Player p, Item i) {
		String sql = "insert into player_items values room_id = ?, item_id = ?";
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, p.getId());
			ps.setInt(2, i.getId());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Item selectItemById(int id) {
		String sql = "select * from items where id = ?";
		Item foundItem = null;
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			foundItem = new Item(rs.getInt("id"), rs.getString("name"), rs.getString("description"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foundItem;
	}
	
	public void deleteItem(Player p, Item i) {
		String sql = "delete from player_items where "
				+ "player_id = ? and "
				+ "item_id = ?";
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, p.getId());
			ps.setInt(2, i.getId());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteItem(Room r, Item i) {
		String sql = "delete from room_items where "
				+ "room_id = ? and "
				+ "item_id = ?";
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r.getId());
			ps.setInt(2, i.getId());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
