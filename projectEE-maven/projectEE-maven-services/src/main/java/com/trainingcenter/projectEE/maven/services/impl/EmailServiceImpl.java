package com.trainingcenter.projectEE.maven.services.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.trainingcenter.projectEE.maven.services.EmailService;
import com.trainingcenter.projectEE.maven.services.exceptions.ExceptionService;


public final class EmailServiceImpl implements EmailService {

	public void sendEmail(String addressRecipient, String subject, byte[] text){
		Properties emailSettings = getEmailSettings();

		String fromEmail = emailSettings.getProperty("mail.from");
		final String user = emailSettings.getProperty("mail.user");
		final String password = emailSettings.getProperty("mail.password");

		Session mailSession = Session.getDefaultInstance(emailSettings, new Authenticator() {
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
			message.setSubject(subject);

			// read from byte[] text
			String messageText = new String(text, "UTF-8");
			message.setText(messageText);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new ExceptionService("Exception in sending Email.", e);
		} catch (UnsupportedEncodingException e) {
			throw new ExceptionService("Exception in reading body email text.", e);
		}
	}
	
	public void sendEmail(String addressRecipient, String subject, String body){
		Properties emailSettings = getEmailSettings();

		String fromEmail = emailSettings.getProperty("mail.from");
		final String user = emailSettings.getProperty("mail.user");
		final String password = emailSettings.getProperty("mail.password");

		Session mailSession = Session.getDefaultInstance(emailSettings, new Authenticator() {
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
			message.setSubject(subject);
			message.setText(body);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new ExceptionService("Exception in sending Email.", e);
		}
	}

	private Properties getEmailSettings() {
		InputStream stream = null;

		String emailSettingsPath = "/settings/email.properties";
		stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(emailSettingsPath);

		Properties emailSettings = new Properties();
		try {
			emailSettings.load(stream);
		} catch (IOException e) {
			throw new ExceptionService("Exception in reading properties for email.", e);
		} finally {
			try {
				stream.close();
			} catch (IOException e) {
				throw new ExceptionService("Exception in closing properties stream.", e);
			}
		}

		return emailSettings;
	}

}
