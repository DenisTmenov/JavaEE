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
<style>
p {
	text-indent: 20px; /* Отступ первой строки в пикселах */
}

a {
	text-indent: 0px;
}
</style>

<title>Lesson 05. Task 01.</title>
</head>
<body>
	<h1 align='center'>Lesson 05 - JDBC. Task 01.</h1>
	<div class='container'>
		<div class='col-xs-2'>
			<p>
				<a href="./" class='btn btn-primary'>Кнопка меню 1</a>
			</p>
			<p>
				<a href="./" class='btn btn-primary'>Кнопка меню 2</a>
			</p>
			<p>
				<a href="./" class='btn btn-primary'>Кнопка меню 3</a>
			</p>
		</div>

		<div class='col-xs-8'>
			<form id="primaryTable" method="post" class="form-group"
				onsubmit="true" action="jdbcDB">
				<table>
					<tr>
						<td colspan="3"><h3>В базе содержатся следующие
								продукты:</h3></td>
					</tr>

					<%
						//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

						Connection c = null;
						Statement statement = null;
						ResultSet set = null;

						try {
							Class.forName("com.mysql.jdbc.Driver");
							c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_task01_db" + "?useSSL=false", "root",
									"root");
							statement = c.createStatement();
							set = statement.executeQuery("SELECT id, products FROM jdbc_task01_db.products");

							while (set.next()) {
								Integer id = set.getInt("id"); // Вот так получать данные - очень хорошо!
								String products = set.getString("products");
					%>
					<tr>

						<td align="right" height="40px"><%=id%>
						&nbsp;
						</td>
						<td colspan="2"><lable><%=products%>&nbsp;
							<button name="button" type="submit" value="<%=id%>"
								class="btn btn-primary">Удалить</button>
							</lable></td>
					</tr>
					<%
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
						//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
					%>
					<tr>
						<td><label for="newProduct">Добавить товар:&nbsp;</label></td>
						<td><input type="text" size="30" maxlength="50"
							class="form-control" id="Product" name="Product"></td>
						<td>&nbsp;<button name="button" type="submit" value="Add"
								class="btn btn-primary">Добавить</button></td>
					</tr>
				</table>
			</form>
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
