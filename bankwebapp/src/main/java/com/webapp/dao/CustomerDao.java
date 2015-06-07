package com.webapp.dao;

import com.webapp.model.Customer;

public interface CustomerDao extends IEntityDao<Customer> {

	Customer findByLogin(String login);

	void create(Customer customer, String[] roles);

	void update(Customer customer, String[] selectedRoles);

}
