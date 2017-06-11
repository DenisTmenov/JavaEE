package com.trainingcenter.projectee.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class CreateTXT {
	public static byte[] create(HttpServletRequest request, String filePath, Map<String, String> mapWithParameters) throws IOException {
		String realPathTemplate = request.getServletContext().getRealPath(filePath);
		Path pathTemplate = Paths.get(realPathTemplate);
		List<String> readAllLines = Files.readAllLines(pathTemplate);

		File tempFile = File.createTempFile("temp_" + System.currentTimeMillis(), ".txt");

		FileWriter out = new FileWriter(tempFile.getAbsolutePath(), false);

		for (String str : readAllLines) {
			String str01 = Parser.start(str, mapWithParameters);
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
