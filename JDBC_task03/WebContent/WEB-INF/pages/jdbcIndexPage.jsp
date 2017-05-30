<%@page import="com.trainingcenter.connectionpool.ConnectionPool"%>
<%@page import="java.sql.SQLException"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="com.trainingcenter.javaclass.ReadFile"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.NamingException"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.Random"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	response.setContentType("text/html");

	if (request.getAttribute("actionDelete") != null && request.getAttribute("actionDelete").equals("OK")) {
%>
<script>
	alert("Удаление прошло успешно!")
</script>
<%
	}

	List<String> readHeader = ReadFile.writeContent(request, "/WEB-INF/html/header.html");
	for (String str : readHeader) {
		out.println(str);
	}

	List<String> readMenu = ReadFile.writeContent(request, "/WEB-INF/html/menu.html");
	for (String str : readMenu) {
		out.println(str);
	}
%>
<div class='col-xs-8'>
	<form id="primaryTable" method="post" class="form-group"
		onsubmit="true" action="jdbcSubmit.html">
		<table>
			<%
				Connection connection = null;
				PreparedStatement statement = null;
				ResultSet set = null;
				ArrayList<Integer> allNumberQuestions = new ArrayList<Integer>();
				HashMap<Integer, String> allQuestions = new HashMap<Integer, String>();
				Integer id_q = null;
				Boolean questionNotEmpty = false;
				try {
					connection = ConnectionPool.getPool().getConnection();

					statement = connection.prepareStatement("SELECT * FROM jdbc_task03_db.questions");

					set = statement.executeQuery();
					if (set.next()) {
						questionNotEmpty = true;
						set.previous();
						while (set.next()) {
							Integer id_qq = set.getInt("id_q"); // Вот так получать данные - очень хорошо!
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
				}
				} catch (SQLException e) {
					throw new RuntimeException("Some errors occurred during DB access!", e);
				} finally {
					ConnectionPool.getPool().closeDbResources(connection, statement);
				}
				if (questionNotEmpty) {
			%>
			<tr>
				<td colspan="3">Варианты ответа:</td>
			</tr>
			<%
				
					try {
						connection = ConnectionPool.getPool().getConnection();

						statement = connection
								.prepareStatement("SELECT * FROM jdbc_task03_db.answers WHERE fk_question_id = ?");
						statement.setInt(1, id_q);

						set = statement.executeQuery();
						int i = 1;
						while (set.next()) {
							Integer id_a = set.getInt("id_a"); // Вот так получать данные - очень хорошо!
							String answer = set.getString("answer");
			%>
			<tr>
				<td><%=i%></td>
				<td><%=answer%><input id="answer" name="answer" type="hidden"
					value="<%=answer%>" /></td>
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
				}
			if (!questionNotEmpty){
				out.print("Вопросов нет в базе :(");
			}
			%>


		</table>
	</form>
</div>
<%
	response.setCharacterEncoding("UTF-8");
	response.setContentType("text/html");
	List<String> readAdvertising = ReadFile.writeContent(request, "/WEB-INF/html/advertising.html");
	for (String str : readAdvertising) {
		out.println(str);
	}

	List<String> readFooter = ReadFile.writeContent(request, "/WEB-INF/html/footer.html");
	for (String str : readFooter) {
		out.println(str);
	}
%>