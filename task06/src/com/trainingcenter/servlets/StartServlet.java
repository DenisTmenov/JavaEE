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

import javaClasses.ReadFile;

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

		RequestDispatcher dispatcher = request.getRequestDispatcher("menu.html");
		dispatcher.include(request, response);
		dispatcher = request.getRequestDispatcher("home.html");
		dispatcher.include(request, response);

		Cookie[] cookie = request.getCookies();
		if (cookie != null && cookie.length > 0) {

			out.println("</table>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<td colspan='2'>Вас может заинтересовать</td>");
			out.println("</tr>");

			for (Cookie cook : cookie) {
				System.out.println("cookie " + cook.getName() + "   " + cook.getValue());
				out.println("<tr>");
				out.println("<td>" + cook.getValue() + "</td>");
				out.println("<td><button name=" + cook.getName() + " type='submit' value=" + cook.getValue()
						+ "	class='btn btn-primary'>Купить</button></td>");
				out.println("</tr>");
			}

		}

		dispatcher = request.getRequestDispatcher("advertising.html");
		dispatcher.include(request, response);
		dispatcher = request.getRequestDispatcher("footer.html");
		dispatcher.include(request, response);

		out.close();
	}
}
