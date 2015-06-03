package com.webapp.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.dao.AccountDao;
import com.webapp.dao.CustomerDao;
import com.webapp.dao.RoleDao;
import com.webapp.dao.TransactionDao;
import com.webapp.dao.impl.AccountDaoImpl;
import com.webapp.dao.impl.CustomerDaoImpl;
import com.webapp.dao.impl.RoleDaoImpl;
import com.webapp.dao.impl.TransactionDaoImpl;
import com.webapp.services.DataService;
import com.webapp.utils.WebappConstants;

public abstract class AbstractServletHandler extends HttpServlet implements WebappConstants {

	private static final long serialVersionUID = 1L;
	private CustomerDao customerDao;
	private AccountDao accountDao;
	private TransactionDao transactionDao;
	private RoleDao roleDao;

	private DataService dataService;

	public AbstractServletHandler() {

		this.customerDao = new CustomerDaoImpl();
		this.accountDao = new AccountDaoImpl();
		this.transactionDao = new TransactionDaoImpl();
		this.roleDao = new RoleDaoImpl();
		this.dataService = new DataService(getCustomerDao(), getRoleDao());

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

	public RoleDao getRoleDao() {
		return roleDao;
	}

}
