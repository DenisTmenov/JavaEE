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
import com.trainingcenter.projectee.beans.UserInfoBean;
import com.trainingcenter.projectee.controllers.helpers.LinkKeeper;
import com.trainingcenter.projectee.controllers.helpers.WriterOutJsp;
import com.trainingcenter.projectee.dao.mysql.MySqlUserDaoImpl;
import com.trainingcenter.projectee.dao.mysql.MySqlUserInfoDaoImpl;
import com.trainingcenter.projectee.dto.ForgotDto;
import com.trainingcenter.projectee.services.EmailService;
import com.trainingcenter.projectee.services.factory.ServiceFactory;
import com.trainingcenter.projectee.utils.CreateTXT;
import com.trainingcenter.projectee.utils.HttpUtils;

@WebServlet("/forgot.html")
public class ForgotController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String VALIDATION_ERRORS_ATTR_FORGOT = "validation_errors";

	public static final String EMAIL_EMPTY_CODE = "email.empty";
	public static final String EMAIL_NOT_EXISTS_CODE = "email.not.exists";

	public static final String EMAIL_EMPTY_VALUE = "Email is empty!";
	public static final String EMAIL_NOT_EXISTS_VALUE = "This email is not registered on ProjectEE!";

	private static final String EMPTY_VALUE_IN_REG_INFO_VALUE = "К сожалению, этот параметр пуст.";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpUtils.forwardToView(LinkKeeper.JSP_FORGOT, request, response);
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
				ForgotDto forgotDto = new ForgotDto();
				forgotDto.setEmail(email);
				request.setAttribute("forgotDto", forgotDto);

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
							userAllParameters.put("FIRST_NAME", EMPTY_VALUE_IN_REG_INFO_VALUE);
						}
						if (userInfoBean.getLastName() != null) {
							userAllParameters.put("LAST_NAME", userInfoBean.getFirstName());
						} else {
							userAllParameters.put("LAST_NAME", EMPTY_VALUE_IN_REG_INFO_VALUE);
						}
						userAllParameters.put("LOGIN", userBean.getLogin());
						userAllParameters.put("PASSWORD", userBean.getPassword());

						if (delStatus) {
							textMessage = CreateTXT.create(request, LinkKeeper.TEXT_FORGOT_DEL, userAllParameters);
						}
						if (!delStatus) {
							textMessage = CreateTXT.create(request, LinkKeeper.TEXT_FORGOT_OK, userAllParameters);
						}

						EmailService emailService = ServiceFactory.getFactory().getEmailService();
						emailService.sendEmail(email, "Restore credentials.", textMessage);

						WriterOutJsp.writeEmailIsSend(email, response);
					}

					session.removeAttribute(VALIDATION_ERRORS_ATTR_FORGOT);
				} else {
					errorMap.put(EMAIL_NOT_EXISTS_CODE, EMAIL_NOT_EXISTS_VALUE);
					session.setAttribute(VALIDATION_ERRORS_ATTR_FORGOT, errorMap);
					HttpUtils.forwardToView(LinkKeeper.JSP_FORGOT, request, response);
				}
			} else {
				errorMap.put(EMAIL_EMPTY_CODE, EMAIL_EMPTY_VALUE);
				session.setAttribute(VALIDATION_ERRORS_ATTR_FORGOT, errorMap);
				HttpUtils.forwardToView(LinkKeeper.JSP_FORGOT, request, response);
			}
		} else {
			session.removeAttribute(VALIDATION_ERRORS_ATTR_FORGOT);
			HttpUtils.forwardToView(LinkKeeper.JSP_FORGOT, request, response);
		}
	}

}
