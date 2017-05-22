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
					Context initContext = new InitialContext();
					Context rootContext = (Context) initContext.lookup("java:comp/env");
					DataSource dataSource = (DataSource) rootContext.lookup("jdbc/jdbc_task03_db_link");

					c = dataSource.getConnection();
					statement = c.createStatement();
					set = statement.executeQuery("SELECT * FROM jdbc_task03_db.answers WHERE id_a=" + id_a);
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
						ConnectionManager.closeDbResources(c, statement, set);
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