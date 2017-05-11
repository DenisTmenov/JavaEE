package com.trainingcenter.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaClasses.ReadFile;

public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		List<String> readAllLines = ReadFile.writeContent(request, "/WEB-INF/html/header.html");
		for (String str : readAllLines) {
			out.println(str);
		}

		System.out.println("request.getSession().getAttribute('reg') " + request.getSession().getAttribute("reg"));

		System.out.println(
				"request.getSession().getAttribute('autoriz') " + request.getSession().getAttribute("autoriz"));

		if (request.getSession().getAttribute("reg") == null) {
			readAllLines = ReadFile.writeContent(request, "/WEB-INF/html/headerRegHom.html");
		} else if (request.getSession().getAttribute("autoriz") == null) {
			readAllLines = ReadFile.writeContent(request, "/WEB-INF/html/headerRegAutHom.html");
		} else if (request.getSession().getAttribute("autoriz") != null) {
			readAllLines = ReadFile.writeContent(request, "/WEB-INF/html/headerFotoExitHom.html");
		}

		for (String str : readAllLines) {
			out.println(str);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("menu.html");
		dispatcher.include(request, response);
		out.close();
	}
}
