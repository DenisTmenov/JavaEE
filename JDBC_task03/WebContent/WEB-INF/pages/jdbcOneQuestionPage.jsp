<%@page import="javax.sql.DataSource"%>
<%@page import="com.trainingcenter.javaclass.ConnectionManager"%>
<%@page import="java.util.List"%>
<%@page import="com.trainingcenter.javaclass.ReadFile"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.PreparedStatement"%>

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

<%
	response.setCharacterEncoding("UTF-8");
	response.setContentType("text/html");
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
				String id_question = request.getParameter("button");
				Connection c = null;
				Statement statement = null;
				ResultSet set = null;
				ArrayList<Integer> allNumberQuestions = new ArrayList<Integer>();
				HashMap<Integer, String> allQuestions = new HashMap<Integer, String>();
				try {
					Context initContext = new InitialContext();
					Context rootContext = (Context) initContext.lookup("java:comp/env");
					DataSource dataSource = (DataSource) rootContext.lookup("jdbc/jdbc_task03_db_link");

					c = dataSource.getConnection();
					statement = c.createStatement();
					set = statement.executeQuery("SELECT * FROM jdbc_task03_db.questions WHERE id_q=" + id_question);

					set.next();
					Integer id_q = set.getInt("id_q"); // Вот так получать данные - очень хорошо!
					String question = set.getString("question");
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
					ConnectionManager.closeDbResources(c, statement, set);
				}
			%>
			<tr>
				<td colspan="3">Варианты ответа:</td>
			</tr>
			<%
				try {
					Context initContext = new InitialContext();
					Context rootContext = (Context) initContext.lookup("java:comp/env");
					DataSource dataSource = (DataSource) rootContext.lookup("jdbc/jdbc_task03_db_link");

					c = dataSource.getConnection();
					statement = c.createStatement();
					set = statement
							.executeQuery("SELECT * FROM jdbc_task03_db.answers WHERE fk_question_id=" + id_question);
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
					ConnectionManager.closeDbResources(c, statement, set);
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