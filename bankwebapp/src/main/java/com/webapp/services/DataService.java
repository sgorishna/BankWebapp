package com.webapp.services;

import java.util.List;

import com.webapp.dao.CustomerDao;
import com.webapp.dao.RoleDao;
import com.webapp.exceptions.InvalidDataException;
import com.webapp.model.Customer;
import com.webapp.model.Role;

public class DataService {

	private CustomerDao customerDao;
	private RoleDao roleDao;

	public DataService(CustomerDao customerDao, RoleDao roleDao) {

		this.customerDao = customerDao;
		this.roleDao = roleDao;
	}

	public Customer login(String login, String password, Integer role) throws InvalidDataException {

		Customer customer = customerDao.findByLogin(login);

		if (customer == null) {
			throw new InvalidDataException("Account not found");
		} else {

			if (password.equals(customer.getPassword())) {
				List<Role> roles = roleDao.findCustomerRoles(customer);
				for (Role r : roles) {
					if (r.getIdRole().equals(role)) {
						return customer;
					}
				}

				throw new InvalidDataException("Invalid role");

			} else {

				throw new InvalidDataException("Invalid password");
			}
		}

	}
}
