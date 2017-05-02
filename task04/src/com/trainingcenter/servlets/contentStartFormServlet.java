package com.trainingcenter.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class contentStartFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<div class='col-xs-8'>");
		
		writeContent(out, request);
		
		out.println("</div>");
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("advertising.html");
		dispatcher.include(request, response);
		out.close();
		
		
	}
	
	private void writeContent(PrintWriter out, HttpServletRequest request) throws IOException {

		ServletContext servletContext = request.getServletContext();
		String realPath = servletContext.getRealPath("/startFormPattern.html");
		Path path = Paths.get(realPath);
		List<String> readAllLines = Files.readAllLines(path);

		for (String str : readAllLines) {
			String str01 = parser(str);
			out.println(str01);
			System.out.println(str01);
		}
	}
	
	private String parser(String strRegex) {

		Pattern pNum = Pattern.compile("\\$\\{themeNUM\\}");
		Matcher matcherNum = pNum.matcher(strRegex);
		if (matcherNum.find()) {
			strRegex = matcherNum.replaceAll(myCollection(matcherNum.group()));
		}
		
		Pattern pTheme = Pattern.compile("\\$\\{theme\\}");
		Matcher matcherTheme = pTheme.matcher(strRegex);
		if (matcherTheme.find()) {
			strRegex = matcherTheme.replaceAll(myCollection(matcherTheme.group()));
		}
		return strRegex;
	}
	
	private String myCollection(String str) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("${themeNUM}", "theme01");
		map.put("${theme}", "aaaaaaaaa");

		for (String key : map.keySet()) {
			if (str.equals(key)) {
				return map.get(key);
			}
		}
		return str;
	}

}
