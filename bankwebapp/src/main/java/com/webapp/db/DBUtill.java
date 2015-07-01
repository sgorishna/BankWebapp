package com.webapp.db;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class DBUtill {

	private DBUtill() {

	}

	private static Connection conn = null;

	public static Connection getConnection() {

		try {
			String username = "root";
			String passwd = "root";

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", username, passwd);
		} catch (Exception e) {
			Logger.getLogger(DBUtill.class.getName()).log(Level.DEBUG, null, e);
		}

		return conn;
	}

	public static void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
			Logger.getLogger(DBUtill.class.getName()).log(Level.DEBUG, null, e);
		}
	}
}
