package com.webapp.services;

import com.sun.media.sound.InvalidDataException;
import com.webapp.dao.CustomerDao;
import com.webapp.model.Customer;

public class DataService {

	private CustomerDao customerDao;

	public DataService(CustomerDao customerDao) {

		this.customerDao = customerDao;
	}

	public Customer login(String login, String password) throws InvalidDataException {

		Customer customer = customerDao.findByLogin(login);

		if (customer == null) {
			throw new InvalidDataException("Account not found");
		} else {

			if (password.equals(customer.getPassword())) {

				return customer;
			} else {
				throw new InvalidDataException("Invalid password");
			}
		}

	}

}
