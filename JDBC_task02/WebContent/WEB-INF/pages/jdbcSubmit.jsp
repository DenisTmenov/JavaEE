<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="javax.activation.DataSource"%>
<%@page import="javax.naming.NamingException"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.Random"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang='eng'>
<head>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<meta charset='UTF-8'>

<!-- Latest compiled and minified CSS -->
<link rel='stylesheet'
	href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'
	integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u'
	crossorigin='anonymous'>
<!-- Optional theme -->
<link rel='stylesheet'
	href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css'
	integrity='sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp'
	crossorigin='anonymous'>
<!-- Latest compiled and minified JavaScript -->
<script
	src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'
	integrity='sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa'
	crossorigin='anonymous'></script>
<link href="css/style.css" rel="stylesheet">

<title>Lesson 05. Task 02.</title>
</head>
<body>
	<h1 align='center'>Lesson 05 - JDBC. Task 02.</h1>
	<div class='container'>
		<div class='col-xs-2'>
			<p>
				<a href="jdbcindex.html" class='btn btn-primary'>Вернуться <br>
					к вопросам
				</a>
			</p>
			
		</div>

		<div class='col-xs-8'>
			<%
				request.setCharacterEncoding("UTF-8");
			%>
			<table>
				<tr>
					<td>На вопрос: "<%=request.getParameter("question")%>"
					</td>
				</tr>
				<tr>
					<td>Вы ответили: <%
						String id_a = request.getParameter("button");

						Connection c = null;
						Statement statement = null;
						ResultSet set = null;
						try {
							Class.forName("com.mysql.jdbc.Driver");
							c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_task02_db" + "?useSSL=false", "root",
									"root");
							statement = c.createStatement();
							set = statement.executeQuery("SELECT * FROM jdbc_task02_db.answers WHERE id_a=" + id_a);
							int columns = set.getMetaData().getColumnCount();
							set.next();
							String answer = set.getString("answer");
					%> "<%=answer%>"
					</td>
				</tr>
				<tr>
					<td>
						<%
							//String trueOrFalse = set.getString(3);
								String trueOrFalse = set.getString("trueOrFalse");
								if (trueOrFalse.equals("true")) {
						%> Поздравляем! Вы ответили правильно. <%
							}
								if (trueOrFalse.equals("false")) {
						%> К сожалению Вы ошиблись. <%
							}
							} catch (SQLException e) {
								throw new RuntimeException("Some errors occurred during DB access!", e);
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
							}
						%>
					</td>
				</tr>
			</table>
		</div>


		<div class='col-xs-2'>
			<p>реклама</p>
		</div>
	</div>
	<div class='footer' align='center'>
		<p>This page was developed by Denis Tmenov.</p>
	</div>
</body>
</html>
