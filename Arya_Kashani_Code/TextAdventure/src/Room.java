
public class Room {
	
	private Room left;
	private Room right;
	private Room fwd;
	private Room back;
	
	private String name;
	
	Room(String s) {
		this.name = s;
		
		this.left = null;
		this.right = null;
		this.fwd = null;
		this.back = null;
	}
	
	public void setRooms(Room l, Room r, Room f, Room b) {
		left = l;
		right = r;
		fwd = f;
		back = b;
	}
	
//	public String currentRoom() {
//		return name;
//	}
//	
	public String toString() {
		return this.name;
	}
	
//	public String getRoomName() {
//		return this.name;
//	}
	/*
	public void setLeft(Room r) {
		left = r;
	}
	public void setRight(Room r) {
		right = r;
	}
	public void setUp(Room r) {
		fwd = r;
	}
	public void setDown(Room r) {
		back = r;
	}
	*/
	public Room getLeft() {
		return left;
	}
	public Room getRight() {
		return right;
	}
	public Room getUp() {
		return fwd;
	}
	public Room getDown() {
		return back;
	}
	
}
