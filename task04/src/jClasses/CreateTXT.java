package jClasses;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class CreateTXT {
	public static byte[] create(HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("UTF-8");
		//ServletContext servletContext = request.getServletContext(); // дурацкое условие задания
		//String realPathTemplate = servletContext.getRealPath("/recomendate.txt");
		
		String realPathTemplate = request.getServletContext().getInitParameter("recomendate.txt");
		Path pathTemplate = Paths.get(realPathTemplate);
		List<String> readAllLines = Files.readAllLines(pathTemplate);

		File tempFile = File.createTempFile("rec_" + System.currentTimeMillis(), ".txt");

		FileWriter out = new FileWriter(tempFile.getAbsolutePath(), false);

		for (String str : readAllLines) {
			String str01 = Parser.start(str, request);
			out.write(str01);
			out.flush();
		}
		out.close();
		Path pathTXT = Paths.get(tempFile.getAbsolutePath());
		byte[] fileTXT = Files.readAllBytes(pathTXT);
		
		tempFile.delete();
		return fileTXT;
	}
}
