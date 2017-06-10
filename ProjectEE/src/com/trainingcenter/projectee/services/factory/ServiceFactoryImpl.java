package com.trainingcenter.projectee.services.factory;

import com.trainingcenter.projectee.services.EmailService;
import com.trainingcenter.projectee.services.impl.EmailServiceImpl;

public class ServiceFactoryImpl extends ServiceFactory {

	@Override
	public EmailService getEmailService() {
		return new EmailServiceImpl();
	}

	
}
