package com.example;

class Animal {
	  public void animalSound() {
	    System.out.println("The animal makes a sound");
	  }
	  public void fly()
			  {
	}
}

	class Pig extends Animal {
		
		  public void animalSound() { System.out.println("The pig says: wee wee"); }
		 
	    public void walk() {
	  }
	}
	
	class Dog extends Animal {
	  public void animalSound() {
	    System.out.println("The dog says: bow wow");
	  }
	    public void stay() {
	  
	}
	}

	public class MyMainClass{
		public static void main(String[] args) {
			
			Animal p=new Pig();
			
		}
	}

	


	