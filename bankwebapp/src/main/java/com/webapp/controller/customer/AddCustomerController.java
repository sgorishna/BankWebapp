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

		String idCustomer = request.getParameter("idCustomer");

		if (idCustomer == null || idCustomer.isEmpty()) {
			getCustomerDao().addCustomer(customer);
		}

		request.setAttribute("customers", getCustomerDao().getAllCustomers());
		gotoToJSP("customer/listCustomers.jsp", request, response);

	}

}
