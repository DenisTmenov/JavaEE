package com.trainingcenter.projectee.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trainingcenter.projectee.dao.MySqlUserDAO;
import com.trainingcenter.projectee.utils.HttpUtils;
import com.trainingcenter.projectee.utils.StringUtils;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VIEW_OK_NAME = "/WEB-INF/pages/xxxx.jsp";
	private static final String VIEW_BED_NAME = "/WEB-INF/pages/welcomelogin.jsp";

	public static final String VALIDATION_ERRORS_ATTR_LOGIN_PAGE = "validation_errors";

	public static final String LOGIN_EMPTY_CODE = "login.empty";
	public static final String LOGIN_NOT_EXISTS_CODE = "login.not.exists";
	public static final String PASSWORD_EMPTY_CODE = "password.empty";
	public static final String PASSWORD_BED_CODE = "password.is.wrong";

	public static final String LOGIN_EMPTY_VALUE = "Login is empty!";
	public static final String LOGIN_NOT_EXISTS_VALUE = "This login is not registered!";
	public static final String PASSWORD_EMPTY_VALUE = "Password is empty!";
	public static final String PASSWORD_BED_VALUE = "Password is wrong!";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Boolean isBtnLogIn = HttpUtils.isParameterExists(request, "BtnLogIn");

		if (isBtnLogIn) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			boolean isValid = validateData(request, username, password);

			if (isValid) {
				HttpUtils.forwardToView(VIEW_OK_NAME, request, response);
			} else {
				HttpUtils.forwardToView(VIEW_BED_NAME, request, response);
			}
		}
	}

	private boolean validateData(HttpServletRequest request, String username, String password) {
		Map<String, String> errorMap = new HashMap<>();
		HttpSession session = request.getSession();

		if (StringUtils.isEmpty(username)) {
			errorMap.put(LOGIN_EMPTY_CODE, LOGIN_EMPTY_VALUE);
		}
		if (StringUtils.isEmpty(password)) {
			errorMap.put(PASSWORD_EMPTY_CODE, PASSWORD_EMPTY_VALUE);
		}

		if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {
			MySqlUserDAO userDao = new MySqlUserDAO();

			if (userDao.loginExists(username)) {
				if (!userDao.passwordEquals(username, password)) {
					errorMap.put(PASSWORD_BED_CODE, PASSWORD_BED_VALUE);
				}
			} else {
				errorMap.put(LOGIN_NOT_EXISTS_CODE, LOGIN_NOT_EXISTS_VALUE);
			}
		}

		if (!errorMap.isEmpty()) {
			session.setAttribute(VALIDATION_ERRORS_ATTR_LOGIN_PAGE, errorMap);
			return false;
		}
		session.removeAttribute(VALIDATION_ERRORS_ATTR_LOGIN_PAGE);
		return true;
	}

}
