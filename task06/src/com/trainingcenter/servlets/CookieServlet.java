package com.trainingcenter.servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
	
		Enumeration<String> allParameters = request.getParameterNames();
		while (allParameters.hasMoreElements()) {
			String name = allParameters.nextElement();
			String value = request.getParameter(name);
			response.addCookie(new Cookie(name, value));
		}

		response.sendRedirect("start.html");
	}
}
