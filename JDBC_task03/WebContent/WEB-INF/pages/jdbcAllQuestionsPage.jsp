<%@page import="javax.sql.DataSource"%>
<%@page import="com.trainingcenter.javaclass.ConnectionManager"%>
<%@page import="com.trainingcenter.javaclass.ReadFile"%>
<%@page import="java.util.List"%>
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
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<form id="primaryTable" method="post" class="form-group"
		onsubmit="true" action="onequestion.html">
		<table>
			<tr>
				<td>Список вопросов вопрос:</td>
			</tr>
			<%
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
					set = statement.executeQuery("SELECT * FROM jdbc_task03_db.questions");

					while (set.next()) {
						Integer id_q = set.getInt("id_q"); // Вот так получать данные - очень хорошо!
						String question = set.getString("question");
			%>
			<tr>
				<td align="right">Вопрос: <%=id_q%> &nbsp; 
				</td>
				<td colspan="3"><%=question%><input id="question"
					name="question" type="hidden" value="<%=question%>" /></td>
				<td>
					<p>
						<button id="bt_answer" name="button" type="submit"
							value="<%=id_q%>" class="btn btn-primary">Ответить на
							вопрос</button>
					</p>
					<p>
						<a href="changequestion.html?change_id_q=<%=id_q%>"
							class='btn btn-primary'>Изменить вопрос</a>
					</p>
					<p>
						<a href="deletequestion.html?change_id_q=<%=id_q%>"
							class='btn btn-primary'>Удалить вопрос</a>
					</p>
				</td>
			</tr>
			
			<%
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