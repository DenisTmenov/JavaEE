package com.trainingcenter.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class menuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<div class='container'>");
		out.println("<div class='col-xs-2'>Menu");
		out.println("<p><input type='submit' id='buttonClean' class='btn btn-primary'value='Пустое письмо' onclick='letterClean()'/></p>");
		out.println("<p><input type='submit' id='buttonFull' class='btn btn-primary'value='Заполненное письмо' onclick='letterFull()' /></p>");
		out.println("</div>");
		RequestDispatcher dispatcher = request.getRequestDispatcher("contentstartform.html");
		dispatcher.include(request, response);

		out.close();

	}

}
