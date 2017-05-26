package com.trainingcenter.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trainingcenter.javaClasses.ReadFile;

public class StartServlet extends HttpServlet {
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
		readAllLines = ReadFile.writeContent(request, "/WEB-INF/html/menu.html");
		for (String str : readAllLines) {
			out.println(str);
		}
		readAllLines = ReadFile.writeContent(request, "/WEB-INF/html/home.html");
		for (String str : readAllLines) {
			out.println(str);
		}
		readAllLines = ReadFile.writeContent(request, "/WEB-INF/html/advertising.html");
		for (String str : readAllLines) {
			out.println(str);
		}
		readAllLines = ReadFile.writeContent(request, "/WEB-INF/html/footer.html");
		for (String str : readAllLines) {
			out.println(str);
		}

		out.close();
	}
}
