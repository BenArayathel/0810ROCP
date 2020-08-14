package com.example.controlflow;

public class WhileLoop {
	
	//A while loop will keep looping, as long as the condition has been met
	
	public static void main(String[] args) {
		
		int firstVariable = 0;
		
		
		while(firstVariable < 1000) {//loop will stop when firstvariable is no longer less than 1000
			
			System.out.println("inside while");
			System.out.println(firstVariable);
			firstVariable++; //firstVariable = firstVariable + 1;
//			firstVariable--; //firstVariable = firstVariable - 1;
			System.out.println(firstVariable);
			
			
		}
		
		while(firstVariable < 1000) {//loop will stop when firstvariable is no longer less than 1000
			
			
			if(firstVariable < 6) { //you can have nested loops inside other loops as well as if and switch cases
				firstVariable++;
				System.out.println("The number is less than 6, execute special code ");
				
//				break and continue need to be nested inside a for, while loop or a switch case statement.
				
//				continue; //will cause the rest of the loop to be skipped, but the rest of the loops will still try to execute
			    break; //will cause the rest of the loop to be skipped, and none of the other loops will execute
			}
			
			System.out.println("inside while");
			System.out.println(firstVariable);
			firstVariable++; //firstVariable = firstVariable + 1;
//			firstVariable--; //firstVariable = firstVariable - 1;
			System.out.println(firstVariable);
			
			
		}
		
		
		
		do { // A do while will execute once, even if the condition has not been met
			
			System.out.println("Inside do while ");
			System.out.println(firstVariable);
			firstVariable++;
			
		}while(firstVariable < 8);
		
		
	}

}
