package com.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.webapp.db.DBUtill;
import com.webapp.model.Customer;

public class CustomerDao {

	public void addCustomer(Customer customer) {

		Connection connection = null;

		try {
			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("insert into customer(name,gender,login,password) values (?, ?, ?, ?)");

			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getGender());
			preparedStatement.setString(3, customer.getLogin());
			preparedStatement.setString(4, customer.getPassword());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtill.closeConnection(connection);
		}

	}

	public List<Customer> getAllCustomers() {
		Connection connection = null;

		ArrayList<Customer> customerList = new ArrayList<Customer>();

		Statement stmt = null;
		ResultSet rs = null;

		try {

			connection = DBUtill.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from customer order by name");
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setIdCustomer(rs.getLong("idCustomer"));
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setCreated(rs.getTimestamp("created"));
				customer.setUpdated(rs.getTimestamp("updated"));
				customer.setLogin(rs.getString("login"));
				customer.setPassword(rs.getString("password"));
				customerList.add(customer);
			}

		} catch (SQLException ex) {
			Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBUtill.closeConnection(connection);
		}

		return customerList;
	}

	public Customer getCustomerById(long IdCustomer) {

		Connection connection = null;
		Customer customer = new Customer();
		try {
			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from customer where idCustomer=?");
			preparedStatement.setLong(1, IdCustomer);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				customer.setIdCustomer(rs.getLong("idCustomer"));
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setCreated(rs.getTimestamp("created"));
				customer.setUpdated(rs.getTimestamp("updated"));
				customer.setLogin(rs.getString("login"));
				customer.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtill.closeConnection(connection);
		}

		return customer;
	}

	public void deleteCustomer(long IdCustomer) {
		Connection conn = null;
		try {
			conn = DBUtill.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("delete from customer where idCustomer=?");

			preparedStatement.setLong(1, IdCustomer);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtill.closeConnection(conn);
		}
	}

	public void updateCustomer(Customer customer) {
		Connection conn = null;
		try {
			conn = DBUtill.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("update customer set name=?, gender=?, updated=?, login=?, password=?" + " where idCustomer=?");

			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getGender());
			preparedStatement.setTimestamp(3, new Timestamp(new java.util.Date().getTime()));

			preparedStatement.setString(4, customer.getLogin());
			preparedStatement.setString(5, customer.getPassword());

			preparedStatement.setLong(6, customer.getIdCustomer());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtill.closeConnection(conn);
		}
	}

	public Customer findByLogin(String login) {

		Connection connection = null;
		Customer customer = new Customer();
		try {
			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from customer where login=?");
			preparedStatement.setString(1, login);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				customer.setIdCustomer(rs.getLong("idCustomer"));
				customer.setLogin(rs.getString("login"));
				customer.setPassword(rs.getString("password"));
				customer.setName(rs.getString("name"));
				customer.setGender(rs.getString("gender"));
				customer.setCreated(rs.getTimestamp("created"));
				customer.setUpdated(rs.getTimestamp("updated"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtill.closeConnection(connection);
		}

		return customer;

	}

}
