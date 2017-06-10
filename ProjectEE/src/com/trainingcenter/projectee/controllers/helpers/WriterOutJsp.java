package com.trainingcenter.projectee.controllers.helpers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public final class WriterOutJsp {

	public static void writeEmailIsSend(String email, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<p> Login and password were sent to the address - " + email + "</p>");
		out.println("<a class=' login-detail-panel-button btn'");
		out.print("href='");
		out.print(LinkKeeper.PAGE_START);
		out.print("'> <i class='fa fa-arrow-left'></i>");
		out.println("Go back to Homepage</a>");
	}

}
