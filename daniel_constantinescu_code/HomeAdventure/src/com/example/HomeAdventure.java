package com.example;


import java.util.Scanner;

public class HomeAdventure {

	public static void displayMessage(String greeting) {
	System.out.println(greeting);
}
	
	public static void main(String[] args) {
		
		String[] itemsKitchen= {"Cabinets","Table","Chairs","Appliances"};
		String[] itemsHallway= {"Closet"};
		String[] itemsLiving= {"Cauch","TV stand","TV set","armchair"};
		String[] itemsBedroom= {"Bed","Nightstand","Desk"};
		String userResponse="";
		
		room k=new room("Kitchen","Welcome to Kitchen area", itemsKitchen);
		room h=new room("Hallway","You are now in Hallway area",itemsHallway);
		room b = new room("Bedrom","You are in the bedroom area",itemsBedroom);
		room l= new room("Living","You are now in the bedroom area",itemsLiving);
					
		
		displayMessage("Welcome to Real Estate One. This is first property for sale located on 11051 dill dr. Price 200K  ");
		
		while (userResponse.equals("E")==false) {
			
			displayMessage("What room would you like to see next? Kitchen(K), Living[L], Bedroom[B], Hallway[H], Exit[E] ?");
			
			Scanner sc = new Scanner(System.in);		
 		    userResponse = sc.nextLine();
		
 		    switch (userResponse){
 		    case "K":
 		    	displayMessage("Inside this room we have "+ k.getItems());
 		    	break;
 		    case "E":
 		    	break;
 		    case "H":
 		    	displayMessage("Inside this room we have "+ h.getItems());
 		    case "B":
		    	displayMessage("Inside this room we have "+ b.getItems());	
		    	break;
 		    case "L":
		    	displayMessage("Inside this room we have "+ l.getItems());	
		    	break;
 		    default:
 		    	displayMessage("Invalid entry");
 		    }
		}
		
		
		displayMessage("Now let's go to next property");
 		    
 		    	
 		
			
		}
		
		
			
		}

