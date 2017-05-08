package com.trainingcenter.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jClasses.CreateHashMapHTML;
import jClasses.WriteContentHTML;

public class CreateLetterHTML extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		HashMap<String, String> paramFromRequest = CreateHashMapHTML.create(request);
		WriteContentHTML.start(out, request, paramFromRequest);
		out.close();
	}

	
	

}