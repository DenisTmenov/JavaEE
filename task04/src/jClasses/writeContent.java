package jClasses;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class writeContent {
	public static void start(FileWriter out, HttpServletRequest request, HashMap<String, String> paramFromRequest)
			throws IOException {
		ServletContext servletContext = request.getServletContext();
		String realPath = servletContext.getRealPath("/recomendateDOC.txt");
		Path path = Paths.get(realPath);
		List<String> readAllLines = Files.readAllLines(path);

		for (String str : readAllLines) {
			String str01 = parser.start(str, request, paramFromRequest);
			out.write(str01);
			out.flush();
		}
	}
}
