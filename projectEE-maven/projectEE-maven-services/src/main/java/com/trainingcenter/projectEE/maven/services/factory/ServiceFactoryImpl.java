package com.trainingcenter.projectEE.maven.services.factory;

import com.trainingcenter.projectEE.maven.services.EmailService;
import com.trainingcenter.projectEE.maven.services.impl.EmailServiceImpl;

public class ServiceFactoryImpl extends ServiceFactory {

	@Override
	public EmailService getEmailService() {
		return new EmailServiceImpl();
	}

	
}
