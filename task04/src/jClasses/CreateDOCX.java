package jClasses;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class CreateDOCX {
	public static byte[] create(HttpServletRequest request) throws IOException {
		//ServletContext context = request.getServletContext(); // дурацкое условие задания
		//Path path = Paths.get(context.getRealPath("recomendate.docx"));
		Path path = Paths.get(request.getServletContext().getInitParameter("recomendation.docx"));
		
		List<String> lines = Files.readAllLines(path);
		
		
		XWPFDocument doc = new XWPFDocument();

		//File tempFile = File.createTempFile("rec_" + System.currentTimeMillis(), ".docx");
		//FileOutputStream out = new FileOutputStream(tempFile);

		FileOutputStream out = new FileOutputStream(new File("recomendation.docx"));

		XWPFParagraph paragraph = doc.createParagraph();
		XWPFRun run = paragraph.createRun();

		for (String str : lines) {
			run.setText(Parser.start(str, request));
		}

		doc.write(out);
		out.close();
		doc.close();
		//Path pathDOCX = Paths.get(tempFile.getAbsolutePath());
		
		//byte[] fileDOCX = Files.readAllBytes(pathDOCX);
		byte[] fileDOCX = null;
		//tempFile.delete();
		return fileDOCX;
	}
}
