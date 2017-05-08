package com.trainingcenter.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jClasses.CreateZIP;
import jClasses.CreateDOC;
import jClasses.CreateDOCX;
import jClasses.CreateJAR;
import jClasses.CreateTXT;

public class CreateLetterArchive extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/zip");

		String typeFile = request.getParameter("fileType");
		byte[] file = null;
		if (typeFile.equals("TXT")) {
			file = CreateTXT.create(request);
		} else if (typeFile.equals("DOC")) {
			file = CreateDOC.create(request);
		} else if (typeFile.equals("DOCX")) {
			file = CreateDOCX.create(request);
		}

		String typeArchive = request.getParameter("archiveType");
		byte[] fileArchive = null;
		if (typeArchive.equals("ZIP")) {
			fileArchive = CreateZIP.create(file, "recommendation." + typeFile.toLowerCase());

		} else if (typeArchive.equals("JAR")) {
			fileArchive = CreateJAR.create(file, "recommendation." + typeFile.toLowerCase());

		}

		ServletOutputStream stream = response.getOutputStream();
		response.setHeader("Content-Disposition: attachment; filename=recommendation",
				"new." + typeArchive.toLowerCase());
		stream.write(fileArchive);
		stream.close();

	}
}