package com.trainingcenter.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/jdbcDB")
public class jdbcDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		HashMap<String, String> reqParams = new HashMap<String, String>();
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			reqParams.put(paramName, request.getParameter(paramName));
			System.out.println(paramName + "  " + request.getParameter(paramName));
		}

		Connection c = null;
		Statement statement = null;
		ResultSet set = null;
		ArrayList<String> productsFromDB = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_task01_db" + "?useSSL=false", "root",
					"root");
			statement = c.createStatement();
			set = statement.executeQuery("SELECT products FROM jdbc_task01_db.products");

			while (set.next()) {
				productsFromDB.add(set.getString("products"));
				System.out.println(set.getString("products"));
			}
			
			if(request.getParameter("button").equals("Add")){
				if (!productsFromDB.contains(request.getParameter("Product"))) {
					PreparedStatement ps = c.prepareStatement(
							"INSERT INTO jdbc_task01_db.products (products) VALUES ('"+ reqParams.get("Product") +"');");
					ps.execute();
				}
			}
			if(!request.getParameter("button").equals("Add")){
				System.out.println("Удалить");
				PreparedStatement ps = c.prepareStatement("DELETE FROM jdbc_task01_db.products WHERE id = "+ reqParams.get("button") +";");
		        ps.execute();
			}

		} catch (SQLException e) {
			throw new RuntimeException("Some errors occurred during DB access!", e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (set != null) {
				try {
					set.close();
				} catch (SQLException e) {
					System.out.println("Error: ResultSet has not been closed!");
				}
			}

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println("Error: Statement has not been closed!");
				}
			}

			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					System.out.println("Error: Connection has not been closed!");
				}
			}
			
			response.sendRedirect("jdbcindex.html");
			
		}

		
	}

}
