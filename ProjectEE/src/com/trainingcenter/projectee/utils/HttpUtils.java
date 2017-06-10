package com.trainingcenter.projectee.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
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
	
	public Map<String, String> createMapParameters(HttpServletRequest request) throws IOException {

		Enumeration<String> parameterNames = request.getParameterNames();
		Map<String, String> parametersRequest = new HashMap<String, String>();
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			String paramValue = request.getParameter(paramName);
			parametersRequest.put(paramName, paramValue);
		}
		return parametersRequest;
	}
	
	public void printMapToScrean(Map<String, String> map, HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");

		for (String name : map.keySet()) {

			String key = name.toString();
			String value = map.get(name).toString();
			StringBuffer sb = new StringBuffer();
			sb.append(key).append("\t").append(value).append("\n");
			out.write(sb.toString());
		}

		out.close();

	}

	@SuppressWarnings("unchecked")
	public static <T> T getAttribute(HttpSession session, String attrName) {
		if (session == null) {
			throw new IllegalArgumentException("HttpSession can not be NULL!");
		}

		if (StringUtils.isEmpty(attrName)) {
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
	
	public static Map<String, String> getMapAttribute(HttpServletRequest request, String attrName) {
		Map<String, String> attribute = getAttribute(request, attrName);
		if (attribute == null) {
			return new HashMap<>();
		}

		return attribute;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getAttribute(HttpServletRequest request, String attrName) {
		if (request == null) {
			throw new IllegalArgumentException("HttpServletRequest can not be NULL!");
		}

		if (StringUtils.isEmpty(attrName)) {
			throw new IllegalArgumentException("Attribute name can not be blank!");
		}

		return (T) request.getAttribute(attrName);
	}

	public static boolean isParameterExists(HttpServletRequest request, String paramName) {
		if (StringUtils.isEmpty(paramName)) {
			throw new IllegalArgumentException("Parameter name can not be blank!");
		}

		String valueStr = request.getParameter(paramName);
		return StringUtils.isNotEmpty(valueStr);
	}
	
	public static boolean isParameterExists(HttpSession session, String paramName) {
		if (StringUtils.isEmpty(paramName)) {
			throw new IllegalArgumentException("Parameter name can not be blank!");
		}

		String valueStr = (String) session.getAttribute(paramName);
		return StringUtils.isNotEmpty(valueStr);
	}

	public static Integer getIntParam(HttpServletRequest request, String paramName) {
		if (StringUtils.isEmpty(paramName)) {
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
