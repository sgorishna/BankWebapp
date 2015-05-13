package com.webapp.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class Database {

	private static MysqlDataSource ds;

	private static Connection connect;

	public static Connection getConnection() {

		try {

			ds = new MysqlDataSource();
			ds.setUrl("jdbc:mysql://localhost:3306/bank");
			ds.setUser("root");
			ds.setPassword("root");

			connect = ds.getConnection();

		} catch (SQLException e) {
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
		}

		return connect;

	}

}
