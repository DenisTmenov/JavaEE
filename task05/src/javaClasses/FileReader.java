package javaClasses;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class FileReader {
	public static List<String> readContentFromWebInf(HttpServletRequest request, String relativePathToFile) throws IOException {
		ServletContext servletContext = request.getServletContext();
		String realPath = servletContext.getRealPath(relativePathToFile);
		Path path = Paths.get(realPath);
		List<String> readAllLines = Files.readAllLines(path);

		return readAllLines;
	}

}
