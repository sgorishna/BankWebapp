package com.webapp.actions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.exceptions.InvalidDataException;
import com.webapp.model.Customer;
import com.webapp.model.Role;

@WebServlet("/login.php")
public class LoginController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	private final Map<Integer, String> homePages = new HashMap<Integer, String>();

	public LoginController() {

		homePages.put(ROLE_ADMIN, "/admin/home.php");
		homePages.put(ROLE_CUSTOMER, "/customer/home.php");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Role> roles = getRoleDao().findAll();

		request.setAttribute("roles", roles);

		gotoToJSP("login.jsp", request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		Integer role = Integer.parseInt(request.getParameter("role"));
		try {

			Customer customer = getDataService().login(login, password, role);

			String homePage = homePages.get(role);

			if (homePage != null) {

				request.getSession().setAttribute(CURRENT_SESSION_ACCOUNT, customer);
				request.getSession().setAttribute("CURRENT_ROLE_ACCOUNT", role);

				redirectRequest(homePage, request, response);

			} else {
				throw new InvalidDataException("Unsupported role id " + role);
			}

		} catch (InvalidDataException e) {
			gotoToJSP("login.jsp", request, response);

		}

	}

}
