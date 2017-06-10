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

import com.trainingcenter.projectee.beans.UserBean;
import com.trainingcenter.projectee.beans.UserRoleBean;
import com.trainingcenter.projectee.controllers.helpers.LinkKeeper;
import com.trainingcenter.projectee.dao.mysql.MySqlUserDaoImpl;
import com.trainingcenter.projectee.dao.mysql.MySqlUserRoleDaoImpl;
import com.trainingcenter.projectee.utils.HttpUtils;
import com.trainingcenter.projectee.utils.StringUtils;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String VALIDATION_ERRORS_ATTR_LOGIN_PAGE = "validation_errors";

	public static final String LOGIN_EMPTY_CODE = "login.empty";
	public static final String LOGIN_NOT_EXISTS_CODE = "login.not.exists";
	public static final String LOGIN_IS_BLOCKED_CODE = "login.is.bloked";
	public static final String PASSWORD_EMPTY_CODE = "password.empty";
	public static final String PASSWORD_BED_CODE = "password.is.wrong";

	public static final String LOGIN_EMPTY_VALUE = "Login is empty!";
	public static final String LOGIN_NOT_EXISTS_VALUE = "This login is not registered!";
	public static final String LOGIN_IS_BLOCKED_VALUE = "You are bloked!";
	public static final String PASSWORD_EMPTY_VALUE = "Password is empty!";
	public static final String PASSWORD_BED_VALUE = "Password is wrong!";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.sendRedirect(LinkKeeper.PAGE_WELCOME);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		Boolean buttonIsClick = HttpUtils.isParameterExists(request, "BtnLogIn");

		if (buttonIsClick) {
			
			String username = request.getParameter("userName");
			String password = request.getParameter("password");
			boolean isValid = validateData(request, username, password);

			if (isValid) {
				sendRoleAndNameInSession(username, request);
				
				response.sendRedirect(LinkKeeper.PAGE_MAIN);
			} else {
				HttpUtils.forwardToView(LinkKeeper.JSP_WELCOME_LOGIN, request, response);
			}
		}

		if (!buttonIsClick) {
			response.sendRedirect(LinkKeeper.PAGE_WELCOME);
		}

	}
	
	private void sendRoleAndNameInSession(String userName, HttpServletRequest request){
		MySqlUserDaoImpl userDao = new MySqlUserDaoImpl();
		Integer idUser = userDao.returnIdByLogin(userName);
		UserBean userBean = userDao.loadUserByIdUser(idUser);
		Integer fkRole = userBean.getFkRole();

		MySqlUserRoleDaoImpl userRoleDao = new MySqlUserRoleDaoImpl();
		UserRoleBean userRoleBean = userRoleDao.loadUserRoleByIdRole(fkRole);
		String userRoleName = userRoleBean.getNameRole();

		HttpSession session = request.getSession();
		session.setAttribute(LinkKeeper.SESSION_USER_BEAN_ROLE, userRoleName);
		session.setAttribute(LinkKeeper.SESSION_USER_BEAN_LOGIN, userName);
	}

	private boolean validateData(HttpServletRequest request, String userName, String password) {
		Map<String, String> errorMap = new HashMap<>();

		if (StringUtils.isEmpty(userName)) {
			errorMap.put(LOGIN_EMPTY_CODE, LOGIN_EMPTY_VALUE);
		}
		if (StringUtils.isEmpty(password)) {
			errorMap.put(PASSWORD_EMPTY_CODE, PASSWORD_EMPTY_VALUE);
		}

		if (!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(password)) {
			MySqlUserDaoImpl userDao = new MySqlUserDaoImpl();

			if (userDao.loginExists(userName)) {
				if (!userDao.passwordEquals(userName, password)) {
					errorMap.put(PASSWORD_BED_CODE, PASSWORD_BED_VALUE);
				}
				if(userDao.returnDelStatusByLogin(userName)){
					errorMap.put(LOGIN_IS_BLOCKED_CODE, LOGIN_IS_BLOCKED_VALUE);
				}
				
			} else {
				errorMap.put(LOGIN_NOT_EXISTS_CODE, LOGIN_NOT_EXISTS_VALUE);
			}
		}

		if (!errorMap.isEmpty()) {
			request.setAttribute(VALIDATION_ERRORS_ATTR_LOGIN_PAGE, errorMap);
			return false;
		}
		return true;
	}

}
