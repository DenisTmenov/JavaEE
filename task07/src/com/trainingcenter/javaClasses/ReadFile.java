package com.trainingcenter.javaClasses;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class ReadFile {
	public static List<String> writeContent(HttpServletRequest request, String relativePathToFile) throws IOException {
		request.setCharacterEncoding("UTF-8");
		ServletContext servletContext = request.getServletContext();
		String realPath = servletContext.getRealPath(relativePathToFile);
		Path path = Paths.get(realPath);
		List<String> readAllLines = Files.readAllLines(path);

		return readAllLines;
	}

}
