package com.trainingcenter.projectee.services.factory;

import com.trainingcenter.projectee.services.EmailService;

public abstract class ServiceFactory {

	public abstract EmailService getEmailService();

	public static ServiceFactory getFactory() {
		return new ServiceFactoryImpl();
	}
}
