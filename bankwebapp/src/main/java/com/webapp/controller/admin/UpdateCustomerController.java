package com.webapp.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.model.Customer;

public class UpdateCustomerController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long IdCustomer = Long.parseLong(request.getParameter("IdCustomer"));
		Customer customer = getCustomerDao().findById(IdCustomer);
		request.setAttribute("customer", customer);

		gotoToJSP("admin/updateCustomer.jsp", request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Customer customer = new Customer();
		String selectedRoles[] = request.getParameterValues("role");
		customer.setName(request.getParameter("name"));
		customer.setGender(request.getParameter("gender"));
		customer.setLogin(request.getParameter("login"));
		customer.setPassword(request.getParameter("password"));

		customer.setIdCustomer(Long.parseLong(request.getParameter("idCustomer")));
		getCustomerDao().update(customer, selectedRoles);

		redirectRequest("/admin/home.php", request, response);

	}

}
