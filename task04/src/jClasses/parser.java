package jClasses;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public class parser {
	public static String start(String strStart, HttpServletRequest request, HashMap<String, String> paramFromRequest)
			throws IOException {
		for (HashMap.Entry<String, String> entry : paramFromRequest.entrySet()) {
			strStart = strStart.replaceAll("\\$\\{" + entry.getKey() + "\\}", entry.getValue());
		}
		strStart = strStart + "\r\n";
		return strStart;
	}
}
