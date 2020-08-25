package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static String url = "jdbc:postgresql://localhost/postgres?currentSchema=room_game";
	private static String username = "postgres";
	private static String password = "postgres";
	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
