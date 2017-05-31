<%@page import="com.trainingcenter.connectionpool.ConnectionPool"%>
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
			
		</div>

		<div class='col-xs-8'>
			<form id="primaryTable" method="post" class="form-group"
				onsubmit="true" action="jdbcSubmit">
				<table>
					<%
					Connection connection = null;
					PreparedStatement statement = null;
					ResultSet set = null;
						ArrayList<Integer> allNumberQuestions = new ArrayList<Integer>();
						HashMap<Integer, String> allQuestions = new HashMap<Integer, String>();
						Integer id_q;
						try {
							connection = ConnectionPool.getPool().getConnection();

							statement = connection.prepareStatement("SELECT * FROM jdbc_task02_db.questions");
							set = statement.executeQuery();
							
							while (set.next()) {
								Integer id_qq = set.getInt("id_q"); 
								String question = set.getString("question");
								allNumberQuestions.add(id_qq);
								allQuestions.put(id_qq, question);
							}
							Random rn = new Random();
							int num_q_in_allNumberQuestions = rn.nextInt(allNumberQuestions.size());
							id_q = allNumberQuestions.get(num_q_in_allNumberQuestions);
							String question = allQuestions.get(id_q);
					%>
					<tr>
						<td align="right">Вопрос: <%=id_q%> &nbsp;
						</td>
						<td colspan="3"><%=question%><input id="question"
							name="question" type="hidden" value="<%=question%>" /></td>
					</tr>
					<%
						} catch (SQLException e) {
							throw new RuntimeException("Some errors occurred during DB access!", e);
						} finally {
							ConnectionPool.getPool().closeDbResources(connection, statement, set);
						}
					%>
					<tr>
						<td colspan="3">Варианты ответа:</td>
					</tr>
					<%
						try {
							connection = ConnectionPool.getPool().getConnection();

							statement = connection.prepareStatement("SELECT * FROM jdbc_task02_db.answers WHERE fk_question_id=" + id_q);
							set = statement.executeQuery();
							
							int i = 1;
							while (set.next()) {
								Integer id_a = set.getInt("id_a"); 
								String answer = set.getString("answer");
					%>
					<tr>
						<td><%=i%></td>
						<td><%=answer%><input id="answer"	name="answer" type="hidden" value="<%=answer%>" /></td>
						<td>&nbsp;
							<button name="button" type="submit" value="<%=id_a%>"
								class="btn btn-primary">Выбрать</button>
						</td>
					</tr>
					<%
						i++;
							}

						} catch (SQLException e) {
							throw new RuntimeException("Some errors occurred during DB access!", e);
						} finally {
							ConnectionPool.getPool().closeDbResources(connection, statement, set);
						}
					%>


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
