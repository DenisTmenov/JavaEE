<%@page import="com.trainingcenter.connectionpool.ConnectionPool"%>
<%@page import="javax.sql.DataSource"%>
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
	<table>
		<tr>
			<td>На вопрос: "<%=request.getParameter("question")%>"
			</td>
		</tr>
		<tr>
			<td>Вы ответили: <%
				String id_a = request.getParameter("button");

				Connection connection = null;
				PreparedStatement statement = null;
				ResultSet set = null;
				try {
					connection = ConnectionPool.getPool().getConnection();

					statement = connection.prepareStatement("SELECT * FROM jdbc_task03_db.answers WHERE id_a = ?");
					statement.setString(1, id_a);

					set = statement.executeQuery();
					int columns = set.getMetaData().getColumnCount();

					String answer = null;
					while (set.next()) {
						answer = set.getString("answer");
			%> "<%=answer%>"
			</td>
		</tr>
		<tr>
			<td>
				<%
					String trueOrFalse = set.getString("trueOrFalse");
							if (trueOrFalse.equals("true")) {
				%> Поздравляем! Вы ответили правильно. <%
					}
							if (trueOrFalse.equals("false")) {
				%> К сожалению Вы ошиблись. <%
					}
						}
					} catch (SQLException e) {
						throw new RuntimeException("Some errors occurred during DB access!", e);
					} finally {
						ConnectionPool.getPool().closeDbResources(connection, statement, set);
					}
				%>
			</td>
		</tr>
	</table>
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