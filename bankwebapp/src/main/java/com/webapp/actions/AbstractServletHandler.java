package com.webapp.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.dao.AccountDao;
import com.webapp.dao.CustomerDao;
import com.webapp.dao.TransactionDao;
import com.webapp.services.DataService;

public abstract class AbstractServletHandler extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CustomerDao customerDao;
	private AccountDao accountDao;
	private TransactionDao transactionDao;

	private DataService dataService;

	public AbstractServletHandler() {

		this.customerDao = new CustomerDao();
		this.accountDao = new AccountDao();
		this.transactionDao = new TransactionDao();
		this.dataService = new DataService(getCustomerDao());

	}

	protected final void gotoToJSP(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/recources/JSP/" + page).forward(request, response);
	}

	protected final void redirectRequest(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + path);
	}

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public TransactionDao getTransactionDao() {
		return transactionDao;
	}

	public DataService getDataService() {
		return dataService;
	}

	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}

}
