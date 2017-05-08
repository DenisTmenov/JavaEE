package jClasses;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public class createHashMap {
	public static HashMap<String, String> create(HttpServletRequest request) {
		HashMap<String, String> paramFromRequest = new HashMap<String, String>();
		Enumeration<?> params = request.getParameterNames();
		paramFromRequest.put("patronymicStudent", "");
		paramFromRequest.put("patronymicTeacherONE", "");
		paramFromRequest.put("firstNameTeacherONE", "");
		paramFromRequest.put("assessmentOfaCourseCombo", "");
		while (params.hasMoreElements()) {
			String paramName = (String) params.nextElement();
			paramFromRequest.put(paramName, request.getParameter(paramName));
		}
		String dateStart = paramFromRequest.get("dateStart");
		String dateFinish = paramFromRequest.get("dateFinish");
		if (!paramFromRequest.get("dateStart").equals("") && !paramFromRequest.get("dateFinish").equals("")) {

			String monthS = numToMonth.create(dateStart.substring(5, 7));
			String monthF = numToMonth.create(dateFinish.substring(5, 7));
			dateStart = dateStart.substring(8, 10) + " " + monthS + " " + dateStart.substring(0, 4);
			dateFinish = dateFinish.substring(8, 10) + " " + monthF + " " + dateFinish.substring(0, 4);

			paramFromRequest.put("dateStart", dateStart);
			paramFromRequest.put("dateFinish", dateFinish);
		}
		if (!paramFromRequest.get("firstNameTeacher").equals("")) {
		paramFromRequest.put("firstNameTeacherONE", paramFromRequest.get("firstNameTeacher").substring(0, 1) + ".");
		}
		if (!paramFromRequest.get("patronymicTeacher").equals("")) {

			paramFromRequest.put("patronymicTeacherONE",
					paramFromRequest.get("patronymicTeacher").substring(0, 1) + ".");
		}
		String allThemes = "";
		for (int i = 1; i < 100; i++) {
			if (paramFromRequest.containsKey("theme" + i)) {
				allThemes += "\r\n     " + request.getParameter("theme" + i);
			}
		}
		
		allThemes += "\r\n";
		paramFromRequest.put("theme", allThemes);

		return paramFromRequest;
	}
}
