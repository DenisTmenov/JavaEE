function Arhive() {
	var archive = document.getElementById("archive");
	var archiveTypeLable = document.getElementById("archiveTypeLable");
	var ZIP = document.getElementById("ZIP");
	var JAR = document.getElementById("JAR");
	var TXT = document.getElementById("TXT");
	var DOCX = document.getElementById("DOCX");
	var JARLable = document.getElementById("JARLable");
	var ZIPLable = document.getElementById("ZIPLable");
	var TXTLable = document.getElementById("TXTLable");
	var DOCXLable = document.getElementById("DOCXLable");
	if(archive.checked){
		archiveTypeLable.hidden=0;
		
		ZIP.hidden=0;
		JAR.hidden=0;
		TXT.hidden=0;
		DOCX.hidden=0;
		
		JARLable.hidden=0;
		ZIPLable.hidden=0;
		TXTLable.hidden=0;
		DOCXLable.hidden=0;
		
	} else {
		archiveTypeLable.hidden=1;
		
		ZIP.hidden=1;
		JAR.hidden=1;
		TXT.hidden=1;
		DOCX.hidden=1;
		
		JARLable.hidden=1;
		ZIPLable.hidden=1;
		TXTLable.hidden=1;
		DOCXLable.hidden=1;
	}
	
}



