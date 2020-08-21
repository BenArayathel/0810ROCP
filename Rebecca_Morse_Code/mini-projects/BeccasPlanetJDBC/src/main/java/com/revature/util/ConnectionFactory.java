package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	private static final String URL = "jdbc:postgresql://localhost/postgres";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "p";

	public static Connection getConnection() {
		
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
		
	}
	
}
