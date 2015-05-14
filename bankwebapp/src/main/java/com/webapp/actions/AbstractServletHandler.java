package com.webapp.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.dao.CustomerDao;

public abstract class AbstractServletHandler extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CustomerDao customerВao;

	public AbstractServletHandler() {

		this.customerВao = new CustomerDao();

	}

	protected final void gotoToJSP(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/JSP/" + page).forward(request, response);
	}

	public CustomerDao getCustomerDao() {
		return customerВao;
	}

}
