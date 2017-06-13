package com.trainingcenter.projectEE.maven.utils;

import java.io.IOException;
import java.util.Map;

public class Parser {
	public static String start(String strStart, Map<String, String> mapWithParameters)
			throws IOException {
		for (Map.Entry<String, String> entry : mapWithParameters.entrySet()) {
			strStart = strStart.replaceAll("\\$\\{" + entry.getKey() + "\\}", entry.getValue());
		}
		strStart = strStart + "\r\n";
		return strStart;
	}
}
