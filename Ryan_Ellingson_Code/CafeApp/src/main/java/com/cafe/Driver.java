package com.cafe;

import java.util.Scanner;

public class Driver {
	public static void main (String[] args) {
		Cafe myCafe = new Cafe();
		Scanner sc = new Scanner(System.in);
		boolean finished = false;
		while (!finished) {
			boolean isValid1 = false;
			while (!isValid1) {
				System.out.println("Are you a customer or employee? Enter 'customer' or 'employee'");
				String selection = sc.nextLine();
				switch(selection) {
					case "customer":
						myCafe.takeOrder(sc);
						isValid1 = true;
						break;
					case "employee":
						System.out.println(myCafe.getOrders());
						isValid1 = true;
						break;
					default:
						break;
				}
			}
			boolean isValid2 = false;
			while (!isValid2) {
				System.out.println("Would you like to continue? Enter 'y' or 'n'");
				String choice = sc.nextLine();
				switch(choice) {
				case "y":
					isValid2 = true;
					break;
				case "n":
					finished = true;
					isValid2 = true;
					break;
				default:
					break;
				}
			}
		}
	}
}
