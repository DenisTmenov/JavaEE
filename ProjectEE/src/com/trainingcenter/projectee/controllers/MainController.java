package com.trainingcenter.projectee.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trainingcenter.projectee.controllers.helpers.LinkKeeper;
import com.trainingcenter.projectee.utils.HttpUtils;

@WebServlet("/main.html")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpUtils.includeView(LinkKeeper.JSP_HEADER, request, response);
		HttpUtils.includeView(LinkKeeper.JSP_MENU, request, response);
		HttpUtils.includeView(LinkKeeper.JSP_MAIN, request, response);
		HttpUtils.includeView(LinkKeeper.JSP_FOOTER, request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		HttpUtils.forwardToView(LinkKeeper.PAGE_MAIN, request, response);
	}


	
}
