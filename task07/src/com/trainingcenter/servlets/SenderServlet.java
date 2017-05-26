package com.trainingcenter.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
		String propePathDefault = "com/trainingcenter/properties/propertiesForGmail.properties";
		String propePathUser = "com/trainingcenter/properties/userConfig.properties";
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream stream = classLoader.getResourceAsStream(propePathDefault);
		Properties properties = new Properties();
		properties.load(stream);
		stream.close();
		stream = classLoader.getResourceAsStream(propePathUser);
		properties.load(stream);
		
		String fromEmail = properties.getProperty("mail.from");
		final String user = properties.getProperty("mail.user");
		final String password = properties.getProperty("mail.password");

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
			message.setText(request.getParameter("messageText"));

			Transport.send(message);

			response.getWriter().println("E-mail sent !!!");
			response.getWriter().println("<a href='index.html'>back</a>");
		} catch (MessagingException e) {
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
