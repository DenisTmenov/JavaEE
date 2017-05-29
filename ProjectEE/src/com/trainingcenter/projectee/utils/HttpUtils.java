package com.trainingcenter.projectee.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public final class HttpUtils {

	private HttpUtils() {
		throw new AssertionError("Class contains static methods only. You should not instantiate it!");
	}

	@SuppressWarnings("unchecked")
	public static <T> T getAttribute(HttpSession session, String attrName) {
		if (session == null) {
			throw new IllegalArgumentException("HttpSession can not be NULL!");
		}

		if (StringUtils.isBlank(attrName)) {
			throw new IllegalArgumentException("Attribute name can not be blank!");
		}

		return (T) session.getAttribute(attrName);
	}

	public static Map<String, String> getMapAttribute(HttpSession session, String attrName) {
		Map<String, String> attribute = getAttribute(session, attrName);
		if (attribute == null) {
			return new HashMap<>();
		}

		return attribute;
	}

	public static boolean isParameterExists(HttpServletRequest request, String paramName) {
		if (StringUtils.isBlank(paramName)) {
			throw new IllegalArgumentException("Parameter name can not be blank!");
		}

		String valueStr = request.getParameter(paramName);
		return StringUtils.isNotBlank(valueStr);
	}

	public static Integer getIntParam(HttpServletRequest request, String paramName) {
		if (StringUtils.isBlank(paramName)) {
			throw new IllegalArgumentException("Parameter name can not be blank!");
		}

		String valueStr = request.getParameter(paramName);
		try {
			return new Integer(valueStr);
		} catch(Exception e) {
			return null;
		}
	}
	
	public static void forwardToView(String viewName, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
		dispatcher.forward(request, response);
	}

}
