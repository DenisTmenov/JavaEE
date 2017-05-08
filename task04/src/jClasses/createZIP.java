package jClasses;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class createZIP {
	public static byte[] create(byte[] fileToZIP, String nameFileToZIP) throws IOException {
		
		File tempFileZip = File.createTempFile("rec_" + System.currentTimeMillis(), ".zip");
		
		
		FileOutputStream fout = new FileOutputStream(tempFileZip.getAbsolutePath());
		ZipOutputStream zout = new ZipOutputStream(fout);
		// Для всех файлов:
		{
			ZipEntry ze = new ZipEntry(nameFileToZIP); // Имя файла - имя файла в архиве
			byte[] rec = fileToZIP;
			ze.setCompressedSize(9);
			zout.putNextEntry(ze);
			zout.write(rec);
			// отправка данных в поток zout
			zout.closeEntry();
		}
		zout.close();
		Path pathZIP = Paths.get(tempFileZip.getAbsolutePath());
		byte[] fileZIP = Files.readAllBytes(pathZIP);
		tempFileZip.delete();
		
		return fileZIP;
	}
}
