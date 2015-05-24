package com.webapp.controller.transaction;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.model.Account;

@WebServlet("/transaction.php")
public class TransactionController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		gotoToJSP("transaction/transaction.jsp", request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long senderAccountNumber = Long.parseLong(request.getParameter("senderAccountNumber"));
		long receiverAccountNumber = Long.parseLong(request.getParameter("receiverAccountNumber"));
		BigDecimal amount = new BigDecimal(request.getParameter("amount"));

		getTransactionDao().doTransaction(senderAccountNumber, receiverAccountNumber, amount);

		Account account = getAccountDao().getAccountByAccountNumber(senderAccountNumber);

		redirectRequest("/listAccounts.php?IdCustomer=" + account.getIdCustomer(), request, response);
	}
}
