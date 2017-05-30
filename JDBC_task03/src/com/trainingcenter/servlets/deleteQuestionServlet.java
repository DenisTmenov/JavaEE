package com.trainingcenter.servlets;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trainingcenter.javaclass.ChangerAnswer;
import com.trainingcenter.javaclass.ChangerQuestion;

@WebServlet("/deleteQuestionServlet")
public class deleteQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");
		String id_q = request.getParameter("change_id_q");
		if (id_q != null && command != null) {
			if (command.equals("save")) {
				try {
					ChangerAnswer.nullAllAnswers(id_q);
					ChangerQuestion.deleteQuestion(id_q);
				} catch (NamingException e) {
					e.printStackTrace();
				}
			}
			if (command.equals("delete")) {
				try {
					ChangerAnswer.deleteAllAnswers(id_q);
					ChangerQuestion.deleteQuestion(id_q);
				} catch (NamingException e) {
					e.printStackTrace();
				}
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("jdbcindex.html");
			request.setAttribute("actionDelete", "OK");
			
			dispatcher.forward(request, response);
		}
	}

}
