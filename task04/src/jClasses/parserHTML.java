package jClasses;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public class parserHTML {
	public static String start(String strStart, HttpServletRequest request, HashMap<String, String> paramFromRequest)
			throws IOException {
		strStart = "<pre><p>" + strStart;
		for (HashMap.Entry<String, String> entry : paramFromRequest.entrySet()) {
			strStart = strStart.replaceAll("\\$\\{" + entry.getKey() + "\\}", entry.getValue());
		}
		strStart = strStart + "</p></pre>";
		return strStart;
	}
}
