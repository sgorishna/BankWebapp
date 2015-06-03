package com.webapp.dao;

import java.util.List;

import com.webapp.model.Customer;
import com.webapp.model.Role;

public interface RoleDao {

	List<Role> findAll();

	List<Role> findCustomerRoles(Customer c);

}
