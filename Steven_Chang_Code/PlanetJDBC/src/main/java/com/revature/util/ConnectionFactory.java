package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	/*
	 * JDBC API
	 * 	Handles database using Java, allows us to interact withh our database through
	 * 	CRUD Methods
	 */
	
	// "jdbc:postgresql://[HOST]/[DATABASE]"
	private static String url = "jdbc:postgresql://localhost/postgres";
	private static String username = "postgres";
	private static String password = "penguin";
	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
