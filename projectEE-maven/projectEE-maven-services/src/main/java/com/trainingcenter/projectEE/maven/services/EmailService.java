package com.trainingcenter.projectEE.maven.services;

import com.trainingcenter.projectEE.maven.services.exceptions.ExceptionService;

public interface EmailService {

	void sendEmail(String emailTo, String subject, byte[] text) throws ExceptionService;
	void sendEmail(String emailTo, String subject, String body) throws ExceptionService;
}
