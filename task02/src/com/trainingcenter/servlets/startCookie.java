package com.trainingcenter.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class startCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		Cookie c = null;
		Enumeration<String> enumeration = request.getParameterNames();
		PrintWriter out = response.getWriter();
		while (enumeration.hasMoreElements()) {
			String name = enumeration.nextElement();
			String value = request.getParameter(name);
			c = new Cookie(name, value);
			c.setMaxAge(3600);
			response.addCookie(c);
		}
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Hello</title>");
		out.print("</head>");
		out.print("<body>");
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			out.println("Number cookie : " + cookies.length + "<br/>");
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				out.print("Secure :" + cookie.getSecure());
				out.print(cookie.getName() + " = " + cookie.getValue() + "<br/>");
			}
		}
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

}
