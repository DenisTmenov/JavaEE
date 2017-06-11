package com.trainingcenter.projectee.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trainingcenter.projectee.controllers.helpers.LinkKeeper;
import com.trainingcenter.projectee.utils.HttpUtils;

@WebServlet("/UserInSession")
public class UserInSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if (HttpUtils.isParameterExists(session, WelcomeController.SESSION_USER_BEAN_ROLE)) {
			response.sendRedirect(LinkKeeper.PAGE_MAIN);
		} else {
			response.sendRedirect(LinkKeeper.PAGE_WELCOME);
		}

	}

}
