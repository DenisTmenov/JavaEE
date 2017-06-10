package com.trainingcenter.projectee.services;

import com.trainingcenter.projectee.services.exceptions.ExceptionService;

public interface EmailService {

	void sendEmail(String emailTo, String subject, byte[] text) throws ExceptionService;
	void sendEmail(String emailTo, String subject, String body) throws ExceptionService;
}
