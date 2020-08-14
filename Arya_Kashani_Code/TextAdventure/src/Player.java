
public class Player {
	
	private Room currentState;
	
	Player() {
		currentState = null;
	}
	
	Player(Room r) {
		currentState = r;
	}
	
	
	public void setCurrState(Room r) {
		currentState = r;
	}
	public Room getCurrState() {
		return currentState;
	}
	
	public void move(String input) {
		if (input.equals("L") || input.equals("l") || input.equals("Left") || input.equals("LEFT") || input.equals("left")) {
			if(currentState.getLeft() == null) {
				System.out.println("Can't go left");
			}
			else {
				Room r = currentState.getLeft();
				currentState = r;
				System.out.println("You are now in " + currentState);
			}
		}
		else if(input.equals("R") || input.equals("r")|| input.equals("Right") || input.equals("RIGHT")|| input.equals("right")) {
			if(currentState.getRight() == null) {
				System.out.println("Can't go right");
			}
			else {
				Room r = currentState.getRight();
				currentState = r;
				System.out.println("You are now in " + currentState);
			}
		}
		else if (input.equals("F") || input.equals("f") || input.equals("Forward") || input.equals("FORWARD")|| input.equals("forward")) {
			if(currentState.getUp() == null) {
				System.out.println("Can't go forward");
			}
			else {
				Room r = currentState.getUp();
				currentState = r;
				System.out.println("You are now in " + currentState);
			}
		}
		else if (input.equals("D") || input.equals("d") || input.equals("Down") || input.equals("DOWN") || input.equals("down")) {
			if(currentState.getDown() == null) {
				System.out.println("Can't go back");
			}
			else {
				Room r = currentState.getDown();
				currentState = r;
				System.out.println("You are now in " + currentState);
			}
		}
		else {
			System.out.println("Invalid input; try again.");
		}
		
	}
	
	
	
	
	
	
	
	
}
