package com.trainingcenter.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jClasses.createZIP;
import jClasses.createDOC;
import jClasses.createDOCX;
import jClasses.createJAR;
import jClasses.createTXT;

public class createLetterArchive extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/zip");

		String typeFile = request.getParameter("fileType");
		byte[] file = null;
		if (typeFile.equals("TXT")) {
			file = createTXT.create(request);
		} else if (typeFile.equals("DOC")) {
			file = createDOC.create(request);
		} else if (typeFile.equals("DOCX")) {
			file = createDOCX.create(request);
		}

		String typeArchive = request.getParameter("archiveType");
		byte[] fileArchive = null;
		if (typeArchive.equals("ZIP")) {
			fileArchive = createZIP.create(file, "recommendation." + typeFile.toLowerCase());

		} else if (typeArchive.equals("JAR")) {
			fileArchive = createJAR.create(file, "recommendation." + typeFile.toLowerCase());

		}

		ServletOutputStream stream = response.getOutputStream();
		response.setHeader("Content-Disposition: attachment; filename=recommendation",
				"new." + typeArchive.toLowerCase());
		stream.write(fileArchive);
		stream.close();

	}
}