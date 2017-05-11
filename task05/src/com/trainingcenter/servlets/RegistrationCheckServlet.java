package com.trainingcenter.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String surName = request.getParameter("surName");
		String password = request.getParameter("password");

		Boolean answer = true;
		if (!firstName.equals("") && firstName != null
				&& !firstName.equals(request.getSession().getAttribute(firstName))) {
		} else {
			answer = false;
		}

		if (!surName.equals("") && surName != null
				&& !surName.equals(request.getSession().getAttribute(firstName + "${surName}"))) {
		} else {
			answer = false;
		}

		if ((!password.equals("") || password != null)
				&& !password.equals(request.getSession().getAttribute(firstName + "${pass}"))) {
		} else {
			answer = false;
		}

		if (answer) {
			request.getSession().setAttribute(request.getParameter("firstName"), request.getParameter("firstName"));
			request.getSession().setAttribute(request.getParameter("firstName") + "${surName}",
					request.getParameter("surName"));
			request.getSession().setAttribute(request.getParameter("firstName") + "${pass}",
					request.getParameter("password"));
			request.getSession().setAttribute("page", "registration");
			request.getSession().setAttribute("reg", "regActive");
			request.getSession().setAttribute("error", "NO");
			response.sendRedirect("home.html");
		} else {
			request.getSession().setAttribute("error", "YES");
			response.sendRedirect("registration.html");
		}
	}

}
