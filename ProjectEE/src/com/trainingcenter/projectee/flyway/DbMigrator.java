package com.trainingcenter.projectee.flyway;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.FlywayException;

public class DbMigrator extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// Create the Flyway instance
        Flyway flyway = new Flyway();
        
        flyway.setBaselineOnMigrate(true);
    	flyway.setValidateOnMigrate(false);
        // Point it to the database
        flyway.setDataSource("jdbc:mysql://localhost:3306/project_ee_db", "root", "root");

        // Start the migration
        try {
			flyway.migrate();
		} catch (Exception e) {
			System.out.println("tut");
		    flyway.repair();
		    flyway.migrate();
		}
	}
}
