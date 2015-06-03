package com.webapp.controller.customer;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.model.Account;
import com.webapp.model.Transaction;

@WebServlet("/customer/transferFunds.php")
public class TransferFundsController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		gotoToJSP("customer/transferFunds.jsp", request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Transaction transaction = new Transaction();
		long senderAccountNumber = Long.parseLong(request.getParameter("senderAccountNumber"));
		long receiverAccountNumber = Long.parseLong(request.getParameter("receiverAccountNumber"));

		BigDecimal amount = new BigDecimal(request.getParameter("amount"));

		Account sender = getAccountDao().getAccountByAccountNumber(senderAccountNumber);
		Account receiver = getAccountDao().getAccountByAccountNumber(receiverAccountNumber);

		transaction.setIdAccountSender(sender.getIdAccount());
		transaction.setIdAccountReceiver(receiver.getIdAccount());
		transaction.setComments(request.getParameter("comments"));
		transaction.setSenderAccountNumber(senderAccountNumber);
		transaction.setReceiverAccountNumber(receiverAccountNumber);
		transaction.setAmount(amount);

		getTransactionDao().create(transaction);

		redirectRequest("/customer/myAccounts.php", request, response);
	}
}
