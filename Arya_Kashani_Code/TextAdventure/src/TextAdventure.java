import java.util.Scanner;

public class TextAdventure {
	
	/*
	Room curr;
	Room left;
	Room right;
	Room up;
	Room down;
	
	public TextAdventure(Room start) {
		curr = start;
		left = null;
		right = null;
		up = null;
		down = null;
	}
	public TextAdventure(Room start, Room l, Room r, Room u, Room d) {
		curr = start;
		left = l;
		right = r;
		up = u;
		down = d;
	}
	*/
	
	public static void main(String[] args) {
		Room one = new Room("Living Room");
		Room two = new Room ("Kitchen");
		Room three = new Room("Garage");
		Room four = new Room("Garden");
		Room five = new Room("Play Room");
		Room six = new Room("Master Bedroom");
		Room seven = new Room("Office");
		Room eight = new Room("Guest Room");
		
		one.setRooms(four, two, three, five);
		two.setRooms(one, seven, eight, six);
		three.setRooms(null, eight, null, one);
		four.setRooms(null, one, null, null);
		five.setRooms(null, six, one, null);
		six.setRooms(five, null, two, null);
		seven.setRooms(two, null, null, null);
		eight.setRooms(three, null, null, two);
		
		Scanner s = new Scanner(System.in);
		Player p = new Player(one);
		System.out.println("Hello, Welcome to Arya's Text Adventure!");
		System.out.println("You are in " + one);
		System.out.println("Move options are: Left, Right, Forward, Down, Exit");
		while (true) {
			System.out.print("Please enter a command: ");
			String str = s.nextLine();
			//System.out.println(str);
			if(str.equals("exit") || str.equals("Exit")|| str.equals("EXIT")) {
				break;
			}
			p.move(str);
		}
		System.out.println("You exited the house from the " + p.getCurrState());
		s.close();
	}
	
	
	
}
