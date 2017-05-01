package com.trainingcenter.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class advertisingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<div class='col-xs-2'>");
		out.println("реклама");
		out.println("</div>");
		out.println("</div>");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("footer.html");
		dispatcher.include(request, response);
		
		out.close();
	}

}
