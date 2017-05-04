package com.trainingcenter.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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

public class createLetter extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		HashMap<String, String> paramFromRequest = putToHashMap(request);
		writeContent(out, request, paramFromRequest);
	}

	private HashMap<String, String> putToHashMap(HttpServletRequest request) {
		HashMap<String, String> paramFromRequest = new HashMap<String, String>();
		Enumeration<?> params = request.getParameterNames();

		while (params.hasMoreElements()) {
			String paramName = (String) params.nextElement();
			paramFromRequest.put(paramName, request.getParameter(paramName));
		}
		String dateStart = paramFromRequest.get("dateStart");
		String dateFinish = paramFromRequest.get("dateFinish");
		String monthS = numToMonth(dateStart.substring(5, 7));
		String monthF = numToMonth(dateFinish.substring(5, 7));
		dateStart = dateStart.substring(8, 10) + " " + monthS + " " + dateStart.substring(0, 4);
		dateFinish = dateFinish.substring(8, 10) + " " + monthF + " " + dateFinish.substring(0, 4);

		paramFromRequest.put("dateStart", dateStart);
		paramFromRequest.put("dateFinish", dateFinish);
		paramFromRequest.put("firstNameTeacherONE", paramFromRequest.get("firstNameTeacher").substring(0, 1));
		paramFromRequest.put("patronymicTeacherONE", paramFromRequest.get("patronymicTeacher").substring(0, 1));
		String allThemes = "";
		for (int i = 1; i < 10; i++) {
			if (paramFromRequest.containsKey("theme" + i)) {
				allThemes += "<li>" + request.getParameter("theme" + i) + "</li>";
			}
		}

		paramFromRequest.put("theme", allThemes);

		return paramFromRequest;
	}

	private void writeContent(PrintWriter out, HttpServletRequest request, HashMap<String, String> paramFromRequest)
			throws IOException {
		ServletContext servletContext = request.getServletContext();
		String realPath = servletContext.getRealPath("/recomendateDOC.txt");
		Path path = Paths.get(realPath);
		List<String> readAllLines = Files.readAllLines(path);

		for (String str : readAllLines) {
			String str01 = parser(str, request, paramFromRequest);
			out.println(str01);
		}

	}

	private String parser(String strStart, HttpServletRequest request, HashMap<String, String> paramFromRequest)
			throws IOException {
		strStart = "<pre><p>" + strStart;
		for (HashMap.Entry<String, String> entry : paramFromRequest.entrySet()) {
			strStart = strStart.replaceAll("\\$\\{" + entry.getKey() + "\\}", entry.getValue());
		}
		strStart = strStart + "</p></pre>";
		return strStart;
	}

	private String numToMonth(String numMonth) {
		switch (numMonth) {
		case "01":
			numMonth = "января";
			break;
		case "02":
			numMonth = "февраля";
			break;
		case "03":
			numMonth = "марта";
			break;
		case "04":
			numMonth = "апреля";
			break;
		case "05":
			numMonth = "мая";
			break;
		case "06":
			numMonth = "июня";
			break;
		case "07":
			numMonth = "июля";
			break;
		case "08":
			numMonth = "августа";
			break;
		case "09":
			numMonth = "сентября";
			break;
		case "10":
			numMonth = "октября";
			break;
		case "11":
			numMonth = "ноября";
			break;
		case "12":
			numMonth = "декабря";
			break;
		default:
			break;
		}

		return numMonth;
	}
}