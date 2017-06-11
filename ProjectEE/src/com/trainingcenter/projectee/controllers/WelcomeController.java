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

import com.trainingcenter.projectee.controllers.helpers.LinkKeeper;
import com.trainingcenter.projectee.dao.mysql.MySqlUserDaoImpl;
import com.trainingcenter.projectee.domain.WelcomeDto;
import com.trainingcenter.projectee.utils.HttpUtils;
import com.trainingcenter.projectee.utils.StringUtils;

@WebServlet("/welcome.html")
public class WelcomeController extends HttpServlet {
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
	
	public static final String SESSION_USER_BEAN_LOGIN = "userLogin";
	public static final String SESSION_USER_BEAN_ROLE = "userRole";
	
	private final String BTN_LOG_IN = "BtnLogIn";
	
	private final String PARAMETER_USERNAME = "username";
	private final String PARAMETER_PASSWORD = "password";
	
	private final String ATTRIBUTE_WELCOMEDTO = "welcomeDto";
	
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpUtils.forwardToView(LinkKeeper.JSP_WELCOME, request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		Boolean buttonIsClick = HttpUtils.isParameterExists(request, BTN_LOG_IN);

		if (buttonIsClick) {
			WelcomeDto welcomeDto = fillWelcomeDto(request);
			request.setAttribute(ATTRIBUTE_WELCOMEDTO, welcomeDto);
			boolean isValid = validateData(request, welcomeDto);

			if (isValid) {
				sendRoleAndNameInSession(welcomeDto, request);
				
				response.sendRedirect(LinkKeeper.PAGE_MAIN);
			} else {
				HttpUtils.forwardToView(LinkKeeper.JSP_WELCOME, request, response);
			}
		}

	}
	
	private void sendRoleAndNameInSession(WelcomeDto welcomeDto, HttpServletRequest request){
		String login = welcomeDto.getUsername();
		MySqlUserDaoImpl userDao = new MySqlUserDaoImpl();
		
		String userRoleName = userDao.returnRoleByLogin(login);

		HttpSession session = request.getSession();
		session.setAttribute(SESSION_USER_BEAN_ROLE, userRoleName);
		session.setAttribute(SESSION_USER_BEAN_LOGIN, login);
	}

	private boolean validateData(HttpServletRequest request, WelcomeDto welcomeDto) {
		String username = welcomeDto.getUsername();
		String password = welcomeDto.getPassword();
		Map<String, String> errorMap = new HashMap<>();

		if (StringUtils.isEmpty(username)) {
			errorMap.put(LOGIN_EMPTY_CODE, LOGIN_EMPTY_VALUE);
		}
		if (StringUtils.isEmpty(password)) {
			errorMap.put(PASSWORD_EMPTY_CODE, PASSWORD_EMPTY_VALUE);
		}

		if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {
			MySqlUserDaoImpl userDao = new MySqlUserDaoImpl();

			if (userDao.loginExists(username)) {
				if (!userDao.passwordEquals(username, password)) {
					errorMap.put(PASSWORD_BED_CODE, PASSWORD_BED_VALUE);
				}
				if(userDao.returnDelStatusByLogin(username)){
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

	private WelcomeDto fillWelcomeDto(HttpServletRequest request){
		String username = request.getParameter(PARAMETER_USERNAME);
		String password = request.getParameter(PARAMETER_PASSWORD);
		
		WelcomeDto welcomeDto = new WelcomeDto();
		
		welcomeDto.setUsername(username);
		welcomeDto.setPassword(password);
		
		return welcomeDto;
	}
	
}
