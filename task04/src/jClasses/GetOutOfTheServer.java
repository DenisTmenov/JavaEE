package jClasses;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GetOutOfTheServer {
	public static byte[] start(String pathToFile) throws IOException {

		Path pathFile = Paths.get(pathToFile);
		byte[] file = Files.readAllBytes(pathFile);

		return file;
	}
}
