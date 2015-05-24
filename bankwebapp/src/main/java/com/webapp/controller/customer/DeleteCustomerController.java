package com.webapp.controller.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;

public class DeleteCustomerController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		getCustomerDao().deleteCustomer(Long.parseLong(request.getParameter("IdCustomer")));

		// request.setAttribute("customers",
		// getCustomerDao().getAllCustomers());

		// gotoToJSP("customer/listCustomers.jsp", request, response);

		redirectRequest("/customers.php", request, response);
	}

}
