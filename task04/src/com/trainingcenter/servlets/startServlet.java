package com.trainingcenter.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class startServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			String type = request.getParameter("archiveType");
			if (type.equals("ZIP") || type.equals("JAR")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("createLetterArchive.html");
				dispatcher.forward(request, response);
			}
		} catch (NullPointerException e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("createLetterHTML.html");
			dispatcher.forward(request, response);
		}
	}

}
