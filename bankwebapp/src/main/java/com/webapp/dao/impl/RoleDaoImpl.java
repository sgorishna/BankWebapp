package com.webapp.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.webapp.dao.RoleDao;
import com.webapp.db.DBUtill;
import com.webapp.model.Customer;
import com.webapp.model.Role;

public class RoleDaoImpl implements RoleDao {

	private static final long serialVersionUID = 1L;

	public List<Role> findAll() {
		Connection connection = null;

		ArrayList<Role> roleList = new ArrayList<Role>();

		Statement stmt = null;
		ResultSet rs = null;

		try {

			connection = DBUtill.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from role");
			while (rs.next()) {
				Role role = new Role();
				role.setIdRole(rs.getInt("idRole"));
				role.setRole(rs.getString("role"));

				roleList.add(role);
			}

		} catch (SQLException ex) {
			Logger.getLogger(RoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBUtill.closeConnection(connection);
		}

		return roleList;

	}

	public List<Role> findCustomerRoles(Customer c) {
		Connection connection = null;

		List<Role> roleList = new ArrayList<Role>();

		Statement stmt = null;
		ResultSet rs = null;

		try {

			connection = DBUtill.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT r.idRole, r.role FROM role r join customer_role cr on r.idRole = cr.idRole where cr.idCustomer=" + c.getIdCustomer());
			while (rs.next()) {
				Role role = new Role();
				role.setIdRole(rs.getInt("idRole"));
				role.setRole(rs.getString("role"));

				roleList.add(role);
			}

		} catch (SQLException ex) {
			Logger.getLogger(RoleDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBUtill.closeConnection(connection);
		}

		return roleList;
	}

}
