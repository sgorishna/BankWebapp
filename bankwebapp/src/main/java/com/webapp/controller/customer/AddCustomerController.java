package com.webapp.controller.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.model.Customer;

public class AddCustomerController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		gotoToJSP("customer/customer.jsp", request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Customer customer = new Customer();
		customer.setName(request.getParameter("name"));
		customer.setGender(request.getParameter("gender"));
		customer.setLogin(request.getParameter("login"));
		customer.setPassword(request.getParameter("password"));

		getCustomerDao().addCustomer(customer);

		redirectRequest("/customers.php", request, response);

	}

}
