package com.trainingcenter.servlets;

import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SenderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Properties properties = new Properties();
		String addressFrom = request.getParameter("addressSender");

		properties.setProperty("mail.from", addressFrom);
		properties.setProperty("mail.user", addressFrom.substring(0, addressFrom.indexOf("@")));
		properties.setProperty("mail.password", request.getParameter("pass"));
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.socketFactory.port", "465");
		properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.port", "465");

		String fromEmail = properties.getProperty("mail.from");
		final String user = properties.getProperty("mail.user");
		final String password = properties.getProperty("mail.password");

		// Get the default Mail Session object.
		Session mailSession = Session.getDefaultInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		try {
			Message message = new MimeMessage(mailSession);
			message.setFrom(new InternetAddress(fromEmail));
			InternetAddress to[] = new InternetAddress[1];
			to[0] = new InternetAddress(request.getParameter("addressRecipient"));
			message.setRecipients(Message.RecipientType.TO, to);
			message.setSubject(request.getParameter("theme"));
			message.setContent(request.getParameter("messageText"), "text/plain");

			// Send Email
			Transport.send(message);

			response.getWriter().println("E-mail sent !!!");
			response.getWriter().println("<a href='index.html'>back");
		} catch (MessagingException e) {
			response.getWriter().println("E-mail not send !!!");
			response.getWriter().println("<a href='index.html'>back");
			throw new RuntimeException(e);
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet");
		response.sendRedirect("start.html");
	}

}
