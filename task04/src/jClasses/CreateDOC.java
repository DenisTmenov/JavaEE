package jClasses;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


public class CreateDOC {
	public static byte[] create(HttpServletRequest request) throws IOException {
		//ServletContext context = request.getServletContext(); // дурацкое условие задания
		//Path path = Paths.get(context.getRealPath("recomendation.doc"));
		Path path = Paths.get(request.getServletContext().getInitParameter("recomendation.doc"));
		
		List<String> lines = Files.readAllLines(path);
		/*XWPFDocument document = new XWPFDocument();
		FileOutputStream out = new FileOutputStream(new File("recomendation.docx"));
		XWPFParagraph paragraph = document.createParagraph();
		XWPFRun run = paragraph.createRun();
		
		 * for (String string : lines) { run.setText((match(string, request,
		 * response)) + "\n"); }
		 
		document.write(out);
		out.close();
		document.close();*/
		byte[] fileTXT = null;
		return fileTXT;
	}
}