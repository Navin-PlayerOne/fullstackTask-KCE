package com.kce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static Connection connection;
	public static Connection createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			connection=null;
		}
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","okokokok");
			
		} catch (SQLException e) {
			e.printStackTrace();
			connection=null;
		}
		return connection;
	}
}