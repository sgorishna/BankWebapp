package com.webapp.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtill {

	private static Connection conn = null;

	public static Connection getConnection() {

		try {
			String username = "root";
			String passwd = "root";

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", username, passwd);
		} catch (Exception e) {
			e.getMessage();
		}

		return conn;
	}

	public static void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
