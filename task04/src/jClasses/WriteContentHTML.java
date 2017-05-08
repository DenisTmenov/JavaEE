package jClasses;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class WriteContentHTML {
	public static void start(PrintWriter out, HttpServletRequest request, HashMap<String, String> paramFromRequest)
			throws IOException {
		//ServletContext servletContext = request.getServletContext();  // дурацкое условие задания
		//String realPath = servletContext.getRealPath("/recomendate.txt");
		String realPath = request.getServletContext().getInitParameter("recomendate.txt");
		
		Path path = Paths.get(realPath);
		List<String> readAllLines = Files.readAllLines(path);

		for (String str : readAllLines) {
			String str01 = ParserHTML.start(str, request, paramFromRequest);
			out.println(str01);
		}

	}
}
