package com.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.dao.RoomGameDAOImpl;
import com.models.User;
import com.models.Room;
import com.util.ConnectionFactory;

public class RoomStuff {
	private Connection conn;
	private RoomGameDAOImpl rDao;
	private User user;
	private Map<Integer, Room> rooms;
	private boolean gameRunning = false;
	private Scanner sc;
	
	public RoomStuff() {
		this.conn = ConnectionFactory.getConnection();
		this.rDao = new RoomGameDAOImpl(conn);
		this.sc = new Scanner(System.in);
	}
	
	public void start() {
		System.out.println("Welcome to the house exploration adventure!");
		boolean isValid = false;
		while (!isValid) {
			System.out.println("Would you like to start a new game or load a saved game?  Enter 'new', 'load', or 'quit'");
			String choice = this.sc.nextLine();
			switch(choice) {
			case "new":
				this.gameRunning = true;
				isValid = true;
				newGame();
				break;
			case "load":
				this.gameRunning = true;
				isValid = true;
				loadGame();
				break;
			case "quit":
				isValid = true;
				break;
			default:
				break;
			}
		}
	}
	
	public void newGame() {
//		Initialize rooms
		List<Room> newRooms = rDao.getAllRooms();
		this.rooms = new HashMap<>();
		for (Room room : newRooms) {
			this.rooms.put(room.getId(), room);
		}
		rooms.get(1).setForward(rooms.get(2));
		rooms.get(2).setBack(rooms.get(1));
		rooms.get(2).setLeft(rooms.get(3));
		rooms.get(2).setRight(rooms.get(4));
		rooms.get(3).setBack(rooms.get(2));
		rooms.get(4).setBack(rooms.get(2));
//		Create user
		System.out.println("Enter your name");
		String name = this.sc.nextLine();
		int insertId = rDao.insertUser(new User(0, name, 1));
		this.user = rDao.getUserById(insertId);
		for (int roomId : this.rooms.keySet()) {
			rDao.insertRoomInst(this.user, rooms.get(roomId));
		}
		runGame();
	}
	
	public void loadGame() {
		System.out.println("Saved games:");
		Map<Integer, User> savedUsers = rDao.getAllUsers();
		for (int userId : savedUsers.keySet()) {
			System.out.println("ID: " + savedUsers.get(userId).getId() + "   Name: " + savedUsers.get(userId).getName());
		}
		boolean isValid = false;
		int idChoice = 0;
		while (!isValid) {
			System.out.println("Enter the ID of the game you would like to load");
			idChoice = this.sc.nextInt();
			this.sc.nextLine();
			if (savedUsers.keySet().contains(idChoice)) {
				isValid = true;
			}
		}
		this.user = rDao.getUserById(idChoice);
		this.rooms = rDao.getRoomsByUser(idChoice);
		this.rooms.get(1).setForward(rooms.get(2));
		this.rooms.get(2).setBack(rooms.get(1));
		this.rooms.get(2).setLeft(rooms.get(3));
		this.rooms.get(2).setRight(rooms.get(4));
		this.rooms.get(3).setBack(rooms.get(2));
		this.rooms.get(4).setBack(rooms.get(2));
		System.out.println(this.user);
		System.out.println(this.rooms);
		runGame();
	}
	
	public void runGame() {
		while (this.gameRunning) {
			exploreCurrentRoom();
		}
		this.sc.close();
	}
	
	public void exploreCurrentRoom() {
		Room currentRoom = this.rooms.get(this.user.getCurrentRoom());
		System.out.println("Hello " + this.user.getName() + "!");
		System.out.println("You are in the " + currentRoom.getName());
		List<String> options = new ArrayList<>();
		if (currentRoom.isHasItem()) {
			System.out.println("You look around and see a " + currentRoom.getItem());
			options.add("take item");
		} else {
			System.out.println("This room used to contain a " + currentRoom.getItem());
			options.add("replace item");
		}
		if (currentRoom.getForward() != null) {
			options.add("forward");
		}
		if (currentRoom.getBack() != null) {
			options.add("back");
		}
		if (currentRoom.getLeft() != null) {
			options.add("left");
		}
		if (currentRoom.getRight() != null) {
			options.add("right");
		}
		options.add("quit");
		boolean isValid = false;
		String choice = "";
		while (!isValid) {
			System.out.println("Options:");
			for (String option : options) {
				System.out.println(option);
			}
			choice = this.sc.nextLine();
			if (options.contains(choice)) {
				isValid = true;
				switch(choice) {
				case "take item":
					currentRoom.setHasItem(false);
					rDao.updateRoom(this.user.getId(), currentRoom);
					break;
				case "replace item":
					currentRoom.setHasItem(true);
					rDao.updateRoom(this.user.getId(), currentRoom);
					break;
				case "forward":
					this.user.setCurrentRoom(currentRoom.getForward().getId());
					rDao.updateUser(this.user);
					break;
				case "back":
					this.user.setCurrentRoom(currentRoom.getBack().getId());
					rDao.updateUser(this.user);
					break;
				case "left":
					this.user.setCurrentRoom(currentRoom.getLeft().getId());
					rDao.updateUser(this.user);
					break;
				case "right":
					this.user.setCurrentRoom(currentRoom.getRight().getId());
					rDao.updateUser(this.user);
					break;
				case "quit":
					this.gameRunning = false;
					break;
				default:
					break;
				}
			}
		}
	}
}
