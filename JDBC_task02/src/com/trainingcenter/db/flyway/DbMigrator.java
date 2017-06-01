package com.trainingcenter.db.flyway;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.flywaydb.core.Flyway;

import com.trainingcenter.db.connectionpool.ConnectionPool;

public class DbMigrator extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// Create the Flyway instance
        Flyway flyway = new Flyway();

        // Point it to the database
        flyway.setDataSource(ConnectionPool.getPool().getDataSource());

        // Start the migration
        flyway.migrate();
	}
}