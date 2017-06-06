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

import com.trainingcenter.projectee.utils.StringUtils;
import com.trainingcenter.projectee.beans.UserBean;
import com.trainingcenter.projectee.beans.UserInfoBean;
import com.trainingcenter.projectee.controllers.helpers.LinkKeeper;
import com.trainingcenter.projectee.dao.mysql.MySqlUserDaoImpl;
import com.trainingcenter.projectee.dao.mysql.MySqlUserInfoDaoImpl;
import com.trainingcenter.projectee.utils.HttpUtils;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String VALIDATION_ERRORS_ATTR = "validation_errors";

	private static final String USER_ROLE = "role";
	private static final String USER_ROLE_NAME = "user";

	public static final String LOGIN_EMPTY_CODE = "login.empty";
	public static final String LOGIN_EXISTS_CODE = "login.exists";
	public static final String PASSWORD_EMPTY_CODE = "password.empty";
	public static final String PASSWORD_CONFIRM_EMPTY_CODE = "password.confirm.empty";
	public static final String PASSWORDS_NOT_MATCH_CODE = "passwords.not.match";
	public static final String EMAIL_EMPTY_CODE = "email.empty";
	public static final String EMAIL_EXISTS_CODE = "email.exists";

	public static final String LOGIN_EMPTY_VALUE = "Login is empty!";
	public static final String LOGIN_EXISTS_VALUE = "This login already exists!";
	public static final String PASSWORD_EMPTY_VALUE = "Password is empty!";
	public static final String PASSWORD_CONFIRM_EMPTY_VALUE = "Confirm password is empty!";
	public static final String PASSWORDS_NOT_MATCH_VALUE = "Passwords don't match!";
	public static final String EMAIL_EMPTY_VALUE = "Email is empty!";
	public static final String EMAIL_EXISTS_VALUE = "This email already exists!";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		Boolean isBtnRegister = HttpUtils.isParameterExists(request, "btn_register");

		if (isBtnRegister) {
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			String password_confirm = request.getParameter("password_confirm");
			String email = request.getParameter("email");

			boolean isValid = validateData(request, login, password, password_confirm, email);

			if (isValid) {

				MySqlUserDaoImpl userDao = new MySqlUserDaoImpl();
				MySqlUserInfoDaoImpl userInfoDAO = new MySqlUserInfoDaoImpl();

				UserBean userBean = new UserBean();
				userBean.setLogin(login);
				userBean.setPassword(password);
				userBean.setDelStatus(false);
				userBean.setFkRole(3);

				userDao.save(userBean);

				Integer id_user = userDao.returnIdByLogin(login);

				UserInfoBean userInfoBean = new UserInfoBean();
				userInfoBean.setEmail(email);
				userInfoBean.setFkIdUser(id_user);

				HttpSession session = request.getSession();
				session.setAttribute(USER_ROLE, USER_ROLE_NAME);

				userInfoDAO.save(userInfoBean);

				response.sendRedirect(LinkKeeper.USER_PAGE);
			}

			if (!isValid) {

				HttpUtils.forwardToView(LinkKeeper.JSP_REGISTRATION, request, response);

			}

		}
		if (!isBtnRegister) {

			HttpUtils.forwardToView(LinkKeeper.JSP_REGISTRATION, request, response);

		}

	}

	private boolean validateData(HttpServletRequest request, String login, String password, String password_confirm,
			String email) {
		Map<String, String> errorMap = new HashMap<>();
		HttpSession session = request.getSession();
		MySqlUserDaoImpl userDao = new MySqlUserDaoImpl();
		MySqlUserInfoDaoImpl userInfoDao = new MySqlUserInfoDaoImpl();

		if (StringUtils.isEmpty(login)) {
			errorMap.put(LOGIN_EMPTY_CODE, LOGIN_EMPTY_VALUE);
		} else if (userDao.loginExists(login)) {
			errorMap.put(LOGIN_EXISTS_CODE, LOGIN_EXISTS_VALUE);
		}

		if (StringUtils.isEmpty(password)) {
			errorMap.put(PASSWORD_EMPTY_CODE, PASSWORD_EMPTY_VALUE);
		}

		if (StringUtils.isEmpty(password_confirm)) {
			errorMap.put(PASSWORD_CONFIRM_EMPTY_CODE, PASSWORD_CONFIRM_EMPTY_VALUE);
		}

		if (!StringUtils.isEmpty(password) && !StringUtils.isEmpty(password_confirm)) {
			if (!password.contains(password_confirm)) {
				errorMap.put(PASSWORDS_NOT_MATCH_CODE, PASSWORDS_NOT_MATCH_VALUE);
			}
		}

		if (StringUtils.isEmpty(email)) {
			errorMap.put(EMAIL_EMPTY_CODE, EMAIL_EMPTY_VALUE);
		} else if (userInfoDao.emailExists(email)) {
			errorMap.put(EMAIL_EXISTS_CODE, EMAIL_EXISTS_VALUE);
		}

		if (!errorMap.isEmpty()) {
			session.setAttribute(VALIDATION_ERRORS_ATTR, errorMap);
			return false;
		}
		session.removeAttribute(VALIDATION_ERRORS_ATTR);
		return true;

	}
}
