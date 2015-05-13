package com.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.webapp.db.Database;
import com.webapp.model.Customer;

public class CustomerDao {

	private Connection connection;

	public CustomerDao() {
		connection = Database.getConnection();
	}

	public void addCustomer(Customer customer) {

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into customer(name,gender) values (?, ?)");

			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getGender());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Customer> getAllCustomers() {

		ArrayList<Customer> customerList = new ArrayList<Customer>();

		Statement stmt = null;
		ResultSet rs = null;

		try {
			//
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from customer order by name");
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setIdCustomer(rs.getLong("idCustomer"));
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setCreated(rs.getTimestamp("created"));
				customer.setUpdated(rs.getTimestamp("updated"));
				customerList.add(customer);
			}

		} catch (SQLException ex) {
			Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
		}

		return customerList;
	}

	public Customer getCustomerById(long IdCustomer) {
		Customer customer = new Customer();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from customer where idCustomer=?");
			preparedStatement.setLong(1, IdCustomer);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				customer.setIdCustomer(rs.getLong("idCustomer"));
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setCreated(rs.getTimestamp("created"));
				customer.setUpdated(rs.getTimestamp("updated"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customer;
	}
}
