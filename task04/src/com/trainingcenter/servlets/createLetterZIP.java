package com.trainingcenter.servlets;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jClasses.createHashMap;
import jClasses.parser;
import jClasses.writeContent;

public class createLetterZIP extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		ServletContext servletContext = request.getServletContext();
		String realPath = servletContext.getRealPath("/");
		System.out.print(realPath);
		FileWriter out = new FileWriter(realPath + "recOUT.txt", false);
		
		HashMap<String, String> paramFromRequest = createHashMap.create(request);
		writeContent.start(out, request, paramFromRequest);
		out.close();
	}
}