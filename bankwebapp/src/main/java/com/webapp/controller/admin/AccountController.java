package com.webapp.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;

@WebServlet("/admin/listAccounts.php")
public class AccountController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("accounts", getAccountDao().getAccountByIdCustomer(Long.parseLong(request.getParameter("IdCustomer"))));

		gotoToJSP("admint/listAccounts.jsp", request, response);

	}
}
