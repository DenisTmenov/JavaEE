package com.trainingcenter.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class footerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<div class='footer' align='center'>");
		out.println("<p>");
		out.println("This page was developed by Denis Tmenov.");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
