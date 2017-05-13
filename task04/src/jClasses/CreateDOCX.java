package jClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class CreateDOCX {
	public static byte[] create(HttpServletRequest request) throws IOException {
		File docFile = new File(request.getServletContext().getInitParameter("recomendate.docx"));
		FileInputStream finStream = new FileInputStream(docFile); // docFile.getAbsolutePath());

		XWPFDocument docxRead = new XWPFDocument(finStream);
		
		File tempFile = File.createTempFile("rec_" + System.currentTimeMillis(), ".docx");
		FileOutputStream out = new FileOutputStream(tempFile);

		XWPFDocument doc = new XWPFDocument();
		XWPFParagraph paragraph = doc.createParagraph();
		XWPFRun run = paragraph.createRun();
		
		List<XWPFParagraph> paragraphList = docxRead.getParagraphs();
		for (XWPFParagraph xwpfParagraph : paragraphList) {
			run.setText(Parser.start(xwpfParagraph.getText(), request));
		}

		doc.write(out);
		out.close();
		doc.close();
		docxRead.close();
		Path pathDOCX = Paths.get(tempFile.getAbsolutePath());

		byte[] fileDOCX = Files.readAllBytes(pathDOCX);
		tempFile.delete();
		return fileDOCX;
	}
}
