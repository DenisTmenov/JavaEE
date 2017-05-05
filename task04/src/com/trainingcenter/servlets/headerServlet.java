package com.trainingcenter.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class headerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html lang='eng'>");
		out.println("<head>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
		out.println("<meta charset='UTF-8'>");
		out.println("<!-- Latest compiled and minified CSS -->");
		out.println(
				"<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'");
		out.println(
				"integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'>");
		out.println("<!-- Optional theme -->");
		out.println(
				"<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css'");
		out.println(
				"integrity='sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp' crossorigin='anonymous'>");
		out.println("<!-- Latest compiled and minified JavaScript -->");
		out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'");
		out.println("integrity='sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa'");
		out.println("crossorigin='anonymous'></script>");
		out.println("<script src='/task04/validate.js'></script>");
		out.println("<script src='/task04/arhive.js'></script>");
		out.println("<script src='/task04/action.js'></script>");
		out.println("<title>Lesson 03. Task 02.</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 align='center'>Lesson 03 - Servlet API. Task 04. <br>");
		out.println("Форма для создания рекомендательного письма.</h1>");
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("menu.html");
		dispatcher.include(request, response);
		out.close();
	}
}
