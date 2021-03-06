package com.trainingcenter.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javaClasses.FileReader;

public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		List<String> readAllLines = null;
		if (request.getSession().getAttribute("reg") == null) {
			readAllLines = FileReader.readContentFromWebInf(request, "/WEB-INF/html/menuRegHom.html");
		} else if (request.getSession().getAttribute("autoriz") == null) {
			readAllLines = FileReader.readContentFromWebInf(request, "/WEB-INF/html/menuRegAutHom.html");
		} else if (request.getSession().getAttribute("autoriz") != null) {
			readAllLines = FileReader.readContentFromWebInf(request, "/WEB-INF/html/menuFotoExitHom.html");
		}

		for (String str : readAllLines) {
			out.println(str);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("start.html");
		dispatcher.include(request, response);
		out.close();

	}

}
