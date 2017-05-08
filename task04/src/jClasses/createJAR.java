package jClasses;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;


public class createJAR {
	public static byte[] create(byte[] fileToJAR, String nameFileToJAR) throws IOException {
		
		File tempFileJAR = File.createTempFile("rec_" + System.currentTimeMillis(), ".jar");
		
		FileOutputStream fout = new FileOutputStream(tempFileJAR.getAbsolutePath());
		JarOutputStream jout = new JarOutputStream(fout);
		// Для всех файлов:
		{
			JarEntry je = new JarEntry(nameFileToJAR); // Имя файла - имя файла в архиве
			byte[] rec = fileToJAR;
			je.setCompressedSize(9);
			jout.putNextEntry(je);
			jout.write(rec);
			// отправка данных в поток zout
			jout.closeEntry();
		}
		jout.close();
		Path pathJAR = Paths.get(tempFileJAR.getAbsolutePath());
		byte[] fileJAR = Files.readAllBytes(pathJAR);
		tempFileJAR.delete();
		
		return fileJAR;
	}
}
