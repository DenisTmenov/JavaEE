package main.java.com.trainingcenter.projectEE.maven.dao.db.flyway;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.flywaydb.core.Flyway;

import main.java.com.trainingcenter.projectEE.maven.dao.db.ConnectionPool;

public class DbMigrator extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		Flyway flyway = new Flyway();

		flyway.setBaselineOnMigrate(true);
		flyway.setValidateOnMigrate(false);
		flyway.setDataSource(ConnectionPool.getInstance().getDataSource());

		try {
			flyway.migrate();
		} catch (Exception e) {
			flyway.repair();
			flyway.migrate();
		}
	}
}
