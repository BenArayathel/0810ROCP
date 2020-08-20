package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	/*
	 * Java DataBase Connection
	 * 
	 * JDBC API handles database using Java, allows us to interact with 
	 * our database through CRUD Methods
	 * 
	 * Core interfaces:
	 * 		DriverManager
	 * 		Connection 
	 * 		Statement
	 * 		PreparedStatement
	 * 		CallableStatement
	 * 		ResultSet
	 * 
	 */
	
	/*
	 * Let's connect to our database: 
	 * 1) URL endpoint
	 * 2) username
	 * 3) password
	 * 4) driver (jar that implemets JDBC)
	 * 
	 */
	
	// "jdbc:postgresql://[HOST]/[DATABASE]
	private static String url = "jdbc:postgresql://localhost/postgres";
	private static String username = "postgres";
	private static String password = "$Patches1";
	
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url,username,password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	//BEST PRACTICE CODE
	public String random() {
		int a = 1;
		
		String fruit;
		
//		if(a > 1) {
//			return "Apples";
//		} else {
//			return "Kiwi";
//		}
		if(a > 1) {
			fruit = "Apple";
		} else {
			fruit = "Kiwi";
		}
		
		
		return fruit;
	}

}
