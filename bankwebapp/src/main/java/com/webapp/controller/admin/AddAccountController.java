package com.webapp.controller.admin;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.model.Account;
import com.webapp.model.Customer;

@WebServlet("/admin/addAccount.php")
public class AddAccountController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long IdCustomer = Long.parseLong(request.getParameter("IdCustomer"));
		Customer customer = getCustomerDao().findById(IdCustomer);
		request.setAttribute("customer", customer);

		gotoToJSP("admin/addAccount.jsp", request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Account account = new Account();
		account.setIdCustomer(Long.parseLong(request.getParameter("idCustomer")));
		account.setIdAccountType(Long.parseLong(request.getParameter("accountType")));
		account.setIdCurrency(Long.parseLong(request.getParameter("currency")));
		account.setAccountNumber(Long.parseLong(request.getParameter("accountNumber")));
		account.setBalance(new BigDecimal(request.getParameter("balance")));

		getAccountDao().create(account);
		request.setAttribute("accounts", getAccountDao().getAccountByIdCustomer(account.getIdCustomer()));
		redirectRequest("/admin/accountList.php?IdCustomer=" + account.getIdCustomer(), request, response);

	}

}
