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

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();

		writeContent(out, request);
	}

	private void writeContent(PrintWriter out, HttpServletRequest request) throws IOException {

		ServletContext servletContext = request.getServletContext();
		String realPath = servletContext.getRealPath("/HTMLpattern.html");
		Path path = Paths.get(realPath);
		List<String> readAllLines = Files.readAllLines(path);

		for (String str : readAllLines) {
			out.println(parser(str));
		}
	}

	private String parser(String strRegex) {

		Pattern pattern = Pattern.compile("\\$\\{.*\\}");
		Matcher matcher = pattern.matcher(strRegex);
		if (matcher.find()) {
			return matcher.replaceAll(myCollection(matcher.group()));
		}
		return strRegex;
	}

	private String myCollection(String str) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("${FIRST_NAME_PARAM}", "Ivan");
		map.put("${SUR_NAME_PARAM}", "Krasnov");

		for (String key : map.keySet()) {
			if (str.equals(key)) {
				return map.get(key);
			}
		}
		return str;
	}

}
