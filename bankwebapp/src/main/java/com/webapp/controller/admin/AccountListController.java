package com.webapp.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;

@WebServlet("/admin/accountList.php")
public class AccountListController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("IdCustomer") != null) {
			long IdCustomer = Long.parseLong(request.getParameter("IdCustomer"));
			request.setAttribute("accounts", getAccountDao().getAccountByIdCustomer(IdCustomer));
			gotoToJSP("admin/accountListByIdCustomer.jsp", request, response);
		} else {
			request.setAttribute("accounts", getAccountDao().findAll());
			gotoToJSP("admin/accountList.jsp", request, response);
		}

	}

}
