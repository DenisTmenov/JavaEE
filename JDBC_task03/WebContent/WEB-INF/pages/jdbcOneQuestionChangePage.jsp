<%@page import="com.trainingcenter.connectionpool.ConnectionPool"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="com.trainingcenter.javaclass.ChangerQuestion"%>
<%@page import="com.trainingcenter.javaclass.ChangerAnswer"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Properties"%>
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
<%!%>




<div class='col-xs-8'>
	<%
		request.setCharacterEncoding("UTF-8");
		String btn_save_question = request.getParameter("btn_save_question");
		int change_id_q = Integer.valueOf(request.getParameter("change_id_q"));
		String txt_question = request.getParameter("txt_question");
		String txt_answer_01 = request.getParameter("txt_answer_01");
		String txt_answer_02 = request.getParameter("txt_answer_02");
		String txt_answer_03 = request.getParameter("txt_answer_03");
		String txt_answer_04 = request.getParameter("txt_answer_04");
		String true_answer = request.getParameter("true_answer");
		int num_answer_01 = 0;
		int num_answer_02 = 0;
		int num_answer_03 = 0;
		int num_answer_04 = 0;

		if (change_id_q != 0) {

			Connection connection = null;
			PreparedStatement statement = null;
			ResultSet set = null;
			ArrayList<Integer> allNumberQuestions = new ArrayList<Integer>();
			HashMap<Integer, String> allQuestions = new HashMap<Integer, String>();
			try {
				connection = ConnectionPool.getPool().getConnection();

				statement = connection.prepareStatement("SELECT * FROM jdbc_task03_db.questions WHERE id_q = ?");
				statement.setInt(1, change_id_q);

				set = statement.executeQuery();
				while (set.next()) {
					Integer id_q = set.getInt("id_q"); // Вот так получать данные - очень хорошо!
					String question = set.getString("question");
					txt_question = question;
				}
			} catch (SQLException e) {
				throw new RuntimeException("Some errors occurred during DB access!", e);
			} finally {
				ConnectionPool.getPool().closeDbResources(connection, statement, set);
			}

			try {
				connection = ConnectionPool.getPool().getConnection();

				statement = connection.prepareStatement("SELECT * FROM jdbc_task03_db.answers WHERE fk_question_id = ?");
				statement.setInt(1, change_id_q);
				
				set = statement.executeQuery();
				
				String fourAnswers[] = new String[4];
				int fourNumAnswer[] = new int[4];
				int i = 0;
				while (set.next()) {
					Integer id_a = set.getInt("id_a"); // Вот так получать данные - очень хорошо!
					String answer = set.getString("answer");
					fourAnswers[i] = answer;
					fourNumAnswer[i] = id_a;
					i++;
				}
				txt_answer_01 = fourAnswers[0];
				txt_answer_02 = fourAnswers[1];
				txt_answer_03 = fourAnswers[2];
				txt_answer_04 = fourAnswers[3];
				num_answer_01 = fourNumAnswer[0];
				num_answer_02 = fourNumAnswer[1];
				num_answer_03 = fourNumAnswer[2];
				num_answer_04 = fourNumAnswer[3];

			} catch (SQLException e) {
				throw new RuntimeException("Some errors occurred during DB access!", e);
			} finally {
				ConnectionPool.getPool().closeDbResources(connection, statement, set);
			}

			if (btn_save_question != null) {
				txt_question = request.getParameter("txt_question");
				txt_answer_01 = request.getParameter("txt_answer_01");
				txt_answer_02 = request.getParameter("txt_answer_02");
				txt_answer_03 = request.getParameter("txt_answer_03");
				txt_answer_04 = request.getParameter("txt_answer_04");
				true_answer = request.getParameter("true_answer");
				if (txt_question != null && txt_answer_01 != null && txt_answer_02 != null && txt_answer_03 != null
						&& txt_answer_04 != null && true_answer != null && !true_answer.equals("")) {
					ChangerQuestion.changeQuestion(txt_question, change_id_q);
					int questionInt = ChangerQuestion.numQuestionInDB(txt_question);
					ChangerAnswer.changeAnswer(txt_answer_01, num_answer_01);
					ChangerAnswer.changeAnswer(txt_answer_02, num_answer_02);
					ChangerAnswer.changeAnswer(txt_answer_03, num_answer_03);
					ChangerAnswer.changeAnswer(txt_answer_04, num_answer_04);
					switch (true_answer) {
					case "1":
						ChangerAnswer.saveTrueAnswer(txt_answer_01);
						break;
					case "2":
						ChangerAnswer.saveTrueAnswer(txt_answer_02);
						break;
					case "3":
						ChangerAnswer.saveTrueAnswer(txt_answer_03);
						break;
					case "4":
						ChangerAnswer.saveTrueAnswer(txt_answer_04);
						break;
					default:
						System.out.println("Error with add trueOrFalse in DB!!!");
					}
					out.println("<script>alert('Вопрос был изменен!!!');</script>");
				} else {
					out.println("<script>alert('Вы ошиблись');</script>");
				}
			}
		}
	%>
	<h2>Изменить вопрос</h2>
	<form>
		<br>
		<h4>Формулировка вопроса:</h4>
		<input type="text" id="txt_question" name="txt_question" size="80"
			value="<%if (txt_question == null)
				txt_question = "";%><%=txt_question%>" />
		<br>
		<h4>Варианты ответов:</h4>
		<table>
			<tr>
				<th>№</th>
				<th>&nbsp;&nbsp;Вариант ответа</th>
				<th>Правильный ответ</th>
			</tr>
			<tr>
				<td>1</td>
				<td><input type="text" id="txt_answer_01" name="txt_answer_01"
					size="60"
					value="<%if (txt_answer_01 == null)
				txt_answer_01 = "";%><%=txt_answer_01%>" /></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"
					name="true_answer" value="1" /></td>
			</tr>
			<tr>
				<td>2</td>
				<td><input type="text" id="txt_answer_02" name="txt_answer_02"
					size="60"
					value="<%if (txt_answer_02 == null)
				txt_answer_02 = "";%><%=txt_answer_02%>" /></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"
					name="true_answer" value="2" /></td>
			</tr>
			<tr>
				<td>3</td>
				<td><input type="text" id="txt_answer_03" name="txt_answer_03"
					size="60"
					value="<%if (txt_answer_03 == null)
				txt_answer_03 = "";%><%=txt_answer_03%>" /></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"
					name="true_answer" value="3" /></td>
			</tr>
			<tr>
				<td>4</td>
				<td><input type="text" id="txt_answer_04" name="txt_answer_04"
					size="60"
					value="<%if (txt_answer_04 == null)
				txt_answer_04 = "";%><%=txt_answer_04%>" /></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"
					name="true_answer" value="4" /></td>
			</tr>
		</table>
		<input type="submit" name="btn_save_question" value="Изменить" /> <input
			type="text" name="change_id_q"
			value="<%=request.getParameter("change_id_q")%>" hidden="hidden" />


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