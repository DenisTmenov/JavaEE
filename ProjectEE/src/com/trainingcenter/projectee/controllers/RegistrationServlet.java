package com.trainingcenter.projectee.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trainingcenter.projectee.utils.StringUtils;
import com.trainingcenter.projectee.beans.UserBean;
import com.trainingcenter.projectee.beans.UserInfoBean;
import com.trainingcenter.projectee.dao.MySqlUserDAO;
import com.trainingcenter.projectee.dao.MySqlUserInfoDAO;
import com.trainingcenter.projectee.utils.HttpUtils;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VIEW_NAME = "/WEB-INF/pages/registration.jsp";

	public static final String VALIDATION_ERRORS_ATTR = "validation_errors";

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
		Map<String, String> paramsRequest = createMapParameters(request);
		printMapToScrean(paramsRequest, response);
		Boolean isBtnRegister = HttpUtils.isParameterExists(request, "btn_register");

		if (isBtnRegister) {
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			String password_confirm = request.getParameter("password_confirm");
			String email = request.getParameter("email");

			boolean isValid = validateData(request, login, password, password_confirm, email);
			
			if (isValid) {
				MySqlUserDAO userDao = new MySqlUserDAO();
				MySqlUserInfoDAO userInfoDAO = new MySqlUserInfoDAO();
				
				UserBean userBean = new UserBean();
				userBean.setLogin(login);
				userBean.setPassword(password);
				userBean.setDelStatus(true);
				userBean.setFkRole(3);
				
				userDao.storeUser(userBean);
				
				Integer id_user = userDao.returnIdByLogin(login);
				
				UserInfoBean userInfoBean = new UserInfoBean();
				userInfoBean.setEmail(email);
				userInfoBean.setFkIdUser(id_user);
				
				userInfoDAO.storeUserInfo(userInfoBean);
				
			}
			
		}

	}

	public void printMapToScrean(Map<String, String> map, HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");

		for (String name : map.keySet()) {

			String key = name.toString();
			String value = map.get(name).toString();
			StringBuffer sb = new StringBuffer();
			sb.append(key).append("\t").append(value).append("\n");
			out.write(sb.toString());
		}

		out.close();

	}

	public Map<String, String> createMapParameters(HttpServletRequest request) throws IOException {

		Enumeration<String> parameterNames = request.getParameterNames();
		Map<String, String> parametersRequest = new HashMap<String, String>();
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			String paramValue = request.getParameter(paramName);
			parametersRequest.put(paramName, paramValue);
		}
		return parametersRequest;
	}

	private boolean validateData(
			HttpServletRequest request, String login, String password, String password_confirm,	String email) {
		Map<String, String> errorMap = new HashMap<>();

		if (StringUtils.isBlank(login)) {
			errorMap.put(LOGIN_EMPTY_CODE, LOGIN_EMPTY_VALUE);
		}
		
		/*if (StringUtils.isBlank(login)) {
			errorMap.put(LOGIN_EXISTS_CODE, LOGIN_EXISTS_VALUE);
		}*/

		if (StringUtils.isBlank(password)) {
			errorMap.put(PASSWORD_EMPTY_CODE, PASSWORD_EMPTY_VALUE);
		}
		
		if (StringUtils.isBlank(password)) {
			errorMap.put(PASSWORD_CONFIRM_EMPTY_CODE, PASSWORD_CONFIRM_EMPTY_VALUE);
		}
		
		/*if (StringUtils.isBlank(password, password_confirm)) {
			errorMap.put(PASSWORDS_NOT_MATCH_CODE, PASSWORDS_NOT_MATCH_VALUE);
		}*/

		if (StringUtils.isBlank(email)) {
			errorMap.put(EMAIL_EMPTY_CODE, EMAIL_EMPTY_VALUE);
		}
		
		/*if (StringUtils.isBlank(email)) {
			errorMap.put(EMAIL_EXISTS_CODE, EMAIL_EXISTS_VALUE);
		}*/
		
		if (!errorMap.isEmpty()) {
			request.setAttribute(VALIDATION_ERRORS_ATTR, errorMap);
			return false;
		}

		return true;
	}

}
