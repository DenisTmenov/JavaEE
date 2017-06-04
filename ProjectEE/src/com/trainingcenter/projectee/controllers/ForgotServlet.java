package com.trainingcenter.projectee.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trainingcenter.projectee.beans.UserBean;
import com.trainingcenter.projectee.beans.UserInfoBean;
import com.trainingcenter.projectee.dao.mysql.MySqlUserDaoImpl;
import com.trainingcenter.projectee.dao.mysql.MySqlUserInfoDaoImpl;
import com.trainingcenter.projectee.utils.CreateTXT;
import com.trainingcenter.projectee.utils.HttpUtils;

@WebServlet("/ForgotServlet")
public class ForgotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String VALIDATION_ERRORS_ATTR_FORGOT = "validation_errors";
	
	public static final String HOME_PAGE = "./index.html";
	public static final String FORGOT_PAGE = "./forgot.html";
	
	public static final String EMAIL_EMPTY_CODE = "email.empty";
	public static final String EMAIL_NOT_EXISTS_CODE = "email.not.exists";

	public static final String EMAIL_EMPTY_VALUE = "Email is empty!";
	public static final String EMAIL_NOT_EXISTS_VALUE = "This email is not registered on ProjectEE!";

	private static final String VIEW_BED_NAME = "/WEB-INF/pages/forgotlogin.jsp";

	private static final String TEXT_FORGOT_DEL = "/WEB-INF/txtTemplates/forgotDEL.txt";
	private static final String TEXT_FORGOT_OK = "/WEB-INF/txtTemplates/forgotOK.txt";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Map<String, String> errorMap = new HashMap<>();
		Boolean isBtnFrogot = HttpUtils.isParameterExists(request, "BtnForgot");
		if (isBtnFrogot) {
			Boolean isEmail = HttpUtils.isParameterExists(request, "email");
			if (isEmail) {
				String email = request.getParameter("email");

				MySqlUserInfoDaoImpl infoDAO = new MySqlUserInfoDaoImpl();
				UserInfoBean userInfoBean = infoDAO.loadUserInfoByEmail(email);
				if (userInfoBean != null) {
					Integer fkIdUser = userInfoBean.getFkIdUser();

					if (userInfoBean != null) {
						MySqlUserDaoImpl userDAO = new MySqlUserDaoImpl();
						UserBean userBean = userDAO.loadUserByIdUser(fkIdUser);
						Boolean delStatus = userBean.getDelStatus();
						byte[] textMessage = null;
						Map<String, String> userAllParameters = new HashMap<String, String>();
						if (userInfoBean.getFirstName() != null) {
							userAllParameters.put("FIRST_NAME", userInfoBean.getFirstName());
						} else {
							userAllParameters.put("FIRST_NAME", "К сожалению, этот параметр пуст.");
						}
						if (userInfoBean.getLastName() != null) {
							userAllParameters.put("LAST_NAME", userInfoBean.getFirstName());
						} else {
							userAllParameters.put("LAST_NAME", "К сожалению, этот параметр пуст.");
						}
						userAllParameters.put("LOGIN", userBean.getLogin());
						userAllParameters.put("PASSWORD", userBean.getPassword());

						if (delStatus) {
							textMessage = CreateTXT.create(request, TEXT_FORGOT_DEL,
									userAllParameters);
						}
						if (!delStatus) {
							textMessage = CreateTXT.create(request, TEXT_FORGOT_OK,
									userAllParameters);
						}

						Sender.sendEmail(email, textMessage);
						PrintWriter out = response.getWriter();
						out.println("<p> Login and password were sent to the address - " + email + "</p>");
						out.println("<a class=' login-detail-panel-button btn'");
						out.print("href='");
						out.print(HOME_PAGE);
						out.print("'> <i class='fa fa-arrow-left'></i>");
						out.println("Go back to Homepage</a>");
					}

					session.removeAttribute(VALIDATION_ERRORS_ATTR_FORGOT);
				} else {
					errorMap.put(EMAIL_NOT_EXISTS_CODE, EMAIL_NOT_EXISTS_VALUE);
					session.setAttribute(VALIDATION_ERRORS_ATTR_FORGOT, errorMap);
					response.sendRedirect(FORGOT_PAGE);
				}
			} else {
				errorMap.put(EMAIL_EMPTY_CODE, EMAIL_EMPTY_VALUE);
				session.setAttribute(VALIDATION_ERRORS_ATTR_FORGOT, errorMap);
				response.sendRedirect(FORGOT_PAGE);
			}
		} else {
			session.removeAttribute(VALIDATION_ERRORS_ATTR_FORGOT);
			response.sendRedirect(FORGOT_PAGE);
		}

	}

}
