package com.trainingcenter.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String pageAttribute = (String) request.getAttribute("page");
		if(pageAttribute == null){
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.html");
			dispatcher.forward(request, response);
		} else if(pageAttribute.equals("home")){
			RequestDispatcher dispatcher = request.getRequestDispatcher("homecontent.html");
			dispatcher.include(request, response);
		} else if(pageAttribute.equals("authorization")){
			RequestDispatcher dispatcher = request.getRequestDispatcher("authorizationshow.html");
			dispatcher.include(request, response);
		} else if(pageAttribute.equals("registration")){
			RequestDispatcher dispatcher = request.getRequestDispatcher("registrationshow.html");
			dispatcher.include(request, response);
		} else if(pageAttribute.equals("foto")){
			RequestDispatcher dispatcher = request.getRequestDispatcher("fotoshow.html");
			dispatcher.include(request, response);
		}
	}
}
