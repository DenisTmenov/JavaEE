package com.trainingcenter.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class start3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String param1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Hello</title>");
		out.print("</head>");
		out.print("<body>");
		Enumeration<String> enumeration = request.getParameterNames();
		while(enumeration.hasMoreElements()){
			String name = enumeration.nextElement();
			String value = request.getParameter(name);
			out.print(name + " = " + value + "<br/>"); 
			
		}
		out.println("ServletConfig:" + "<br/>");
		out.println(param1 + "<br/>");
		out.println("ServletContext:" + "<br/>");
		out.println(request.getServletContext().getInitParameter("TitelName01"));
		
		out.print("<form id='primaryTable' method='post' action='startCookie'>");
		out.println("<td><input type='submit' value='Go to Cookie'></td>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		param1 = config.getInitParameter("nameParam");
	
	}
	
	
	

}
