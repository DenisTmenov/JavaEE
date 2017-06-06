package com.trainingcenter.projectee.controllers.helpers;

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

public final class Sender {

	public static void sendEmail(String addressRecipient, byte[] text) throws IOException {
		String propePathDefault = "settings/email.properties";
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream stream = classLoader.getResourceAsStream(propePathDefault);
		Properties properties = new Properties();
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
			to[0] = new InternetAddress(addressRecipient);
			message.setRecipients(Message.RecipientType.TO, to);
			message.setSubject("Restore the registration data.");

			// read from byte[] text
			String messageText = new String(text, "UTF-8");
			message.setText(messageText);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
