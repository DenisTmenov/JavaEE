package com.trainingcenter.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StartformServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		writeHeader(response);
		writeMenu(response);
		writeContent(request, response);
		writeAdvertising(response);
		writeFooter(response);
		
	}
	
	

	private void writeHeader(HttpServletResponse response) throws IOException {
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
		out.println("<script src='/task04/letterFullOrClean.js'></script>");
		out.println("<title>Lesson 03. Task 04.</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 align='center'>Lesson 03 - Servlet API. Task 04. <br>");
		out.println("Форма для создания рекомендательного письма.</h1>");
	}

	private void writeMenu(HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<div class='container'>");
		out.println("<div class='col-xs-2'>Menu");
		out.println("<p><input type='submit' id='buttonClean' class='btn btn-primary'value='Пустое письмо' onclick='letterClean()'/></p>");
		out.println("<p><input type='submit' id='buttonFull' class='btn btn-primary'value='Заполненное письмо' onclick='letterFull()' /></p>");
		out.println("</div>");
	}

	private void writeContent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<div class='col-xs-8'>");

		ServletContext servletContext = request.getServletContext();
		String realPath = servletContext.getRealPath("/startFormPattern.html");
		Path path = Paths.get(realPath);
		List<String> readAllLines = Files.readAllLines(path);

		for (String str : readAllLines) {
			String str01 = parser(str, request);
			out.println(str01);
		}

		out.println("</div>");
	}
	
	private void writeAdvertising(HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<div class='col-xs-2'>");
		out.println("реклама");
		out.println("</div>");
		out.println("</div>");
	}
	
	private void writeFooter(HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<div class='footer' align='center'>");
		out.println("<p>");
		out.println("This page was developed by Denis Tmenov.");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

		out.close();
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
