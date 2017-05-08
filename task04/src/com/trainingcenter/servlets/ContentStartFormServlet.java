package com.trainingcenter.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContentStartFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<div class='col-xs-8'>");

		writeContent(out, request);

		out.println("</div>");

		RequestDispatcher dispatcher = request.getRequestDispatcher("advertising.html");
		dispatcher.include(request, response);
		out.close();

	}

	private void writeContent(PrintWriter out, HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("UTF-8");
		ServletContext servletContext = request.getServletContext();
		String realPath = servletContext.getRealPath("/startFormPattern.html");
		Path path = Paths.get(realPath);
		List<String> readAllLines = Files.readAllLines(path);

		for (String str : readAllLines) {
			String str01 = parser(str, request);
			out.println(str01);
			// System.out.println(str01);
		}
	}

	private String parser(String strStart, HttpServletRequest request) throws IOException {
		Pattern pNum = Pattern.compile("\\$\\{themeNUM\\}");
		Matcher matcherNum = pNum.matcher(strStart);
		String strFinish = "";
		if (matcherNum.find()) {
			String copyStr = copyString(strStart);
			int countNUM = 0;
			Pattern pTheme = Pattern.compile("\\$\\{theme\\}");
			List<String> linesFromFile = readFromFile(request.getServletContext().getInitParameter("themes.txt"), request);
			for (String strFromFile : linesFromFile) {
				strFinish += copyStr;
				matcherNum = pNum.matcher(strFinish);
				countNUM++;
				strFinish = matcherNum.replaceAll("theme" + countNUM);
				Matcher matcherTheme = pTheme.matcher(strFinish);
				strFinish = matcherTheme.replaceAll(strFromFile);

			}
		} else {
			strFinish = strStart;
		}

		return strFinish;
	}

	private List<String> readFromFile(String pathForFile, HttpServletRequest request) throws IOException {
		//ServletContext servletContext = request.getServletContext();
		//String realPath = servletContext.getRealPath(pathForFile);
		
		String realPath = pathForFile;
		Path path = Paths.get(realPath);
		List<String> readAllLines = Files.readAllLines(path);

		return readAllLines;
	}

	private String copyString(String str) {
		char[] chars = str.toCharArray();
		String strCOPY = String.valueOf(chars).trim();
		return strCOPY;
	}

}
