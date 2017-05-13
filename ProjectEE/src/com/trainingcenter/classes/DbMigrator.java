package com.trainingcenter.classes;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.flywaydb.core.Flyway;

public class DbMigrator implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		Flyway flyway = new Flyway();
		flyway.setDataSource("jdbc:mysql//localhost:3306/project_ee_db", "root", "root");
		flyway.migrate();		
	}

}
