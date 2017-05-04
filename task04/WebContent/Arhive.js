function Arhive() {
	var archive = document.getElementById("archive");
	var archiveTypeLable = document.getElementById("archiveTypeLable");
	var ZIP = document.getElementById("ZIP");
	var JAR = document.getElementById("JAR");
	var JARLable = document.getElementById("JARLable");
	var ZIPLable = document.getElementById("ZIPLable");

	
	if(archive.checked){
		archiveTypeLable.hidden=0;
		ZIP.hidden=0;
		JAR.hidden=0;
		JARLable.hidden=0;
		ZIPLable.hidden=0;
	} else {
		archiveTypeLable.hidden=1;
		ZIP.hidden=1;
		JAR.hidden=1;
		JARLable.hidden=1;
		ZIPLable.hidden=1;
	}
	
}