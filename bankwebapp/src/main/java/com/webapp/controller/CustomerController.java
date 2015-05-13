package com.webapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.dao.CustomerDao;
import com.webapp.model.Customer;

public class CustomerController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static String LIST_CUSTOMER = "/pages/listCustomers.jsp";

	private static String INSERT_OR_EDIT = "/pages/customer.jsp";

	private CustomerDao dao;

	public CustomerController() {
		super();
		dao = new CustomerDao();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("listCustomers")) {
			forward = LIST_CUSTOMER;
			request.setAttribute("customers", dao.getAllCustomers());
		} else {
			forward = INSERT_OR_EDIT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Customer customer = new Customer();
		customer.setName(request.getParameter("name"));
		customer.setGender(request.getParameter("gender"));

		String idCustomer = request.getParameter("idCustomer");

		if (idCustomer == null || idCustomer.isEmpty()) {
			dao.addCustomer(customer);
		}

		RequestDispatcher view = request.getRequestDispatcher(LIST_CUSTOMER);
		request.setAttribute("customers", dao.getAllCustomers());
		view.forward(request, response);

	}
}
