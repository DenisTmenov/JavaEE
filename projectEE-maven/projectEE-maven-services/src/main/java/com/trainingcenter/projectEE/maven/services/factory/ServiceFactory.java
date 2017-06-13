package com.trainingcenter.projectEE.maven.services.factory;

import com.trainingcenter.projectEE.maven.services.EmailService;

public abstract class ServiceFactory {

	public abstract EmailService getEmailService();

	public static ServiceFactory getFactory() {
		return new ServiceFactoryImpl();
	}
}
