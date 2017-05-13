package com.trainingcenter.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebServlet("/task01form")*/
public class task01form extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {

	}

	public void destroy() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		
		out.write("<!DOCTYPE html>");
		out.write("<html lang='eng'>");
		out.write("<head>");
		out.write("<meta name='viewport' content='width=device-width, initial-scale=1'>");
		out.write("<meta charset='UTF-8'>");
		out.write("<!-- Latest compiled and minified CSS -->");
		out.write(
				"<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'>");
		out.write("<!-- Optional theme -->");
		out.write(
				"<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css' integrity = 'sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp'  crossorigin = 'anonymous' > ");
		out.write("<!-- Latest compiled and minified JavaScript -->");
		out.write(
				"<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js' integrity = 'sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa' crossorigin = 'anonymous' ></script > ");
		out.write("<title>Lesson 03. Task 01.</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<h1 align='center'> Lesson 03 - Servlet API. Task 01. <br>");
		out.write("Электронная анкета для оценки качества образования.</h1>");
		out.write("<div class='container'>");
		out.write("<div class='col-xs-2'>Menu</div>");
		out.write("<div class='col-xs-8'>");
		
		
		
		out.write("<table border='1'>");
		out.write("<tr>");
		out.write("<td>&nbsp;Surname &nbsp;");
		out.write("<td> &nbsp;" + request.getParameter("surName") + " &nbsp; </td>");
		out.write("<td> &nbsp;" + checkSurName(request) + " &nbsp; </td>");
		out.write("</tr>");
		out.write("");
		out.write("<tr>");
		out.write("<td>&nbsp;Name &nbsp;</td>");
		out.write("<td> &nbsp;" + request.getParameter("firstName") + " &nbsp; </td>");
		out.write("<td> &nbsp;" + checkFirstName(request) + " &nbsp; </td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td>&nbsp;Patronymic &nbsp;</td>");
		out.write("<td> &nbsp;" + request.getParameter("patronymic") + " &nbsp;</td>");
		out.write("<td>&nbsp</td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td>&nbsp;Secret phrase &nbsp;</td>");
		out.write("<td> &nbsp;" + request.getParameter("secretPhrase") + "&nbsp;</td>");
		out.write("<td> &nbsp;" + checkSecretPhrase(request) + "&nbsp; </td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td>&nbsp;Age &nbsp;</td>");
		out.write("<td> &nbsp;" + request.getParameter("age") + "&nbsp; </td>");
		out.write("<td> &nbsp;" + checkAge(request) + "&nbsp; </td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td>&nbsp;Gender &nbsp;</td>");
		out.write("<td> &nbsp;" + request.getParameter("gender") + " &nbsp;</td>");
		out.write("<td> &nbsp;" + checkGender(request) + "&nbsp; </td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td>&nbsp;Course &nbsp;</td>");
		out.write("<td> &nbsp;" + request.getParameter("courseCombo") + "&nbsp; </td>");
		out.write("<td> &nbsp;" + checkCourse(request) + "&nbsp; </td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td>&nbsp;Teacher name </td>");
		out.write("<td> &nbsp;" + request.getParameter("teacherName") + "</td>");
		out.write("<td> &nbsp;" + checkTeacherName(request) + "</td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td>&nbsp;Assessment of a course &nbsp;</td>");
		out.write("<td> &nbsp;" + request.getParameter("assessmentOfaCourseCombo") + "&nbsp; </td>");
		out.write("<td> &nbsp;" + checkAssessmentOfaCourse(request) + "&nbsp; </td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td>&nbsp;Other courses &nbsp;</td>");
		out.write("<td> &nbsp;" + request.getParameter("otherCoursesCombo") + "&nbsp; </td>");
		out.write("<td>&nbsp</td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td>&nbsp;How did you hear about us &nbsp;</td>");
		out.write("<td> &nbsp;" + request.getParameter("howDidYouHearAboutUs01") + "&nbsp; </td>");
		out.write("<td> &nbsp;" + checkHowDidYouHearAboutUs(request) + "</td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td>&nbsp;How did you hear about us &nbsp;</td>");
		out.write("<td> &nbsp;" + request.getParameter("howDidYouHearAboutUs02") + "&nbsp; </td>");
		out.write("<td> &nbsp;" + checkHowDidYouHearAboutUs(request) + "&nbsp; </td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td>&nbsp;How did you hear about us </td>");
		out.write("<td> &nbsp;" + request.getParameter("howDidYouHearAboutUs03") + "</td>");
		out.write("<td> &nbsp;" + checkHowDidYouHearAboutUs(request) + "</td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td>&nbsp;How did you hear about us </td>");
		out.write("<td> &nbsp;" + request.getParameter("howDidYouHearAboutUs04") + "</td>");
		out.write("<td> &nbsp;" + checkHowDidYouHearAboutUs(request) + "</td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td>&nbsp;How did you hear about us &nbsp;</td>");
		out.write("<td> &nbsp;" + request.getParameter("howDidYouHearAboutUs05") + "&nbsp; </td>");
		out.write("<td> &nbsp;" + checkHowDidYouHearAboutUs(request) + "&nbsp; </td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td> &nbsp;How did you hear about us &nbsp;</td>");
		out.write("<td> &nbsp;" + request.getParameter("textOtherId") + "&nbsp; </td>");
		out.write("<td> &nbsp;" + checkHowDidYouHearAboutUs(request) + "&nbsp; </td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td>&nbsp;Other recommendations &nbsp; </td>");
		out.write("<td> &nbsp;" + request.getParameter("otherRecommendations") + "&nbsp; </td>");
		out.write("<td>&nbsp</td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td>&nbsp;Button (secret value) &nbsp;</td>");
		out.write("<td> &nbsp;" + request.getParameter("secretValue") + "&nbsp; </td>");
		out.write("<td>&nbsp</td>");
		out.write("</tr>");

		out.write("</table>");
		out.write("</div>");
		out.write("<div class='col-xs-2'>реклама</div>");
		out.write("</div>");
		out.write("</body>");
		out.write("</html>");

		out.write("");
	}

	private boolean checkSurName(HttpServletRequest request) {
		String surName = request.getParameter("surName");
		String pattern = " ";
		return !(surName.equals("") || surName.matches(pattern));
	}

	private boolean checkFirstName(HttpServletRequest request) {
		String firstName = request.getParameter("firstName");
		String pattern = " ";
		return !(firstName.equals("") || firstName.matches(pattern));
	}

	private boolean checkSecretPhrase(HttpServletRequest request) {
		String secretPhrase = request.getParameter("secretPhrase");
		return !secretPhrase.equals("");
	}

	private boolean checkAge(HttpServletRequest request) {
		String age = request.getParameter("age");
		String pattern = "[a-zA-Zа-яА-Я]";
		return !(age.equals("") || age.matches(pattern) || Integer.parseInt(age) <= 0 || Integer.parseInt(age) > 120);
	}

	private boolean checkGender(HttpServletRequest request) {
		String gender = request.getParameter("gender");
		return !gender.equals("");
	}

	private boolean checkCourse(HttpServletRequest request) {
		String courseCombo = request.getParameter("courseCombo");
		return !courseCombo.equals("");
	}

	private boolean checkTeacherName(HttpServletRequest request) {
		String teacherName = request.getParameter("teacherName");
		return !teacherName.equals("");
	}

	private boolean checkAssessmentOfaCourse(HttpServletRequest request) {
		String assessmentOfaCourseCombo = request.getParameter("assessmentOfaCourseCombo");
		return !assessmentOfaCourseCombo.equals("");
	}

	private boolean checkHowDidYouHearAboutUs(HttpServletRequest request) {
		String howOther = request.getParameter("textOtherId");
		String how01 = request.getParameter("howDidYouHearAboutUs01");
		String how02 = request.getParameter("howDidYouHearAboutUs02");
		String how03 = request.getParameter("howDidYouHearAboutUs03");
		String how04 = request.getParameter("howDidYouHearAboutUs04");
		String how05 = request.getParameter("howDidYouHearAboutUs05");
		String pattern = "^\\s+$";
		return !(how01.equals("") && how02.equals("") && how03.equals("") && how04.equals("") && how05.equals("")
				&& howOther.matches(pattern));

	}
}
