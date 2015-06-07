package com.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.webapp.dao.CustomerDao;
import com.webapp.db.DBUtill;
import com.webapp.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	public void create(Customer customer, String[] roles) {

		Connection connection = null;

		try {
			connection = DBUtill.getConnection();
			connection.setAutoCommit(false);

			PreparedStatement preparedStatement = connection.prepareStatement("insert into customer(name,gender,login,password) values (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			PreparedStatement preparedStatement2 = connection.prepareStatement("insert into customer_role(idCustomer,idRole) values (?, ?)");

			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getGender());
			preparedStatement.setString(3, customer.getLogin());
			preparedStatement.setString(4, customer.getPassword());
			preparedStatement.executeUpdate();

			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			generatedKeys.next();

			for (int i = 0; i < roles.length; i++) {

				preparedStatement2.setLong(1, generatedKeys.getLong(1));
				preparedStatement2.setLong(2, Long.parseLong(roles[i]));
				preparedStatement2.executeUpdate();
			}

			connection.commit();

		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtill.closeConnection(connection);
		}

	}

	public List<Customer> findAll() {
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
			Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBUtill.closeConnection(connection);
		}

		return customerList;
	}

	public Customer findById(long IdCustomer) {

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

	public void delete(Customer customer) {
		Connection conn = null;
		try {
			conn = DBUtill.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("delete from customer where idCustomer=" + customer.getIdCustomer());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtill.closeConnection(conn);
		}
	}

	public void update(Customer customer) {
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

	public void create(Customer object) throws UnsupportedOperationException {

		try {
			throw new UnsupportedOperationException("Not implemented yet");
		} catch (java.lang.UnsupportedOperationException e) {

		}

	}

	public void update(Customer customer, String[] selectedRoles) {

		Connection connection = null;
		ResultSet rs = null;
		ArrayList<String> roles = new ArrayList<String>();

		try {
			connection = DBUtill.getConnection();
			connection.setAutoCommit(false);

			PreparedStatement preparedStatement = connection.prepareStatement("update customer set name=?, gender=?, updated=?, login=?, password=?" + " where idCustomer=?");

			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getGender());
			preparedStatement.setTimestamp(3, new Timestamp(new java.util.Date().getTime()));

			preparedStatement.setString(4, customer.getLogin());
			preparedStatement.setString(5, customer.getPassword());

			preparedStatement.setLong(6, customer.getIdCustomer());

			PreparedStatement preparedStatement0 = connection.prepareStatement("select idRole from customer_role where idCustomer=" + customer.getIdCustomer());
			rs = preparedStatement0.executeQuery();

			ResultSetMetaData metaData = rs.getMetaData();
			int columns = metaData.getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= columns; i++) {
					String value = rs.getString(i);
					roles.add(value);
				}
			}

			String[] customerRoles = roles.toArray(new String[roles.size()]);

			for (int i = 0; i < customerRoles.length; i++) {
				PreparedStatement ps = connection.prepareStatement("delete from customer_role where idCustomer=" + customer.getIdCustomer() + " and idRole=" + customerRoles[i]);
				ps.executeUpdate();

			}

			PreparedStatement ps = connection.prepareStatement("insert into customer_role(idCustomer,idRole) values (?, ?)");

			for (int i = 0; i < selectedRoles.length; i++) {

				ps.setLong(1, customer.getIdCustomer());
				ps.setLong(2, Long.parseLong(selectedRoles[i]));

				ps.executeUpdate();
			}

			connection.commit();

		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtill.closeConnection(connection);
		}

	}

}
